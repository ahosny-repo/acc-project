package com.alten.acc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.alten.acc.model.CustomerCar;
import com.alten.acc.service.CustomerCarService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
 

@RestController
@RequestMapping("acc")
@CrossOrigin(origins = "*")
public class CustomerCarController {

	@Autowired
	private CustomerCarService customerCarService;
	
	
	@HystrixCommand
	@GetMapping("/customercars")
	public List<CustomerCar> getAllCustomerCars() {
		List<CustomerCar> customerCarList = customerCarService.findAll();
		return customerCarList;
	}

}
