package com.neyma.serviceoffer.dao.db;

import com.neyma.serviceoffer.domain.Offer;

public class OfferRequest implements IRequest {

	private static final String EMPTY_STRING = "";
	
	private Offer offerRequestObject;
	private String userId;
	private String offerId;
	
	private OfferRequest(OfferRequestBuilder builder) {
		offerRequestObject = builder.offerRequestObject;
		userId = builder.userId;
		offerId = builder.offerId;
	}
	
	public Offer getOfferRequestObject() {
		return offerRequestObject;
	}

	public String getUserId() {
		return userId;
	}

	public String getOfferId() {
		return offerId;
	}
	
	public boolean isOfferEmpty() {
		return offerRequestObject == Offer.EMPTY_OFFER;
	}
	
	public boolean isUserIdEmpty() {
		return userId == EMPTY_STRING;
	}
	
	public boolean isOfferIdEmpty() {
		return offerId == EMPTY_STRING;
	}

	public static class OfferRequestBuilder {
		private Offer offerRequestObject;
		private String userId;
		private String offerId;
		
		public OfferRequestBuilder() {
			offerRequestObject = Offer.EMPTY_OFFER;
			userId = EMPTY_STRING;
			offerId = EMPTY_STRING;
		} 
		
		public OfferRequestBuilder withOffer(Offer offer) {
			offerRequestObject = offer;
			return this;
		}
		
		public OfferRequestBuilder withOfferId(String id) {
			offerId = id;
			return this;
		}
		
		public OfferRequestBuilder withUserId(String id) {
			userId = id;
			return this;
		}
		
		public OfferRequest buil() {
			return new OfferRequest(this);
		}
	}
}
