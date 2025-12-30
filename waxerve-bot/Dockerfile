# ====== Build Stage ======
FROM eclipse-temurin:25-jdk AS build

# Set the working directory
WORKDIR /app

# Copy Maven descriptor first for better caching
COPY pom.xml .
COPY src ./src

# Build the application (adjust if your artifact name differs)
RUN ./mvnw -B -DskipTests package || mvn -B -DskipTests package

# ====== Runtime Stage ======
FROM eclipse-temurin:25-jre

WORKDIR /app

# Copy only the built artifact from the build stage
COPY --from=build /app/target/*.jar app.jar

# Set the main class if needed (optional if jar manifest already defines it)
# ENV JAVA_MAIN_CLASS=com.example.Main

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
