package com.destination.BankingApplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
	public static String admin_id;
	public static String admin_pwd;
	
	public static String getAdmin_id() {
		return admin_id;
	}
	public static void setAdmin_id(String admin_id) {
		Admin.admin_id = admin_id;
	}
	public static String getAdmin_pwd() {
		return admin_pwd;
	}
	public static void setAdmin_pwd(String admin_pwd) {
		Admin.admin_pwd = admin_pwd;
	}
	public boolean validate() {
		// Query for admin login function
		try {
			String query = "select * from admin where admin_id=? and admin_pwd=?";
			PreparedStatement pstmt = Connector.Connector().prepareStatement(query);
			pstmt.setString(1,admin_id);
			pstmt.setString(2,admin_pwd);
			
			ResultSet resultSet = pstmt.executeQuery();
			if(resultSet.next()==true) {
				return true;			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
