# springboot k8 ngix proxy & lb & elastic-filebest-kibina for logs 
> Description: \
> spring boot rest and web application 

----

### To build the application
* $ mvn clean package

## To Execute the application 
* mvn spring-boot:run -Dspring-boot.run.profiles=docker
* java -jar -Dspring.profiles.active=docker springboot-service.jar

### To test
* $ curl localhost:8080
* $ curl localhost:8080/api/message

* $ curl localhost:80
* $ curl localhost:80/api/message


---- 
## K8 DEPLOYMENT PROCESS 

### To build the docker image and tag
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-service .

### to push the docker image to the docker hub 
* $ docker push adarshkumarsingh83/springboot-service


### To start the minikube 
* minikube start --vm-driver=hyperkit

### To Enable dashboard 
* minikube addons enable dashboard

### To open dashboard 
* minikube dashboard

### To create namespace 
*  kubectl apply -f namespace.yml 

### To get the namespaces 
* kubectl get namespaces


## To deploye in the k8 
* $  kubectl apply -f $(pwd)/kubernates/configmap.yml
* $  kubectl apply -f $(pwd)/kubernates/elasticsearch.yml
* $  kubectl apply -f $(pwd)/kubernates/kibana.yml
* $  kubectl apply -f $(pwd)/kubernates/service-logstash-config.yml
* $  kubectl apply -f $(pwd)/kubernates/service1.yaml
* $  kubectl apply -f $(pwd)/kubernates/service2.yaml
* $  kubectl apply -f $(pwd)/kubernates/service3.yaml
* $  kubectl apply -f $(pwd)/kubernates/service4.yaml
* $  kubectl apply -f $(pwd)/kubernates/ngix-logstash-config.yml
* $  kubectl apply -f $(pwd)/kubernates/nginx-config.yaml
* $  kubectl apply -f $(pwd)/kubernates/nginx.yaml


## VERIFY DEPLOYMENTS 
### TO VIEW THE DETAILS
* $ kubectl cluster-info
* $ kubectl get all

### exec inside the elastic container 
* execute this curl cmd 
 ``` curl -XDELETE http://localhost:9200/_template/logstash ```


### To Check elasic is getting index data or not 
* kubectl --namespace=default port-forward svc/elasticsearch 9200:9200
* `http://localhost:9200/`

### To list the index 
* `http://localhost:9200/_cat/indices`

### To veiw the data index 
* `http://localhost:9200/[index-name]/_search`

### To create kibina 
* $ kubectl apply -f kibana.yml 

### To get all the items in namespace 
 * $ kubectl --namespace=default get all 

### To port forward 
* kubectl --namespace=default port-forward svc/kibana  5601:5601 
* `http://localhost:5601`



### To test the services 
* $  kubectl --namespace=default port-forward svc/nginx 8090:80
* $ curl localhost:8090
* $ curl localhost:8090/api/message

### Make 100 parallel with 10 jobs call to the service for load testing
* seq 1 500 | xargs -n1 -P10  curl -H "Connection: close" "http://localhost:8080/api/message"

### Make every sec 1 call to the server 
* while sleep 1; do curl -H "Connection: close" "http://localhost:8080/api/message"; "\n"; done

### for system pods listing 
* $ kubectl get pods -n kube-system

### TO VIEW THE POD DETAILS
* $ kubectl get pod

## CLEAN UP 
### FOR DELETING DEPLOYMENT AND SERVICE
* $ kubectl delete services springboot-service1 springboot-service2 springboot-service3 springboot-service4 nginx
* $ kubectl delete deployment springboot-service1 springboot-service2 springboot-service3 springboot-service4 nginx

### TO DELETE CONFIG MAP
* $ kubectl delete configmap nginx-conf -n default
* $ kubectl delete configmap logstash-config -n default

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)