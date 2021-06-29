# springboot kubernates secret mysql
> Description: \
> spring boot application uses mysql db \
> jpa is used for curd operation \
> k8 config map and secret is use for storing \
> credentials and configurations.

----
## Local Deployment 
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
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-jpa-mysql .

### to push the docker image to the docker hub
* $ docker push adarshkumarsingh83/springboot-jpa-mysql

### NOTE CHANGE TO THE DOCKER DESKTOP IN THE DOCKER -> KUBERNATES
* $ kubectl cluster-info

### to create service and other in kubernetes
* $ kubectl apply -f $(pwd)/configmap.yml
* $ kubectl apply -f $(pwd)/secret1.yml
* $ kubectl apply -f $(pwd)/secret2.yml
* $ kubectl apply -f $(pwd)/mysql.yml
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
* $ kubectl describe services springboot-jpa-mysql
* $ kubectl port-forward svc/springboot-jpa-mysql 9090:9090

### Api Testing 
* $ curl http://localhost:9090/api/employee
* $ curl http://localhost:9090/api/employee/1
* $ curl http://localhost:9090/api/employee/2

### TO DELETE CONFIG MAP
* $ kubectl delete configmap  db-conf  -n   default
* $ kubectl delete  secret/db-credentials
* $ kubectl delete  secret/db-root-credentials

### FOR DELETING DEPLOYMENT AND SERVICE
* $ kubectl delete services  springboot-jpa-mysql
* $ kubectl delete deployment  springboot-jpa-mysql

### FOR DELETING DEPLOYMENT AND SERVICE OF MYSQL
* $ kubectl delete services  mysql
* $ kubectl delete deployment  mysql
* $ kubectl delete pvc mysql-pv-claim
