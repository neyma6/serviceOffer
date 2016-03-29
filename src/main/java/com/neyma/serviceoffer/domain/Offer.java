package com.neyma.serviceoffer.domain;

public class Offer {

	private static final String EMPTY_STRING = "";
	public static final Offer EMPTY_OFFER = 
			new OfferBuilder(EMPTY_STRING, EMPTY_STRING ,EMPTY_STRING ,EMPTY_STRING).build();
	
	private final String userId;
	private final String title;
	private final String description;
	private final String cityId;
	private String _id;
	private String creationTime;
	private String lastUpdateTime;
			
	private Offer(OfferBuilder builder) {
		userId = builder.userId;
		title = builder.title;
		description = builder.description;
		cityId = builder.cityId;
		_id = builder._id;
		creationTime = builder.creationTime;
		lastUpdateTime = builder.lastUpdateTime;
	}
	
	public static class OfferBuilder {
		private String userId;
		private String title;
		private String description;
		private String cityId;
		private String _id;
		private String creationTime;
		private String lastUpdateTime;
		
		public OfferBuilder(String userId, String title, String description, String cityId) {
			this.userId = userId;
			this.title = title;
			this.description = description;
			this.cityId = cityId;
			this._id = EMPTY_STRING;
			this.creationTime = EMPTY_STRING;
			this.lastUpdateTime = EMPTY_STRING;
		}
		
		public OfferBuilder(Offer offer) {
			this.userId = offer.userId;
			this.title = offer.title;
			this.description = offer.description;
			this.cityId = offer.cityId;
			this._id = offer._id;
			this.creationTime = offer.creationTime;
			this.lastUpdateTime = offer.lastUpdateTime;
		}
		
		public OfferBuilder withDbId(String id) {
			_id = id;
			return this;
		}
		
		public OfferBuilder withCreationTime(String time) {
			creationTime = time;
			return this;
		}
		
		public OfferBuilder withLastUpdatedTime(String time) {
			lastUpdateTime = time;
			return this;
		}
		
		public Offer build() {
			return new Offer(this);
		}
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

	public String get_id() {
		return _id;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}



	@Override
	public String toString() {
		return "Offer [userId=" + userId + ", title=" + title + ", description=" + description + ", cityId="
				+ cityId + ", _id=" + _id + ", creationTime=" + creationTime + ", lastUpdateTime=" + lastUpdateTime
				+ "]";
	}

	
}
