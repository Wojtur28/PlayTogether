# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Set the working directory
WORKDIR /app

# Copy only the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the entire source code and package the application
COPY . .
RUN mvn package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jre-jammy

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/PlayTogether-0.0.1-SNAPSHOT.jar .

# Expose the application port
EXPOSE 8080

# Command to run the application with a custom application.yml location
ENTRYPOINT ["java", "-jar", "PlayTogether-0.0.1-SNAPSHOT.jar", "--spring.config.location=file:/home/playtogether/application.yml"]
