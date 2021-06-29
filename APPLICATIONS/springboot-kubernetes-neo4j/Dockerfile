FROM openjdk:8
ADD target/springboot-kubernetes-neo4j.jar springboot-kubernetes-neo4j.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","springboot-kubernetes-neo4j.jar"]