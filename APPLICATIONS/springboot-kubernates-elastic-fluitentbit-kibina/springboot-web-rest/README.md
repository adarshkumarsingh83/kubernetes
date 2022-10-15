
# springboot web rest 
> Description: \
> springboot application which has web pages \
> and rest endpoints for the consumer application. 

---- 

### To Build the application 
* $ mvn clean package 

### to create a docker image 
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-web-rest .
```    
[+] Building 1.9s (8/8) FINISHED                                                                                                                                                                      
 => [internal] load build definition from Dockerfile                                                                                                                                             0.0s
 => => transferring dockerfile: 236B                                                                                                                                                             0.0s
 => [internal] load .dockerignore                                                                                                                                                                0.0s
 => => transferring context: 2B                                                                                                                                                                  0.0s
 => [internal] load metadata for docker.io/library/openjdk:8                                                                                                                                     1.4s
 => [auth] library/openjdk:pull token for registry-1.docker.io                                                                                                                                   0.0s
 => [internal] load build context                                                                                                                                                                0.2s
 => => transferring context: 20.94MB                                                                                                                                                             0.2s
 => CACHED [1/2] FROM docker.io/library/openjdk:8@sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8                                                                        0.0s
 => [2/2] ADD target/springboot-web-rest.jar springboot-web-rest.jar                                                                                                                             0.1s
 => exporting to image                                                                                                                                                                           0.1s
 => => exporting layers                                                                                                                                                                          0.1s
 => => writing image sha256:f97c4d9213825b229ea791f1a37370a4c7e13a03b6b2a682e3fb2456dd26cc9a                                                                                                     0.0s
 => => naming to docker.io/adarshkumarsingh83/springboot-web-rest  
```
### To view the docker iamge 
* $ docker images
```
REPOSITORY                                 TAG                   IMAGE ID       CREATED          SIZE
adarshkumarsingh83/springboot-web-rest     latest                f97c4d921382   25 seconds ago   547MB 
```
### to execute the docker image 
* $ docker run -p 8080:8080 adarshkumarsingh83/springboot-web-rest

### to test the image 
* $ curl localhost:8080/api/message
```
{
  "ip": " Your current IP address : 4f66568f8015/172.17.0.2",
  "host": " Your current Hostname : 4f66568f8015",
  "message": " WELCOME FORM ESPARK "
  }
```

### to push to docker repository 
* $ docker push adarshkumarsingh83/springboot-web-rest

----
### Deploy the Application to Kubernetes
----

### To create a sample deployment file 
* $ kubectl create deployment springboot-web-rest --image=adarshkumarsingh83/springboot-web-rest --dry-run=client -o=yaml > deployment.yaml

### To add Separator in the file 
* $ echo --- >> deployment.yaml

### To create a service cluster
* $ kubectl create service LoadBalancer springboot-web-rest --tcp=8080:8080 --dry-run=client -o=yaml >> deployment.yaml


### apply the service 
* $ kubectl apply -f ./$(pwd)/kubernates/springboot-deployment.yml
````
 logs
 deployment.apps/springboot-docker-xxx created
 service/springboot-docker-xxx created
````

### to get the pods shows its status as "Running".
* $ kubectl get all
* $ kubectl port-forward svc/springboot-web-rest 8080:8080

### to hit endpoint 
* $ curl localhost:8080/api/message
