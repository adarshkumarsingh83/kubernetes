# springboot k8 ngix proxy & lb & elk for logs 
> Description: \
> spring boot rest and web application 

----

### To build the application
* $ mvn clean package

## To Execute the application 
* mvn spring-boot:run -Dspring-boot.run.profiles=docker
* java -jar -Dspring.profiles.active=docker springboot-service.jar

### To test
* $ curl localhost:8080
* $ curl localhost:8080/api/message

* $ curl localhost:80
* $ curl localhost:80/api/message


---- 
## K8 DEPLOYMENT PROCESS 

### To build the docker image and tag
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-service .

### to push the docker image to the docker hub 
* $ docker push adarshkumarsingh83/springboot-service


## To deploye in the k8 
* $  kubectl apply -f $(pwd)/kubernates/service1.yaml
* $  kubectl apply -f $(pwd)/kubernates/service2.yaml
* $  kubectl apply -f $(pwd)/kubernates/service3.yaml
* $  kubectl apply -f $(pwd)/kubernates/service4.yaml
* $  kubectl apply -f $(pwd)/kubernates/nginx-config.yaml
* $  kubectl apply -f $(pwd)/kubernates/nginx.yaml


## VERIFY DEPLOYMENTS 
### TO VIEW THE DETAILS
* $ kubectl cluster-info
* $ kubectl get all

### To test the services 
* $ curl localhost:80
* $ curl localhost:80/api/message

### for system pods listing 
* $ kubectl get pods -n kube-system

### TO VIEW THE POD DETAILS
* $ kubectl get pod

## CLEAN UP 
### FOR DELETING DEPLOYMENT AND SERVICE
* $ kubectl delete services springboot-service1 springboot-service2 springboot-service3 springboot-service4 nginx
* $ kubectl delete deployment springboot-service1 springboot-service2 springboot-service3 springboot-service4 nginx

### TO DELETE CONFIG MAP
* $ kubectl delete configmap nginx-conf -n default
* $ kubectl delete configmap logstash-config -n default

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)