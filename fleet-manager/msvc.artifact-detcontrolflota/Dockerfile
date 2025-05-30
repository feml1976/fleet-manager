FROM openjdk:21-jdk

WORKDIR /app

COPY ./target/msvc.artifact-detcontrolflota-0.0.1-SNAPSHOT.jar /app

EXPOSE 8003

ENTRYPOINT ["java", "-jar", "msvc.artifact-detcontrolflota-0.0.1-SNAPSHOT.jar"]