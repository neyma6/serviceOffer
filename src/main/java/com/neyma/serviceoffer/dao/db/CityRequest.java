package com.neyma.serviceoffer.dao.db;

public class CityRequest implements IRequest {

	public static final String EMPTY_NAME = "";
	
	private final String cityName;
	private final String regionId;
	
	public CityRequest(String cityName, String regionId) {
		this.cityName = cityName;
		this.regionId = regionId;
	}

	public String getCityName() {
		return cityName;
	}

	public String getRegionId() {
		return regionId;
	}
	
}
