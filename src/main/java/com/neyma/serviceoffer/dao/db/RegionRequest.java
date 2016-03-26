package com.neyma.serviceoffer.dao.db;

public class RegionRequest implements IRequest {

	public static final RegionRequest EMPTY_REQUEST = new RegionRequest("");
	private final String regionId;

	public RegionRequest(String regionId) {
		this.regionId = regionId;
	}

	public String getRegionId() {
		return regionId;
	}
	
}
