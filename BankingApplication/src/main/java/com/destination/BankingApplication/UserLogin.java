package com.destination.BankingApplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLogin {
	public byte validate() {
		// TODO Auto-generated method stub
		try {
			String query1 = "select * from customers where customerId=? and customerPassword=?";
			PreparedStatement pstmt = Connector.Connector().prepareStatement(query1);
			pstmt.setString(1,BankingApplication.getCustomerId());
			pstmt.setString(2,BankingApplication.getCustomerPassword());

			ResultSet resultSet = pstmt.executeQuery();
			if(resultSet.next()==true) {
				pstmt = Connector.Connector().prepareStatement("select customerId,status from customers where customerId=? and status=\"active\"");
				pstmt.setString(1,BankingApplication.getCustomerId());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()==true) {
					return 1;
				}
				else {
					return 2;
				}
			}
		}
		catch (Exception e) {
			System.out.println("in UserLogin.validate()");
			e.printStackTrace();
		}
		return 3;
	}
}
