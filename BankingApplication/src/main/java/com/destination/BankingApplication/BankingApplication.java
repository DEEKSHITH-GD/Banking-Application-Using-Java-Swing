package com.destination.BankingApplication;

//Model for customer of bank
public class BankingApplication {
	static String customerId; 		
	static String customerName;		
	static int accountNo;	
	static String customerPassword; 		
	static int balance;		
	static String bankName;		
	static String ifscCode;		
	static String email;
	static int recipientAccountNo;
	static int recipientBalance;
	static String recipientIfscCode;
	static int TransferAmount;
	public static String getRecipientIfscCode() {
		return recipientIfscCode;
	}
	public static void setRecipientIfscCode(String recipientIfscCode) {
		BankingApplication.recipientIfscCode = recipientIfscCode;
	}
	public static int getRecipientAccountNo() {
		return recipientAccountNo;
	}
	public static void setRecipientAccountNo(int recipientAccountNo) {
		BankingApplication.recipientAccountNo = recipientAccountNo;
	}
	public static int getRecipientBalance() {
		return recipientBalance;
	}
	public static void setRecipientBalance(int recipientBalance) {
		BankingApplication.recipientBalance = recipientBalance;
	}
	public static int getTransferAmount() {
		return TransferAmount;
	}
	public static void setTransferAmount(int transferAmount) {
		TransferAmount = transferAmount;
	}
	public static String getCustomerId() {
		return customerId;
	}
	public static void setCustomerId(String customerId) {
		BankingApplication.customerId = customerId;
	}
	public static String getCustomerName() {
		return customerName;
	}
	public static void setCustomerName(String customerName) {
		BankingApplication.customerName = customerName;
	}
	public static int getAccountNo() {
		return accountNo;
	}
	public static void setAccountNo(int accountNo) {
		BankingApplication.accountNo = accountNo;
	}
	public static String getCustomerPassword() {
		return customerPassword;
	}
	public static void setCustomerPassword(String customerPassword) {
		BankingApplication.customerPassword = customerPassword;
	}
	public static int getBalance() {
		return balance;
	}
	public static void setBalance(int balance) {
		BankingApplication.balance = balance;
	}
	public static String getBankName() {
		return bankName;
	}
	public static void setBankName(String bankName) {
		BankingApplication.bankName = bankName;
	}
	public static String getIfscCode() {
		return ifscCode;
	}
	public static void setIfscCode(String ifscCode) {
		BankingApplication.ifscCode = ifscCode;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		BankingApplication.email = email;
	}
}
