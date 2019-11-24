FROM openjdk:8
ADD target/acc-gateway-0.0.1-SNAPSHOT.jar acc-gateway-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/acc-gateway-app.jar"]