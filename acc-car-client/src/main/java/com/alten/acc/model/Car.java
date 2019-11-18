package com.alten.acc.model;

public class Car {

	private String id;
	private String carId;
	private String registrationNumber;
	private String status;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String carId, String registrationNumber, String status) {
		this.carId = carId;
		this.registrationNumber = registrationNumber;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carId=" + carId + ", registerationNumber=" + registrationNumber + ", status="
				+ status + "]";
	}
}
