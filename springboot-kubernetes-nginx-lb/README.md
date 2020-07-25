# SPRING BOOT K8 NGINX LB 
> Description: \
> spring boot services managed by nginx lb & reverse proxy \
> nginx lb will do load balancing in k8 and reverse proxy for the clients
>
>

### Build the application 
* $ mvn clean package -Pkubernates

## TO CREATE A DOCKER IMAGE & PUSHING TO REPO

----

### for espark-address-service
* $ cd espark-address-service
* $ docker build -f Dockerfile -t adarshkumarsingh83/espark-address-service .

### to push the docker image to the docker hub
* $ docker push adarshkumarsingh83/espark-address-service

----

### for espark-employee-service
* $ cd espark-employee-service
* $ docker build -f Dockerfile -t adarshkumarsingh83/espark-employee-service .

### to push the docker image to the docker hub
* $ docker push adarshkumarsingh83/espark-employee-service

----
## DEPLOYMENTS 
### TO DO THE DEPLOYMENT OF THE SERVICE
* $ kubectl apply -f $(pwd)/kubernates/config.yaml
* $ kubectl apply -f $(pwd)/kubernates/address.yaml
* $ kubectl apply -f $(pwd)/kubernates/employee.yaml
* $ kubectl apply -f $(pwd)/kubernates/nginx-config.yaml
* $ kubectl apply -f $(pwd)/kubernates/nginx.yaml

----
## VERIFY DEPLOYMENTS 
### TO VIEW THE DETAILS
* $ kubectl cluster-info
* $ kubectl get all

### for system pods listing 
* $ kubectl get pods -n kube-system

### TO VIEW THE POD DETAILS
* $ kubectl get pod

### To get the Ip Address of Ingress
* $ kubectl get ingress springboot-ingress
* $ kubectl get pods -n ingress-nginx -l app.kubernetes.io/name=springboot-ingress --watch

### cluster info dump 
* $ kubectl cluster-info dump
----
### Changes in /etc/hosts
* $ sudo vi /etc/hosts
* crt+i
 ````
 127.0.0.1 espark.com test.com
 ````
* :wq

----
## TESTING SERVICES 

* http://localhost/v1/api/address/{id}
* http://localhost/v1/api/address/all
* http://localhost/v1/api/address/config

* http://localhost/v1/api/employee/{id}
* http://localhost/v1/api/employee/all
* http://localhost/v1/api/employee/config

* OR 

* http://espark.com/v1/api/address/{id}
* http://espark.com/v1/api/address/all
* http://espark.com/v1/api/address/config

* http://espark.com/v1/api/employee/{id}
* http://espark.com/v1/api/employee/all
* http://espark.com/v1/api/employee/config

----
## CLEAN UP 
### FOR DELETING DEPLOYMENT AND SERVICE
* $ kubectl delete services espark-address-service espark-employee-service nginx
* $ kubectl delete deployment espark-address-service espark-employee-service nginx

### TO DELETE CONFIG MAP
* $ kubectl delete configmap  kubernates-configmap-store -n default
* $ kubectl delete configmap  nginx-conf -n default

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)
----
### To ssh to the container 
* $ kubectl exec --stdin --tty {pod-name} -- /bin/bash


