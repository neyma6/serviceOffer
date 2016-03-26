package com.neyma.serviceoffer.dao.testDb;

public class Car {

	private String name;
	private String _id;
	
	public Car(String name, String car_id) {
		this.name = name;
		this._id = car_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	
}
