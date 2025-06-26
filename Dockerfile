# --- Build Stage ---
FROM maven:3.9.4-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copy your project files (adjust path if needed)
COPY . .

# Build the JAR
RUN mvn clean package -DskipTests

# --- Run Stage ---
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
