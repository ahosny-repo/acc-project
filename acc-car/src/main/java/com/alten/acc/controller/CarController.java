package com.alten.acc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alten.acc.model.Car;
import com.alten.acc.service.CarService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand; 

@RestController
@RequestMapping("acc")
public class CarController {

	@Autowired
	private CarService carService;

	@HystrixCommand
	@GetMapping("/cars")
	public List<Car> getAllCars() {
		return carService.findAll();
	}

	@HystrixCommand
	@GetMapping("/cars/{carId}")
	public Car getCarByCarId(@PathVariable String carId) {
		return carService.findByCarId(carId);
	}

 
	@RequestMapping("/cars/new")
	@HystrixCommand(fallbackMethod = "addCarFallbackMethod")
	public String addCar(@RequestParam String carId, @RequestParam String registrationNumber) {
		return carService.addCar(carId, registrationNumber, "DISCONNECTED").toString();
	}
	
	@HystrixCommand
	@RequestMapping("/cars/pulse")
	public Car pulseCar(@RequestParam String carId, @RequestParam String status) {
		return carService.pulseCar(carId, status);
	}

	public String addCarFallbackMethod(String carId, String registrationNumber, Throwable t) {
		return "CIRCUIT BREAKER: Car service is down ..." + t.toString();
	}

}
