# SPRING BOOT ELASTIC SEARCH KIBINA
> Description:
> spring boot elastic search example 
> where data indexed to the elastic search using 
> spring data repository and then kibina is used to view the indexed data  
> 

### To start the elastic docker 
* docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node"  --name elasticsearch docker.elastic.co/elasticsearch/elasticsearch:7.8.0

### To start the kibana for the elastic search 
* docker run --link elasticsearch -p 5601:5601 docker.elastic.co/kibana/kibana:7.8.0
  
### To compile the application 
* mvn clean package -DskipTests

### To execute the application 
* $ mvn spring-boot:run
* $ java -jar target/springboot-kubernetes-elasticsearch-kibana.jar

### To execute application via docker image 
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernetes-elasticsearch-kibana .
* $ docker run -e "SPRING_PROFILES_ACTIVE=default" -p 8080:8080 adarshkumarsingh83/springboot-kubernetes-elasticsearch-kibana

### To test the services 
* curl http://localhost:8080/api/employee
* curl http://localhost:8080/api/employee/100
 

----
### K8 DEPLOYMENT PROCESS

----
### ELASTIC SEARCH 
* $ kubectl cluster-info
* $ kubectl apply -f $(pwd)/kubernates/elasticsearch.yml
* $ kubectl get all
* To list the available elastic web services  localhost:9200
* To list the available elastic web services  localhost:9200/_cat
* To list the available index on the elastic  localhost:9200/_cat/indices
---- 
### FOR KIBINA 

* $ kubectl cluster-info
* $ kubectl apply -f $(pwd)/kubernates/kibana.yml
* $ kubectl get all  
* To log into the kibina console   http://localhost:5601
---- 
### SPRING BOOT APPLICATION
* $ mvn clean package -DskipTests
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernetes-elasticsearch-kibana .
* $ docker push adarshkumarsingh83/springboot-kubernetes-elasticsearch-kibana
* $ kubectl cluster-info
* $ kubectl apply -f $(pwd)/kubernates/app.yml
* $ kubectl get all

----
### TO VIEW THE LOGS IN THE K8 POD 
* $ kubectl get all 
* $ kubectl get pod 
* $ kubectl exec -it <pod-name> -- /bin/bash


### TO VIEW THE POD DETAILS
* $ kubectl get pod

### TO VIEW THE LOGS OF THE POD
* $ kubectl logs <pod-name> -f

----
### To test the services 
* curl http://localhost:8080/api/employee
* curl http://localhost:8080/api/employee/100

----

### TO DELETE DEPLOYMENT & SERVICE 
* $ kubectl delete services elasticsearch kibana springboot-kubernetes-elasticsearch-kibana
* $ kubectl delete deployment  kibana springboot-kubernetes-elasticsearch-kibana
* $ kubectl delete statefulset elasticsearch 



### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)