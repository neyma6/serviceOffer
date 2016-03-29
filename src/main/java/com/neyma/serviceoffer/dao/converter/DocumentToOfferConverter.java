package com.neyma.serviceoffer.dao.converter;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

import com.neyma.serviceoffer.domain.Offer;
import com.neyma.serviceoffer.domain.Offer.OfferBuilder;

public class DocumentToOfferConverter implements Converter<Document, Offer> {

	@Override
	public Offer convert(Document source) {
		
		String userId = source.getString("userId");
		String title = source.getString("title");
		String description = source.getString("description");
		String cityId = source.getString("cityId");
		String _id = source.getString("_id");
		String creationTime = source.getString("creationTime");
		String lastUpdateTime = source.getString("lastUpdateTime");
		
		return new OfferBuilder(userId, title, description, cityId)
				.withCreationTime(creationTime)
				.withLastUpdatedTime(lastUpdateTime)
				.withDbId(_id)
				.build();
	}

}
