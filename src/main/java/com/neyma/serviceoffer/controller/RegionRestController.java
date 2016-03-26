package com.neyma.serviceoffer.controller;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neyma.serviceoffer.dao.facade.RegionAwareFacade;
import com.neyma.serviceoffer.domain.City;
import com.neyma.serviceoffer.domain.Region;

@Controller
@RequestMapping("/region")
public class RegionRestController {

	@Autowired
	private RegionAwareFacade regionAwareFacade;
	
	
	@RequestMapping(value = "/regions", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getRegions() {
		
		List<Region> regions = regionAwareFacade.getRegions();
		List<String> regionNames = new ArrayList<>();
		
		for (Region region : regions) {
			regionNames.add(StringEscapeUtils.escapeHtml4(region.get_id()));
		}
		
		return regionNames;
	}
	
	@RequestMapping(value = "/city", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getCities(@RequestParam String name) throws UnsupportedEncodingException {
		
		System.out.println(StringEscapeUtils.unescapeHtml4(name));
		
		List<City> cities = regionAwareFacade.getCities(name);
		List<String> cityNames = new ArrayList<>();
		
		for (City city : cities) {
			cityNames.add(city.getName());
		}
		
		return cityNames;
	}
}
