FROM openjdk:17

RUN mkdir /build

COPY target/jarinha-0.0.1-SNAPSHOT.jar /build/jarinha.jar

CMD ["java", "-jar", "/build/jarinha.jar"]