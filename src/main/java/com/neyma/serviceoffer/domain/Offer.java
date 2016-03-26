package com.neyma.serviceoffer.domain;

public class Offer {

	private final String userId;
	private final String title;
	private final String description;
	private final String cityId;
	private String _id;
	private String creationTime;
	private String lastUpdateTime;
		
	public Offer(String userId, String title, String description, String cityId) {
		super();
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.cityId = cityId;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getUserId() {
		return userId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
	

	public String getCityId() {
		return cityId;
	}

	@Override
	public String toString() {
		return "Offer [userId=" + userId + ", title=" + title + ", description=" + description + ", cityId="
				+ cityId + ", _id=" + _id + ", creationTime=" + creationTime + ", lastUpdateTime=" + lastUpdateTime
				+ "]";
	}

	
}
