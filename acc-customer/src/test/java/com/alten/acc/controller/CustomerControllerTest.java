package com.alten.acc.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.alten.acc.model.Customer;
import com.alten.acc.service.CustomerService;
 

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	String customerJsonDocument = "{\"name\":\"Ahmed Hosny\",\"Address\":\"Egypt\"}";
	
	@Test
	public void addCustomerTest() throws Exception {
		Customer customer =new Customer("Ahmed Hosny", "Egypt",null);  
		Mockito.when(customerService.addCustomer(Mockito.any(Customer.class))).thenReturn(customer);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/acc/customers/new").accept(MediaType.APPLICATION_JSON)
				.content(customerJsonDocument).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	
	@Test
	public void getCustomerByIdTest() throws Exception {
		Customer customer =new Customer();
		customer.setId("5dc9a0d05462bef600bc6753");
		Mockito.when(customerService.findById("5dc9a0d05462bef600bc6753")).thenReturn(customer);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/acc/customers/id/5dc9a0d05462bef600bc6753")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	@Test
	public void getCustomerByNameTest() throws Exception {
		Customer customer =new Customer();
		customer.setName("Ahmed Hosny");
		Mockito.when(customerService.findByName("Ahmed Hosny")).thenReturn(customer);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/acc/customers/name/Ahmed Hosny")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	@Test
	public void getAllCustomersTest() throws Exception {

		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer("CUST1", "ADD1", null));
		customerList.add(new Customer("CUST2", "ADD2",null));
		Mockito.when(customerService.findAll()).thenReturn(customerList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/acc/customers").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
		Assert.assertEquals(2, customerList.size());

	}
}
