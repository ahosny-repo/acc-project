package com.alten.acc.repository;

import com.alten.acc.model.Car;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository  extends MongoRepository<Car, String>{

	public List<Car> findByCarId(String carId);
	public Car findByRegistrationNumber(String registrationNumber);
    
}
