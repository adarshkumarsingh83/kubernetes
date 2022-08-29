FROM liquibase/liquibase:latest
ADD resources/changelog /liquibase/changelog
ADD resources/changelog/sql /liquibase/changelog/sql
ADD lib /liquibase/classpath/mysql-connector.jar
ADD resources/liquibase.properties /liquibase/changelog/
USER root
COPY lib/mysql-connector.jar /liquibase/classpath/mysql-connector.jar
COPY resources/liquibase.properties /liquibase/changelog/
COPY ./resources/changelog/sql/*.sql /liquibase/changelog/sql/
CMD ["sh", "-c", "docker-entrypoint.sh --url=${DB_URL} --username=${DB_USERNAME} --password=${DB_PASSWORD} --defaultsFile=/liquibase/changelog/liquibase.properties --changeLogFile=changelog/changelog.xml --classpath=/liquibase/changelog:/liquibase/classpath/mysql-connector.jar update"]