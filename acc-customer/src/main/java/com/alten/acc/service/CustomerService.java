package com.alten.acc.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alten.acc.model.Customer;
import com.alten.acc.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	public Customer addCustomer(Customer customer) {
		if (customer == null) {
			throw new IllegalArgumentException("Customer is not provided");
		}
		if (StringUtils.isEmpty(customer.getName())) {
			throw new IllegalArgumentException("Customer name is not provided");
		}
		if (StringUtils.isEmpty(customer.getAddress())) {
			throw new IllegalArgumentException("Customer address is not provided");
		}
		logger.info("New Customer {Name}:" + customer.getName() + ", {Address}: " + customer.getAddress());
		
		return customerRepository.save(customer);
	}

	// delete customer by id
	public String deleteCustomer(String id) {
		Customer customer = customerRepository.findById(id).orElse(null);
		if (customer == null) {
			throw new IllegalArgumentException("No customer found for the provided Id");
		}
		logger.info("Delete Customer {Id}:" + id);
		customerRepository.delete(customer);
		return "Deleted:" + id;
	}

	// get all customers
	public List<Customer> findAll() {
		List<Customer> customers= customerRepository.findAll();
		logger.info("Get All Customer {Total}:" + (customers != null ? customers.size() : "0"));
		return customers;
	}

	// find customer by id
	public Customer findById(String id) {
		if (StringUtils.isEmpty(id)) {
			throw new IllegalArgumentException("Id is not provided");
		}

		return customerRepository.findById(id).orElse(null);
	}

	// find customer by name
	public Customer findByName(String name) {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("Name is not provided");
		}

		return customerRepository.findByName(name);
	}

}
