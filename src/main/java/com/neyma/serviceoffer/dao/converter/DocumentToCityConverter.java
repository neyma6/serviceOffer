package com.neyma.serviceoffer.dao.converter;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

import com.neyma.serviceoffer.domain.City;

public class DocumentToCityConverter implements Converter<Document, City> {

	@Override
	public City convert(Document source) {
		String id = source.getString("_id");
		String name = source.getString("name");
		String regionId = source.getString("regionId");
		return new City(id, name, regionId);
	}

}
