package com.neyma.serviceoffer.dao.db.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.mongodb.client.FindIterable;
import com.neyma.serviceoffer.config.ProjectConfiguration;
import com.neyma.serviceoffer.dao.db.IDbGetAllSupportAlteringRepository;
import com.neyma.serviceoffer.dao.db.OfferRequest;
import com.neyma.serviceoffer.dao.db.OfferResponse;
import com.neyma.serviceoffer.dao.db.OfferResponse.OfferResponseBuilder;
import com.neyma.serviceoffer.dao.util.MongoDbUtil;
import com.neyma.serviceoffer.domain.Offer;
import com.neyma.serviceoffer.domain.Offer.OfferBuilder;

@Service(ProjectConfiguration.OFFER_REPOSITORY)
public class OfferMongoDbRepository extends AbstractMongoDbRepository 
	implements IDbGetAllSupportAlteringRepository<OfferRequest, OfferResponse> {

	@Override
	public OfferResponse save(OfferRequest req) {
		
		if (req.isOfferEmpty()) {
			throw new IllegalArgumentException("Offer can't be empty!");
		}
		
		String timeStamp = new SimpleDateFormat(env.getProperty("db.timestamp")).format(new Date());
		String offerId = req.getOfferRequestObject().getUserId() + timeStamp + Math.random();
		
		Offer setupOffer = new OfferBuilder(req.getOfferRequestObject())
				.withCreationTime(timeStamp)
				.withLastUpdatedTime(timeStamp)
				.withDbId(offerId)
				.build();
		
	    Document doc = MongoDbUtil.convertObjectToDocument(setupOffer);
	    db.getCollection(env.getProperty("db.offertable")).insertOne(doc);
		
		return new OfferResponseBuilder()
				.withOffer(setupOffer)
				.build();
	}

	@Override
	public OfferResponse update(OfferRequest req) {
		
		if (req.isOfferEmpty()) {
			throw new IllegalArgumentException("Offer can't be empty!");
		}
		
		if (req.isOfferIdEmpty()) {
			throw new IllegalArgumentException("OfferId can't be empty!");
		}
		
		OfferResponse checkResponse = get(req);
		
		if (checkResponse.getOfferResponseObject() == Offer.EMPTY_OFFER) {
			throw new IllegalStateException("Cannot update because the entry is not exist!");
		}
		
		String timeStamp = new SimpleDateFormat(env.getProperty("db.timestamp")).format(new Date());
		
		Offer setupOffer = new OfferBuilder(req.getOfferRequestObject())
				.withLastUpdatedTime(timeStamp)
				.build();
		
		Document doc = MongoDbUtil.convertObjectToDocument(setupOffer);
	    db.getCollection(env.getProperty("db.offertable"))
	    	.replaceOne(new Document("_id", req.getOfferRequestObject().get_id()), doc);
		
		return new OfferResponseBuilder()
				.withOffer(setupOffer)
				.build();
	}

	@Override
	public OfferResponse get(OfferRequest req) {
		
		if (req.isOfferIdEmpty()) {
			throw new IllegalArgumentException("OfferId can't be empty!");
		}
		
		FindIterable<Document> offers = findDocument("db.offertable", "_id", req.getOfferId());
		
		Document offer = offers.first();
		
		if (offer == null) {
			return new OfferResponseBuilder().build();
		}
		
		return new OfferResponseBuilder()
				.withOffer(conversionService.convert(offer, Offer.class))
				.build();
	}

	@Override
	public OfferResponse getAll(OfferRequest req) {
		
		if (req.isUserIdEmpty()) {
			throw new IllegalArgumentException("UserId can't be empty!");
		}
		
		FindIterable<Document> offers = findDocument("db.offertable", "userId", req.getUserId());
		
		List<String> offerIds = new ArrayList<>();
		for (Document doc : offers){
			offerIds.add(doc.getString("_id"));
		}
		
		return new OfferResponseBuilder()
				.withOfferIdList(offerIds)
				.build();
	}
	
}
