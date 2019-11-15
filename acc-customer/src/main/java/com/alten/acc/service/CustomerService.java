package com.alten.acc.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alten.acc.model.Customer;
import com.alten.acc.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	// add new customer
	public Customer addCustomer(Customer customer) {
		if (customer == null) {
			throw new IllegalArgumentException("Customer is not provided");
		}
		return customerRepository.save(customer);
	}

	// get all customers
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	// find customer by name
	public Customer findByName(String name) {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("Name is not provided");
		}

		return customerRepository.findByName(name);
	}

}
