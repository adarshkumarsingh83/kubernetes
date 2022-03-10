# SPRINGBOOT JPA ORACLE DB LIQUIDBASE

---

### [step by step guide for oracle xe db docker image creation ](ORACLEDB-DOCKER-IMAGE-README.md)

### To Build Code

* mvn clean package

### To Build the docker image

* $ docker build -f Dockerfile -t espark/springboot-oracledb-service .
```
[+] Building 14.7s (7/7) FINISHED                                                                                                                                                                     
 => [internal] load build definition from Dockerfile                                                                                                                                             0.0s
 => => transferring dockerfile: 206B                                                                                                                                                             0.0s
 => [internal] load .dockerignore                                                                                                                                                                0.0s
 => => transferring context: 2B                                                                                                                                                                  0.0s
 => [internal] load metadata for docker.io/library/openjdk:8                                                                                                                                     1.4s
 => [internal] load build context                                                                                                                                                                0.7s
 => => transferring context: 43.15MB                                                                                                                                                             0.7s
 => [1/2] FROM docker.io/library/openjdk:8@sha256:245ee43af1ed7d94f904ed7df0a7d9b6cda6513bd60fe8d484aaea9bc3e8d9b1                                                                              12.8s
 => => resolve docker.io/library/openjdk:8@sha256:245ee43af1ed7d94f904ed7df0a7d9b6cda6513bd60fe8d484aaea9bc3e8d9b1                                                                               0.0s
 => => sha256:89fd67087664a9a10fd9321cd7b3935369e4029f87e562a90ad7685d35559074 7.81kB / 7.81kB                                                                                                   0.0s
 => => sha256:e4d61adff2077d048c6372d73c41b0bd68f525ad41f5530af05098a876683055 54.92MB / 54.92MB                                                                                                 3.5s
 => => sha256:245ee43af1ed7d94f904ed7df0a7d9b6cda6513bd60fe8d484aaea9bc3e8d9b1 1.04kB / 1.04kB                                                                                                   0.0s
 => => sha256:763ecc9f11937fd3af8a9721e65d2481e4e3b230202474d4d387cf373cef86ee 1.79kB / 1.79kB                                                                                                   0.0s
 => => sha256:4ff1945c672b08a1791df62afaaf8aff14d3047155365f9c3646902937f7ffe6 5.15MB / 5.15MB                                                                                                   0.7s
 => => sha256:ff5b10aec998344606441aec43a335ab6326f32aae331aab27da16a6bb4ec2be 10.87MB / 10.87MB                                                                                                 1.0s
 => => sha256:12de8c754e45686ace9e25d11bee372b070eed5b5ab20aa3b4fab8c936496d02 54.58MB / 54.58MB                                                                                                 4.3s
 => => sha256:4848edf445067f98c6b8a509dedaf172cbffa5273efa89273a90cff48cffa416 5.42MB / 5.42MB                                                                                                   1.5s
 => => sha256:612ca5886be9e1e0bb406743fb5b2078ab1107f3869b6f5a487d5db747e688fc 211B / 211B                                                                                                       1.6s
 => => sha256:3c8418aa597a9edf38f2cbe9c55845aa3be39a45114746b31893fd193aaf3c6a 106.07MB / 106.07MB                                                                                               6.3s
 => => extracting sha256:e4d61adff2077d048c6372d73c41b0bd68f525ad41f5530af05098a876683055                                                                                                        2.4s
 => => extracting sha256:4ff1945c672b08a1791df62afaaf8aff14d3047155365f9c3646902937f7ffe6                                                                                                        0.2s
 => => extracting sha256:ff5b10aec998344606441aec43a335ab6326f32aae331aab27da16a6bb4ec2be                                                                                                        0.3s
 => => extracting sha256:12de8c754e45686ace9e25d11bee372b070eed5b5ab20aa3b4fab8c936496d02                                                                                                        2.3s
 => => extracting sha256:4848edf445067f98c6b8a509dedaf172cbffa5273efa89273a90cff48cffa416                                                                                                        0.2s
 => => extracting sha256:612ca5886be9e1e0bb406743fb5b2078ab1107f3869b6f5a487d5db747e688fc                                                                                                        0.0s
 => => extracting sha256:3c8418aa597a9edf38f2cbe9c55845aa3be39a45114746b31893fd193aaf3c6a                                                                                                        2.9s
 => [2/2] ADD target/springboot-oracledb-service.jar springboot-oracledb-service.jar                                                                                                             0.1s
 => exporting to image                                                                                                                                                                           0.2s
 => => exporting layers                                                                                                                                                                          0.2s
 => => writing image sha256:0f10f013d22632a3b26913c445c519f277fc47c8bd00c69c507b2fa45a4b1e32                                                                                                     0.0s
 => => naming to docker.io/espark/springboot-oracledb-service    
```

### To list the image 
* $ docker images ls 
```
REPOSITORY                           TAG            IMAGE ID       CREATED          SIZE
espark/springboot-oracledb-service   latest         0f10f013d226   50 seconds ago   569MB
espark/liquibase                     latest         64a96c2ca688   5 hours ago      374MB
liquibase/liquibase                  latest         92d9c4600558   2 weeks ago      364MB
oracle/database                      18.4.0-xe      c265dc4e3bd6   3 months ago     5.89GB
```
### To run the docker container

* $ docker run --rm --name espark-springboot-service -p 8080:8080 --net espark-net espark/springboot-oracledb-service

### To test the service

* $ curl http://localhost:8080/employees