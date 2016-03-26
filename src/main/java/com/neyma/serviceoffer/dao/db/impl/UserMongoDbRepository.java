package com.neyma.serviceoffer.dao.db.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.neyma.serviceoffer.config.ProjectConfiguration;

@Service
public class UserMongoDbRepository {

	@Autowired
	private ConversionService conversionService;
}
