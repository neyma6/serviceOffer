package com.neyma.serviceoffer.dao.converter;

import org.springframework.core.convert.converter.Converter;

import com.neyma.serviceoffer.dao.domain.User;

public class DbUserToUserConverter implements Converter<User, com.neyma.serviceoffer.domain.User> {

	@Override
	public com.neyma.serviceoffer.domain.User convert(User dbUser) {
		com.neyma.serviceoffer.domain.User user = new com.neyma.serviceoffer.domain.User();
		user.setEmail(dbUser.get_id());
		user.setName(dbUser.getName());
		user.setPhone(dbUser.getPhone());
		return null;
	}

}
