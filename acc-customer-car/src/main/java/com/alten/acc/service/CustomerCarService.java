package com.alten.acc.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alten.acc.client.CarClient;
import com.alten.acc.client.CustomerClient;
import com.alten.acc.model.Car;
import com.alten.acc.model.Customer;
import com.alten.acc.model.CustomerCar;

@Service
public class CustomerCarService {

	@Autowired
	private CarClient carClient;

	@Autowired
	private CustomerClient customerClient;

	Logger logger = LoggerFactory.getLogger(CustomerCarService.class);

	// get all customers
	public List<CustomerCar> findAll() {
		List<Customer> customers = customerClient.getAllCustomers();
		List<CustomerCar> customerCarList = new ArrayList<CustomerCar>();
		for (int i = 0; i < customers.size(); i++) {
			CustomerCar customerCar = new CustomerCar();
			customerCar.setCustomerName(customers.get(i).getName());
			customerCar.setCustomerAddress(customers.get(i).getAddress());
			customerCar.setCarId("");
			customerCar.setCarRegNumber("");
			customerCar.setCarStatus("");
			List<String> carIds = customers.get(i).getCarIds();
			if (carIds != null && !carIds.isEmpty()) {
				for (int j = 0; j < carIds.size(); j++) {
					Car car = carClient.getCarByCarId(carIds.get(j));
					if (car != null) {
						customerCar.setCarId(car.getCarId());
						customerCar.setCarRegNumber(car.getRegistrationNumber());
						customerCar.setCarStatus(car.getStatus());
						customerCarList.add(customerCar);
					}
				}
			}
			customerCarList.add(customerCar);
		}
		logger.info("Get All Customer Cars {Total}:" + (customerCarList != null ? customerCarList.size() : "0"));
		return customerCarList;
	}

}
