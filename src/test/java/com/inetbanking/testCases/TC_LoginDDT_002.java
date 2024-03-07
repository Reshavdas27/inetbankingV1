package com.inetbanking.testCases;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
		@Test(dataProvider="LoginData")
		public void loginDDT(String user, String pwd) throws InterruptedException
		{
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(user);
			 logger.info("user name provided");
			lp.setPassword(pwd);
			logger.info("password provided");
			lp.clickSubmit();
			logger.info("Clicked Submit Button");
		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//Thread.sleep(3000);
			
			if(isAlertPresent()==true)
			{
				driver.switchTo().alert().accept(); //close alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
				logger.warning("Login Failed");
			}
			else
			{
				Assert.assertTrue(true);
				logger.info("Login Passes");
//				if (lp.closeAd()==true) {
//					//lp.adClosed();
//					Thread.sleep(3000);
//					lp.clickLogout();
//					driver.switchTo().alert().accept(); // close logout alert
//					driver.switchTo().defaultContent();
//				}
//				else {
					lp.clickLogout();
				
					driver.switchTo().alert().accept(); // close logout alert
					driver.switchTo().defaultContent();
				}
				//Thread.sleep(3000);
				
			}
			
					
			
		//}
			
		
		@DataProvider(name="LoginData")
		String [][] getData() throws IOException
		{
			String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetbanking\\testData\\LoginData.xlsx";
			System.out.println("File path: " + path);
			
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
			
			String logindata[][]=new String [rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
					System.out.println("Data at [" + i + "][" + j + "]: " + logindata[i-1][j]);
				}
			}
			return logindata;
		}
		
		public boolean isAlertPresent()
		{
			try {
				driver.switchTo().alert();
				return true;
			} catch (NoAlertPresentException e) {
				return false;
			}
		}
}
