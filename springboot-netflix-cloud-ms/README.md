# SPRING BOOT NETFLIX CLOUD MICRO SERVICE 
### DESCRIPTION:
> this project is implemented with spring netflix cloud api where 
> we have zuul and api gateway as the proxy server eureka as the registry server 
> we have api-service which is aggregator service which internal request to the 
> employee-service & address-service fetch the data and aggregate in it. 
> we have external config-service which holds the configuration of the eco system
> this project can we executed on local machine in default profile and in docker compose 
> finally this is deployed on k8 cluster 
> this application has zuul as well as api-gateway use any one at a time  


### API USED 
* Zuul Server
* Api Gateway Server 
* Eureka Server 
* Config Server 
* Restful Services (api, address, employee)

## Code Building 
* $ mvn clean package

## To Execute the Docker Compose
- micro services with api-gateway  
* $ docker-compose -f docker-compose-api-gateway.yml up
- micro services with zuul-gateway 
* $ docker-compose -f docker-compose-zuul-gateway.yml up

## To Test the Application 

### EUREKA SERVER URL
* http://localhost:8761/

### TO TEST THE API
* $ curl localhost:8080/api/employee/1
* $ curl localhost:8080/api/address/1
* $ curl localhost:8080/api/details/1
* $ curl localhost:8080/api/details

## To Bring Down the Docker Compose
$ docker-compose -f docker-compose-api-gateway.yml down
$ docker-compose -f docker-compose-zuul-gateway.yml down


## Docker util Cmd 
### TO LIST DOWN ALL THE IMAGES
* $ docker images

### TO LIST ALL THE PROCESS
* $ docker ps -a

###  TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)


# K8 PROCESS FOR DEPLOYMENT

### Build docker image 

* cd espark-eureka-server
* docker build -f Dockerfile -t adarshkumarsingh83/espark-eureka-server .

* cd espark-config-server
* docker build -f Dockerfile -t adarshkumarsingh83/espark-config-server .

* cd espark-api-gateway
* docker build -f Dockerfile -t adarshkumarsingh83/espark-api-gateway .

* cd espark-zuul-gateway
* docker build -f Dockerfile -t adarshkumarsingh83/espark-zuul-gateway .

* cd espark-address-service
* docker build -f Dockerfile -t adarshkumarsingh83/espark-address-service .

* cd espark-employee-service
* docker build -f Dockerfile -t adarshkumarsingh83/espark-employee-service .

* cd espark-api-service
* docker build -f Dockerfile -t adarshkumarsingh83/espark-api-service .

### To Push Docker image to docker hub 

* docker push adarshkumarsingh83/espark-eureka-server
* docker push adarshkumarsingh83/espark-config-server
* docker push adarshkumarsingh83/espark-api-gateway
* docker push adarshkumarsingh83/espark-zuul-gateway
* docker push adarshkumarsingh83/espark-address-service
* docker push adarshkumarsingh83/espark-employee-service
* docker push adarshkumarsingh83/espark-api-service

### To Deploy in K8 
* $ kubectl apply -f $(pwd)/kubernates/configmap.yaml
* $ kubectl apply -f $(pwd)/kubernates/eureka-server.yaml
* $ kubectl apply -f $(pwd)/kubernates/config-server.yaml
* $ kubectl apply -f $(pwd)/kubernates/address-service.yaml
* $ kubectl apply -f $(pwd)/kubernates/employee-service.yaml
* $ kubectl apply -f $(pwd)/kubernates/api-service.yaml
* $ kubectl apply -f $(pwd)/kubernates/api-gateway.yaml
or 
* $ kubectl apply -f $(pwd)/kubernates/zuul-gateway.yaml

### To view the service and other
$ kubectl get all

### EUREKA SERVER URL
* http://localhost:8761/

### TO TEST THE API
* $ curl localhost:8080/api/employee/1
* $ curl localhost:8080/api/address/1
* $ curl localhost:8080/api/details/1
* $ curl localhost:8080/api/details

#FOR DELETING DEPLOYMENT AND SERVICE
* $ kubectl delete services  espark-eureka-server espark-config-server espark-address-service espark-employee-service espark-api-service espark-api-gateway
* $ kubectl delete deployment  espark-eureka-server espark-config-server espark-address-service espark-employee-service espark-api-service espark-api-gateway
or
* $ kubectl delete services  espark-eureka-server espark-config-server espark-address-service espark-employee-service espark-api-service espark-zuul-gateway
* $ kubectl delete deployment  espark-eureka-server espark-config-server espark-address-service espark-employee-service espark-api-service espark-zuul-gateway

# TO DELETE CONFIG MAP
$ kubectl delete configmap cluster-config -n default


# TO DELETE ALL THE CONTAINERS WITH VOLUMES
$ docker rm -vf $(docker ps -a -q)

# TO DELETE ALL THE IMAGES
$ docker rmi -f $(docker images -a -q)