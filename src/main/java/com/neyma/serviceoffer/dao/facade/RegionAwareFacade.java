package com.neyma.serviceoffer.dao.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.neyma.serviceoffer.config.ProjectConfiguration;
import com.neyma.serviceoffer.dao.db.CityRequest;
import com.neyma.serviceoffer.dao.db.IPermanentRepository;
import com.neyma.serviceoffer.dao.db.LocationResponse;
import com.neyma.serviceoffer.dao.db.RegionRequest;
import com.neyma.serviceoffer.domain.City;
import com.neyma.serviceoffer.domain.Region;
import com.neyma.serviceoffer.presenter.RegionResultPresenter;

@Service
public class RegionAwareFacade {

	@Autowired
	@Qualifier(ProjectConfiguration.REGION_REPOSITORY)
	private IPermanentRepository<RegionRequest, LocationResponse<Region>> regionRepository;
	
	@Autowired
	@Qualifier(ProjectConfiguration.CITY_REPOSITORY)
	private IPermanentRepository<CityRequest, LocationResponse<City>> cityRepository;
	
	public RegionResultPresenter loadRegionsIntoDb() {
		
		
		return null;
	}
	
	public List<Region> getRegions() {
		return regionRepository.getAll(RegionRequest.EMPTY_REQUEST).getItems();
	}
	
	public List<City> getCities(String regionId) {
		return cityRepository.getAll(new CityRequest(CityRequest.EMPTY_NAME, regionId)).getItems();
	}
}
