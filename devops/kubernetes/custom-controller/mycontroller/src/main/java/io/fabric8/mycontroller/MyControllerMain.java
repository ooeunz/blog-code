package io.fabric8.mycontroller;

import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.mycontroller.api.model.v1alpha1.Foo;
import io.fabric8.mycontroller.api.model.v1alpha1.FooList;
import io.fabric8.mycontroller.controller.MyController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main Class for application, you can run this sample using this command:
 *
 * $ mvn clean install
 * $ mvn exec:java -Dexec.mainClass="io.fabric8.mycontroller.MyControllerMain"
 */
public class MyControllerMain {
    public static final Logger logger = LoggerFactory.getLogger(MyControllerMain.class.getName());
    public static final String DEFAULT_NAMESPACE = "default";

    public static void main(String[] args) {
        try (KubernetesClient client = new DefaultKubernetesClient()) {
            String namespace = client.getNamespace();
            if (namespace.isEmpty()) {
                logger.info("No namespace found via config, assuming default.");
                namespace = DEFAULT_NAMESPACE;
            }

            logger.info("Using namespace : {}", namespace);
            CustomResourceDefinitionContext context = new CustomResourceDefinitionContext.Builder()
                .withVersion("v1alpha1")
                .withScope("Namespaced")
                .withGroup("mycontroller.k8s.io")
                .withPlural("foos")
                .build();

            SharedInformerFactory informerFactory = client.informers();

            MixedOperation<Foo, FooList, Resource<Foo>> fooClient = client.customResources(Foo.class, FooList.class);
            SharedIndexInformer<Deployment> deploymentSharedIndexInformer =
                informerFactory.sharedIndexInformerFor(Deployment.class, 10 * 60 * 1000);
            SharedIndexInformer<Foo> fooSharedIndexInformer =
                informerFactory.sharedIndexInformerForCustomResource(Foo.class,10 * 60 * 1000);

            MyController myController = new MyController(client, fooClient, deploymentSharedIndexInformer, fooSharedIndexInformer, namespace);


            myController.create();
            informerFactory.startAllRegisteredInformers();
            informerFactory.addSharedInformerEventListener(exception -> logger.error("Exception occurred, but caught", exception));

            logger.info("Starting Foo Controller");
            myController.run();
        } catch (KubernetesClientException exception) {
            logger.error("Kubernetes Client Exception : ", exception);
        }
    }
}
