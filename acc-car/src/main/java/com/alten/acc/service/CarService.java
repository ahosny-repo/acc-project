package com.alten.acc.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alten.acc.model.Car;
import com.alten.acc.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	Logger logger = LoggerFactory.getLogger(CarService.class);

	public Car addCar(Car car) {
		if (StringUtils.isEmpty(car.getCarId()) && StringUtils.isEmpty(car.getRegistrationNumber())) {
			throw new IllegalArgumentException("Car Parrameters are not provided");
		}
		if (StringUtils.isEmpty(car.getStatus())) {
			car.setStatus("DISCONNECTED");
		}
		logger.info("New Car {Car Id}:" + car.getCarId() + ", {Registration Number}: " + car.getRegistrationNumber());
		return carRepository.save(car);
	}

	public String deleteCar(String id) {
		Car car = carRepository.findById(id).orElse(null);
		if (car == null) {
			throw new IllegalArgumentException("No car found for the provided Id");
		}
		logger.info("Delete Car {Id}:" + id);
		carRepository.delete(car);
		return "Deleted:" + id;
	}

	// get all cars
	public List<Car> findAll() {
		List<Car> cars = carRepository.findAll();
		logger.info("Get All Cars {Total}:" + (cars != null ? cars.size() : "0"));
		return cars;
	}

	// find car by id
	public Car findById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Id is not provided");
		}
		return carRepository.findById(id).orElse(null);
	}

	// find car by car id
	public List<Car> findByCarId(String carId) {
		if (StringUtils.isEmpty(carId)) {
			throw new IllegalArgumentException("Car Id is not provided");
		}
		return carRepository.findByCarId(carId);
	}

	// set car status {CONNECTED/DISCONNECTED}
	public Car pulseCar(String id, String status) {
		if (StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Id is not provided");
		}
		if (StringUtils.isEmpty(status)) {
			throw new IllegalArgumentException("Status is not provided");
		}

		Car car = carRepository.findById(id).orElse(null);
		if (car == null) {
			throw new IllegalArgumentException("No car found for the provided Id");
		}
		car.setStatus(status);
		carRepository.save(car);
		return car;
	}
}
