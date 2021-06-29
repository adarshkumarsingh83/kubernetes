# springboot kubernates mongo
> Description: \
> spring boot jpa mongo db application \
> where curd operation implemented and data \ 
> data is persisted into the mongo db

---- 
## Local Execution 
* $ mvn clean package
* $ mvn spring-boot:run


* Post
* http://localhost:9090/api/employee
````
{
 "name":"adarsh"
 ,"email":"adarsh@kumar"
}
{
 "name":"radha"
 ,"email":"radha@singh"
}
````

* Get
* http://localhost:9090/api/employee
````
[
    {
        "id": 1,
        "name": "adarsh",
        "email": "adarsh@kumar",
        "createdDate": "2018-04-07T03:03:16.000+0000",
        "updatedDate": "2018-04-07T03:03:16.000+0000"
    },
    {
        "id": 2,
        "name": "radha",
        "email": "radha@singh",
        "createdDate": "2018-04-07T03:03:31.000+0000",
        "updatedDate": "2018-04-07T03:03:31.000+0000"
    }
]

````
* PUT
* http://localhost:9090/api/employee/1
````
{
    "id": 1,
    "name": "adarsh",
    "email": "adarsh@kumar.singh"
}

````
* DElETE
* http://localhost:9090/api/employee/3

### TO START THE DOCKER CONTAINERS
* $ docker-compose up
* $ docker-compose down

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)

----
## K8 Deployment Process 

### To build code
* $ mvn clean package

### To build the docker image and tag
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-jpa-mongo .

### to push the docker image to the docker hub
* $ docker push adarshkumarsingh83/springboot-jpa-mongo

### NOTE CHANGE TO THE DOCKER DESKTOP IN THE DOCKER -> KUBERNATES
* $ kubectl cluster-info

### to create service and other in kubernetes
* $ kubectl apply -f $(pwd)/configmap.yml
* $ kubectl apply -f $(pwd)/secret.yml
* $ kubectl apply -f $(pwd)/mongo.yml
* $ kubectl apply -f $(pwd)/springboot.yml

### to view the service and other
* $ kubectl get all

### to view the secrets
* $ kubectl get secrets

### to get the persistence volume
* $ kubectl get persistentvolumes
* $ kubectl get persistentvolumeclaims

### TO VIEW THE POD DETAILS
* $ kubectl get pod

### TO VIEW THE LOGS OF THE POD
* $ kubectl logs <pod-name> -f
* $ kubectl describe services springboot-jpa-mongo


### Api testing 
* $ curl http://localhost:9090/api/employee
* $ curl http://localhost:9090/api/employee/1
* $ curl http://localhost:9090/api/employee/2

### TO DELETE CONFIG MAP
* $ kubectl delete configmap  mongo-db-conf  -n   default
* $ kubectl delete  secret/mongo-db-credentials

### FOR DELETING DEPLOYMENT AND SERVICE
* $ kubectl delete services  springboot-jpa-mongo
* $ kubectl delete deployment  springboot-jpa-mongo

### FOR DELETING DEPLOYMENT AND SERVICE OF POSTGRACE
* $ kubectl delete services  mongo
* $ kubectl delete deployment  mongo  