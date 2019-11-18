package com.alten.acc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient; 
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream; 

@EnableEurekaClient
@EnableTurbineStream
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrixDashboard
public class AccTurbineStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccTurbineStreamApplication.class, args);
	}

}
