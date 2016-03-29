package com.neyma.serviceoffer.dao.db.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.mongodb.client.FindIterable;
import com.neyma.serviceoffer.dao.util.MongoDbUtil;
import com.neyma.serviceoffer.domain.Offer;
import com.neyma.serviceoffer.domain.Offer.OfferBuilder;

@Service
public class OfferMongoDbRepository extends AbstractMongoDbRepository {
	
	public Offer save(Offer offer) {
		
		if (offer == null) {
			throw new IllegalArgumentException("offer can't be null!");
		}
		
		String timeStamp = new SimpleDateFormat(env.getProperty("db.timestamp")).format(new Date());
		String offerId = offer.getUserId() + timeStamp + Math.random();
		
		Offer setupOffer = new OfferBuilder(offer)
				.withCreationTime(timeStamp)
				.withLastUpdatedTime(timeStamp)
				.withDbId(offerId)
				.build();
		
	    Document doc = MongoDbUtil.convertObjectToDocument(setupOffer);
	    db.getCollection(env.getProperty("db.offertable")).insertOne(doc);
		
		return offer;
	}
	
	public Offer get(String offerId) {
		
		FindIterable<Document> offers = findDocument("db.offertable", "_id", offerId);
		
		Document offer = offers.first();
		
		if (offer == null) {
			throw new IllegalArgumentException("No offer returned!");
		}
		
		return conversionService.convert(offer, Offer.class);
	}
	
	public Offer update(Offer offer) {
		throw new UnsupportedOperationException();
	}
	
	public List<String> getOfferListForUser(String userId) {
		
		FindIterable<Document> offers = findDocument("db.offertable", "userId", userId);
		
		List<String> offerIds = new ArrayList<>();
		for (Document doc : offers){
			offerIds.add(doc.getString("_id"));
		}
		
		return offerIds;
	}
	
}
