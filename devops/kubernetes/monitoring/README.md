# Monitoring

## Prometheus
Prometheus는 오픈소스 모니터링 툴입니다. 이와 관련된 자세한 내용은 아래에서 확인하실 수 있습니다.
- [[Prometheus] kubernetes 환경에 prometheus 구축하기](https://ooeunz.tistory.com/139)

## Script
아래의 명령어들로 간편하게 Monitoring system을 배포 및 삭제할 수 있습니다. 

본 repository에 있는 source code 및 script는 아래의 버전에서 동작이 검증되었으며 이외의 버전일 경우 확인이 필요합니다.

```shell
kubernetes:v1.15.11
kubernetes:v1.17.12
```

아래의 script로 배포되는 component들의 version은 아래와 같습니다.
- [prom/prometheus:v2.20.1](https://hub.docker.com/r/prom/prometheus/tags?page=1&ordering=last_updated)
- [prom/node-exporter:v1.0.1](https://hub.docker.com/r/prom/node-exporter/tags?page=1&ordering=last_updated)
- [quay.io/coreos/kube-state-metrics:v1.8.0](https://quay.io/repository/coreos/kube-state-metrics?tag=v1.8.0&tab=tags)

#### Start
아래의 명령어로 모니터링 시스템을 cluster에서 배포할 수 있습니다.

```shell
$ sh script/start-monitoring.sh
```

#### Destroy script
아래의 명령어로 모니터링 시스템을 cluster에서 삭제할 수 있습니다.

```shell
$ sh script/destory-monitoring.sh
```
