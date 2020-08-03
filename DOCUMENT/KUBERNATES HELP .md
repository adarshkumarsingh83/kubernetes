----
## CREATE A SPRING BOOT APP AND DOCKERISED IT AND PUSH IMAGE TO DOCKER HUB 
----

#### Create a Spring Boot Application 
* dockerized it and push to the dockerhub 

* Dockerfile
````
FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/springboot-docker-xxx.jar springboot-docker-xxx.jar
ENV PORT 8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","springboot-docker-xxx.jar"]

````

### to create a docker image 
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-docker-xxx .

### To view the docker image 
* $ docker images

### to execute the docker image 
* $ docker run -p 8080:8080 adarshkumarsingh83/springboot-xxx:latest

### to test the image 
* $ curl localhost:8080/api/message

### to push to docker repository 
* $ docker push adarshkumarsingh83/springboot-docker-xxx

----

## CREATE A KUBERNATES DEPLOYMENT AND SERVICES AND DEOPLOYE THE SERVICE AND TESTING.
 
----

### To view the cluster info 
* $ kubectl cluster-info

### to get the service info 
* $ kubectl get all

----
### Deploy the Application to Kubernetes
----
### To create a sample deployment file 
* $ kubectl create deployment <deployment-name> --image=<repository-name/image-name> --dry-run -o=yaml > deployment.yaml
* $ kubectl create deployment springboot-docker-xxx --image=adarshkumarsingh83/springboot-docker-xxx --dry-run -o=yaml > deployment.yaml

### to add sepreator in the file 
* $ echo --- >> deployment.yaml
### we can create multiple deployment only we have to use separator after every deployment 

### To create a service cluster
* $ kubectl create service clusterip <service-name> --tcp=8080:8080 --dry-run -o=yaml >> deployment.yaml
* $ kubectl create service clusterip springboot-docker-xxx --tcp=8080:8080 --dry-run -o=yaml >> deployment.yaml
### we can create multiple services only we have to use separator after every services 

### apply the service 
* $ kubectl apply -f deployment.yaml
- logs
- deployment.apps/springboot-docker-xxx created
- service/springboot-docker-xxx created
 
### To get the deployment  
* $ kubectl get deployment

### to get the replicas 
* $ kubectl get replicaset

### to get the pods shows its status as "Running".
* $ kubectl get all

### bining the internal port to the external port 
* $ kubectl port-forward svc/springboot-docker-xxx 8080:8080

### to hit endpoint 
* $ curl localhost:8080/api/message

### to get the service details 
* $ get service springboot-docker-xxx

### to get the service details 
* $ kubectl get svc 

### to ssh to the minikube 
* $ minikube ssh 
- and then do the curl with ip of service which is given by get svc cmd with  port 

### To create more replicas 
* $ kubectl scale --replicas=2 deployment/springboot-docker-xxx

### to Describe the pods 
* $ kubectl describe pods
* or 
* $ kubectl describe pod springboot-docker-xxx

### To View the logs 
* $ kubectl logs pod_name(from describe cmd )

### To exeucte cmd on pod 
* $ kubectl exec podname -- <cmd>

### To exeucte cmd on container 
* $ kubectl exec podname  -c containername -- <cmd>

### to get inside the pod bash shell 
* $ kubtectl exec -it podname -- bash 

### to come out of pod 
* $ exit 

### to get inside the container bash shell 
* $ kubtectl exec -it podname -c containername -- bash 

### to come out of container
* $ exit 

### To delete service 
* $ kubectl delete services springboot-docker-xxx

### to delete deployment 
* $ kubectl delete deployment springboot-docker-xxx


### to delete all in one shot 
* $ kubectl delete --all pods
* $ kubectl delete --all services
* $ kubectl delete --all configmap
* $ kubectl delete --all statefulset
* $ kubectl delete --all deployment