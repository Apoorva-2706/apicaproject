FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/journal-service-0.0.1-SNAPSHOT.jar journal-service.jar
ENTRYPOINT ["java","-jar","/journal-service.jar"]
