#FROM docker pull openjdk:15.0.1
FROM maven:3.6.3-openjdk-15
# copy the source tree and the pom.xml to our new container
COPY ./ ./
# package our application code
RUN mvn clean package                   #shell form
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]   #execution form
