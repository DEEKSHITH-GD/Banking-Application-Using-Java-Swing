package com.destination.BankingApplication.Test;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.destination.BankingApplication.Admin;

public class BankAppTest {
	@Test
	public void testAdmin() {
		Admin a = new Admin();
		a.setAdmin_id("admin@123");
		a.setAdmin_pwd("Admin123!");
		Assert.assertEquals(true, a.validate());
		
	}
	@Test
	public void testAdmin2() {
		Admin a = new Admin();
		a.setAdmin_id("admin@123");
		a.setAdmin_pwd("123!");
		Assert.assertEquals(false, a.validate());
	}
}
