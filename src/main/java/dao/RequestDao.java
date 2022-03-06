package dao;

import java.util.List;

import pojo.RequestPojo;

public interface RequestDao {

	//view all request doesnt matter of the status
	List<RequestPojo> viewAllRequest();
	
	RequestPojo addRequest(RequestPojo requestPojo);
	
	//view pending request
	List<RequestPojo> viewPendingRequest();
	
	//manage to review and either approve, denied the request
	RequestPojo reviewRequest(int reqId);
	
	RequestPojo deleteRequest(int reqId);
}
