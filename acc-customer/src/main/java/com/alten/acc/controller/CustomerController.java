package com.alten.acc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alten.acc.model.Customer;
import com.alten.acc.service.CustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("acc")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@HystrixCommand
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.findAll();
	}

	@HystrixCommand
	@GetMapping("/customers/id/{id}")
	public Customer getCustomerById(@PathVariable String id) {
		return customerService.findById(id);
	}
	
	@HystrixCommand
	@GetMapping("/customers/name/{name}")
	public Customer getCustomerByName(@PathVariable String name) {
		return customerService.findByName(name);
	}

	@RequestMapping("/customers/new")
	@HystrixCommand(fallbackMethod = "addCustomerFallbackMethod")
	public String addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer).toString();
	}

	public String addCustomerFallbackMethod(Customer customer, Throwable t) {
		return "CIRCUIT BREAKER: Customer service is down ..." + t.toString();
	}
}
