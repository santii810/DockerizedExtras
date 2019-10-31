# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Define file path
ARG JAR_FILE=target/Extras-0.0.3-SNAPSHOT.jar

# Add the application's jar to the container
ADD target/Extras-0.0.3-SNAPSHOT.jar Extras.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Extras.jar"]