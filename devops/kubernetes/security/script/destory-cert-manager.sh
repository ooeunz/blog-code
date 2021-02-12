#! /bin/bash

echo 🔥 Destory cert-manager

kubectl delete namespace cert-manager
kubectl delete crd clusterissuers.cert-manager.io
kubectl delete crd challenges.acme.cert-manager.io
kubectl delete crd certificates.cert-manager.io
kubectl delete crd certificaterequests.cert-manager.io
kubectl delete clusterissuer selfsigned-issuer