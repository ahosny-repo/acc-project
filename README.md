[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=ahosny-repo_acc-project&metric=alert_status)](https://sonarcloud.io/dashboard?id=ahosny-repo_acc-project)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=ahosny-repo_acc-project&metric=coverage)](https://sonarcloud.io/dashboard?id=ahosny-repo_acc-project)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=ahosny-repo_acc-project&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=ahosny-repo_acc-project)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=ahosny-repo_acc-project&metric=security_rating)](https://sonarcloud.io/dashboard?id=ahosny-repo_acc-project)


# Car Monitoring System (ACC)
Car Monitoring System (A Connected Car - ACC for short) is a system for tracking and monitoring car status of the customers whos are registered within the system so the can manage their day to day business operations. 

<p align="center">
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/acc-dashboard.JPG" width="800">
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

The following diagrams represent the solution components, domains, infrastructure and services that used as building block for our project using Spring Boot, Spring Cloud with Netflix OSS Components and AWS for database hosting service pluse Angular8 for fronted Web-GUI / dashboard.

<p align="center">
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/acc-arch.JPG" width="500">
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
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/spring-boot-arch.JPG" width="800">
</p>

### Microservice

The following are service components that are mainly used to build ACC.

<p align="center">
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/acc-service-diagram.JPG" width="600">
</p>

1- Car Service

This service is used for managing and getting car data.

| Method | Path                    | Description                  |
|--------|-------------------------|------------------------------|
| GET    | /acc/cars/id/{id}       | Get car data by id           |
| GET    | /acc/cars               | Get all cars data            |
| POST   | /acc/cars/new/{car}     | Add new car                  |
| POST   | /acc/cars/pulse/{id}    | Set car status               |

2- Customer Service

This service is used for managing and getting customer data.

| Method | Path                         	 | Description                  |
|--------|-----------------------------------|------------------------------|
| GET    | /acc/customers/id/{id}     		 | Get customer data by id      |
| GET    | /acc/customers              		 | Get all customer data        |
| POST   | /acc/customers/new/{customer}     | Add new car                  |

3- Query Service (Customer Cars)

this service is used to get customer cars details into one view.

| Method | Path              	  | Description                  |
|--------|------------------------|------------------------------|
| GET    | /acc/customercars      | Get all customer cars data   |


### Service Configuration

Spring Cloud Config provides server-side and client-side support for externalized configuration in a distributed system. With the Config Server,we have a central place to manage external properties for applications across all environments. 

### Discovery Server (Eureka)

Netflix Eureka allows micro services to register themselves at runtime as they appear in the system landscape.

Below screenshot shows the ACC Project services registered and running on Eureka Server:

<p align="center">
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/eureka-server.JPG" width="800">
</p>

### Microservice API Gateway

Zulu provides a well-known entry point to the micro services in the system landscape. Using dynamically allocated ports is convenient to avoid port conflict and Zuul Intelligent routing (proxy for our micro services) and also as a gateway for external requests.

### Client-side Load Balancing

Netflix Ribbon can be used by service consumers to look up services at runtime. Ribbon uses the information available in Eureka to locate appropriate service instances. If more than one instance is found, Ribbon will apply load balancing to spread the requests over the available instances. Ribbon does not run as a separate service but instead as an embedded component in each service consumer.

### Circuit Breaker and Monitoring

Netflix’s Hystrix library provides an implementation of the circuit breaker pattern. When you apply a circuit breaker to a method, Hystrix watches for failing calls to that method, and, if failures build up to a threshold, Hystrix opens the circuit so that subsequent calls automatically fail. While the circuit is open, Hystrix redirects calls to the method, and they are passed to your specified fallback method.
While Hystrix used for circuit breaker funtion; Turbine stream is used for aggregating streams of Server-Sent Event (SSE) JSON data for multiple Hystrix into a single stream. 

<p align="center">
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/turbine-dashboard.JPG" width="800">
</p>

### Microservice Communications

There are different patterns that are used in microservice architecture depending on the design approach for example direct service communications wherein the services are integrating and talking to each other using synchronous REST calls as in the case of car client and car services in this project.

One other approach is Asynchronous Messaging Design Pattern In this type of microservices design pattern, all the services can communicate with each other, but they do not have to communicate with each other sequentially. wherein the service fires the request and receives acknoledgment while processing continoue separately in the called service.

Also - Command Query Responsibility Segregator (CQRS) Design Pattern - Every microservices design has either the database per service model or the shared database per service. But, in the database per service model, we cannot implement a query as the data access is only limited to one single database. So, in such scenario, you can use the CQRS pattern. According to this pattern, the application will be divided into two parts: Command and Query. The command part will handle all the requests related to CREATE, UPDATE, DELETE while the query part will take care of the materialized views. The materialized views are updated through a sequence of events which are creating using the event source pattern discussed above.

Related to CQRS Design Pattern - the API Decomposition Pattern to query the data from various microservices for example in this project a standalone service 'customer-car' was created to query and get combined data from car and customer microservices.

In addition to event-driven architecture, when a service performs some piece of work that other services might be interested in, that service produces an event—a record of the performed action. Other services consume those events so that they can perform any of their own tasks needed as a result of the event. Unlike with REST, services that create requests do not need to know the details of the services consuming the requests.

#### Feigen Client

For direct service communication, I used feigen client for microservice communications - as per Spring Documentation; Feign is a declarative web service client. It makes writing web service clients easier. To use Feign create an interface and annotate it. It has pluggable annotation support including Feign annotations and JAX-RS annotations. Feign also supports pluggable encoders and decoders. Spring Cloud adds support for Spring MVC annotations and for using the same HttpMessageConverters used by default in Spring Web. Spring Cloud integrates Ribbon and Eureka to provide a load balanced http client when using Feign.

### MongoDB (Document Database)

In the project MongoDB was used as a data store for our data; MongoDB is an open source NoSQL database management system (DBMS) that uses a document-oriented database model which supports various forms of data. 

MongoDB architecture is made up of collections and documents, A record in MongoDB is a document, which is a data structure composed of field and value pairs. MongoDB documents are similar to JavaScript Object Notation objects but use a variant called Binary JSON (BSON) that accommodates more data types.

<p align="center">
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/mongodb.JPG" width="800">
</p>


#### Car Collection

Sample Document:

{"_id":"5dd6ee304cc7683f1c895d31","carId":"YS2R4X","registrationNumber":"ABC123","status":"DISCONNECTED"}

#### Customer Collection

Sample Document:

{"_id":"5dc9a0d05462bef800bc6753","name":"KG AB","address":"CS 11","carIds":["5dd6ee304cc7683f1c895d31","5dd6ef428a81ba3f1ce1b626","5dd6ef558a81ba3f1ce1b627"]}


## Microservice End-Points (Ports)

<p align="left">
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/running-services.JPG" width="400">
</p>

Eureka Server: http://localhost:8761

Zuul API Gateway: http://localhost:8088

WebGUI Dashboard: http://localhost:4200

Turbine Stream: http://localhost:9090/hystrix

## Continuous Integration / Delivery (CI/CD)



## Serverless Architecture

In real life scenario, this example would be implemented as an IoT Application built on top of a set of serverless interfaces or a.k.a in clould architecture as Function as a Service 'FaaS'.

Serverless IoT applications will gather, process, analyze, and act on connected vehicle data, without having to manage any infrastructure or scaling which will be clould provider solution i.e. Amazon has a reference architecture for IoT and Connected Device Application.

The diagram below presents the components and functionality you can build using the solution implementation guide and accompanying AWS CloudFormation template. 

Please refer to https://aws.amazon.com/solutions/aws-connected-vehicle-solution/

<p align="center">
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/aws-connected-vehicle-solution.png" width="500">
</p>
