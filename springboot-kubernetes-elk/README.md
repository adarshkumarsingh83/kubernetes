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
### KIBINA
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

----
### K8 DEPLOYMENT PROCESS

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
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernetes-elk .
* $ docker push adarshkumarsingh83/springboot-kubernetes-elk
* $ kubectl cluster-info
* $ kubectl apply -f $(pwd)/kubernates/app.yml
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
* $ kubectl delete services elasticsearch logstash kibana springboot-kubernetes-elk
* $ kubectl delete deployment  kibana logstash springboot-kubernetes-elk
* $ kubectl delete statefulset elasticsearch 
* $ kubectl delete ConfigMap  logstash-configmap 



### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)