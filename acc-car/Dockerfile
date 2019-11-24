FROM openjdk:8
ADD target/acc-car-0.0.1-SNAPSHOT.jar acc-car-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/acc-car-app.jar"]