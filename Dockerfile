FROM bellsoft/liberica-openjdk-debian:17

WORKDIR /app

COPY  out/artifacts/testBank_jar/testBank.jar .
ENTRYPOINT ["java", "-jar", "testBank.jar"]