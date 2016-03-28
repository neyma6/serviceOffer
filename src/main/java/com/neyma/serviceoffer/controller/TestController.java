package com.neyma.serviceoffer.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neyma.serviceoffer.config.ProjectConfiguration;
import com.neyma.serviceoffer.dao.db.CityRequest;
import com.neyma.serviceoffer.dao.db.IPermanentRepository;
import com.neyma.serviceoffer.dao.db.LocationResponse;
import com.neyma.serviceoffer.dao.db.RegionRequest;
import com.neyma.serviceoffer.dao.db.impl.OfferMongoDbRepository;
import com.neyma.serviceoffer.dao.util.LoadRegionAndCities;
import com.neyma.serviceoffer.domain.City;
import com.neyma.serviceoffer.domain.Region;

@Controller
public class TestController {

	@Autowired
	private OfferMongoDbRepository offerRepo;
	
	@Autowired
	@Qualifier(ProjectConfiguration.REGION_REPOSITORY)
	private IPermanentRepository<RegionRequest, LocationResponse<Region>> regionRepo;
	
	@Autowired
	@Qualifier(ProjectConfiguration.CITY_REPOSITORY)
	private IPermanentRepository<CityRequest, LocationResponse<City>> cityRepo;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String get() throws InterruptedException, IOException {
		
		/*Offer offer = new Offer("neyma6@gmail.com", "title", "desc", "Szeged");
		
		for (int i = 0; i < 3; i++) {
			Offer extended = offerRepo.save(offer);
			System.out.println(extended);
			Thread.sleep(10);
		}
		
		List<String> ids = offerRepo.getOfferListForUser("neyma6@gmail.com");
		System.out.println("ids = " + ids);
		
		for (String id : ids) {
			Offer ret = offerRepo.get(id);
			System.out.println("ret " + ret);
		}*/
		
		Resource resource = resourceLoader.getResource("classpath:HU.txt");
		Map<String, Set<String>> data = LoadRegionAndCities.loadCountyAndCities(resource.getFile());
		
		data.remove("Budapest");
		data.get("Pest").add("Budapest");
		
		for (Map.Entry<String, Set<String>> entry : data.entrySet()) {
			regionRepo.save(new RegionRequest(entry.getKey()));
			for (String city : entry.getValue()) {
				cityRepo.save(new CityRequest(city, entry.getKey()));
			}
		}
		
		List<Region> regions = regionRepo.getAll(RegionRequest.EMPTY_REQUEST).getItems();
		
		for (Region region : regions) {
			System.out.println(region);
			List<City> cities = cityRepo.getAll(new CityRequest(CityRequest.EMPTY_NAME, region.get_id())).getItems();
			
			for (City city : cities) {
				System.out.print(city + " ");
			}
			System.out.println();
		}
		
		return "test";
	}
}
