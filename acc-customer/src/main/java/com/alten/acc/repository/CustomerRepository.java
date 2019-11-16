package com.alten.acc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alten.acc.model.Customer;

@Repository
public interface CustomerRepository extends  MongoRepository<Customer, String>  {

	public Customer findByName(String name);
}
