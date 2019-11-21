package com.alten.acc.model;

import java.util.List; 
public class Customer {
 
	private String id;
	private String name;
	private String address;
	private List<String> carIds;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String address, List<String> carIds) {
		this.name = name;
		this.address = address;
		this.carIds = carIds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getCarIds() {
		return carIds;
	}

	public void setCarIds(List<String> carIds) {
		this.carIds = carIds;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", carIds=" + carIds + "]";
	}

}
