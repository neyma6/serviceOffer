package com.neyma.serviceoffer.dao.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LoadRegionAndCities {

	private static final int CITY_INDEX = 2;
	private static final int REGION_INDEX = 3;
	
	// TODO: move Budapest to Pest County
	public static Map<String, Set<String>> loadCountyAndCities(File file) {
		
		Map<String, Set<String>> regionsAndCities = new TreeMap<>();
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), "UTF-8"))) {
			
			String line;
			while ((line = reader.readLine()) != null) {
				String[] pieces = line.split(",");
				String city = pieces[CITY_INDEX];
				String region = pieces[REGION_INDEX];
				addCityAndRegion(regionsAndCities, region, city);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			regionsAndCities.clear();
			return regionsAndCities;
		}
		
		return regionsAndCities;
	}
	
	private static void addCityAndRegion(Map<String, Set<String>> collection, String region, String city) {
		Set<String> cities = collection.get(region);
		if (cities == null) {
			cities = new TreeSet<>();
			collection.put(region, cities);
		}
		cities.add(city);
	}
}
