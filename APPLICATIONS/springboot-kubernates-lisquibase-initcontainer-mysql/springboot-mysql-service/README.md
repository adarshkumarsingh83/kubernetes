# SPRINGBOOT JPA MYSQL DB LIQUIDBASE

---



## Docker n/w creation
* docker network create mynet

##  launch the db
* $ docker run --name epsark-mysql \
  --shm-size=1g \
  --network=mynet \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=rootPwd \
  -e MYSQL_DATABASE=espark \
  -h epsark-mysql \
  -v mysql-data:/var/lib/mysql \
  mysql:5.6


### To Build Code

- mvn clean install -DskipTests
- or
- mvn clean install -Dmaven.test.skip=true

### To Build the docker image

- $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-mysql-service .

```
[+] Building 2.4s (8/8) FINISHED                                                                                                                                                        
 => [internal] load build definition from Dockerfile                                                                                                                               0.0s
 => => transferring dockerfile: 84B                                                                                                                                                0.0s
 => [internal] load .dockerignore                                                                                                                                                  0.0s
 => => transferring context: 2B                                                                                                                                                    0.0s
 => [internal] load metadata for docker.io/library/openjdk:8                                                                                                                       1.3s
 => [auth] library/openjdk:pull token for registry-1.docker.io                                                                                                                     0.0s
 => [internal] load build context                                                                                                                                                  0.7s
 => => transferring context: 38.57MB                                                                                                                                               0.7s
 => CACHED [1/2] FROM docker.io/library/openjdk:8@sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8                                                          0.0s
 => [2/2] ADD target/springboot-mysql-service.jar springboot-mysql-service.jar                                                                                                     0.1s
 => exporting to image                                                                                                                                                             0.2s
 => => exporting layers                                                                                                                                                            0.2s
 => => writing image sha256:869da9a04835e0a724c77697f44a811829da4378ada1783fce5bd60201084934                                                                                       0.0s
 => => naming to docker.io/adarshkumarsingh83/springboot-mysql-service  
```

### To list the image

- $ docker images ls

```
REPOSITORY                           TAG            IMAGE ID       CREATED          SIZE
espark/springboot-mysql-service   latest         0f10f013d226   50 seconds ago   569MB
```

### To push to docker hum 
* docker push adarshkumarsingh83/springboot-mysql-service

### To run the docker container

- $ docker run --rm --name springboot-mysql-service -p 8080:8080 --net espark-net adarshkumarsingh83/springboot-mysql-service

### To test the service

- $ curl http://localhost:9090/employees
