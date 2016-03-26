package com.neyma.serviceoffer.dao.converter;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

import com.neyma.serviceoffer.domain.Offer;

public class DocumentToOfferConverter implements Converter<Document, Offer> {

	@Override
	public Offer convert(Document source) {
		String userId = source.getString("userId");
		String title = source.getString("title");
		String description = source.getString("description");
		String cityId = source.getString("cityId");
		
		Offer offer = new Offer(userId, title, description, cityId);
		offer.set_id(source.getString("_id"));
		offer.setCreationTime(source.getString("creationTime"));
		offer.setLastUpdateTime(source.getString("lastUpdateTime"));
		
		return offer;
	}

}
