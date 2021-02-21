#FROM docker pull openjdk:15.0.1
FROM maven:3.6.3-openjdk-15
RUN mvn clean package
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
