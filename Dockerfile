#FROM docker pull openjdk:15.0.1
FROM maven:3.6.3-openjdk-15
CMD pwd
CMD ls -lrt
ARG JAR_FILE=target/*.jar
CMD pwd
CMD ls -lrt
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
