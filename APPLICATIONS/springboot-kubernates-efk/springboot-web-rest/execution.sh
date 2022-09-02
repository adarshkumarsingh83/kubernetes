#!bin/bash
#Start Server only if it is not running
if [ $(lsof -n -i :8080 | grep LISTEN | wc -l) -eq 0 ]
then
 # Note starting server
  echo " Server Started"
  java -jar ./target/springboot-web-rest.jar
else
  echo "Server Already Running"
fi