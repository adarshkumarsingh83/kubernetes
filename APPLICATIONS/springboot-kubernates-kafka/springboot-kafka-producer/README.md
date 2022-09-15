# spring boot kafka producer 

----

### To Build the code 
* mvn clean package 



### To build the docker image and tag
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kafka-producer .
``` 
[+] Building 1.9s (8/8) FINISHED                                                                                                                                                                      
 => [internal] load build definition from Dockerfile                                                                                                                                             0.0s
 => => transferring dockerfile: 200B                                                                                                                                                             0.0s
 => [internal] load .dockerignore                                                                                                                                                                0.0s
 => => transferring context: 2B                                                                                                                                                                  0.0s
 => [internal] load metadata for docker.io/library/openjdk:8                                                                                                                                     1.2s
 => [auth] library/openjdk:pull token for registry-1.docker.io                                                                                                                                   0.0s
 => [internal] load build context                                                                                                                                                                0.3s
 => => transferring context: 30.03MB                                                                                                                                                             0.3s
 => CACHED [1/2] FROM docker.io/library/openjdk:8@sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8                                                                        0.0s
 => [2/2] ADD target/springboot-kafka-producer.jar springboot-kafka-producer.jar                                                                                                                 0.2s
 => exporting to image                                                                                                                                                                           0.1s
 => => exporting layers                                                                                                                                                                          0.1s
 => => writing image sha256:f690e8cc63426b33e1cfa85bccd7547ed0166275522d188c13cd605b57f009d4                                                                                                     0.0s
 => => naming to docker.io/adarshkumarsingh83/springboot-kafka-producer   
```
### to push the docker image to the docker hub
* $ docker push adarshkumarsingh83/springboot-kafka-producer