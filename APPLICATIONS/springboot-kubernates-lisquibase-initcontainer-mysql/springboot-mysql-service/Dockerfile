FROM openjdk:8
ADD target/springboot-mysql-service.jar springboot-mysql-service.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","springboot-mysql-service.jar"]