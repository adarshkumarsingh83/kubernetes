# SPRING BOOT K8 CLOUD MICRO SERVICE 
### DESCRIPTION:
> this project is implemented with spring boot & k8 cloud api where 
> we have zuul and api gateway as the proxy server k8  registry as the registry server 
> we have api-service which is aggregator service which internal request to the 
> employee-service & address-service fetch the data and aggregate in it. 
> we have k8 config map service which holds the configuration of the eco system
> this project can we executed on k8 cluster 
> this application has zuul as well as api-gateway use any one at a time  


### API USED 
* Zuul Server
* Api Gateway Server 
* K8 Registry Server 
* K8 Config Map 
* Restful Services (api, address, employee)

## Code Building 
* $ mvn clean package

# K8 PROCESS FOR DEPLOYMENT

### Build docker image 

* cd espark-address-service
* docker build -f Dockerfile -t adarshkumarsingh83/espark-address-service .

* cd espark-employee-service
* docker build -f Dockerfile -t adarshkumarsingh83/espark-employee-service .

* cd espark-api-service
* docker build -f Dockerfile -t adarshkumarsingh83/espark-api-service .

* cd espark-api-gateway
* docker build -f Dockerfile -t adarshkumarsingh83/espark-api-gateway .

* cd espark-zuul-gateway
* docker build -f Dockerfile -t adarshkumarsingh83/espark-zuul-gateway .


### To Push Docker image to docker hub 

* docker push adarshkumarsingh83/espark-address-service
* docker push adarshkumarsingh83/espark-employee-service
* docker push adarshkumarsingh83/espark-api-service
* docker push adarshkumarsingh83/espark-zuul-gateway
* docker push adarshkumarsingh83/espark-api-gateway

### To Deploy in K8 
* $ kubectl apply -f $(pwd)/kubernates/config.yaml
* $ kubectl apply -f $(pwd)/kubernates/address.yaml
* $ kubectl apply -f $(pwd)/kubernates/employee.yaml
* $ kubectl apply -f $(pwd)/kubernates/api.yaml
* $ kubectl apply -f $(pwd)/kubernates/gateway.yaml
* or 
* $ kubectl apply -f $(pwd)/kubernates/zuul.yaml

### To view the service and other
$ kubectl get all

### EUREKA SERVER URL
* http://localhost:8761/

### TO TEST THE API
* $ curl localhost:8080/api/employee/1
* $ curl localhost:8080/api/address/1
* $ curl localhost:8080/api/details/1
* $ curl localhost:8080/api/details
* $ curl localhost:8080/api/config
* $ curl localhost:8080/api/message

### FOR DELETING DEPLOYMENT AND SERVICE
* $ kubectl delete services  espark-address-service espark-api-gateway espark-api-service espark-employee-service
* $ kubectl delete deployment  espark-address-service espark-api-gateway espark-api-service espark-employee-service
* or
* $ kubectl delete services  espark-address-service espark-zuul-gateway espark-api-service espark-employee-service
* $ kubectl delete deployment  espark-address-service espark-zuul-gateway espark-api-service espark-employee-service

### TO DELETE CONFIG MAP
$ kubectl delete configmap  kubernates-configmap-store  -n   default

###  TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)