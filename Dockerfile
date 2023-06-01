# Set the base image to Maven
FROM maven:3.8.5-openjdk-17-slim AS build

# Copy the project directory into the container
COPY . /app

# Set the working directory
WORKDIR /app

# Build the Maven project
RUN mvn clean package

# Set the base image to OpenJDK
FROM openjdk:17-slim

# Copy the built application from the Maven container
COPY --from=build /app/target/server-1.jar /app/server-1.jar

# Set the working directory
WORKDIR /app

# Expose the application port
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "server-1.jar"]

