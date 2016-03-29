package com.neyma.serviceoffer.dao.db.impl;

import org.springframework.stereotype.Service;

import com.neyma.serviceoffer.config.ProjectConfiguration;
import com.neyma.serviceoffer.dao.db.IDbUserAwareAlteringRepository;
import com.neyma.serviceoffer.dao.db.UserRequest;
import com.neyma.serviceoffer.dao.db.UserResponse;

@Service(ProjectConfiguration.USER_REPOSITORY)
public class UserMongoDbRepository implements IDbUserAwareAlteringRepository<UserRequest, UserResponse> {

	@Override
	public UserResponse save(UserRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse update(UserRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse get(UserRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse authUser(UserRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
