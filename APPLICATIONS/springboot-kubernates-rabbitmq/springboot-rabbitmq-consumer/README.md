### springboot rabbitmq consumer
---

### Build and execution
* $ mvn clean package

### To Build the docker image
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-rabbitmq-consumer .
```      
[+] Building 1.1s (7/7) FINISHED                                                                                                                                                                      
 => [internal] load build definition from Dockerfile                                                                                                                                             0.0s
 => => transferring dockerfile: 209B                                                                                                                                                             0.0s
 => [internal] load .dockerignore                                                                                                                                                                0.0s
 => => transferring context: 2B                                                                                                                                                                  0.0s
 => [internal] load metadata for docker.io/library/openjdk:8                                                                                                                                     0.6s
 => [internal] load build context                                                                                                                                                                0.2s
 => => transferring context: 19.79MB                                                                                                                                                             0.2s
 => CACHED [1/2] FROM docker.io/library/openjdk:8@sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8                                                                        0.0s
 => [2/2] ADD target/springboot-rabbitmq-consumer.jar springboot-rabbitmq-consumer.jar                                                                                                           0.1s
 => exporting to image                                                                                                                                                                           0.1s
 => => exporting layers                                                                                                                                                                          0.1s
 => => writing image sha256:55acaf368e463dd1bee263abcb96d2dbf2b525a7f61db3057194e404dc8bd283                                                                                                     0.0s
 => => naming to docker.io/adarshkumarsingh83/springboot-rabbitmq-consumer 
```
### TO PUSH TO DOCKER HUB
* $ docker push adarshkumarsingh83/springboot-rabbitmq-consumer
```
Using default tag: latest
The push refers to repository [docker.io/adarshkumarsingh83/springboot-rabbitmq-consumer]
c3e7d0dad242: Pushed 
6b5aaff44254: Mounted from adarshkumarsingh83/springboot-rabbitmq-producer 
53a0b163e995: Mounted from adarshkumarsingh83/springboot-rabbitmq-producer 
b626401ef603: Mounted from adarshkumarsingh83/springboot-rabbitmq-producer 
9b55156abf26: Mounted from adarshkumarsingh83/springboot-rabbitmq-producer 
293d5db30c9f: Mounted from adarshkumarsingh83/springboot-rabbitmq-producer 
03127cdb479b: Mounted from adarshkumarsingh83/springboot-rabbitmq-producer 
9c742cd6c7a5: Mounted from adarshkumarsingh83/springboot-rabbitmq-producer 
latest: digest: sha256:6c359cfbfe45ef485958c5974fa2844410df2b4a3c2638f509dd40cff817b0bd size: 2007

```