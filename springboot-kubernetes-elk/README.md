# SPRINGBOOT K8 ELK 
> Description:
> 
>
>



### build the code 
* $ mvn clean package 
* $ mvn spring-boot:run
* $ java -jar target/springboot-kubernetes-elk.jar


### TO BUILD & RUN TFS API SERVER VIA DOCKER
* $ docker build -f Dockerfile -t springboot-kubernetes-elk .
* $ docker run -e "SPRING_PROFILES_ACTIVE=default" -p 8080:8080 -t springboot-kubernetes-elk

### to debug the logs of the docker container 
* $ docker ps -a
* $ docker exec -it <docker-container-name> cat /var/[docker-container-file-system-path]]/logs/application.log > $HOME/spring.log [host-machine-file-system ]
* $ docker exec -it <friendly_boyd> cat /var/logs/application.log > $HOME/spring.log


### FOR DIRECTLY PRODUCING LOGS TO HOST MACHINE RATHER THEN THE DOCKER CONTAINER 
* $ docker container run  -p 8080:8080  -v $HOME/log:/var/logs springboot-kubernetes-elk


### FOR TESTING 
* http://localhost:8080/actuator/health
* http://localhost:8080/actuator/info
* http://localhost:8080/actuator/env
* http://localhost:8080/actuator/beans
* http://localhost:8080/actuator/metrics



### K8 DEPLOYMENT PROCESS 
