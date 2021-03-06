# SPRING BOOT HA-PROXY SAMPLE

### build the code 
* $ mvn clean package 
* $ mvn spring-boot:run
* $ java -jar target/springboot-kubernates-haproxy.jar

### To Execute all server 
* sh servers.sh 
* sh servers-stop.sh 


### Manually install in Mac 
````
### To install
$ brew update 
$ brew install haproxy

### To start ther server  
$ sudo haproxy -f ./config/standalone/etc/haproxy/haproxy.cfg

### Service test 
http://localhost/actuator/env
http://localhost/actuator/info
http://localhost/actuator/beans
http://localhost/actuator/metrics
http://localhost/actuator/health

### for admin ui 
http://localhost:9999/stats

### To kill process on port 80 
 $ sudo lsof -i tcp:80
 $ kill -9 

### To unstall 
$ brew uninstall haproxy  

````

````
frontend: defines a reverse proxy which will listen for incoming requests on a specific IP address and port.
backend: defines a pool of servers that the frontend will forward requests to.
listen: a shorthand notation that combines frontend and backend features into a single command.

````


### To Execute ha proxy 
* $ docker run --name springboot-kubernates-haproxy -p80:80 -v $(pwd)/config/docker/etc/haproxy:/usr/local/etc/haproxy:ro haproxy

### To view docker logs 
* $ docker logs --follow  springboot-kubernates-haproxy

### To stop the container 
* $  docker stop  springboot-kubernates-haproxy

* docker ps -a 
* docker container rm <continerid>

### To reload config file 
* docker kill -s HUP springboot-kubernates-haproxy


### TO BUILD & RUN TFS API SERVER VIA DOCKER
* $ docker build -f Dockerfile -t springboot-haproxy .
* $ docker run -e "SPRING_PROFILES_ACTIVE=default" -p 8081:8081 -t springboot-kubernates-haproxy
* $ docker run -e "SPRING_PROFILES_ACTIVE=default" -p 8082:8082 -t springboot-kubernates-haproxy
* $ docker run -e "SPRING_PROFILES_ACTIVE=default" -p 8083:8083 -t springboot-kubernates-haproxy
* $ docker run -e "SPRING_PROFILES_ACTIVE=default" -p 8084:8084 -t springboot-kubernates-haproxy

### to debug the logs of the docker container 
* $ docker ps -a
* $ docker exec -it <docker-container-name> cat /var/[docker-container-file-system-path]]/logs/application.log > $HOME/spring.log [host-machine-file-system ]
* $ docker exec -it friendly_boyd cat /var/logs/application.log > $HOME/spring.log


### FOR DIRECTLY PRODUCING LOGS TO HOST MACHINE RATHER THEN THE DOCKER CONTAINER 
* $ docker run -v /path/on/host:/path/in/container 
* $ docker container run  -p 8080:8080  -v $HOME/log:/var/logs springboot-kubernates-haproxy

### To ssh to the container 
* $ docker ps -a 
* $ docker exec -it [container-name] /bin/bash


### FOR TESTING 
* http://localhost:8081/actuator/info
* http://localhost:8082/actuator/info
* http://localhost:8083/actuator/info
* http://localhost:8084/actuator/info

* http://localhost:8080/actuator/health
* http://localhost:8080/actuator/info
* http://localhost:8080/actuator/env
* http://localhost:8080/actuator/beans
* http://localhost:8080/actuator/metrics

----

### DOCKER COMPOSE TESTING 
* $ docker-compose up 
* $ docker-compose down 

### FOR TESTING 
* http://localhost/actuator/health
* http://localhost/actuator/info
* http://localhost/actuator/env
* http://localhost/actuator/beans
* http://localhost/actuator/metrics

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)
### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)

---- 
### KUBERNATES BUILD & DOCKER IMAGE CREATION AND PUSH TO DOCKER HUB.
* $ mvn clean package 
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernates-haproxy .
* $ docker push adarshkumarsingh83/springboot-kubernates-haproxy

* $ docker container run  -p 8080:8080  -v $HOME/log:/var/logs adarshkumarsingh83/springboot-kubernates-haproxy

* $ kubectl cluster-info
* $ kubectl apply -f $(pwd)/kubernates/service1.yml
* $ kubectl apply -f $(pwd)/kubernates/service2.yml
* $ kubectl apply -f $(pwd)/kubernates/service3.yml
* $ kubectl apply -f $(pwd)/kubernates/service4.yml
* $ kubectl apply -f $(pwd)/kubernates/haproxy-config.yml
* $ kubectl apply -f $(pwd)/kubernates/haproxy.yml
* $ kubectl get all


### FOR TESTING 
* http://localhost/actuator/info
* http://localhost/actuator/info
* http://localhost/actuator/info
* http://localhost:8084/actuator/info


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
* $ kubectl delete services springboot-haproxy1 springboot-haproxy2 springboot-haproxy3 springboot-haproxy4 haproxy
* $ kubectl delete deployment springboot-haproxy1 springboot-haproxy2 springboot-haproxy3 springboot-haproxy4 haproxy
* $ kubectl delete configmap haproxy-cfg


### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)
### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)

---- 


