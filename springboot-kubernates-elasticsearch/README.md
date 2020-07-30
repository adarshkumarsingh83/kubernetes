# SPRING BOOT K8 ELASTIC SEARCH
> Description: \
>  spring boot application which uses elastic search \
> internally data will be indexed on the elastic search \
> and then based on index fast searching done. 

---- 

### To Build
* $ mvn clean package

### To build the docker image and tag
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernates-elasticsearch .

### to push the docker image to the docker hub
* $ docker push adarshkumarsingh83/springboot-kubernates-elasticsearch

### NOTE CHANGE TO THE DOCKER DESKTOP IN THE DOCKER -> KUBERNATES
* $ kubectl cluster-info

### To create service and other in kubernetes
* $ kubectl apply -f $(pwd)/es.yaml
* $ kubectl apply -f $(pwd)/kibana.yaml
* $ kubectl apply -f $(pwd)/springboot.yaml


### To view the service and other
* $ kubectl get all

## TO VIEW THE POD DETAILS
* $ kubectl get pod

### TO VIEW THE LOGS OF THE POD
* $ kubectl logs <pod-name> -f

### TO VIEW IN KIBINA DASHBOARD
* http://localhost:5601/

----
### Testing api services 
* $ curl -X POST http://localhost:9090/api/employees -d '{"id":"1","name":"adarsh"}' -H "Content-Type: application/json"
* $ curl -X POST http://localhost:9090/api/employees -d '{"id":"2","name":"radha"}' -H "Content-Type: application/json"
* $ curl -X GET http://localhost:9090/api/employees
----

### Clean up of the k8 env 
* $ kubectl delete services  springboot-kubernates-elasticsearch kibana elasticsearch
* $ kubectl delete deployment  springboot-kubernates-elasticsearch kibana 
* $ kubectl delete statefulset  elasticsearch