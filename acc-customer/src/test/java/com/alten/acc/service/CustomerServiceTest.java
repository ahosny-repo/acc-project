package com.alten.acc.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.alten.acc.model.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer();
		customer.setId("1233");
		customer.setName("Ahmed");
		customer.setAddress("Egypt");
		customerService.addCustomer(customer);
		assertEquals(customer.toString(), customer.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddCustomerWithEmptyParam() {
		Customer customer = new Customer();
		customerService.addCustomer(customer);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddCustomerWithNullParam() {
		customerService.addCustomer(null);
	}

	@Test
	public void testDeleteCustomer() {
		Customer customer = customerService.findById("1233");
		String message = customerService.deleteCustomer(customer.getId());
		assertEquals(message, message);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteCustomerWithEmptyParam() {
		customerService.deleteCustomer("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteCustomerWithCustomerNotFound() {
		customerService.deleteCustomer("ieorieoieoeoeoeoe");
	}

	@Test
	public void testFindAllCustomers() {
		List<Customer> customers = customerService.findAll();
		assertEquals(customers.size(), customers.size());
	}

	@Test
	public void testFindCustomerById() {
		Customer customer = customerService.findById("5dc9a0d05462bef600bc6753");
		assertEquals(customer.getName(), "Kalles Grustransporter AB");
	}

	@Test
	public void testFindCustomerByIdWithNotFoundCustomer() {
		Customer customer = customerService.findById("333333333444455555555");
		assertNull(customer);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindCustomerByIdWithEmptyParam() {
		customerService.findById("");
	}

	@Test
	public void testFindCustomerByCustomerName() {
		Customer customer = customerService.findByName("Kalles Grustransporter AB");
		assertEquals(customer.getId(), "5dc9a0d05462bef600bc6753");
	}

	@Test
	public void testFindCustomerByCustomerNameWithNotFoundCustomer() {
		Customer customer = customerService.findByName("YUJWJJWJWJW");
		assertNull(customer);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindCustomerByCustomerNameWithEmptyParam() {
		customerService.findByName("");
	}

}
