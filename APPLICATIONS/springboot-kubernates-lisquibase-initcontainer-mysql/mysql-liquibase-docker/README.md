# oracle-liquibase-custom-image

---

### location in project directory

- $ pwd

```
/Volume/mysql-liquibase-initcontainer
```

### project directory structure

```
$ tree -f
.
├── ./Dockerfile
├── ./README.md
├── ./lib
│   └── ./lib/mysql-connector.jar     ##mysql-connector-java-8.0.30.jar
└── ./resources
    ├── ./resources/changelog
    │   ├── ./resources/changelog/changelog.xml
    │   └── ./resources/changelog/sql
    │       ├── ./resources/changelog/sql/create_schema.sql
    │       ├── ./resources/changelog/sql/insert_data.sql
    │       └── ./resources/changelog/sql/select_data.sql
    └── ./resources/liquibase.properties
```

### to create a new network

- $ docker network create espark-net

### To list the network

- $ docker network list

### To start the mysql database

```
 docker run --name epsark-mysql \
  --shm-size=1g \
  --network=espark-net \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=rootPwd \
  -e MYSQL_DATABASE=espark \
  -h epsark-mysql \
  -v mysql-data:/var/lib/mysql \
  mysql:5.6
```

## get inside the oracle container and find this host and port

- lsnrctl status

## TO TRUNCATE THE DB TABLES

- truncate table DATABASECHANGELOG;
- truncate table DATABASECHANGELOGLOCK;

---

### Create a Dockerfile with below content

```
FROM liquibase/liquibase:latest
ADD resources/changelog /liquibase/changelog
ADD resources/changelog/sql /liquibase/changelog/sql
ADD lib /liquibase/classpath/mysql-connector-java-8.0.30.jar
ADD resources/liquibase.properties /liquibase/changelog/
USER root
COPY lib/mysql-connector-java-8.0.30.jar /liquibase/classpath/mysql-connector-java-8.0.30.jar
COPY resources/liquibase.properties /liquibase/changelog/
COPY ./resources/changelog/sql/*.sql /liquibase/changelog/sql/
CMD ["sh", "-c", "docker-entrypoint.sh --url=${DB_URL} --username=${DB_USERNAME} --password=${DB_PASSWORD} --defaultsFile=/liquibase/changelog/liquibase.properties --changeLogFile=changelog/changelog.xml --classpath=/liquibase/changelog:/liquibase/classpath/mysql-connector-java-8.0.30.jar update"]
```

## To create a custom docker image

- $ docker build -f Dockerfile -t adarshkumarsingh83/mysql-liquibase .

```
+] Building 0.4s (13/13) FINISHED
 => [internal] load build definition from Dockerfile                                                                   0.0s
 => => transferring dockerfile: 815B                                                                                   0.0s
 => [internal] load .dockerignore                                                                                      0.0s
 => => transferring context: 2B                                                                                        0.0s
 => [internal] load metadata for docker.io/liquibase/liquibase:latest                                                  0.0s
 => CACHED [1/8] FROM docker.io/liquibase/liquibase:latest                                                             0.0s
 => [internal] load build context                                                                                      0.0s
 => => transferring context: 2.53MB                                                                                    0.0s
 => [2/8] ADD resources/changelog /liquibase/changelog                                                                 0.0s
 => [3/8] ADD resources/changelog/sql /liquibase/changelog/sql                                                         0.0s
 => [4/8] ADD lib /liquibase/classpath/mysql-connector-java-8.0.30.jar                                                 0.0s
 => [5/8] ADD resources/liquibase.properties /liquibase/changelog/                                                     0.0s
 => [6/8] COPY lib/mysql-connector-java-8.0.30.jar /liquibase/classpath/mysql-connector-java-8.0.30.jar                0.0s
 => [7/8] COPY resources/liquibase.properties /liquibase/changelog/                                                    0.0s
 => [8/8] COPY ./resources/changelog/sql/*.sql /liquibase/changelog/sql/                                               0.0s
 => exporting to image                                                                                                 0.1s
 => => exporting layers                                                                                                0.1s
 => => writing image sha256:b33121fe02d25218c6c72562c0eafaaf933813d39b3990560ec1a3cdcc3f44ee                           0.0s
 => => naming to docker.io/adarshkumarsingh83/mysql-liquibase                                                          0.0s
```

## To list the image

- $ docker images

```
REPOSITORY                                  TAG            IMAGE ID       CREATED               SIZE
adarshkumarsingh83/mysql-liquibase          latest         64a96c2ca688   About a minute ago   369MB
```

## to start the docker container using custom iamge

- $ docker run --rm --name espark-liquibase \
  --net espark-net \
  -e DB_URL=jdbc:mysql://localhost:3306/espark \
  -e DB_USERNAME=root \
  -e DB_PASSWORD=rootPwd \
  adarshkumarsingh83/mysql-liquibase

```
$ docker run --rm --name espark-liquibase --net espark-net -e DB_URL=jdbc:mysql://localhost:3306/espark -e DB_USERNAME=root -e DB_PASSWORD=rootPwd adarshkumarsingh83/mysql-liquibase
####################################################
##   _     _             _ _                      ##
##  | |   (_)           (_) |                     ##
##  | |    _  __ _ _   _ _| |__   __ _ ___  ___   ##
##  | |   | |/ _` | | | | | '_ \ / _` / __|/ _ \  ##
##  | |___| | (_| | |_| | | |_) | (_| \__ \  __/  ##
##  \_____/_|\__, |\__,_|_|_.__/ \__,_|___/\___|  ##
##              | |                               ##
##              |_|                               ##
##                                                ##
##  Get documentation at docs.liquibase.com       ##
##  Get certified courses at learn.liquibase.com  ##
##  Free schema change activity reports at        ##
##      https://hub.liquibase.com                 ##
##                                                ##
####################################################
Starting Liquibase at 20:29:51 (version 4.8.0 #1581 built at 2022-02-18 21:43+0000)
Liquibase Version: 4.8.0
Liquibase Community 4.8.0 by Liquibase
Running Changeset: changelog/changelog.xml::1::adarsh
Running Changeset: changelog/changelog.xml::2::radha
Running Changeset: changelog/changelog.xml::3::radha
Liquibase command 'update' was executed successfully.

```
