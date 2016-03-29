package com.neyma.serviceoffer.dao.db;

public interface IDbGetAllSupportAlteringRepository<Request extends IRequest, Response extends IResponse> 
	extends IDbAlteringRepository<Request, Response>{

	Response getAll(Request req);
}
