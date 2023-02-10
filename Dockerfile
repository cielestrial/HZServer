FROM openjdk:13
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/HZServer-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#
# Build stage
#
FROM maven:3.8.1 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:13-jdk-slim
COPY --from=build /target/HZServer-0.0.1-SNAPSHOT.jar hzserver.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","hzserver.jar"]