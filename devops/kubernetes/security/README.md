# [Cert-manager](https://cert-manager.io/docs/)

## Cert-manager란?
Cert-manager는 Kubernetes 내부에서 HTTPS 통신을 위한 인증서를 생성하고, 또 인증서의 만료 기간이 되면 자동으로 인증서를 갱신해주는 역할을 하는 Certificate manager controller입니다.

아래의 블로그 링크에서 좀 더 자세한 내용을 확인하실 수 있습니다.

- [[Cert manager] Kubernetes 통신 암호화 및 자동화 (MySQL HTTPS 적용)](https://ooeunz.tistory.com/143)
- [[Cert manager] SpringBoot(tomcat) HTTPS 적용하기](https://ooeunz.tistory.com/144)

또한 블로그에서 사용한 예시로 사용한 MySQL코드는 `/example` 디렉토리 하위에서 확인하실 수 있습니다.

## Script
#### Start cert-manager
아래의 명령어로 cert-manager를 cluster에서 배포할 수 있습니다.

```shell
$ script/start-cert-manager.sh
```

#### Start certificate
아래의 명령어로 `default` 네임스페이스에 certificate를 배포할 수 있습니다.

```shell
$ script/start-certificate.sh
```

#### Destroy cert-manager
아래의 명령어로 `cert-manager` 네임스페이스에 배포된 cert-manager를 삭제할 수 있습니다.

```shell
$ script/destory-cert-manager.sh
```

#### Destroy certificate
아래의 명령어로 `default` 네임스페이스에 배포된 certificate를 삭제할 수 있습니다.

```shell
$ script/destory-certificate.sh
```