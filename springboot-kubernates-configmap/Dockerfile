FROM openjdk:8
COPY target/springboot-kubernates-configmap.jar springboot-kubernates-configmap.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /springboot-kubernates-configmap.jar