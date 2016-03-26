package com.neyma.serviceoffer.domain;

public class City {

	private final String _id;
	private final String name;
	private final String regionId;
	
	public City(String _id, String name, String regionId) {
		this._id = _id;
		this.name = name;
		this.regionId = regionId;
	}

	public String get_id() {
		return _id;
	}

	public String getName() {
		return name;
	}

	public String getRegionId() {
		return regionId;
	}

	@Override
	public String toString() {
		return "City [_id=" + _id + ", name=" + name + ", regionId=" + regionId + "]";
	}
	
	
}
