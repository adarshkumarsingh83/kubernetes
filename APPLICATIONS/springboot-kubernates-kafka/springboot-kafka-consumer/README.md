# spring boot kafka consumer 

----

### To Build the code
* mvn clean package 


### To build the docker image and tag
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kafka-consumer .
```
[+] Building 1.4s (7/7) FINISHED                                                                                                                                                                      
 => [internal] load build definition from Dockerfile                                                                                                                                             0.0s
 => => transferring dockerfile: 200B                                                                                                                                                             0.0s
 => [internal] load .dockerignore                                                                                                                                                                0.0s
 => => transferring context: 2B                                                                                                                                                                  0.0s
 => [internal] load metadata for docker.io/library/openjdk:8                                                                                                                                     0.4s
 => [internal] load build context                                                                                                                                                                0.5s
 => => transferring context: 51.15MB                                                                                                                                                             0.5s
 => CACHED [1/2] FROM docker.io/library/openjdk:8@sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8                                                                        0.0s
 => [2/2] ADD target/springboot-kafka-consumer.jar springboot-kafka-consumer.jar                                                                                                                 0.2s
 => exporting to image                                                                                                                                                                           0.2s
 => => exporting layers                                                                                                                                                                          0.2s
 => => writing image sha256:d13938eb3f3ae822568956c0a8d8471b26ab7716a2de39b770162436d1b6fde7                                                                                                     0.0s
 => => naming to docker.io/adarshkumarsingh83/springboot-kafka-consumer        
```
### to push the docker image to the docker hub
* $ docker push adarshkumarsingh83/springboot-kafka-consumer
