[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=ahosny-repo_acc-project&metric=alert_status)](https://sonarcloud.io/dashboard?id=ahosny-repo_acc-project)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=ahosny-repo_acc-project&metric=coverage)](https://sonarcloud.io/dashboard?id=ahosny-repo_acc-project)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=ahosny-repo_acc-project&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=ahosny-repo_acc-project)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=ahosny-repo_acc-project&metric=security_rating)](https://sonarcloud.io/dashboard?id=ahosny-repo_acc-project)


# Car Monitoring System (ACC)
Car Monitoring System (Alten Connected Car - ACC for short) is a system for tracking and monitoring car status of the customers whos are registered within the system so the can manage their day to day business operations. 

<p align="center">
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/acc-dashboard.JPG" width="600">
</p>

## Scenario:
	
	- Partner company has a number of connected vehicles that belongs to a number of customers.
	- They have a need to be able to view the status of the connection among these vehicles on a monitoring display.
	- The vehicles send the status of the connection one time per minute.
	- The status can be compared with a ping (network trace); no request from the vehicle means no connection. 
	- So, vehicle is either Connected or Disconnected.
		
## Task:

	- The is to create a data store that keeps these vehicles with their status and the customers who own them, as well as a GUI (preferably web-based) that displays the status.
	- Obviously, for this task, there are no real vehicles available that can respond to your "ping" request.
	- This can either be solved by using static values or ​​by creating a separate machinery that returns random fake status.

## Requirements

	1. Web GUI (Single Page Application Framework/Platform).
	2. Random simulation to vehicles status sending.
	
## Optional Requirements

	1. Integration test.
	2. Automation test.
	3. Explain if it is possible to be in Serverless architecture and how?
	4. Continuous delivery to the solution to the cloud.
	
## Solution Overview

The following diagrams represent the solution components, domains, infrastructure and services that used as building block for our project using Spring Boot, Spring Cloud with Netflix OSS Components and Angular8 for fronted Web-GUI / dashboard.

<p align="center">
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/acc-arch.JPG" width="600">
</p>

#### About Microservice

The main objective of the micro-services implementation is to split up the application as separate service for each core and API service functionality and it should be deployed independently on cloud. We have chosen the java programming language from spring.io family project with a set of components that can be used to implement our operations model. Spring Cloud integrates the Netflix components in the spring environment in a very nice way using auto configuration and convention over configuration similar to how Spring Boot works.

#### Microservice Benifits

	- The smaller code base is easy to maintain.
	- Easy to scale as an individual component.
	- Technology diversity i.e. we can mix libraries, databases, frameworks etc.
	- Fault isolation i.e. a process failure should not bring the whole system down.
	- Better support for smaller and parallel team.
	- Independent deployment
	- Deployment time reduce

### Microservice Framework

The Spring Framework provides a comprehensive programming and configuration model for modern Java-based enterprise applications - on any kind of deployment platform. A key element of Spring is infrastructural support at the application level: Spring focuses on the "plumbing" of enterprise applications so that teams can focus on application-level business logic, without unnecessary ties to specific deployment environments.

<p align="center">
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/spring-boot-arch.JPG" width="600">
</p>

### Microservice



### Service Configuration

Spring Cloud Config provides server-side and client-side support for externalized configuration in a distributed system. With the Config Server,we have a central place to manage external properties for applications across all environments. 

### Discovery Server (Eureka)

Netflix Eureka allows micro services to register themselves at runtime as they appear in the system landscape.

### Microservice API Gateway

Zulu provides a well-known entry point to the micro services in the system landscape. Using dynamically allocated ports is convenient to avoid port conflict and Zuul Intelligent routing (proxy for our micro services) and also as a gateway for external requests.

### Client-side Load Balancing

Netflix Ribbon can be used by service consumers to look up services at runtime. Ribbon uses the information available in Eureka to locate appropriate service instances. If more than one instance is found, Ribbon will apply load balancing to spread the requests over the available instances. Ribbon does not run as a separate service but instead as an embedded component in each service consumer.

### Circuit Breaker and Monitoring

Netflix’s Hystrix library provides an implementation of the circuit breaker pattern. When you apply a circuit breaker to a method, Hystrix watches for failing calls to that method, and, if failures build up to a threshold, Hystrix opens the circuit so that subsequent calls automatically fail. While the circuit is open, Hystrix redirects calls to the method, and they are passed to your specified fallback method.
While Hystrix used for circuit breaker funtion; Turbine stream is used for aggregating streams of Server-Sent Event (SSE) JSON data for multiple Hystrix into a single stream. 

<p align="center">
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/turbine-dashboard.JPG" width="600">
</p>

### Microservice Communications

There are different patterns that are used in microservice communications depend on the design approach adopted for microservice 

### MongoDB (Document Database)

## Dashboard with SPA Web-GUI

## Continuous Integration / Delivery (CI/CD)




