package com.destination.BankingApplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetDetails {
	//function to fetch data of customer who has currently logged in 
	public static void getDetails() {
		try {
			//Query to get data from SQL database
			PreparedStatement pst = Connector.Connector().prepareStatement("Select customerName, accountNo, customerPassword, balance from customers where customerId=?");
			pst.setString(1, BankingApplication.getCustomerId());
			ResultSet rs1 = pst.executeQuery();
			while (rs1.next()) {
				BankingApplication.setCustomerName(rs1.getString(1)); //acquiring Name of user
				BankingApplication.setAccountNo(rs1.getInt(2)); //acquiring account number of user
				BankingApplication.setCustomerPassword(rs1.getString(3)); //acquiring password of user
				BankingApplication.setBalance(rs1.getInt(4)); //acquiring balance of user
			}
		}
		catch (Exception e) {
			System.out.println("in getdetails()");
			e.printStackTrace();
		}
		
	}
}
