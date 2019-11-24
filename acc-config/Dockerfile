FROM openjdk:8
ADD target/acc-config-0.0.1-SNAPSHOT.jar acc-config-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/acc-config-app.jar"]