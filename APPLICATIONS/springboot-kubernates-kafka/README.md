# SPRING BOOT K8 KAFKA & ZOOKEEPER 
>Description: \
> spring boot application with kaffa queue \
> where producer will keep data into the queue \ 
> consumer will take data from queue.
---

### To Build application
* $ mvn clean package

----
### download kafka locally

````
https://www.apache.org/dyn/closer.cgi?path=/kafka/2.5.0/kafka_2.12-2.5.0.tgz

Start Zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

Start Kafka Server
bin/kafka-server-start.sh config/server.properties

Create Kafka Topic
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic espark-topic

Consume from the Kafka Topic via Console
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic espark-topic --from-beginning

Deleting topic
bin/kafka-topics.sh --zookeeper localhost:2181 --delete --topic espark-topic
````

### Docker compose 
* $ docker-compose up 
* $ docker-compose down

----
### TESTING THE API
----

* post
````
$ curl --location --request POST 'http://localhost:8181/api/message' \
--header 'Content-Type: application/json' \
--data-raw '{"id":"1","data":"adarsh kumar love u radha","definition":"notification"}'
$ curl --location --request POST 'http://localhost:8181/api/message' \
--header 'Content-Type: application/json' \
--data-raw '{"id":"2","data":"radha singh love u adi","definition":"notification"}'
````

* @get
````
$ curl http://localhost:9191/api/message/1
$ curl http://localhost:9191/api/message/2
$ curl http://localhost:9191/api/messages
````


### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)


----

### To start the minikube 
* minikube start --vm-driver=hyperkit

### To enable dashboard 
* minikube addons enable [dashboard]

### To open dashboard 
* minikube dashboard

### To delete the minikube cluster 
* minikube delete

## K8 DEPLOYMENT PROCESS 
---

### Configurations 
* $ kubectl apply -f $(pwd)/kubernates/configmap.yml
* $ kubectl describe configmaps application-conf

### kafka zookeeper cluster 
* $ kubectl apply -f $(pwd)/kubernates/zk.yml
* $ kubectl apply -f $(pwd)/kubernates/kafka0.yml
* $ kubectl apply -f $(pwd)/kubernates/kafka1.yml

### mysql secret
* $ kubectl apply -f $(pwd)/kubernates/secret.yml
* $ kubectl describe secret mysql-credentials
* $ kubectl apply -f $(pwd)/kubernates/mysql.yml

### spring boot services 
* $ kubectl apply -f $(pwd)/kubernates/producer.yml
* $ kubectl apply -f $(pwd)/kubernates/consumer.yml

### VERIFY THE K8 COMPONENTS 

### to view the service and other
* $ kubectl get all

### TO VIEW THE POD DETAILS
* $ kubectl get pod

### TO VIEW THE LOGS OF THE POD
* $ kubectl logs <pod-name> -f

----
### TESTING THE API
----
* post
````
$ curl --location --request POST 'http://localhost:8181/api/message' \
--header 'Content-Type: application/json' \
--data-raw '{"id":"1","data":"adarsh kumar love u radha","definition":"notification"}'
$ curl --location --request POST 'http://localhost:8181/api/message' \
--header 'Content-Type: application/json' \
--data-raw '{"id":"2","data":"radha singh love u adi","definition":"notification"}'
````

* @get
* $ curl http://localhost:9191/api/message/1
* $ curl http://localhost:9191/api/message/2
* $ curl http://localhost:9191/api/messages

----

### FOR DELETING PRODUCER
* $ kubectl delete services springboot-kafka-producer
* $ kubectl delete deployment springboot-kafka-producer


### FOR DELETING CONSUMER
* $ kubectl delete services springboot-kafka-consumer
* $ kubectl delete deployment springboot-kafka-consumer


### FOR DELETING KAFKA
* $ kubectl delete services kafka-service0 kafka-service1
* $ kubectl delete deployment kafka-broker0 kafka-broker1

### FOR DELETING ZOO KEEPER
* $ kubectl delete services zookeeper
* $ kubectl delete deployment zookeeper


### FOR DELETING DEPLOYMENT AND SERVICE OF MYSQL
* $ kubectl delete services mysql
* $ kubectl delete deployment mysql
* $ kubectl delete pvc mysql-pv-claim


### FOR DELETING SECRET
* $ kubectl delete  secret/mysql-credentials

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