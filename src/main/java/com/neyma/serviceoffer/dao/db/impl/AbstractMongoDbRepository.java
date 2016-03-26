package com.neyma.serviceoffer.dao.db.impl;

import org.bson.Document;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.Environment;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

// TODO: add exception handling to all subclasses
public class AbstractMongoDbRepository implements InitializingBean {

	@Autowired
	protected Environment env;
	
	@Autowired
	protected ConversionService conversionService;
	
	protected MongoClient mongoClient;
	protected MongoDatabase db;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		mongoClient = new MongoClient();
		db = mongoClient.getDatabase(env.getProperty("db.name"));
	}
	
	protected FindIterable<Document> findDocument(String tableName, String fieldName, String fieldValue) {
		return db.getCollection(env.getProperty(tableName))
				.find(new Document(fieldName, fieldValue));
	}

}
