#! /bin/bash

echo 🔥 Destory certificate

kubectl delete secret jks-password-secret -n default
kubectl delete certificate selfsigned-cert -n default
kubectl delete certificate selfsigned-jks -n default