# springboot-kubernates-liquibase-initcontainer-oracle

---

## To start

- we have wait a lot becoz oracle db will take time to start mean while spring and liquibase will restart many times
- docker-compose up

```
OracleXE                                               | 43% complete
OracleXE                                               | Completing Database Creation
OracleXE                                               | 47% complete
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ####################################################
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##   _     _             _ _                      ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##  | |   (_)           (_) |                     ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##  | |    _  __ _ _   _ _| |__   __ _ ___  ___   ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##  | |   | |/ _` | | | | | '_ \ / _` / __|/ _ \  ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##  | |___| | (_| | |_| | | |_) | (_| \__ \  __/  ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##  \_____/_|\__, |\__,_|_|_.__/ \__,_|___/\___|  ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##              | |                               ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##              |_|                               ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##                                                ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##  Get documentation at docs.liquibase.com       ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##  Get certified courses at learn.liquibase.com  ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##  Free schema change activity reports at        ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##      https://hub.liquibase.com                 ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ##                                                ##
oracle-liquibase-docker-compose-oracledb-liquibse-1    | ####################################################
oracle-liquibase-docker-compose-oracledb-liquibse-1    | Starting Liquibase at 01:43:55 (version 4.8.0 #1581 built at 2022-02-18 21:43+0000)
oracle-liquibase-docker-compose-oracledb-liquibse-1    | Liquibase Version: 4.8.0
oracle-liquibase-docker-compose-oracledb-liquibse-1    | Liquibase Community 4.8.0 by Liquibase
oracle-liquibase-docker-compose-oracledb-liquibse-1    | Liquibase command 'update' was executed successfully.
oracle-liquibase-docker-compose-oracledb-liquibse-1 exited with code 0
oracle-liquibase-docker-compose-springboot-services-1  | 2022-03-09 01:44:30.575  INFO 1 --- [nio-8080-exec-2] com.zaxxer.hikari.HikariDataSource       : HikariPoolBooks - Starting...
oracle-liquibase-docker-compose-springboot-services-1  | 2022-03-09 01:44:35.757  INFO 1 --- [nio-8080-exec-2] com.zaxxer.hikari.HikariDataSource       : HikariPoolBooks - Start completed.
oracle-liquibase-docker-compose-springboot-services-1  | Hibernate:
oracle-liquibase-docker-compose-springboot-services-1  |     select
oracle-liquibase-docker-compose-springboot-services-1  |         employee0_.emp_id as emp_id1_0_,
oracle-liquibase-docker-compose-springboot-services-1  |         employee0_.career as career2_0_,
oracle-liquibase-docker-compose-springboot-services-1  |         employee0_.first_name as first_name3_0_,
oracle-liquibase-docker-compose-springboot-services-1  |         employee0_.last_name as last_name4_0_
oracle-liquibase-docker-compose-springboot-services-1  |     from
oracle-liquibase-docker-compose-springboot-services-1  |         employee employee0_
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
