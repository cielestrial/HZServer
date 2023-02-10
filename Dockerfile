FROM openjdk:13
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/HZServer-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]