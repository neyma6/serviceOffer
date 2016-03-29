package com.neyma.serviceoffer.dao.db;

import java.util.Collections;
import java.util.List;

import com.neyma.serviceoffer.domain.Offer;

public class OfferResponse implements IResponse {

	private Offer offerResponseObject;
	private List<String> offerList;
	
	private OfferResponse(OfferResponseBuilder builder) {
		offerResponseObject = builder.offerResponseObject;
		offerList = builder.offerList;
	}
	
	public Offer getOfferResponseObject() {
		return offerResponseObject;
	}

	public List<String> getOfferList() {
		return offerList;
	}

	public static class OfferResponseBuilder {
		
		private Offer offerResponseObject;
		private List<String> offerList;
		
		public OfferResponseBuilder() {
			offerResponseObject = Offer.EMPTY_OFFER;
			offerList = Collections.EMPTY_LIST;
		}
		
		public OfferResponseBuilder withOffer(Offer offer) {
			offerResponseObject = offer;
			return this;
		}
		
		public OfferResponseBuilder withOfferIdList(List<String> ids) {
			offerList = ids;
			return this;
		}
		
		public OfferResponse build() {
			return new OfferResponse(this);
		}
	}
}
