FROM openjdk:21-jdk

WORKDIR /app

COPY ./target/msvc-artifact-controlflota-0.0.1-SNAPSHOT.jar /app

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "msvc-artifact-controlflota-0.0.1-SNAPSHOT.jar"]