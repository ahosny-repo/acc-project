FROM openjdk:8
ADD target/acc-turbine-stream-0.0.1-SNAPSHOT.jar acc-turbine-stream-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/acc-turbine-stream-app.jar"]