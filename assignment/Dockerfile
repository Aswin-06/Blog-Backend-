
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/blog-docker.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
