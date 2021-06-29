# springboot-kubernates-rabbitmq
> Description: \
> spring boot rabbitmq application where \
> producer application put data on rabbitmq \
> consumer will read the data from the rabbitmq 

## springboot-rabbitmq-producer
> Description: \
> producer application put data on rabbitmq \
> it uses rabbitmq templates internally 

## springboot-rabbitmq-consumer
> Description: \
> consumer application read data from rabbitmq \
> it uses rabbitmq listener internally 
>

----

### rabbitmq mgmt console
* http://localhost:15672/
* guest/guest

### Build and execution 
* $ mvn clean package
* $ docker-compose up
* $ docker-compose down

* Post
````
curl -H "Content-type:application/json"  \
-d '{"messageId":"1","sender":"adarsh kumar","data":"love u radha"}' \
 http://localhost:8080/api/producer/message
````


* GET
* curl http://localhost:9090/api/consumer/message


### TO LIST DOWN ALL THE IMAGES
* $ docker images

### TO LIST ALL THE PROCESS
* $ docker ps -a

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)

---- 
## K8 DEPLOYMENT AND EXECUTION PROCESS 

# build cmd for whole project
* $ mvn clean package

### TO BUILD
* $ cd springboot-rabbitmq-producer
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-rabbitmq-producer .
* $ cd springboot-rabbitmq-consumer
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-rabbitmq-consumer .

### TO PUSH TO DOCKER HUB
* $ docker push adarshkumarsingh83/springboot-rabbitmq-producer
* $ docker push adarshkumarsingh83/springboot-rabbitmq-consumer


* $ kubectl cluster-info

### to create service and other in kubernetes
* $ cd kubernates
* $ kubectl apply -f $(pwd)/secret.yml
* $ kubectl apply -f $(pwd)/configmap.yml
* $ kubectl apply -f $(pwd)/rabbitmq.yml
* $ kubectl apply -f $(pwd)/producer.yml
* $ kubectl apply -f $(pwd)/consumer.yml


### to view the service and other
* $ kubectl get all

### TO VIEW THE POD DETAILS
* $ kubectl get pod

### TO VIEW THE LOGS OF THE POD
* $ kubectl logs <pod-name> -f

----
## TO TEST THE API
* Post
````
curl -H "Content-type:application/json"  \
-d '{"messageId":"1","sender":"adarsh kumar","data":"love u radha"}' \
http://localhost:8080/api/producer/message
````

* GET
* curl http://localhost:9090/api/consumer/message
----

### TO DELETE CONFIG MAP
* $ kubectl delete configmap rabbit-conf -n default

### TO DELETE SECRET
* $ kubectl delete secret rabbit-secret

### FOR DELETING DEPLOYMENT AND SERVICE
* $ kubectl delete services  springboot-rabbitmq-producer
* $ kubectl delete deployment  springboot-rabbitmq-producer
* $ kubectl delete services  springboot-rabbitmq-consumer
* $ kubectl delete deployment  springboot-rabbitmq-consumer
* $ kubectl delete services  rabbitmq
* $ kubectl delete statefulsets  rabbitmq
