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