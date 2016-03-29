package com.neyma.serviceoffer.dao.db;

public interface IPermanentRepository<Request extends IRequest, Response extends IResponse> {

	void save(Request req);
	
	Response getAll(Request req);
	
}
