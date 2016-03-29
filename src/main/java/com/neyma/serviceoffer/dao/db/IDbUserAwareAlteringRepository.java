package com.neyma.serviceoffer.dao.db;

public interface IDbUserAwareAlteringRepository <Request extends IRequest, Response extends IResponse>
	extends IDbAlteringRepository<Request, Response> {
	
	Response authUser(Request req);

}
