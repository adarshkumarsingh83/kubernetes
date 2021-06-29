# springboot-kubernates-solr-cloud
> Description: \
> spring boot application with solr cloud cluster \
> where application is performing curd operation on the \
> employee data which will be indexed on the solr 

---

### Application Building 
* $ mvn clean package

### To bring up docker compose 
* $ docker-compose up
* $ docker-compose down

### SOLR URL 
* http://localhost:8983/
* http://localhost:8984/

### Api Testing 
````
### To get the list of collection 
$ curl http://localhost:8983/solr/admin/collections?action=List&omitHeader=true&wt=xml&indent=true
### TO CREATE A CORE INTO THE SOLR 
$ curl http://localhost:8983/solr/admin/collections?action=CREATE&name=employee&numShards=2&collection.configName=_default
$ curl -X POST http://localhost:8080/api/employees -d '{"id":"1","name":"adarsh"}' -H "Content-Type: application/json"
$ curl -X POST http://localhost:8080/api/employees -d '{"id":"2","name":"radha"}' -H "Content-Type: application/json"
$ curl -X GET http://localhost:8080/api/employee/1
$ curl -X GET http://localhost:8080/api/employee/2
$ curl -X GET http://localhost:8080/api/employees
````

### TO LIST DOWN ALL THE IMAGES
* $ docker images

### TO LIST ALL THE PROCESS
* $ dcker ps -a

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)

---
## K8 DEPLOYMENT PROCESS 

### Application Building 
* $ mvn clean package

### To build the docker image and tag
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernates-solr-cloud .

### to push the docker image to the docker hub
* $ docker push adarshkumarsingh83/springboot-kubernates-solr-cloud

### Configurations 
* $ kubectl apply -f $(pwd)/kubernates/configmap.yml
* $ kubectl describe configmaps application-conf

### zookeeper & solr cluster cluster 
* $ kubectl apply -f $(pwd)/kubernates/zk.yml
* $ kubectl apply -f $(pwd)/kubernates/s1.yml
* $ kubectl apply -f $(pwd)/kubernates/s2.yml
* $ kubectl apply -f $(pwd)/kubernates/app.yml

### VERIFY THE K8 COMPONENTS 
### to view the service and other
* $ kubectl get all

### TO VIEW THE POD DETAILS
* $ kubectl get pod

### TO VIEW THE LOGS OF THE POD
* $ kubectl logs <pod-name> -f

----


### SOLR URL 
* http://localhost:8983/
* http://localhost:8984/

### Api Testing 
````
### To get the list of collection 
$ curl http://localhost:8983/solr/admin/collections?action=List&omitHeader=true&wt=xml&indent=true
### TO CREATE A CORE INTO THE SOLR 
$ curl http://localhost:8983/solr/admin/collections?action=CREATE&name=employee&numShards=2&collection.configName=_default
$ curl -X POST http://localhost:8080/api/employees -d '{"id":"1","name":"adarsh"}' -H "Content-Type: application/json"
$ curl -X POST http://localhost:8080/api/employees -d '{"id":"2","name":"radha"}' -H "Content-Type: application/json"
$ curl -X GET http://localhost:8080/api/employee/1
$ curl -X GET http://localhost:8080/api/employee/2
$ curl -X GET http://localhost:8080/api/employees
````


### FOR DELETING ZOO KEEPER
* $ kubectl delete services zookeeper solr1 solr2 springboot-kubernates-solr-cloud
* $ kubectl delete deployment zookeeper springboot-kubernates-solr-cloud
* $ kubectl delete statefulset solr1 solr2 

### FOR DELETING CONFIG MAP
* $ kubectl delete configmap application-conf -n default

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
$ docker rmi -f $(docker images -a -q)

--- 

### CLEAN UP ACTIVITY IN SINGLE CMD 
* $ kubectl delete --all pods
* $ kubectl delete --all services
* $ kubectl delete --all configmap
* $ kubectl delete --all statefulset
* $ kubectl delete --all deployment
