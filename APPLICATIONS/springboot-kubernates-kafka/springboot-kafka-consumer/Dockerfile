FROM openjdk:8
ADD target/springboot-kafka-consumer.jar springboot-kafka-consumer.jar
EXPOSE 9191
ENTRYPOINT ["java","-jar","springboot-kafka-consumer.jar"]