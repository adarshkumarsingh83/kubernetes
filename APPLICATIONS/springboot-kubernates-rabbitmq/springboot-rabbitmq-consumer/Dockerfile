FROM openjdk:8
ADD target/springboot-rabbitmq-consumer.jar springboot-rabbitmq-consumer.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","springboot-rabbitmq-consumer.jar"]