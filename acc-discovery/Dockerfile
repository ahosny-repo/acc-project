FROM openjdk:8
ADD target/acc-discovery-0.0.1-SNAPSHOT.jar acc-discovery-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/acc-discovery-app.jar"]
EXPOSE 8761