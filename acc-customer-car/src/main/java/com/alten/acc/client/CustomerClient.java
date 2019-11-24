package com.alten.acc.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.alten.acc.model.Customer;

@FeignClient(name= "${customer-feign.name}",url ="${customer-feign.url}")
public interface CustomerClient {

	@GetMapping("/acc/customers")
	public List<Customer> getAllCustomers();
}
