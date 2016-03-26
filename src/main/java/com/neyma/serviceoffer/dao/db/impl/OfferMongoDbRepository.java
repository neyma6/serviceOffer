package com.neyma.serviceoffer.dao.db.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.neyma.serviceoffer.config.ProjectConfiguration;
import com.neyma.serviceoffer.dao.util.MongoDbUtil;
import com.neyma.serviceoffer.domain.Offer;

@Service
public class OfferMongoDbRepository extends AbstractMongoDbRepository {
	
	public Offer save(Offer offer) {
		
		String timeStamp = new SimpleDateFormat(env.getProperty("db.timestamp")).format(new Date());
		String offerId = offer.getUserId() + timeStamp + Math.random();
		
		offer.setCreationTime(timeStamp);
		offer.setLastUpdateTime(timeStamp);
		offer.set_id(offerId);
		
	    Document doc = MongoDbUtil.convertObjectToDocument(offer);
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
