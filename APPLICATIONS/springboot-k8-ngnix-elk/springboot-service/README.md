# spring boot service 
> Description: \
> spring boot rest and web application 

----
### To build the application
* $ mvn clean package

### To Test the Service 
* mvn spring-boot:run -Dspring-boot.run.profiles=docker
* java -jar -Dspring.profiles.active=docker springboot-service.jar
* or 
* sh execution.sh  


### To test
* $ curl localhost:8080
* $ curl localhost:8080/api/message


### To Create docker image 
* docker build -t adarshkumarsingh83/springboot-service .
``` 
[+] Building 1.8s (8/8) FINISHED                                                                                                                                                           
 => [internal] load build definition from Dockerfile                                                                                                                                  0.0s
 => => transferring dockerfile: 219B                                                                                                                                                  0.0s
 => [internal] load .dockerignore                                                                                                                                                     0.0s
 => => transferring context: 2B                                                                                                                                                       0.0s
 => [internal] load metadata for docker.io/library/openjdk:8                                                                                                                          1.4s
 => [auth] library/openjdk:pull token for registry-1.docker.io                                                                                                                        0.0s
 => [internal] load build context                                                                                                                                                     0.2s
 => => transferring context: 20.94MB                                                                                                                                                  0.2s
 => CACHED [1/2] FROM docker.io/library/openjdk:8@sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8                                                             0.0s
 => [2/2] ADD target/springboot-service.jar springboot-service.jar                                                                                                                    0.1s
 => exporting to image                                                                                                                                                                0.1s
 => => exporting layers                                                                                                                                                               0.1s
 => => writing image sha256:0c59b164ed5cfec03aa27f6adcd8feac606b34c101a642bcf9845dfd36386470                                                                                          0.0s
 => => naming to docker.io/adarshkumarsingh83/springboot-service            
```
### To Run docker image 
* docker run -p 8080:8080 adarshkumarsingh83/springboot-service

### To push image 
* docker push adarshkumarsingh83/springboot-service