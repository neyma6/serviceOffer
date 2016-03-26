package com.neyma.serviceoffer.dao.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neyma.serviceoffer.dao.db.impl.OfferMongoDbRepository;
import com.neyma.serviceoffer.dao.db.impl.UserMongoDbRepository;

@Service
public class MongoDbServiceFacade {

	@Autowired
	private OfferMongoDbRepository offerMongoDbRepository;
	
	@Autowired
	private UserMongoDbRepository userMongoDbRepository;
}
