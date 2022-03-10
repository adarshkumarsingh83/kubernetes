# oracle-liquibase-custom-image

---

### location in project directory

- $ pwd

```
/Volume/oracle-liquibase-initcontainer
```

### project directory structure

```
$ tree -f
.
├── ./Dockerfile
├── ./README.md
├── ./lib
│   └── ./lib/ojdbc11-21.3.0.0.jar
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

### To start the oracle database

```
 docker run --name OracleXE \
  --shm-size=1g \
  --hostname OracleXE \
  --net espark-net \
  -p 1521:1521 \
  -p 8081:8080 \
  -e ORACLE_PWD=12345 \
  -v oracle-data:/u01/app/oracle/oradata \
  oracle/database:18.4.0-xe
```

## get inside the oracle container and find this host and port

- lsnrctl status

## TO TRUNCATE THE DB TABLES

- truncate table system.DATABASECHANGELOG;
- truncate table system.DATABASECHANGELOGLOCK;

### To start the liquidbase cmd

```
 docker run --rm \
--name espark-liquibase \
--net espark-net \
 --url jdbc:oracle:thin:@OracleXE:1521:XE \
 --username SYSTEM \
 --password 12345 \
 -v $(pwd)/resources:/liquibase/changelog \
 -v $(pwd)/resources/changelog/changes:/liquibase/changelog/changelog/changes \
 -v $(pwd)/resources/changelog/changes/sql:/liquibase/changelog/changelog/changes/sql \
 -v $(pwd)/lib:/liquibase/classpath/ojdbc11-21.3.0.0.jar liquibase/liquibase:latest \
 --defaultsFile=/liquibase/changelog/liquibase.properties \
 --classpath=/liquibase/changelog:/liquibase/classpath/ojdbc11-21.3.0.0.jar \
 --changeLogFile=changelog/changelog.xml update
```

### Actual execution

```
$  docker run --rm \
> --name espark-liquibase \
> --net espark-net \
>  -v $(pwd)/resources:/liquibase/changelog \
>  -v $(pwd)/resources/changelog/changes/sql:/liquibase/changelog/changelog/changes/sql \
>  -v $(pwd)/resources/changelog/changes:/liquibase/changelog/changelog/changes \
>  -v $(pwd)/lib:/liquibase/classpath/ojdbc11-21.3.0.0.jar liquibase/liquibase:latest \
>  --defaultsFile=/liquibase/changelog/liquibase.properties \
>  --classpath=/liquibase/changelog:/liquibase/classpath/ojdbc11-21.3.0.0.jar \
>  --changeLogFile=changelog/changelog.xml update
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
Starting Liquibase at 20:49:00 (version 4.8.0 #1581 built at 2022-02-18 21:43+0000)
Liquibase Version: 4.8.0
Liquibase Community 4.8.0 by Liquibase
Liquibase command 'update' was executed successfully.
```

### connect the oralce db from sql developer

- system->tables -> employees

---

### Create a Dockerfile with below content

```
FROM liquibase/liquibase:latest
ADD resources/changelog /liquibase/changelog
ADD resources/changelog/sql /liquibase/changelog/sql
ADD lib /liquibase/classpath/ojdbc11-21.3.0.0.jar
ADD resources/liquibase.properties /liquibase/changelog/
USER root
COPY lib/ojdbc11-21.3.0.0.jar /liquibase/classpath/ojdbc11-21.3.0.0.jar
COPY resources/liquibase.properties /liquibase/changelog/
COPY ./resources/changelog/sql/*.sql /liquibase/changelog/sql/
CMD ["sh", "-c", "docker-entrypoint.sh --url=${DB_URL} --username=${DB_USERNAME} --password=${DB_PASSWORD} --defaultsFile=/liquibase/changelog/liquibase.properties --changeLogFile=changelog/changelog.xml --classpath=/liquibase/changelog:/liquibase/classpath/ojdbc11-21.3.0.0.jar update"]
```

## To create a custom docker image

- $ docker build -f Dockerfile -t espark/liquibase .

```
[+] Building 0.3s (13/13) FINISHED
 => [internal] load build definition from Dockerfile                                        0.0s
 => => transferring dockerfile: 37B                                                         0.0s
 => [internal] load .dockerignore                                                           0.0s
 => => transferring context: 2B                                                             0.0s
 => [internal] load metadata for docker.io/liquibase/liquibase:latest                       0.0s
 => CACHED [1/8] FROM docker.io/liquibase/liquibase:latest                                  0.0s
 => [internal] load build context                                                           0.0s
 => => transferring context: 2.36kB                                                         0.0s
 => [2/8] ADD resources/changelog /liquibase/changelog                                      0.0s
 => [3/8] ADD resources/changelog/sql /liquibase/changelog/sql                              0.0s
 => [4/8] ADD lib /liquibase/classpath/ojdbc11-21.3.0.0.jar                                 0.0s
 => [5/8] ADD resources/liquibase.properties /liquibase/changelog/                          0.0s
 => [6/8] COPY lib/ojdbc11-21.3.0.0.jar /liquibase/classpath/ojdbc11-21.3.0.0.jar           0.0s
 => [7/8] COPY resources/liquibase.properties /liquibase/changelog/                         0.0s
 => [8/8] COPY ./resources/changelog/sql/*.sql /liquibase/changelog/sql/                    0.0s
 => exporting to image                                                                      0.1s
 => => exporting layers                                                                     0.1s
 => => writing image sha256:64a96c2ca68845bd9bcc43892c6acf505e293dcf525fa09abfa00651d7e99a  0.0s
 => => naming to docker.io/espark/liquibase                                                 0.0s
```

## To list the image

- $ docker images

```
REPOSITORY               TAG            IMAGE ID       CREATED        SIZE
espark/liquibase         latest         64a96c2ca688   1 hours ago    374MB
liquibase/liquibase      latest         92d9c4600558   2 weeks ago    364MB
oracle/database          18.4.0-xe      c265dc4e3bd6   3 months ago   5.89GB

```

## to start the docker container using custom iamge

- $ docker run --rm --name espark-liquibase \
  --net espark-net \
  -e DB_URL=jdbc:oracle:thin:@OracleXE:1521:XE \
  -e DB_USERNAME=SYSTEM \
  -e DB_PASSWORD=12345 \
  espark/liquibase

```
$ docker run --rm --name espark-liquibase --net espark-net -e DB_URL=jdbc:oracle:thin:@OracleXE:1521:XE -e DB_USERNAME=SYSTEM -e DB_PASSWORD=12345 espark/liquibase
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
