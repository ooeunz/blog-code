#! /bin/bash

echo 🔥 Destory monitoring system

kubectl delete namespace monitoring

kubectl delete clusterrole monitoring
kubectl delete clusterrole node-exporter
kubectl delete clusterrole kube-state-metrics

kubectl delete clusterrolebinding monitoring
kubectl delete clusterrolebinding node-exporter
kubectl delete clusterrolebinding kube-state-metrics

kubectl delete pv prometheus-volume