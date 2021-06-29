FROM openjdk:8
ADD target/springboot-kafka-producer.jar springboot-kafka-producer.jar
EXPOSE 8181
ENTRYPOINT ["java","-jar","springboot-kafka-producer.jar"]