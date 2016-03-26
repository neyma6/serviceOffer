package com.neyma.serviceoffer.domain;

public class Image {

	private final String _id;
	private final String path;
	private final String offerId;
	
	public Image(String _id, String path, String offerId) {
		this._id = _id;
		this.path = path;
		this.offerId = offerId;
	}

	public String get_id() {
		return _id;
	}

	public String getPath() {
		return path;
	}

	public String getOfferId() {
		return offerId;
	}
	
}
