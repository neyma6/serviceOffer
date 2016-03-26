package com.neyma.serviceoffer.dao.db;

public interface IPermanentRepository<Request extends IRequest, Response extends IResponse> {

	public void save(Request req);
	
	public Response getAll(Request req);
	
}
