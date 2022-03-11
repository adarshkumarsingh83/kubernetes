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
