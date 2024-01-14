# Use a base image with Java and Maven
FROM maven:3-eclipse-temurin-21

# Set the working directory to /app
WORKDIR /app

# Copy your Maven configuration and source code
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

# Build the application
RUN mvn package -Dmaven.test.skip=true

# Copy the built JAR file into the image
COPY target/your-application.jar /app/

# Define environment variable for database configuration
ENV SPRING_DATASOURCE_URL=jdbc:mysql://database-hostname:3306/goodreads
ENV SPRING_DATASOURCE_USERNAME=fred
ENV SPRING_DATASOURCE_PASSWORD=fred
ENV SPRING_DATASOURCE_DRIVER-CLASS-NAME=com.mysql.cj.jdbc.Driver

# Define the database host in an environment variable
ENV DATABASE_HOST=fred

# Expose the port
EXPOSE 8080

# Run the application
CMD ["sh", "-c", "java -jar -Dspring.datasource.url=${SPRING_DATASOURCE_URL} -Dspring.datasource.username=${SPRING_DATASOURCE_USERNAME} -Dspring.datasource.password=${SPRING_DATASOURCE_PASSWORD} -Dspring.datasource.driver-class-name=${SPRING_DATASOURCE_DRIVER-CLASS-NAME} -Dspring.datasource.hikari.connectionTimeout=30000 -Dspring.datasource.hikari.idleTimeout=600000 -Dspring.datasource.hikari.minimumIdle=2 -Dspring.datasource.hikari.maximumPoolSize=8 -Dspring.datasource.hikari.jdbcUrl=${SPRING_DATASOURCE_URL} -Dserver.port=8080 -Ddatabase.host=${DATABASE_HOST} day21-0.0.1-SNAPSHOT.jar"]