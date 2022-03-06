package dao;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import pojo.UserPojo;

public class UserDaoImp implements UserDao {

	public List<UserPojo> fetchAllAccounts() {
		Connection conn = DBUtil.obtainConnection();
		List<UserPojo> userpojo= new ArrayList();
        String query = "SELECT userid,username,firstname,lastname,email,roleid FROM user_details;";
            PreparedStatement ps;
			try {
				ps = conn.prepareStatement(query);
				   ResultSet rs = ps.executeQuery();
			       while(rs.next()){
			    	   userpojo.add(
		                        new UserPojo(
		                            rs.getInt("userID"),
		                            rs.getString("username"),
		                            rs.getString("password"),
		                            rs.getString("firstname"),
		                            rs.getString("email"),
		                            rs.getInt("roleid")
		                ));
			       }
			         ps.close();
			     } catch (Exception ex) {
			         ex.printStackTrace();
			     }
			     return userpojo;
				}

	public UserPojo fetchAAccount(int userId) {
		UserPojo userInfo=null; 
		Connection conn = DBUtil.obtainConnection();
		try {
			 Statement stmt = conn.createStatement();
		  String sql = "SELECT * FROM user_details WHERE userID ="+userId;
		 
			
	          ResultSet rs = stmt.executeQuery(sql);

	          while(rs.next()){
	              userInfo = new UserPojo(
		                          rs.getInt("userID"),
		                            rs.getString("username"),
		                            rs.getString("password"),
		                            rs.getString("firstname"),
		                            rs.getString("email"),
		                            rs.getInt("roleid"));
	          }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
       
    
    return userInfo;
	}

	public UserPojo updateAccount( UserPojo userpojo) {
		Connection conn = DBUtil.obtainConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "UPDATE user_details SET email="+userpojo.getEmail()+" WHERE userID="+userpojo.getUserID();
			int rows = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		
		return userpojo;
	}

}
