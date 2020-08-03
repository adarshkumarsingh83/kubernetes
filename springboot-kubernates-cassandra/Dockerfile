FROM openjdk:8
ADD target/springboot-kubernates-cassandra.jar springboot-kubernates-cassandra.jar
RUN apt-get update
RUN apt-get install -y curl
EXPOSE 8080
ENTRYPOINT ["java","-jar","springboot-kubernates-cassandra.jar"]