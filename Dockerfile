#Installing java inside docker container
FROM openjdk:11

#Installing maven inside docker container
FROM maven:alpine

WORKDIR  /app
COPY . /app

#this command is running inside app folder
#Creating jar inside the target folder
RUN mvn -v
RUN mvn clean install -DskipTests

LABEL maintainer="technohunk444@gmail.com"

RUN cp  target/publish-data-consumer-0.0.1-SNAPSHOT.jar  publish-data-consumer-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","publish-data-consumer-0.0.1-SNAPSHOT.jar"] 

