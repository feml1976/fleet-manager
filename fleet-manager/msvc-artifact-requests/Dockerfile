FROM openjdk:21-jdk

WORKDIR /app

COPY ./targmsvc-artifact-requests .

RUN ./mvnw clean package -DskipTest

EXPOSE 8002

ENTRYPOINT ["java", "-jar", "./target/msvc-artifact-requests-0.0.1-SNAPSHOT.jar"]