# SPRING BOOT KUBERNATES HAZELCAST EXTERNAL 
> Description: \
> spring boot hazelcast client which connect to \
> hazelcast cluster and management center \
> connected to the hazel cast 

----
# To Execute locally 

### To build the application 
* $ mvn clean package 

###To execute hazelcast locally
````
extract the zip file then 'hazelcast-3.12.7.zip'
got to hazelcast-3.12.7/bin
then $ sh start.sh
for stopping $ sh stop.sh
````

### To kill the process on 5701
* $ sudo lsof -i tcp:5701

### to bring the docker compose 
* $ docker-compose up

### To test the application 
* $  curl -X POST http://localhost:9090/api/write -d '{"id":1,"key":"adarsh","value":"adarsh"}' -H "Content-Type: application/json"
* $ curl  -X GET http://localhost:9090/api/read/adarsh

### To bring down docker compose 
* $ docker-compose down

### TO LIST DOWN ALL THE IMAGES
* $ docker images

### TO LIST ALL THE PROCESS
* $ docker ps -a

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)

----

# To Execute on K8 

### build cmd for whole project
* $ mvn clean package

### docker image operation 
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernates-hazelcast-external .
* $ docker push adarshkumarsingh83/springboot-kubernates-hazelcast-external

### k8 cluster info
* $ kubectl cluster-info

### to create service and other in kubernetes
* $ kubectl apply -f $(pwd)/kubernates/hazelcast.yml
* $ kubectl apply -f $(pwd)/kubernates/hazelcast-mc.yml
* $ kubectl apply -f $(pwd)/kubernates/spring.yml

### to view the service and other
* $ kubectl get all

### TO VIEW THE POD DETAILS
* $ kubectl get pod

### TO VIEW THE LOGS OF THE POD
* $ kubectl logs <pod-name> -f

### TO TEST THE API
* $ curl -X POST http://localhost:9090/api/write -d '{"id":1,"key":"adarsh","value":"adarsh"}' -H "Content-Type: application/json"
* $ curl  -X GET http://localhost:9090/api/read/adarsh

### To open management center console
* http://localhost:8080

### Resource Clean up 
* $ kubectl delete statefulsets  hazelcast
* $ kubectl delete services  hazelcast

* $ kubectl delete services springboot-kubernates-hazelcast-external management-center 
* $ kubectl delete deployment springboot-kubernates-hazelcast-external management-center

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)
----