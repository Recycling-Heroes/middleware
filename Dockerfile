#Gradle Build
FROM gradle:7.5-jdk17 AS builder
COPY build.gradle /app/
COPY src /app/src
WORKDIR /app
RUN gradle build --no-daemon

#Run
FROM openjdk:17-jdk-slim-buster
COPY --from=builder /app//build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
