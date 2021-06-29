FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/espark-config-server.jar espark-config-server.jar
EXPOSE 8888
ENV PORT 8888
ENV REGISTRY_HOST=espark-config-server
ENTRYPOINT ["java","-jar","espark-config-server.jar"]