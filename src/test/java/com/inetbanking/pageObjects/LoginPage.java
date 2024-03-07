package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	
	WebElement txtUserName;
	
	@FindBy(name="password")
	
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnkLogout;
	
	@FindBy(xpath="/html/body/div/div/div[1]/div[1]/div/svg") 
	WebElement adblock;
	
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public boolean closeAd()
	{
		if (adblock.isDisplayed() && adblock.isEnabled()) {
		    adblock.click();
		    return true;
		}
		else {
			return false;
		}
	}
	
	public void adClosed()
	{
		adblock.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
}
