# springboot k8 ngix proxy & lb
> Description: \
> spring boot rest and web application 

----

### To build the application
* $ mvn clean package

### To execute the application 
* $ docker-compose up 
* $ docker-compose down 

### To test
* $ curl localhost:8080
* $ curl localhost:8080/api/message

* $ curl localhost:80
* $ curl localhost:80/api/message


---- 
## K8 DEPLOYMENT PROCESS 

### To build the docker image and tag
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernates-ngnix .

### to push the docker image to the docker hub 
* $ docker push adarshkumarsingh83/springboot-kubernates-ngnix

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
* $ kubectl delete services springboot-kubernates-ngnix1 springboot-kubernates-ngnix2 springboot-kubernates-ngnix3 springboot-kubernates-ngnix4 nginx
* $ kubectl delete deployment springboot-kubernates-ngnix1 springboot-kubernates-ngnix2 springboot-kubernates-ngnix3 springboot-kubernates-ngnix4 nginx

### TO DELETE CONFIG MAP
* $ kubectl delete configmap nginx-conf -n default

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)