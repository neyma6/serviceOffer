package com.neyma.serviceoffer.dao.db;

import java.util.List;

public class LocationResponse<Type> implements IResponse {

	private final List<Type> items;

	public LocationResponse(List<Type> items) {
		this.items = items;
	}

	public List<Type> getItems() {
		return items;
	}
	
}
