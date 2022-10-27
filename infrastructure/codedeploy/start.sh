#!/bin/bash
cd /home/centos
url=$(cat mysqlsetting.txt | sed -r 's/.*"(.+)".*/\1/')
echo $url

cd /home/centos/webapp/target
pwd
nohup java -jar assignment01-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev --spring.datasource.username=csye6225master --spring.datasource.password=Password --spring.datasource.url=jdbc:mysql://$url/csye6225 --server.port=8080 >/opt/logs.log 2>&1 &

