# Start with a base image containing Java runtime 17 for the build stage
FROM openjdk:17-jdk-slim as build

# Add Author info
LABEL maintainer="jefasoftwaresolutions@gmail.com"

# Set the working directory in Docker
WORKDIR /app

# Copy the Maven Wrapper, pom.xml file, and source code
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Make the Maven Wrapper script executable
RUN chmod +x ./mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Run stage
FROM openjdk:17-jdk-slim

ARG DATABASE_URL
ENV DATABASE_URL=${DATABASE_URL}

COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
