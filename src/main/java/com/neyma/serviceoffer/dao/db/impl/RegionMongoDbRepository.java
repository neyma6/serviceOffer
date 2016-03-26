package com.neyma.serviceoffer.dao.db.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.mongodb.client.FindIterable;
import com.neyma.serviceoffer.config.ProjectConfiguration;
import com.neyma.serviceoffer.dao.db.IPermanentRepository;
import com.neyma.serviceoffer.dao.db.LocationResponse;
import com.neyma.serviceoffer.dao.db.RegionRequest;
import com.neyma.serviceoffer.dao.util.MongoDbUtil;
import com.neyma.serviceoffer.domain.Region;

@Service(ProjectConfiguration.REGION_REPOSITORY)
public class RegionMongoDbRepository extends AbstractMongoDbRepository 
	implements IPermanentRepository<RegionRequest, LocationResponse<Region>>{

	@Override
	public void save(RegionRequest req) {
		Document doc = MongoDbUtil.convertObjectToDocument(new Region(req.getRegionId()));
	    db.getCollection(env.getProperty("db.regiontable")).insertOne(doc);
	}

	@Override
	public LocationResponse<Region> getAll(RegionRequest req) {
		List<Region> regions = new ArrayList<>();
		FindIterable<Document> documents = db.getCollection(env.getProperty("db.regiontable")).find();
		for (Document doc : documents) {
			regions.add(new Region(doc.getString("_id")));
		}
		
		return new LocationResponse<>(regions);
	}
	
}
