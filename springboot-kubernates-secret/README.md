# spring boot k8 secret vault
> Description: \
> spring boot application fetches the data from k8 secret vault \
> and uses it in the application services

---- 

### To Build the application 
* $ mvn clean package 

### To execute and test locally 
* $ mvn spring-boot:run
* $  curl localhost:9090/api/conf


----

### To build the docker image and tag
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernates-secret .

### to push the docker image to the docker hub
* $ docker push adarshkumarsingh83/springboot-kubernates-secret


## K8 Deployment Process 

### Secret data Encoding & Decoding testing
````
# Encoding 

$ echo  'adarsh@kumar' | base64
YWRhcnNoQGt1bWFyCg==
$ echo  '9999999' | base64
OTk5OTk5OQo=
$ echo  'espark' | base64
ZXNwYXJrCg==

# Decoding 
$ echo  "YWRhcnNoQGt1bWFyCg==" | base64 -d 
$ echo  "OTk5OTk5OQo=" | base64 -d 
$ echo  "ZXNwYXJrCg==" | base64 -d 


````

$ kubectl apply -f $(pwd)/kubernates/secret.yml
$ kubectl apply -f $(pwd)/kubernates/springboot.yml

### to view the service and other
* $ kubectl get all

### to view the secrets
* $ kubectl get secrets
* $ kubectl describe secret espark-secret

### TO VIEW THE POD DETAILS
* $ kubectl get pod

### TO VIEW THE LOGS OF THE POD
* $ kubectl logs <pod-name> -f

### Service testing 
* $  curl localhost:9090/api/conf

### Clean Up Process 
### FOR DELETING DEPLOYMENT AND SERVICE
$ kubectl delete services springboot-kubernates-secret
$ kubectl delete deployment springboot-kubernates-secret

### To Secret Deletion
* $ kubectl delete  secret/espark-secret


### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)