package com.neyma.serviceoffer.dao.testDb;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.neyma.serviceoffer.dao.domain.User;

public class TestDb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerAddress serverAddress = new ServerAddress("localhost");
		MongoCredential credential = MongoCredential.createCredential("neyma", "admin", "neyma".toCharArray());
		MongoClient mongoClient = new MongoClient();//(serverAddress, Arrays.asList(credential));
		MongoDatabase db = mongoClient.getDatabase("offerservice");
		User user = new User();
		user.set_id("neyma@gmail.com");
		user.setPassword("neyma");
		user.setName("Csatlós Gábor");
		user.setPhone("06303366717");
		
		Gson gson = new Gson();
	    String json = gson.toJson(user);
	    
	    Document doc = Document.parse(json);
	    db.getCollection("cars").insertOne(doc);
	    
	    FindIterable<Document> iterable = db.getCollection("cars").find();
	    iterable.forEach(new Block<Document>() {
	      @Override
	      public void apply(final Document document) {
	        System.out.println(document); // See below to convert document back to Employee
	      }
	    });
	}

}
