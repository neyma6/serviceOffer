package com.neyma.serviceoffer.dao.db;

import java.util.Collection;

public interface IDbRepository<Request extends IRequest, Response extends IResponse> {

	Response getData(Request request);
	
	void setData(Request request);
	
	void setData(Collection<Request> request);
	
	boolean updateData(Request request);
}
