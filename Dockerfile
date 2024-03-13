FROM openjdk:21
VOLUME /tmp
EXPOSE 8081
COPY target/rest-0.0.1-SNAPSHOT.jar rest.jar
ENTRYPOINT ["java", "-jar", "/rest.jar"]