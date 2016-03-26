package com.neyma.serviceoffer.domain;

import java.util.List;

import com.neyma.serviceoffer.dao.db.IResponse;

public class User implements IResponse{

	private String name;
	private String email;
	private String phone;
	private List<String> offerIds;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<String> getOfferIds() {
		return offerIds;
	}
	public void setOfferIds(List<String> offerIds) {
		this.offerIds = offerIds;
	}
}
