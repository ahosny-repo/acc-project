package com.alten.acc.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alten.acc.model.Car;
import com.alten.acc.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	// add new car
	public Car addCar(String carId, String registrationNumber, String status) {
		return carRepository.save(new Car(carId, registrationNumber, status));
	}

	// get all cars
	public List<Car> findAll() {
		return carRepository.findAll();
	}

	// find car by id
	public Car findById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Id is not provided");
		}

		return carRepository.findById(id).orElse(null);
	}

	// find car by car id
	public Car findByCarId(String carId) {
		if (StringUtils.isEmpty(carId)) {
			throw new IllegalArgumentException("Car Id is not provided");
		}
		return carRepository.findByCarId(carId);
	}

	// find car by registration number
	public Car findByRegistrationNumber(String registrationNumber) {
		if (StringUtils.isEmpty(registrationNumber)) {
			throw new IllegalArgumentException("Registration Number is not provided");
		}
		return carRepository.findByRegistrationNumber(registrationNumber);
	}

	// set car status {CONNECTED/DISCONNECTED}
	public Car pulseCar(String carId, String status) {
		if (StringUtils.isEmpty(carId)) {
			throw new IllegalArgumentException("Car Id is not provided");
		}
		if (StringUtils.isEmpty(status)) {
			status = "DISCONNECTED";
		}
		Car car = carRepository.findByCarId(carId);
		car.setStatus(status);
		carRepository.save(car);
		return car;
	}
}
