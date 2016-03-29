package com.neyma.serviceoffer.dao.db;

public interface IDbAlteringRepository<Request extends IRequest, Response extends IResponse> {

	Response save(Request req);
	
	Response update(Request req);
	
	Response get(Request req);
}
