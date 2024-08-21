FROM openjdk:21-jdk
WORKDIR /app
COPY target/Snail-1.0.0.jar /app/Snail-1.0.0.jar
CMD ["java", "-jar", "/app/Snail-1.0.0.jar"]