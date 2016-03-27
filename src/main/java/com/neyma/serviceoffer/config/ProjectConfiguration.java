package com.neyma.serviceoffer.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.converter.StringHttpMessageConverter;

import com.neyma.serviceoffer.dao.converter.DbUserToUserConverter;
import com.neyma.serviceoffer.dao.converter.DocumentToCityConverter;
import com.neyma.serviceoffer.dao.converter.DocumentToOfferConverter;

@Configuration
@ComponentScan("com.neyma")
@PropertySource("classpath:config.properties")
public class ProjectConfiguration {

	public static final String CITY_REPOSITORY = "cityRepository";
	public static final String REGION_REPOSITORY = "regionRepository";
	private static final String CONVERSION_SERVICE = "conversionService";
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
	@Bean(name = CONVERSION_SERVICE)
	public ConversionService getConversionService() {
		
		ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
		factory.setConverters(new HashSet<Converter>(getConverters()));
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	private List<Converter<? extends Object, ? extends Object>> getConverters() {
		return Arrays.asList(new DbUserToUserConverter(), 
				new DocumentToOfferConverter(),
				new DocumentToCityConverter());
	}
}
