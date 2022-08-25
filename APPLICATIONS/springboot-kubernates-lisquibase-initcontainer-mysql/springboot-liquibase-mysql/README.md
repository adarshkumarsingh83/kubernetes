# Springboot-liquibase-standalone
---

### TO BUILD THE CODE 
* mvn clean install -DskipTests
* or 
* mvn clean install -Dmaven.test.skip=true


## To Execute the 
* mvn spring-boot:run 

## To Build Docker image 
* $ docker build -f Dockerfile -t springboot-liquibase-mysql .

## To List Image 
* $ docker images

## Docker n/w creation 
* docker network create mynet

##  launch the db
* $ docker run --name epsark-mysql \
  --shm-size=1g \
  --network=mynet \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=rootPwd \
  -e MYSQL_DATABASE=espark \
  -h epsark-mysql \
  -v mysql-data:/var/lib/mysql \
  mysql:5.6

## To Execute Image
* docker run -e "SPRING_PROFILES_ACTIVE=docker" --network=mynet  springboot-liquibase-mysql --name springboot-liquibase-mysql

```        
   .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.2)

2022-08-25 20:42:23.805  INFO 1 --- [           main] c.e.a.SpringbootLiquibaseApplication     : Starting SpringbootLiquibaseApplication v0.0.1-SNAPSHOT using Java 11.0.16 on 558377d9d82f with PID 1 (/springboot-liquibase-mysql.jar started by root in /)
2022-08-25 20:42:23.807  INFO 1 --- [           main] c.e.a.SpringbootLiquibaseApplication     : The following 1 profile is active: "docker"
2022-08-25 20:42:24.531  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : hikar-pool - Starting...
2022-08-25 20:42:24.802  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : hikar-pool - Start completed.
2022-08-25 20:42:25.076  INFO 1 --- [           main] liquibase.lockservice                    : Successfully acquired change log lock
2022-08-25 20:42:25.086  INFO 1 --- [           main] liquibase.command                        : Dropping Database Objects in schema: espark.espark
2022-08-25 20:42:25.101  INFO 1 --- [           main] liquibase.changelog                      : Creating database history table with name: espark.DATABASECHANGELOG
2022-08-25 20:42:25.328  INFO 1 --- [           main] liquibase.database                       : Successfully deleted all supported object types in schema espark.espark.
2022-08-25 20:42:25.330  INFO 1 --- [           main] liquibase.lockservice                    : Successfully released change log lock
All objects dropped from root@172.19.0.3@jdbc:mysql://epsark-mysql:3306/espark
2022-08-25 20:42:25.369  INFO 1 --- [           main] liquibase.lockservice                    : Successfully acquired change log lock
2022-08-25 20:42:25.715  INFO 1 --- [           main] liquibase.changelog                      : Creating database history table with name: espark.DATABASECHANGELOG
2022-08-25 20:42:25.725  INFO 1 --- [           main] liquibase.changelog                      : Reading from espark.DATABASECHANGELOG
Running Changeset: db/changelog/db.changelog-master.xml::1::adarsh
2022-08-25 20:42:25.781  INFO 1 --- [           main] liquibase.changelog                      : SQL in file db/changelog/changes/sql/create_schema.sql executed
2022-08-25 20:42:25.782  INFO 1 --- [           main] liquibase.changelog                      : ChangeSet db/changelog/db.changelog-master.xml::1::adarsh ran successfully in 21ms
Running Changeset: db/changelog/db.changelog-master.xml::2::radha
2022-08-25 20:42:25.800  INFO 1 --- [           main] liquibase.changelog                      : SQL in file db/changelog/changes/sql/insert_data.sql executed
2022-08-25 20:42:25.802  INFO 1 --- [           main] liquibase.changelog                      : ChangeSet db/changelog/db.changelog-master.xml::2::radha ran successfully in 13ms
Running Changeset: db/changelog/db.changelog-master.xml::3::radha
2022-08-25 20:42:25.823  INFO 1 --- [           main] liquibase.changelog                      : SQL in file db/changelog/changes/sql/select_data.sql executed
2022-08-25 20:42:25.823  INFO 1 --- [           main] liquibase.changelog                      : ChangeSet db/changelog/db.changelog-master.xml::3::radha ran successfully in 17ms
2022-08-25 20:42:25.830  INFO 1 --- [           main] liquibase.lockservice                    : Successfully released change log lock
2022-08-25 20:42:25.895  INFO 1 --- [           main] c.e.a.SpringbootLiquibaseApplication     : Started SpringbootLiquibaseApplication in 2.561 seconds (JVM running for 3.102)
2022-08-25 20:42:25.904  INFO 1 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : hikar-pool - Shutdown initiated...
2022-08-25 20:42:25.933  INFO 1 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : hikar-pool - Shutdown completed.

```


## DROP THE TABLE 
``` 
drop table EMPLOYEE;
drop table DATABASECHANGELOG;
drop table DATABASECHANGELOGLOCK;
```

### mysql original procedure 
```    
DELIMITER $$
DROP PROCEDURE IF EXISTS getEmployee$$
CREATE PROCEDURE getEmployee(IN EMP_NO INT(10))
LANGUAGE SQL
READS SQL DATA
DETERMINISTIC
BEGIN
   select GROUP_CONCAT(EMP_ID,' ', FIRST_NAME,' ',LAST_NAME,' ',CAREER) FROM EMPLOYEE WHERE EMP_ID = EMP_NO;
END $$
DELIMITER ;

CALL getEmployee(100);
```