package io.fabric8.mycontroller.api.model.v1alpha1;

public class FooSpec {
    private String deploymentName;
    private int replicas;

    public String getDeploymentName() {
        return deploymentName;
    }

    public void setDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
    }

    public int getReplicas() {
        return replicas;
    }

    public void setReplicas(int replicas) {
        this.replicas = replicas;
    }

    @Override
    public String toString() {
        return "FooSpec{replicas=" + replicas + "}";
    }
}
