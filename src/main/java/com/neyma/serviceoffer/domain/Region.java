package com.neyma.serviceoffer.domain;

public class Region {

	// county name
	private final String _id;
	
	public Region(String _id) {
		this._id = _id;
	}

	public String get_id() {
		return _id;
	}

	@Override
	public String toString() {
		return "Region [_id=" + _id + "]";
	}

	
}
