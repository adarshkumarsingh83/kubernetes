FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/espark-employee-service.jar espark-employee-service.jar
EXPOSE 8282
ENV PORT 8282
ENTRYPOINT ["java","-jar","espark-employee-service.jar"]