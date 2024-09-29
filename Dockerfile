FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY build/libs/mistergold-0.0.1-SNAPSHOT.jar /app/mistergold-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/mistergold-0.0.1-SNAPSHOT.jar"]