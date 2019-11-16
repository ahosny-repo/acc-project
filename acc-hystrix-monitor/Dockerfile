FROM openjdk:8
ADD target/acc-hystrix-monitor-0.0.1-SNAPSHOT.jar acc-hystrix-monitor-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/acc-hystrix-monitor-app.jar"]
EXPOSE 8886