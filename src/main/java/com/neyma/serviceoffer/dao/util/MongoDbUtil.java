package com.neyma.serviceoffer.dao.util;

import org.bson.Document;

import com.google.gson.Gson;

public class MongoDbUtil {

	public static <Obj> Document convertObjectToDocument(Obj obj) {
		Gson gson = new Gson();
	    String json = gson.toJson(obj);
	    return Document.parse(json);
	}
}
