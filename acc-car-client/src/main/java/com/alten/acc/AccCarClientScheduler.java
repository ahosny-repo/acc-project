package com.alten.acc;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alten.acc.client.CarClient;
import com.alten.acc.model.Car;

@Component
public class AccCarClientScheduler {

	@Autowired
	private CarClient carClient;
	
	Logger logger = LoggerFactory.getLogger(AccCarClientScheduler.class);

	@Scheduled(fixedRate = 60000)
	public void fixedRateSch() {
		List<Car> cars = carClient.findAll();
		Random rand = new Random();
		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			Boolean randomStatusFlag = rand.nextBoolean();
			String status = (randomStatusFlag == true) ? "CONNECTED" : "DISCONNECTED";
			logger.info("Pulse Car {Id}:"+car.getId()+", {Status}:" + status );
			carClient.pulseCar(car.getId(), status);
		}
	}
}
