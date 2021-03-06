package com.alten.acc.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.alten.acc.model.Car;

@FeignClient(name= "${car-feign.name}",url ="${car-feign.url}")
public interface CarClient {

	@GetMapping("/acc/cars")
	List<Car> findAll();

	@RequestMapping("/acc/cars/pulse")
	Car pulseCar(@RequestParam String id, @RequestParam String status);
}