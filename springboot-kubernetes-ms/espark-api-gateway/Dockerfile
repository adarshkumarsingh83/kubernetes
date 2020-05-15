FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/espark-api-gateway.jar espark-api-gateway.jar
EXPOSE 8080
ENV PORT 8080
ENTRYPOINT ["java","-jar","espark-api-gateway.jar"]