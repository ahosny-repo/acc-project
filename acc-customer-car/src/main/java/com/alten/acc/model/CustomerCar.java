package com.alten.acc.model;

public class CustomerCar {

	private String customerName;
	private String customerAddress;
	private String carId;
	private String carRegNumber;
	private String carStatus;
	
	public CustomerCar() {
		// TODO Auto-generated constructor stub
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	 

	public String getCarStatus() {
		return carStatus;
	}

	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}

	public String getCarRegNumber() {
		return carRegNumber;
	}

	public void setCarRegNumber(String carRegNumber) {
		this.carRegNumber = carRegNumber;
	}
	
}
