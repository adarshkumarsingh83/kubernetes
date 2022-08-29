# springboot-kubernates-liquibase-initcontainer-oracle

---

## To start

- we have wait a lot becoz oracle db will take time to start mean while spring and liquibase will restart many times
- docker-compose up

```
Ospringboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ####################################################
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##   _     _             _ _                      ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##  | |   (_)           (_) |                     ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##  | |    _  __ _ _   _ _| |__   __ _ ___  ___   ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##  | |   | |/ _` | | | | | '_ \ / _` / __|/ _ \  ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##  | |___| | (_| | |_| | | |_) | (_| \__ \  __/  ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##  \_____/_|\__, |\__,_|_|_.__/ \__,_|___/\___|  ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##              | |                               ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##              |_|                               ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##                                                ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##  Get documentation at docs.liquibase.com       ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##  Get certified courses at learn.liquibase.com  ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##  Free schema change activity reports at        ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##      https://hub.liquibase.com                 ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ##                                                ##
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | ####################################################
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | Starting Liquibase at 02:53:19 (version 4.8.0 #1581 built at 2022-02-18 21:43+0000)
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | Liquibase Version: 4.8.0
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | Liquibase Community 4.8.0 by Liquibase
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | Running Changeset: changelog/changelog.xml::1::adarsh
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | Running Changeset: changelog/changelog.xml::2::radha
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | Running Changeset: changelog/changelog.xml::3::radha
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1    | Liquibase command 'update' was executed successfully.
springboot-kubernates-liquibase-initcontainer-oracle-oracledb-liquibse-1 exited with code 0
OracleXE                                                                    | 43% complete
OracleXE                                                                    | Completing Database Creation
OracleXE                                                                    | 47% complete
```

## To access the api

```
$ curl http://localhost:8080/employees
[{"empId":100,"firstName":"adarsh","lastName":"kumar","career":"It"},{"empId":200,"firstName":"radha","lastName":"singh","career":"IT"},{"empId":300,"firstName":"sonu","lastName":"singh","career":"IT"},{"empId":400,"firstName":"amit","lastName":"kumar","career":"Finance"}]USMB113823:docker us-guest$
```

## To shut down the docker compose

```
$ docker-compose down
[+] Running 4/4
 ⠿ Container oracle-liquibase-docker-compose-springboot-services-1      Removed                                                                                                  0.7s
 ⠿ Container oracle-liquibase-docker-compose-oracledb-liquibse-1    Removed                                                                                                  0.8s
 ⠿ Container OracleXE                                               Removed                                                                                                 10.4s
 ⠿ Network oracle-liquibase-docker-compose_espark-net               Removed                                                                                                  0.1s
```


----

---

# k8

---

## K8 Deployment Process

### To build code

- $ mvn clean package

### To build the docker image and tag

- $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-oracledb-service .

### to push the docker image to the docker hub

- $ docker push adarshkumarsingh83/springboot-oracledb-service

### NOTE CHANGE TO THE DOCKER DESKTOP IN THE DOCKER -> KUBERNATES

- $ kubectl cluster-info

### to create service and other in kubernetes

- $ kubectl apply -f $(pwd)/configmap.yml
- $ kubectl apply -f $(pwd)/secret.yml
- $ kubectl apply -f $(pwd)/oracle.yml
- $ kubectl apply -f $(pwd)/springboot.yml

### to view the service and other
- $ kubectl get all

### to view the secrets
- $ kubectl get secrets

### to view the configmap
- $ kubectl get configmap

### to get the persistence volume
- $ kubectl get persistentvolumes
- $ kubectl get persistentvolumeclaims

### TO VIEW THE POD DETAILS
- $ kubectl get pod

### To View oracle logs 
* kubectl logs -f [pod-name]  -c [conatiner-name]
	* kubectl logs -f [oracle-xe-c98cfddfb-ptvpk]  -c oracle-db

### TO VIEW THE LOGS OF THE POD
- $ kubectl logs [pod-name] -f
- $ kubectl describe services springboot-oracledb-service
- $ kubectl port-forward svc/springboot-oracledb-service 8080:8080

### Api Testing

- $ curl http://localhost:9090/employees
- $ curl http://localhost:9090/employee/1
- $ curl http://localhost:9090/employee/2

### TO DELETE CONFIG MAP

- $ kubectl delete configmap db-conf -n default
- $ kubectl delete secret/db-credentials
- $ kubectl delete secret/db-root-credentials

### FOR DELETING DEPLOYMENT AND SERVICE

- $ kubectl delete services springboot-oracledb-service
- $ kubectl delete deployment springboot-oracledb-service

### FOR DELETING DEPLOYMENT AND SERVICE OF MYSQL

- $ kubectl delete services oracle-xe
- $ kubectl delete deployment oracle-xe
- $ kubectl delete pvc oracle-pv-claim
- $ kubectl delete pvc oracle-pv-volume
