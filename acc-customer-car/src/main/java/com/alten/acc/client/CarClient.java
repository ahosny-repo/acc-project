package com.alten.acc.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.alten.acc.model.Car;

@FeignClient(name= "${car-feign.name}",url ="${car-feign.url}")
public interface CarClient {

	@GetMapping("/acc/cars/id/{id}")
	public Car getCarById(@PathVariable String id);

	@GetMapping("/acc/cars/carid/{carId}")
	public List<Car> getCarByCarId(@PathVariable String carId);

}