package com.alten.acc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableHystrix
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class AccCustomerCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccCustomerCarApplication.class, args);
	}

}
