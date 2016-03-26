package com.neyma.serviceoffer.dao.db.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.mongodb.client.FindIterable;
import com.neyma.serviceoffer.config.ProjectConfiguration;
import com.neyma.serviceoffer.dao.db.CityRequest;
import com.neyma.serviceoffer.dao.db.IPermanentRepository;
import com.neyma.serviceoffer.dao.db.LocationResponse;
import com.neyma.serviceoffer.dao.util.MongoDbUtil;
import com.neyma.serviceoffer.domain.City;

@Service(ProjectConfiguration.CITY_REPOSITORY)
public class CityMongoDbRepository extends AbstractMongoDbRepository 
	implements IPermanentRepository<CityRequest, LocationResponse<City>>{

	@Override
	public void save(CityRequest req) {
		String regionId = req.getRegionId();
		String name = req.getCityName();
		City city = new City(regionId + name, name, regionId);
		
		Document doc = MongoDbUtil.convertObjectToDocument(city);
	    db.getCollection(env.getProperty("db.citytable")).insertOne(doc);
	}

	@Override
	public LocationResponse<City> getAll(CityRequest req) {
		List<City> cities = new ArrayList<>();
		FindIterable<Document> documents = findDocument("db.citytable", "regionId", req.getRegionId());
		
		for (Document doc : documents) {
			cities.add(conversionService.convert(doc, City.class));
		}
		
		return new LocationResponse<>(cities);
	}
}
