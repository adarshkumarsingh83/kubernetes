### springboot rabbitmq producer
---

### Build and execution
* $ mvn clean package


### To Build the docker image 
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-rabbitmq-producer .
```
[+] Building 2.3s (8/8) FINISHED                                                                                                                                                                      
 => [internal] load build definition from Dockerfile                                                                                                                                             0.0s
 => => transferring dockerfile: 210B                                                                                                                                                             0.0s
 => [internal] load .dockerignore                                                                                                                                                                0.0s
 => => transferring context: 2B                                                                                                                                                                  0.0s
 => [internal] load metadata for docker.io/library/openjdk:8                                                                                                                                     1.7s
 => [auth] library/openjdk:pull token for registry-1.docker.io                                                                                                                                   0.0s
 => [internal] load build context                                                                                                                                                                0.2s
 => => transferring context: 19.79MB                                                                                                                                                             0.2s
 => CACHED [1/2] FROM docker.io/library/openjdk:8@sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8                                                                        0.0s
 => [2/2] ADD target/springboot-rabbitmq-producer.jar  springboot-rabbitmq-producer.jar                                                                                                          0.2s
 => exporting to image                                                                                                                                                                           0.1s
 => => exporting layers                                                                                                                                                                          0.1s
 => => writing image sha256:8b535870e96c97573149442d988c40dd9a6f87f9b56e066ed38eb86f2eae0fb6                                                                                                     0.0s
 => => naming to docker.io/adarshkumarsingh83/springboot-rabbitmq-producer 
```

### TO PUSH TO DOCKER HUB
* $ docker push adarshkumarsingh83/springboot-rabbitmq-producer
```
Using default tag: latest
The push refers to repository [docker.io/adarshkumarsingh83/springboot-rabbitmq-producer]
e02bf7bd3f88: Pushed 
6b5aaff44254: Mounted from adarshkumarsingh83/springboot-kafka-consumer 
53a0b163e995: Mounted from adarshkumarsingh83/springboot-kafka-consumer 
b626401ef603: Mounted from adarshkumarsingh83/springboot-kafka-consumer 
9b55156abf26: Mounted from adarshkumarsingh83/springboot-kafka-consumer 
293d5db30c9f: Mounted from adarshkumarsingh83/springboot-kafka-consumer 
03127cdb479b: Mounted from adarshkumarsingh83/springboot-kafka-consumer 
9c742cd6c7a5: Mounted from adarshkumarsingh83/springboot-kafka-consumer 
latest: digest: sha256:5664cae37ab901fb8d78200dc1568ede74cd828dd6ed597cdb390921d959c658 size: 2007

```