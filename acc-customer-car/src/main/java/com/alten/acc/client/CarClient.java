package com.alten.acc.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.alten.acc.model.Car;

@FeignClient(name = "acc-car", url = "http://localhost:8066")
public interface CarClient {

	@GetMapping("/acc/cars/carid/{carId}")
	public Car getCarByCarId(@PathVariable String carId);

}