# SPRINGBOOT K8 ELK
> Description: \
> springboot kubernates logs application 
> elastic is used to index the logs and kibina is used to \
> do search and query on the indexed logs and logstash is 
> used to send the logs from application to the elastic search 

----
# ELK SETUP ON LOCAL STEP BY STEP 
----
### ELASTIC SEARCH
* Download 
* https://www.elastic.co/downloads/elasticsearch

### To Execute the elastic 
* $ cd ~/Downloads/ELK/elasticsearch-7.8.0/
* $ ./bin/elasticsearch


### To list the available elastic web services  
* localhost:9200/_cat

### To list the available index on the elastic 
* localhost:9200/_cat/indices  

----
### KIBANA
* Download 
* https://www.elastic.co/downloads/kibana
* edit the config file in location config/kibana.yml 
````
 server.port: 5601
 server.host: "localhost"
 elasticsearch.hosts: ["http://localhost:9200"]
````

### To execute the kibina 
* $ cd kibana-7.8.0-darwin-x86_64
* $ ./bin/kibana

### To view web console 
* http://localhost:5601
----
### LOG STASH
* Download
* https://www.elastic.co/downloads/logstash
* $ cd logstash-7.8.0
* $ vi logstash.config 
* crt + i  
### form tcp logback appender enabled logstash configuration 
* application.yaml spring.logstash.enabled: true
````
input {

  tcp {
        port => "5000"
        codec => json_lines
    }

}

filter {
  #If log line contains tab character followed by 'at' then we will tag that entry as stacktrace
  if [message] =~ "\tat" {
    grok {
      match => ["message", "^(\tat)"]
      add_tag => ["stacktrace"]
    }
  }

  #Grokking Spring Boot's default log format
  grok {
    match => [ "message",
               "(?<timestamp>%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{TIME})  %{LOGLEVEL:level} %{NUMBER:pid} --- \[(?<thread>[A-Za-z0-9-]+)\] [A-Za-z0-9.]*\.(?<class>[A-Za-z0-9#_]+)\s*:\s+(?<logmessage>.*)",
               "message",
               "(?<timestamp>%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{TIME})  %{LOGLEVEL:level} %{NUMBER:pid} --- .+? :\s+(?<logmessage>.*)"
             ]
  }

  #Parsing out timestamps which are in timestamp field thanks to previous grok section
  date {
    match => [ "timestamp" , "yyyy-MM-dd HH:mm:ss.SSS" ]
  }
}

output {
    stdout {
        codec => rubydebug
    }
    elasticsearch{
        hosts=>["localhost:9200"]
        index=>"esaprk-%{+YYYY.MM.dd}"
    }
}
````
### for log file reading configuration for logstash
* application.yaml spring.logstash.enabled: false
````
input {
  file {
    type => "syslog"
    # Logstash insists on absolute paths...
    path => "/logs/application.log"
  }
}

filter {
  #If log line contains tab character followed by 'at' then we will tag that entry as stacktrace
  if [message] =~ "\tat" {
    grok {
      match => ["message", "^(\tat)"]
      add_tag => ["stacktrace"]
    }
  }

  #Grokking Spring Boot's default log format
  grok {
    match => [ "message",
               "(?<timestamp>%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{TIME})  %{LOGLEVEL:level} %{NUMBER:pid} --- \[(?<thread>[A-Za-z0-9-]+)\] [A-Za-z0-9.]*\.(?<class>[A-Za-z0-9#_]+)\s*:\s+(?<logmessage>.*)",
               "message",
               "(?<timestamp>%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{TIME})  %{LOGLEVEL:level} %{NUMBER:pid} --- .+? :\s+(?<logmessage>.*)"
             ]
  }

  #Parsing out timestamps which are in timestamp field thanks to previous grok section
  date {
    match => [ "timestamp" , "yyyy-MM-dd HH:mm:ss.SSS" ]
  }
}

output {
    stdout {
        codec => rubydebug
    }
    elasticsearch{
        hosts=>["localhost:9200"]
        index=>"esaprk-%{+YYYY.MM.dd}"
    }
}
````
* esc: wq
* $ bin/logstash -f logstash.config
----


### build the code 
* $ mvn clean package 
* $ mvn spring-boot:run
* $ java -jar target/springboot-kubernetes-elk-sidecar-container.jar


### TO BUILD & RUN TFS API SERVER VIA DOCKER
* $ docker build -f Dockerfile -t springboot-kubernetes-elk-sidecar-container .
* $ docker run -e "SPRING_PROFILES_ACTIVE=default" -p 8080:8080 -t springboot-kubernetes-elk-sidecar-container

### to debug the logs of the docker container 
* $ docker ps -a
* $ docker exec -it <docker-container-name> cat /var/[docker-container-file-system-path]]/logs/application.log > $HOME/spring.log [host-machine-file-system ]
* $ docker exec -it <friendly_boyd> cat /var/logs/application.log > $HOME/spring.log


### FOR DIRECTLY PRODUCING LOGS TO HOST MACHINE RATHER THEN THE DOCKER CONTAINER 
* $ docker container run  -p 8080:8080  -v $HOME/log:/var/logs springboot-kubernetes-elk-sidecar-container

### FOR TESTING 
* http://localhost:8080/actuator/health
* http://localhost:8080/actuator/info
* http://localhost:8080/actuator/env
* http://localhost:8080/actuator/beans
* http://localhost:8080/actuator/metrics

----
### K8 DEPLOYMENT PROCESS

### To Start minikube cluster
* $ minikube start --vm-driver=hyperkit

### To enable addons in minikube
* $ minikube addons enable dashboard

### To open minikube dashboard
* $ minikube dashboard

### To delete minikube virtualbox
* $ minikube delete
----
### ELASTIC SEARCH 
* $ kubectl cluster-info
* $ kubectl apply -f $(pwd)/kubernates/elasticsearch.yml
* $ kubectl get all
* To list the available elastic web services  localhost:9200/_cat
* To list the available index on the elastic  localhost:9200/_cat/indices
---- 
### FOR KIBINA 

* $ kubectl cluster-info
* $ kubectl apply -f $(pwd)/kubernates/kibana.yml
* $ kubectl get all  
* To log into the kibina console   http://localhost:5601
---- 
### FOR LOGSTASH
 
* $ kubectl cluster-info
* $ kubectl apply -f $(pwd)/kubernates/logstash-config.yml
* $ kubectl apply -f $(pwd)/kubernates/logstash.yml
* $ kubectl get all   

---- 
### SPRING BOOT APPLICATION
* $ mvn clean package 
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernetes-elk-sidecar-container .
```
[+] Building 2.2s (8/8) FINISHED                                                                                                                                                                      
 => [internal] load build definition from Dockerfile                                                                                                                                             0.0s
 => => transferring dockerfile: 223B                                                                                                                                                             0.0s
 => [internal] load .dockerignore                                                                                                                                                                0.0s
 => => transferring context: 2B                                                                                                                                                                  0.0s
 => [internal] load metadata for docker.io/library/openjdk:8                                                                                                                                     1.5s
 => [auth] library/openjdk:pull token for registry-1.docker.io                                                                                                                                   0.0s
 => CACHED [1/2] FROM docker.io/library/openjdk:8@sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8                                                                        0.0s
 => [internal] load build context                                                                                                                                                                0.3s
 => => transferring context: 30.44MB                                                                                                                                                             0.3s
 => [2/2] COPY target/springboot-kubernetes-elk-sidecar-container.jar springboot-kubernetes-elk-sidecar-container.jar                                                                                                                0.2s
 => exporting to image                                                                                                                                                                           0.1s
 => => exporting layers                                                                                                                                                                          0.1s
 => => writing image sha256:a1436c8a28f8596fa631de10f831799b944658dfc450675fdfdba5b45c1757ec                                                                                                     0.0s
 => => naming to docker.io/adarshkumarsingh83/springboot-kubernetes-elk-sidecar-container    
```
### To push the image to docker hub
* $ docker push adarshkumarsingh83/springboot-kubernetes-elk-sidecar-container


---

### k8 configurations 
* $ kubectl cluster-info
* $ minikube start --vm-driver=hyperkit
* $ minikube addons enable dashboard
* $ minikube dashboard
* $ kubectl apply -f $(pwd)/kubernetes/configmap.yml
* $ kubectl apply -f $(pwd)/kubernetes/logstash-config.yml
* $ kubectl apply -f $(pwd)/kubernetes/elasticsearch.yml

### To Check elastic is getting index data or not
* $ kubectl port-forward svc/elasticsearch 9200:9200
  * http://localhost:9200/
  * http://localhost:9200/_cat/indices
  

* $ kubectl apply -f $(pwd)/kubernetes/kibana.yml
### To port forward
  * kubectl  port-forward svc/kibana 5601:5601
  * http://localhost:5601

### api testing  
  * $ kubectl apply -f $(pwd)/kubernetes/springboot.yml
  * kubectl port-forward svc/springboot-kubernetes-elk  8080:8080
 
### Enable ingress for api and do below config. 
* minikube addons enable ingress
* kubectl get pods -n ingress-nginx

* kubectl apply -f $(pwd)/kubernetes/ingress.yml
* kubectl get ingress
```
NAME                 CLASS   HOSTS                  ADDRESS         PORTS   AGE
springboot-ingress   nginx   espark.com,localhost   192.168.64.24   80      13m
```
* sudo vi /etc/hosts
```
192.168.64.24 espark.com
```

### Make 100 parallel with 10 jobs call to the service for load testing
* seq 1 500 | xargs -n1 -P10  curl -H "Connection: close" "http://espark.com/api/message"

* $ kubectl get all

----

### TO VIEW THE LOGS IN THE K8 POD 
* $ kubectl get all 
* $ kubectl get pod 
* $ kubectl exec -it <pod-name> -- /bin/bash


### TO VIEW THE POD DETAILS
* $ kubectl get pod

### TO VIEW THE LOGS OF THE POD
* $ kubectl logs <pod-name> -f

### TO DELETE DEPLOYMENT & SERVICE 
* $ kubectl delete -n default ingress springboot-ingress
* $ kubectl delete services  kibana elasticsearch logstash springboot-kubernetes-elk-sidecar-container
* $ kubectl delete deployment kibana logstash springboot-kubernetes-elk-sidecar-container
* $ kubectl delete -n default statefulset elasticsearch
* $ kubectl delete configmap  logstash-configmap app-config

### To Delete minikube cluster 
* $ minikube delete

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)