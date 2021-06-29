# SPRING BOOT K8 HAZELCAST EMBEDDED 
>Description: \
> springboot application with embedded hazelcast cache \
> k8 based hazal cast application where k8 will support for \
> embedded hazelcast which is further used by the spring boot application. 

---- 


### TO BUILD THE APPLICATION
* $ mvn clean package

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)

### TO CREATE A DOCKER IMAGE
### To build the docker image and tag
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernates-hazelcast .

### to push the docker image to the docker hub
* $ docker push adarshkumarsingh83/springboot-kubernates-hazelcast

### k8 deployment 
* $ kubectl apply -f $(pwd)/deployment.yaml

### to view the service and other
* $ kubectl get all

### TO VIEW THE POD DETAILS
* $ kubectl get pod

### TO VIEW THE LOGS OF THE POD
* $ kubectl logs <pod-name> -f

----
### TESTING APIS
* $ curl -X POST http://localhost:8080/api/hazelcast -d '{"id":1,"key":"owner","value":"adarsh"}' -H "Content-Type: application/json"

* $ curl -X GET http://localhost:8080/api/hazelcast/owner
----

### DELETION OF THE SERVICE AND DEPLOYMENTS
* $ kubectl delete deployment hazelcast-service
* $ kubectl delete service hazelcast-service

* $ kubectl delete deployment springboot-kubernates-hazelcast
* $ kubectl delete service springboot-kubernates-hazelcast