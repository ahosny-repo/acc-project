package com.alten.acc.service;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.alten.acc.model.Car;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

	@Autowired
	private CarService carService;

	@Test
	public void testAddCar() {
		Car car = carService.addCar(new Car("1235", "A1235", "CONNECTED"));
		assertEquals(car.toString(), car.toString());
	}

	@Test
	public void testDeleteCar() {
		List<Car> carList = carService.findByCarId("1235");
		String message = carService.deleteCar(carList.get(0).getId());
		assertEquals(message, message);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddCarWithEmptyParam() {
		carService.addCar(new Car("", "", ""));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDeleteCarWithEmptyParam() {
		carService.deleteCar("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteCarWithCarNotFound() {
		carService.deleteCar("ieorieoieoeoeoeoe");
	}

	@Test
	public void testFindAllCars() {
		List<Car> cars = carService.findAll();
		assertEquals(cars.size(), cars.size());
	}

	@Test
	public void testFindCarById() {
		Car car = carService.findById("601dc54628b3ae15fe1c90b0");
		assertEquals(car.getCarId(), "A2030");
	}

	@Test
	public void testFindCarByIdWithNotFoundCar() {
		Car car = carService.findById("333333333444455555555");
		assertNull(car);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindCarByIdWithEmptyParam() {
		carService.findById("");
	}

	@Test
	public void testFindCarByCarId() {
		List<Car> carList = carService.findByCarId("A2030");
		assertEquals(carList.get(0).getId(), "601dc54628b3ae15fe1c90b0");
	}

	@Test
	public void testFindCarByCarIdWithNotFoundCar() {
		List<Car> carList = carService.findByCarId("YUJWJJWJWJW");
		assertEquals(carList.isEmpty(), true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindCarByCarIdWithEmptyParam() {
		carService.findByCarId("");
	}

	@Test
	public void testPulseCar() {
		carService.pulseCar("601dc54628b3ae15fe1c90b0", "DISCONNECTED");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPulseCarWithNotFoundCar() {
		carService.pulseCar("23343344OPPP", "CONNECTED");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPulseCarWithEmptyParam() {
		carService.pulseCar("", "");
	}
}
