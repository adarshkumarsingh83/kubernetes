FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/espark-eureka-server.jar espark-eureka-server.jar
EXPOSE 8761
ENV PORT 8761
ENV REGISTRY_HOST=espark-eureka-server
ENTRYPOINT ["java","-jar","espark-eureka-server.jar"]