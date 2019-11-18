FROM openjdk:8
ADD target/acc-car-client-0.0.1-SNAPSHOT.jar acc-car-client-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/acc-car-client-app.jar"]
EXPOSE 8068