# springboot-kubernates-liquibase-initcontainer-mysql

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

- $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-mysql-service .

### to push the docker image to the docker hub

- $ docker push adarshkumarsingh83/springboot-mysql-service

### NOTE CHANGE TO THE DOCKER DESKTOP IN THE DOCKER -> KUBERNATES

- $ kubectl cluster-info

### to create service and other in kubernetes

- $ kubectl apply -f $(pwd)/configmap.yml
- $ kubectl apply -f $(pwd)/secret1.yml
- $ kubectl apply -f $(pwd)/secret2.yml
- $ kubectl apply -f $(pwd)/mysql.yml
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

### TO VIEW THE LOGS OF THE POD
- $ kubectl logs [pod-name] -f
- $ kubectl describe pod [pod-name]
- $ kubectl describe services springboot-mysql-service
- $ kubectl port-forward svc/springboot-mysql-service 9090:9090

## To ssh into mysql container 
* $ exec kubectl exec -i -t  [mysql-pod-name]  -c mysql -- sh -c "clear; (bash || ash || sh)"
```
$ exec kubectl exec -i -t  mysql-55bf77bc8f-kjz9v  -c mysql -- sh -c "clear; (bash || ash || sh)"
bash-4.2# mysql -u root -p  
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 15
Server version: 5.7.39 MySQL Community Server (GPL)

Copyright (c) 2000, 2022, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| espark-mysql       |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.01 sec)

mysql> use espark-mysql;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed

mysql> select * from EMPLOYEE;
+--------+------------+-----------+---------+
| emp_id | first_name | last_name | career  |
+--------+------------+-----------+---------+
|    100 | adarsh     | kumar     | It      |
|    200 | radha      | singh     | IT      |
|    300 | sonu       | singh     | IT      |
|    400 | amit       | kumar     | Finance |
+--------+------------+-----------+---------+
4 rows in set (0.00 sec)
```

## To see the logs of the container 
* kubectl logs -f [pod-name] -c [container-name]
```
USMB113823:~ us-guest$ kubectl logs -f springboot-mysql-service-7f4f8fd9df-zx4dg  -c liquibase

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.2)

2022-08-29 14:11:35.161  INFO 1 --- [           main] c.e.a.SpringbootLiquibaseApplication     : Starting SpringbootLiquibaseApplication v0.0.1-SNAPSHOT using Java 11.0.16 on springboot-mysql-service-7f4f8fd9df-zx4dg with PID 1 (/springboot-liquibase-mysql.jar started by root in /)
2022-08-29 14:11:35.164  INFO 1 --- [           main] c.e.a.SpringbootLiquibaseApplication     : The following 1 profile is active: "kubernates"
2022-08-29 14:11:36.466  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : hikar-pool - Starting...
2022-08-29 14:11:36.787  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : hikar-pool - Start completed.
2022-08-29 14:11:37.257  INFO 1 --- [           main] liquibase.lockservice                    : Successfully acquired change log lock
2022-08-29 14:11:37.270  INFO 1 --- [           main] liquibase.command                        : Dropping Database Objects in schema: espark-mysql.espark-mysql
2022-08-29 14:11:37.634  INFO 1 --- [           main] liquibase.database                       : Successfully deleted all supported object types in schema espark-mysql.espark-mysql.
2022-08-29 14:11:37.646  INFO 1 --- [           main] liquibase.lockservice                    : Successfully released change log lock
All objects dropped from root@172.17.0.4@jdbc:mysql://mysql:3306/espark-mysql?createDatabaseIfNotExist=true&useSSL=false
2022-08-29 14:11:37.707  INFO 1 --- [           main] liquibase.lockservice                    : Successfully acquired change log lock
2022-08-29 14:11:38.291  INFO 1 --- [           main] liquibase.changelog                      : Creating database history table with name: `espark-mysql`.DATABASECHANGELOG
2022-08-29 14:11:38.305  INFO 1 --- [           main] liquibase.changelog                      : Reading from `espark-mysql`.DATABASECHANGELOG
Running Changeset: db/changelog/db.changelog-master.xml::1::adarsh
2022-08-29 14:11:38.385  INFO 1 --- [           main] liquibase.changelog                      : SQL in file db/changelog/changes/sql/create_schema.sql executed
2022-08-29 14:11:38.386  INFO 1 --- [           main] liquibase.changelog                      : ChangeSet db/changelog/db.changelog-master.xml::1::adarsh ran successfully in 31ms
Running Changeset: db/changelog/db.changelog-master.xml::2::radha
2022-08-29 14:11:38.448  INFO 1 --- [           main] liquibase.changelog                      : SQL in file db/changelog/changes/sql/insert_data.sql executed
2022-08-29 14:11:38.449  INFO 1 --- [           main] liquibase.changelog                      : ChangeSet db/changelog/db.changelog-master.xml::2::radha ran successfully in 31ms
Running Changeset: db/changelog/db.changelog-master.xml::3::radha
2022-08-29 14:11:38.463  INFO 1 --- [           main] liquibase.changelog                      : SQL in file db/changelog/changes/sql/select_data.sql executed
2022-08-29 14:11:38.464  INFO 1 --- [           main] liquibase.changelog                      : ChangeSet db/changelog/db.changelog-master.xml::3::radha ran successfully in 10ms
2022-08-29 14:11:38.471  INFO 1 --- [           main] liquibase.lockservice                    : Successfully released change log lock
2022-08-29 14:11:38.558  INFO 1 --- [           main] c.e.a.SpringbootLiquibaseApplication     : Started SpringbootLiquibaseApplication in 4.167 seconds (JVM running for 4.777)
2022-08-29 14:11:38.568  INFO 1 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : hikar-pool - Shutdown initiated...
2022-08-29 14:11:38.586  INFO 1 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : hikar-pool - Shutdown completed.

```

### Api Testing

- $ curl http://localhost:9090/employees
- $ curl http://localhost:9090/employee/1
- $ curl http://localhost:9090/employee/2

### TO DELETE CONFIG MAP

- $ kubectl delete configmap db-conf -n default
- $ kubectl delete secret/db-credentials
- $ kubectl delete secret/db-root-credentials

### FOR DELETING DEPLOYMENT AND SERVICE

- $ kubectl delete services springboot-mysql-service
- $ kubectl delete deployment springboot-mysql-service

### FOR DELETING DEPLOYMENT AND SERVICE OF MYSQL

- $ kubectl delete services mysql
- $ kubectl delete deployment mysql
- $ kubectl delete pvc mysql-pv-claim
- $ kubectl delete pvc mysql-pv-volume
