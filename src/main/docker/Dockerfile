# node image for angular if existent
FROM node:9.4.0

# java image
FROM openjdk:8-jdk-alpine

VOLUME /tmp

ADD cars-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]
