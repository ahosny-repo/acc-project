package com.alten.acc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping("/cars/new")
	@HystrixCommand(fallbackMethod = "addCarFallbackMethod")
	public String addCar(@RequestBody Car car) {
		return carService.addCar(car).toString();
	}

	@RequestMapping("/cars/delete/{id}")
	@HystrixCommand
	public String deleteCar(@PathVariable String id) {
		return carService.deleteCar(id);

	}

	@HystrixCommand
	@GetMapping("/cars")
	public List<Car> getAllCars() {
		return carService.findAll();
	}

	@HystrixCommand
	@GetMapping("/cars/id/{id}")
	public Car getCarById(@PathVariable String id) {
		return carService.findById(id);
	}

	@HystrixCommand
	@GetMapping("/cars/carid/{carId}")
	public Car getCarByCarId(@PathVariable String carId) {
		return carService.findByCarId(carId);
	}

	@HystrixCommand
	@RequestMapping("/cars/pulse")
	public Car pulseCar(@RequestParam String id, @RequestParam String status) {
		return carService.pulseCar(id, status);
	}

	public String addCarFallbackMethod(String carId, String registrationNumber, Throwable t) {
		return "CIRCUIT BREAKER: Car service is down ..." + t.toString();
	}

}
