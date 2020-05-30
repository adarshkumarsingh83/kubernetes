FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/espark-address-service.jar espark-address-service.jar
EXPOSE 8383
ENV PORT 8383
ENTRYPOINT ["java","-jar","espark-address-service.jar"]