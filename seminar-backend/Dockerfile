FROM openjdk:17-jdk-alpine
EXPOSE 8080
WORKDIR /app
COPY target/edu-journey-backend-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
