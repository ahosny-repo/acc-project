package com.alten.acc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class AccCarClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccCarClientApplication.class, args);
	}

}
