# Variables
ARG VERSION

# Build Stage
FROM maven:3.9.9-eclipse-temurin-24-alpine AS builder
WORKDIR /app
COPY . .
RUN mvn clean package

# Runtime Stage (only copies the JAR)
FROM eclipse-temurin:24-jre
WORKDIR /app
COPY --from=builder /app/target/waxerve-bot-$VERSION.jar waxerve-bot-$VERSION.jar
CMD ["java", "-jar", "waxerve-bot-$VERSION.jar"]
