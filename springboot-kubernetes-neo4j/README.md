# SPRING BOOT NEO4J K8 
> Description:   \
> spring boot application with neo4j spring data jpa repository \
> with curd operation and rest endpoints for curd operation 

----
# LOCAL TESTING 

### FOR DOCKER COMPOSE UP 
* $ docker-compose up
* $ docker-compose down

### To log into the console of the neo4j
* http://localhost:7474/browser/
* user/pwd => neo4j/secret

### Code Build
* $ mvn clean package 

### APPLICATION EXECUTION 
* $ java -jar target/springboot-kubernetes-neo4j.jar 
* $ mvn spring-boot:run 
----
### @POST
* $ curl -X POST http://localhost:8080/api/employee -d '{"id":"100","name":"adarsh kumar"}' -H "Content-Type: application/json"
* $ curl -X POST http://localhost:8080/api/department -d '{"id":"1","name":"it"}' -H "Content-Type: application/json"

### @GET
* $ curl -X GET http://localhost:8080/api/graph/10
* $ curl -X GET http://localhost:8080/api/departments/it
* $ curl -X GET http://localhost:8080/api/employee/100 
* $ curl -X GET http://localhost:8080/api/employees
----

---- 
# K8 DEPLOYMENT PROCESS 

### Code Build
* $ mvn clean package 

### FOR DOCKER IMAGE BUILDING
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernetes-neo4j .

### to push the docker image to the docker hub
* $ docker push adarshkumarsingh83/springboot-kubernetes-neo4j

### DEPLOYMENTS
* $ kubectl apply -f $(pwd)/kubernates/neo4j.yml
* $ kubectl apply -f $(pwd)/kubernates/service.yml


### To log into the console of the neo4j
* http://localhost:7474/browser/
* user/pwd => neo4j/secret

### TO VIEW THE DETAILS
* $ kubectl cluster-info
* $ kubectl get all

### for system pods listing
* $ kubectl get pods -n kube-system

### TO VIEW THE POD DETAILS
* $ kubectl get pod
 
### cluster info dump
* $ kubectl cluster-info dump
 
----
### @POST
* $ curl -X POST http://localhost:8080/api/employee -d '{"id":"100","name":"adarsh kumar"}' -H "Content-Type: application/json"
* $ curl -X POST http://localhost:8080/api/department -d '{"id":"1","name":"it"}' -H "Content-Type: application/json"

### @GET
* $ curl -X GET http://localhost:8080/api/graph/10
* $ curl -X GET http://localhost:8080/api/departments/it
* $ curl -X GET http://localhost:8080/api/employee/100 
* $ curl -X GET http://localhost:8080/api/employees
----
## CLEAN UP 


### SERVICE, DEPLOYMENT, PV, AND PVC CLEAN UP 
* $ kubectl delete service neo4j-lb springboot-kubernetes-neo4j
* $ kubectl delete deployment neo4j-db springboot-kubernetes-neo4j
* $ kubectl delete PersistentVolumeClaim neo4j-data-claim
* $ kubectl delete PersistentVolume neo4j-data-storage


### TO LIST DOWN ALL THE IMAGES
* $ docker images

### TO LIST ALL THE PROCESS
* $ docker ps -a

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)