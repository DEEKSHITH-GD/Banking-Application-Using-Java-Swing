package com.destination.BankingApplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetCustomerName {
	//function to fetch customer name
	public static void getCustomerName() {
		try {
			//query to get data of customerName for user that is currently logged in 
			PreparedStatement pst = Connector.Connector().prepareStatement("Select customerName from customers where customerId=?");
			pst.setString(1, BankingApplication.getCustomerId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				BankingApplication.setCustomerName(rs.getString(1));
			}
		}
		catch (Exception e) {
			System.out.println("in getCustomerName()");
			e.printStackTrace();
		}
	}
}
