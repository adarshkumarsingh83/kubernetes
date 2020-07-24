# [springboot-kubernetes-redis-cache](https://github.com/adarshkumarsingh83/kubernetes/tree/master/springboot-kubernetes-redis-cache)
> Description: \
> spring boot redis cache data repository example 

----

### To Execute the Redis docker images
* $  docker run -d -p 6379:6379 --name espark-redis redis
* $  docker ps
* $  docker logs espark-redis
* $  docker exec -it espark-redis sh
* $  redis-cli

````
127.0.0.1:6379> ping
127.0.0.1:6379> set name espark
OK
127.0.0.1:6379> get name
"espark"
127.0.0.1:6379> incr counter
(integer) 1
127.0.0.1:6379> incr counter
(integer) 2
127.0.0.1:6379> get counter
"2"
127.0.0.1:6379> exit
#exit
````

### Connecting from other docker container 
* $ docker run -it --rm --link espark-redis:redis --name espark-client redis sh
*  redis-cli -h redis
````
redis:6379>
redis:6379> get name
"espark"
redis:6379> get counter
"2"
redis:6379> exit
# exit
````

### To clean up the redis docker
```` 
* $ docker stop espark-redis
* $ docker rm espark-redis
* $ docker image ls
* $ docker image rm -f redis
````

----

### Build the application 
* $ mvn clean package -DskipTests 
* $ mvn spring-boot:run 

----

### Api Testing 
* $ curl -d '{"id":"100","userName":"adarsh kumar"}' -H 'Content-Type: application/json' -X POST http://localhost:8080/api/v1/users
* $ curl -d '{"id":"101","userName":"amit kumar"}' -H 'Content-Type: application/json' -X POST http://localhost:8080/api/v1/users
* $ curl -d '{"id":"200","userName":"radha singh"}' -H 'Content-Type: application/json' -X POST http://localhost:8080/api/v1/users
* $ curl -X GET http://localhost:8080/api/v1/users


----

## KUBERNETES DEPLOYMENT

### K8 Service deployment  
* $ kubectl apply -f $(pwd)/kubernates/config.yml 
* $ kubectl apply -f $(pwd)/kubernates/redis.yml 


### spring boot application deployment 
* $ mvn clean package -DskipTests 
* $ docker build -f Dockerfile -t springboot-kubernetes-redis-cache .
* $ docker push adarshkumarsingh83/springboot-kubernetes-redis-cache
* $ kubectl apply -f $(pwd)/kubernates/app.yml


### TO VIEW THE LOGS IN THE K8 POD 
* $ kubectl get all 
* $ kubectl get pod 
* $ kubectl exec -it <pod-name> -- /bin/bash

### TO VIEW THE POD DETAILS
* $ kubectl get pod

### TO VIEW THE LOGS OF THE POD
* $ kubectl logs <pod-name> -f

### Deletion of service deployment configmap statefulset
* $ kubectl delete services redis-cluster
* $ kubectl delete deployment redis-cluster
* $ kubectl delete statefulset redis-cluster
* $ kubectl delete configmap redis-cluster

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)