# springboot kubernates solr
> Description: \
> spring boot application implemented with curd operation \
> data is stores on solr search engine \ 
> where data is indexed for fast searching  

----

## LOCAL EXECUTION 
### Build the code 
* $ mvn clean package

### Build the docker image and tag 
* $ docker build . -t springboot-kubernates-solr

### To Bring the docker compose up 
* $ docker-compose up
* $ docker-compose down

### Api testing 
* http://localhost:8983/solr/#/

### To list the images 
* $ docker images

### to view the dockers process
* $ docker ps -a

### to stop forcefully
* $ docker rm --force <name>

### to delete docker image
* $ docker image rm --force springboot-kubernates-solr

### TO LIST DOWN ALL THE IMAGES
* $ docker images

### TO LIST ALL THE PROCESS
* $ docker ps -a

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)


* @post
* curl -X POST http://localhost:9090/api/employee -d '{"id":"100","name":"adarsh kumar","age":35}' -H "Content-Type: application/json"
* curl -X POST http://localhost:9090/api/employee -d '{"id":"200","name":"radha singh","age":31}' -H "Content-Type: application/json"
* curl -X POST http://localhost:9090/api/employee -d '{"id":"300","name":"amit kumar","age":31}' -H "Content-Type: application/json"


* @get
* curl  -X GET http://localhost:9090/api/employee/100
````
{
    "id": "100",
    "name": "adarsh kumar",
    "age": 35
}

````
* @get
* curl  -X GET http://localhost:9090/api/employee/name/adarsh
````
{
    "id": "100",
    "name": "adarsh kumar",
    "age": 35
}

````
* @get
* curl  -X GET http://localhost:9090/api/employee/name-like/*ad*
````
[
    {
        "id": "100",
        "name": "adarsh kumar",
        "age": 35
    },
    {
        "id": "300",
        "name": "radha singh",
        "age": 31
    }
]

````
* @get
* curl  -X GET http://localhost:9090/api/employee/age/31
````
[
    {
        "id": "200",
        "name": "amit kumar",
        "age": 31
    },
    {
        "id": "300",
        "name": "radha singh",
        "age": 31
    }
]

````

---- 

## K8 Deployment & Execution Process 

### To Build
* $ mvn clean package

### To build the docker image and tag
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-kubernates-solr .

### to push the docker image to the docker hub
* $ docker push adarshkumarsingh83/springboot-kubernates-solr

### NOTE CHANGE TO THE DOCKER DESKTOP IN THE DOCKER -> KUBERNATES

* K8 CHEAT SHEET
* https://kubernetes.io/docs/reference/kubectl/cheatsheet/

* $ kubectl cluster-info

### to create service and other in kubernetes
* $ kubectl apply -f $(pwd)/solr.yaml
* $ kubectl apply -f $(pwd)/configmap.yaml
* $ kubectl apply -f $(pwd)/springboot.yaml


### to view the service and other
* $ kubectl get all

### TO VIEW THE POD DETAILS
* $ kubectl get pod

### TO VIEW THE LOGS OF THE POD
* $ kubectl logs <pod-name> -f

----
* @post
* curl -X POST http://localhost:9090/api/employee -d '{"id":"100","name":"adarsh kumar","age":35}' -H "Content-Type: application/json"
* curl -X POST http://localhost:9090/api/employee -d '{"id":"200","name":"radha singh","age":31}' -H "Content-Type: application/json"
* curl -X POST http://localhost:9090/api/employee -d '{"id":"300","name":"amit kumar","age":31}' -H "Content-Type: application/json"

* @get
* curl  -X GET http://localhost:9090/api/employee/100
````
{
    "id": "100",
    "name": "adarsh kumar",
    "age": 35
}
````


### TO DELETE CONFIG MAP
* $ kubectl delete configmap solr-conf -n default

### FOR DELETING DEPLOYMENT AND SERVICE
* $ kubectl delete services springboot-kubernates-solr
* $ kubectl delete deployment springboot-kubernates-solr
* $ kubectl delete services  solr
* $ kubectl delete statefulset  solr



![JPA REPOSITORY METHOD FOR SOLR ](https://github.com/adarshkumarsingh83/kubernetes/blob/master/springboot-kubernates-solr/doc/solar%20repository%20methods%20.png)