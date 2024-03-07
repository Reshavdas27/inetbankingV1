package com.inetbanking.testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is Provided.");
		lp.setPassword(password);
		logger.info("Password is Provided.");
		lp.clickSubmit();
		logger.info("Clicked on submit button.");
		
		Thread.sleep(3000);
		
		logger.info("Providing Customer Details...");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("Rahul");
		addcust.custGender();
		addcust.custdob("07", "02", "2000");
		Thread.sleep(3000);
		addcust.custAddress("INDIA");
		addcust.custCity("Kollkata");
		addcust.custState("West Bengal");
		addcust.custPinno("700001");
		addcust.custMobileno("9087688542");
		
		String email = randomString() + "@gmail.com";
		addcust.custEmailId(email);
		
		addcust.custPassword("abcdef01");
		addcust.custSubmit();
		
		Thread.sleep(5000);
		
		logger.info("Validation Started...");
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result==true) {
			Assert.assertTrue(true);
			logger.info("Testcase Passed!");
		}
		else {
			logger.info("Testcase Failed!");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphanumeric(6, 8);
		return generatedString;
	}
 	
}
