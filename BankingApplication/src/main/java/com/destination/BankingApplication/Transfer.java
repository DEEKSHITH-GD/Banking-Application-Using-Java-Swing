package com.destination.BankingApplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Transfer {
	public byte validate() {
		try {
			//check sufficient balance
			PreparedStatement pstmt = Connector.Connector().prepareStatement("Select balance from customers where customerId=? and balance>?");
			pstmt.setString(1, BankingApplication.getCustomerId()); 
			pstmt.setInt(2, BankingApplication.getTransferAmount());

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()==true) {
				pstmt = Connector.Connector().prepareStatement("Update customers set balance=? where accountNo=? and ifscCode=?"); //update recipient A/C
				pstmt.setInt(1, BankingApplication.getRecipientBalance()+BankingApplication.getTransferAmount()); //add current balance & transfer amount to update db
				pstmt.setInt(2, BankingApplication.getRecipientAccountNo());
				pstmt.setString(3, BankingApplication.getRecipientIfscCode());

				byte q2 = (byte) pstmt.executeUpdate();
				if(q2>0) {
					pstmt = Connector.Connector().prepareStatement("Update customers set balance=? where customerId=?"); //update sender A/C
					pstmt.setInt(1, BankingApplication.getBalance()-BankingApplication.getTransferAmount()); //subtract current balance & transfer amount to update db
					pstmt.setString(2, BankingApplication.getCustomerId());

					byte q3 = (byte) pstmt.executeUpdate();
					if(q3>0) {
						return 1;
					}
				}else {
					return 2;
				}
			}
		}
		catch (Exception e) {
			System.out.println("in transfer()");
			e.printStackTrace();
		}
		return 3;
	}
}
