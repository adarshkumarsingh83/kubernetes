# SPRING BOOT LOG SAMPLE

### build the code 
* $ mvn clean package 
* $ mvn spring-boot:run
* $ java -jar target/springboot-kubernetes-logs.jar


### TO BUILD & RUN TFS API SERVER VIA DOCKER
* $ docker build -f Dockerfile -t springboot-kubernetes-logs .
* $ docker run -e "SPRING_PROFILES_ACTIVE=default" -p 9090:9090 -t springboot-kubernetes-logs

### to debug the logs of the docker container 
* $ docker ps -a
* $ docker exec -it <docker-container-name> cat /var/[docker-container-file-system-path]]/logs/application.log > $HOME/spring.log [host-machine-file-system ]
* $ docker exec -it friendly_boyd cat /var/logs/application.log > $HOME/spring.log


### FOR DIRECTLY PRODUCING LOGS TO HOST MACHINE RATHER THEN THE DOCKER CONTAINER 
* $ docker run -v /path/on/host:/path/in/container 
* $ docker container run  -p 8080:8080  -v $HOME/log:/var/logs springboot-kubernetes-logs


### FOR TESTING 
* http://localhost:8080/actuator/health
* http://localhost:8080/actuator/info
* http://localhost:8080/actuator/env
* http://localhost:8080/actuator/beans
* http://localhost:8080/actuator/metrics


### KUBERNATES BUILD & DOCKER IMAGE CREATION AND PUSH TO DOCKER HUB.
* $ mvn clean package 
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernetes-logs .
* $ docker container run  -p 8080:8080  -v $HOME/log:/var/logs adarshkumarsingh83/springboot-kubernetes-logs
* $ docker push adarshkumarsingh83/springboot-kubernetes-logs

* $ kubectl cluster-info
* $ kubectl apply -f $(pwd)/kubernates/app.yml
* $ kubectl get all

### TO VIEW THE LOGS IN THE K8 POD 
* $ kubectl get pod 
* $ kubectl exec -it <pod-name> -- /bin/bash
* $ cd /var/logs
* $ cat application.log


### TO VIEW THE POD DETAILS
$ kubectl get pod

### TO VIEW THE LOGS OF THE POD
$ kubectl logs <pod-name> -f


### TO DELETE DEPLOYMENT & SERVICE 
$ kubectl delete services springboot-kubernetes-logs
$ kubectl delete deployment springboot-kubernetes-logs






