# springboot-kubernates-solr-cloud
> Description: \
> spring boot application  with solr cloud cluster \
> 

---

### Application Building 
* $ mvn clean package


### To 
$ docker-compose up
$ docker-compose down

### SOLR URL 
* http://localhost:8983/

### Api Testing 
````
$ curl -X POST http://localhost:8080/api/employees -d '{"id":"1","name":"adarsh"}' -H "Content-Type: application/json"
$ curl  -X GET http://localhost:8080/api/employees/1
````

### TO LIST DOWN ALL THE IMAGES
* $ docker images

### TO LIST ALL THE PROCESS
* $ dcker ps -a

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)