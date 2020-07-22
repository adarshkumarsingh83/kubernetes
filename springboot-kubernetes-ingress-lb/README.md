# SPRING BOOT K8 INGRESS LB 
> Description: \
> spring boot services managed by ingress lb \
> ingress lb will do load balancing in k8 
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
* $ kubectl apply -f $(pwd)/kubernates/ingress.yaml

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

### cluster info dump 
* $ kubectl cluster-info dump
----
### Changes in /etc/hosts
* $ sudo vi /etc/hosts
crt+i
 ````
 127.0.0.1 espark.com test.com
 ````
:wq

----
## TESTING SERVICES 

* http://localhost:8080/v1/api/address/{id}
* http://localhost:8080/v1/api/address/all
* http://localhost:8080/v1/api/address/config

* http://localhost:8080/v1/api/employee/{id}
* http://localhost:8080/v1/api/employee/all
* http://localhost:8080/v1/api/employee/config

* http://espark.com:8080/v1/api/employee/all

----
## CLEAN UP 
### FOR DELETING DEPLOYMENT AND SERVICE
* $ kubectl delete services  espark-address-service espark-employee-service
* $ kubectl delete deployment  espark-address-service espark-employee-service
* $ kubectl delete ingress springboot-ingress

### TO DELETE CONFIG MAP
* $ kubectl delete configmap  kubernates-configmap-store -n default

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)
----

### installing k8 dashboard 
* $ kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v1.10.1/src/deploy/recommended/kubernetes-dashboard.yaml
* $ kubectl proxy
* http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/#!/login



