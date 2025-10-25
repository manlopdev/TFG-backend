# Step 1: Build the JAR using Gradle
FROM gradle:jdk17-corretto AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# Step 2: Run the JAR
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy only the main JAR (not the plain one)
COPY --from=build /app/build/libs/*-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
