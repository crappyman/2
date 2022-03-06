package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.RequestPojo;


public class RequestDaoImpl implements RequestDao {

	public List<RequestPojo> viewAllRequest() {
		Connection conn = DBUtil.obtainConnection();
		List<RequestPojo> requestPojo= new ArrayList();
        String query = "SELECT req_id,user_id,type,request_amount,submit_date,approve_date,status FROM request_details;";
            PreparedStatement ps;
			try {
				ps = conn.prepareStatement(query);
				   ResultSet rs = ps.executeQuery();
			       while(rs.next()){
			    	   requestPojo.add(
		                        new RequestPojo(
		                            rs.getInt("req_id"),
		                            rs.getInt("user_id"),
		                            rs.getString("type"),
		                            rs.getInt("request_amount"),
		                            rs.getString("submit_date"),
		                            rs.getString("approve_date"),
		                            rs.getString("status")
		                          
		                ));
			       }
			         ps.close();
			     } catch (Exception ex) {
			         ex.printStackTrace();
			     }
			     return requestPojo;
	}

	public RequestPojo addRequest(RequestPojo requestPojo) {
		Connection conn = DBUtil.obtainConnection();
		
		Statement stmt = null;
		
		try {
			 stmt = conn.createStatement();
		String query2 = "INSERT INTO request_details(book_title, book_author, book_genre, book_cost, book_image_url) VALUES('"+requestPojo.getEp()+"','"+requestPojo.getReqType()+"','"+requestPojo.getReqAmount()+"',"+requestPojo.getSubmitDate()+",'"+requestPojo.getApproveDate()+",'"+requestPojo.getReqStatus()+"') RETURNING req_id";
		//int rows = stmt.executeUpdate(query2);
		
		ResultSet rs = stmt.executeQuery(query2);
		if(rs.next()) {
			requestPojo.setReqId(rs.getInt(1));
		}
		
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	
	return requestPojo;
	}
	
	public List<RequestPojo> viewPendingRequest() {
		Connection conn = DBUtil.obtainConnection();
		  List<RequestPojo> requestList = new ArrayList();
		 PreparedStatement ps;
		 try {
			 String sql = "SELECT * FROM request WHERE reimb_status_id = 1 ";

	            // adding any filters or sorting orders.
	             ps = conn.prepareStatement(sql);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	            	requestList.add(
	                        new RequestPojo(
	                        		rs.getInt("reimbursementid"),
	                                rs.getInt("ep"),
	                                rs.getString("reqtype"),
	                                rs.getInt("amount"),
	                                rs.getString("submitDate"),
	                                rs.getString("approveDate"),
	                                rs.getString("status")
	                               
	                        ));
	            }
	            ps.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return requestList;
	}

	public RequestPojo reviewRequest(int reqId) {
		RequestPojo reqPojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM book_details WHERE book_id="+reqId;
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				reqPojo = new RequestPojo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6),rs.getString(7));
			}
		} catch (Exception e) {
			
		}
		
		return reqPojo;
	}

	public RequestPojo deleteRequest(int reqId) {
		RequestPojo reqPojo = null;
		Connection conn = DBUtil.obtainConnection();
		try {
			Statement stmt = conn.createStatement();
			reqPojo = reviewRequest(reqId);
			String query = "DELETE FROM book_details WHERE book_id="+reqId;
			int rows = stmt.executeUpdate(query);
		} catch (Exception e) {
			
		}
		
		return reqPojo;
	}

}
