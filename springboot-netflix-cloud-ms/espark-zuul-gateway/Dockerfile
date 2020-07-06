FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/espark-zuul-gateway.jar espark-zuul-gateway.jar
EXPOSE 8080
ENV PORT 8080
ENTRYPOINT ["java","-jar","espark-zuul-gateway.jar"]