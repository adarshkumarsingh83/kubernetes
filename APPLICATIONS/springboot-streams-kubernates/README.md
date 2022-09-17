# SPRING BOOT STREAM PRODUCER AND CONSUMERS FOR KAFKA AND RABBITMQ 

----

> this project just post the data to the messag provider rabbit or kafaka 
> and reads it back using listner it has maven profile binded with spring profile to build code 
> for specific messag provider and docker image will build based on that and excuted 



## KAFKA PRODUCER AND CONSUME 

### To Run kakfa locally 

* [downlaod kafka](https://www.apache.org/dyn/closer.cgi?path=/kafka/2.5.0/kafka_2.12-2.5.0.tgz)

```
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
```

## KAFKA PRODUCER PROCESSOR AND CONSUMER 
* [KAFKA-PRODUCER](./springboot-kafka-rabbitmq-producer/KAFKA-README.md)
* [KAFKA-PROCESSOR](./springboot-kafka-rabbitmq-processor/KAFKA-README.md)
* [KAFKA-CONSUMNER](./springboot-kafka-rabbitmq-consumer/KAFKA-README.md)


---

### To run rabbit 
* docker run --name espark-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3-management


## RABBIT MQ PRODUCER PROCESSOR AND CONSUMER 
* [RABBIT-PRODUCER](./springboot-kafka-rabbitmq-producer/RABBIT-README.md)
* [RABBIT-PROCESSOR](./springboot-kafka-rabbitmq-processor/RABBIT-README.md)
* [RABBIT-CONSUMNER](./springboot-kafka-rabbitmq-consumer/RABBIT-README.md)


### To Exeucte kafka docker compose
* docker compose -f docker-compose-kafka.yml up
* docker compose -f docker-compose-kafka.yml down


### To Exeucte rabbit docker compose
* docker compose -f docker-compose-rabbit.yml up 
* docker compose -f docker-compose-rabbit.yml down 

---

# K8

### To start the minikube 
* minikube start --vm-driver=hyperkit

### To enable dashboard 
* minikube addons enable dashboard

### To open dashboard 
* minikube dashboard

### To delete the minikube cluster 
* minikube delete

### for Kafka 
* $ kubectl apply -f $(pwd)/kafka-kubernates/configmap.yml
* $ kubectl apply -f $(pwd)/kafka-kubernates/zk.yml
* $ kubectl apply -f $(pwd)/kafka-kubernates/kafka.yml
* $ kubectl apply -f $(pwd)/kafka-kubernates/producer.yml
* $ kubectl apply -f $(pwd)/kafka-kubernates/processor.yml
* $ kubectl apply -f $(pwd)/kafka-kubernates/consumer.yml


### Port Forwarding 
* kubectl port-forward svc/springboot-kafka-producer 8080:8080 

### To post daa to the api 
* $ curl --location --request POST 'http://localhost:8080/api/message' \
--header 'Content-Type: application/json' \
--data-raw '{"id":1,"name":"adarsh kumar","message":"love u radha"}'

* $ curl --location --request POST 'http://localhost:8080/api/message' \
--header 'Content-Type: application/json' \
--data-raw '{"id":2,"name":"radha singh","message":"love u adi"} '
---

### for Rabbitmq 
* $ kubectl apply -f $(pwd)/rabbit-kubernates/secret.yml
* $ kubectl apply -f $(pwd)/rabbit-kubernates/configmap.yml
* $ kubectl apply -f $(pwd)/rabbit-kubernates/rabbitmq.yml
* $ kubectl apply -f $(pwd)/rabbit-kubernates/producer.yml
* $ kubectl apply -f $(pwd)/rabbit-kubernates/processor.yml
* $ kubectl apply -f $(pwd)/rabbit-kubernates/consumer.yml

### port forwardind 
* $ kubectl port-forward svc/rabbitmq 15672:15672
* kubectl port-forward svc/springboot-rabbitmq-producer 8080:8080 
