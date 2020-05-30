FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/espark-api-service.jar espark-api-service.jar
EXPOSE 8181
ENV PORT 8181
ENTRYPOINT ["java","-jar","espark-api-service.jar"]