# Start from an official Maven image with JDK 21
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml /app/
RUN mvn dependency:go-offline

# Copy the rest of the application's source code and resources
COPY . /app/

# Package the application
RUN mvn package -DskipTests

# Use a minimal JRE image for the final build
FROM eclipse-temurin:21-jre-jammy

# Set the working directory
WORKDIR /app

# Copy the JAR file from the previous stage
COPY --from=build /app/target/PlayTogether-0.0.1-SNAPSHOT.jar /app/PlayTogether-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8080

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "/app/PlayTogether-0.0.1-SNAPSHOT.jar"]
