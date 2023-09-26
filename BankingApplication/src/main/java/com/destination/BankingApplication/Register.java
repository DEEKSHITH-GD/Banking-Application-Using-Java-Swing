package com.destination.BankingApplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register {
	public boolean register() {
		try {
			String query = "insert into customers values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = Connector.Connector().prepareStatement(query);
			pstmt.setString(1,BankingApplication.customerId);
			pstmt.setString(2,BankingApplication.customerName);
			pstmt.setInt(3,BankingApplication.accountNo);
			pstmt.setString(4,BankingApplication.customerPassword);
			pstmt.setInt(5,BankingApplication.balance);
			pstmt.setString(6,BankingApplication.bankName);
			pstmt.setString(7,BankingApplication.ifscCode);
			pstmt.setString(8,BankingApplication.email);
			pstmt.setString(9,"inactive");
			int result = pstmt.executeUpdate();
			if(result > 0) {
				return true;			
			}
		}
		catch (Exception e) {
			System.out.println("in register()");
			e.printStackTrace();
		}
		return false;
	}
}
