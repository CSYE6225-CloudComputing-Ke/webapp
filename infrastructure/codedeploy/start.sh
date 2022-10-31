#!/bin/bash
cd /home/centos || exit
url=$(cat mysqlsetting.txt | sed -r 's/.*"(.+)".*/\1/')
echo $url

cd /home/centos/webapp/target || exit
pwd
nohup java -jar demo-0.0.1-SNAPSHOT.war --spring.profiles.active=dev --spring.datasource.username=csye6225master --spring.datasource.password=Password --spring.datasource.url=jdbc:mysql://$url/csye6225 --server.port=8080 >/opt/logs.log 2>&1 &

