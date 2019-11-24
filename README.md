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

#### About Microservice

#### Microservice Benifits

	- The smaller code base is easy to maintain.
	- Easy to scale as an individual component.
	- Technology diversity i.e. we can mix libraries, databases, frameworks etc.
	- Fault isolation i.e. a process failure should not bring the whole system down.
	- Better support for smaller and parallel team.
	- Independent deployment
	- Deployment time reduce

### Microservice Framework

Spring Boot

<p align="center">
<img src="https://github.com/ahosny-repo/acc-project/blob/master/images/spring-boot-arch.JPG" width="600">
</p>

### Microservice Architecture

### Service Configuration

### Discovery Server (Eureka)

### Microservice API Gateway

### Client-side Load Balancing

### Microservice Communications

### MongoDB (Document Database)

## Dashboard with SPA Web-GUI

## Continuous Integration / Delivery (CI/CD)




