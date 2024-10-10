FROM bellsoft/liberica-openjdk-debian:17

WORKDIR /app

COPY  target/testBank-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", " .jar"]