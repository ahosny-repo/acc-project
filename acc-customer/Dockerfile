FROM openjdk:8
ADD target/acc-customer-0.0.1-SNAPSHOT.jar acc-customer-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/acc-customer-app.jar"]
EXPOSE 8076