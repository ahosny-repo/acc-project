package com.alten.acc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.alten.acc.model.CustomerCar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerCarServiceTest {

	@Autowired
	private CustomerCarService customerCarService;

	@Test
	public void testFindAllCars() {
		List<CustomerCar> customerCarsList = customerCarService.findAll();
		assertEquals(customerCarsList.size(), customerCarsList.size());
	}

}
