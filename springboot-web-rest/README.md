
# springboot web rest 
> Description: \
> springboot application which has web pages \
> and rest endpoints for the consumer application. 

---- 

### To Build the application 
* $ mvn clean package 

### to create a docker image 
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-web-rest .

### To view the docker iamge 
* $ docker images

### to execute the docker image 
* $ docker run -p 8080:8080 adarshkumarsingh83/springboot-web-rest

### to test the image 
* $ curl localhost:8080/api/message

### to push to docker repository 
* $ docker push adarshkumarsingh83/springboot-web-rest

----
### Deploy the Application to Kubernetes
----

### To create a sample deployment file 
* $ kubectl create deployment springboot-web-rest --image=adarshkumarsingh83/springboot-web-rest --dry-run -o=yaml > deployment.yaml

### To add Separator in the file 
* $ echo --- >> deployment.yaml

### To create a service cluster
* $ kubectl create service clusterip springboot-web-rest --tcp=8080:8080 --dry-run -o=yaml >> deployment.yaml


### apply the service 
* $ kubectl apply -f deployment.yaml
````
 logs
 deployment.apps/springboot-docker-xxx created
 service/springboot-docker-xxx created
````

### to get the pods shows its status as "Running".
* $ kubectl get all


* $ kubectl port-forward svc/springboot-web-rest 8080:8080

### to hit endpoint 
* $ curl localhost:8080/api/message
