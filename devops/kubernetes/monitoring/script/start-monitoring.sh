#! /bin/bash

echo 🎉 Deploy monitoring system

kubectl create namespace monitoring

kubectl apply -f ../prometheus
kubectl apply -f ../node-exporter
kubectl apply -f ../kube-state-metrics