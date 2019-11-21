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

import com.alten.acc.model.Car;
import com.alten.acc.service.CarService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CarController.class)
public class CarControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CarService carService;

	String carJsonDocument = "{\"carId\":\"1234\",\"registrationNumber\":\"A1234\",\"status\":\"CONNECTED\"}";

	@Test
	public void addCarTest() throws Exception {
		Car car = new Car("1234", "A1234", "CONNECTED");
		Mockito.when(carService.addCar(Mockito.any(Car.class))).thenReturn(car);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/acc/cars/new").accept(MediaType.APPLICATION_JSON)
				.content(carJsonDocument).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	@Test
	public void getCarByCarIdTest() throws Exception {
		List<Car> carList = new ArrayList<Car>();
		Car car = new Car("1234", "A1234", "CONNECTED");
		carList.add(car);
		Mockito.when(carService.findByCarId("1234")).thenReturn(carList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/acc/cars/carid/1234")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	@Test
	public void getCarByIdTest() throws Exception {
		Car car = new Car();
		car.setId("5dd6ee304cc7683f1c895d31");
		Mockito.when(carService.findById("5dd6ee304cc7683f1c895d31")).thenReturn(car);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/acc/cars/id/5dd6ee304cc7683f1c895d31")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	@Test
	public void getAllCarsTest() throws Exception {

		List<Car> carList = new ArrayList<Car>();
		carList.add(new Car("123", "123A", "CONNECTED"));
		carList.add(new Car("124", "124A", "DISCONNECTED"));
		Mockito.when(carService.findAll()).thenReturn(carList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/acc/cars").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
		Assert.assertEquals(2, carList.size());

	}
}
