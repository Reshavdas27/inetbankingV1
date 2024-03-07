package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	
	WebElement txtAddNewCustomer;
	
	@FindBy(name = "name")
	
	WebElement txtCustomerName;
	
	@FindBy(name = "rad1")
	
	WebElement rdGender;
	
	@FindBy(name = "dob")
	
	WebElement txtDob;
	
	@FindBy(name = "addr")
	
	WebElement txtAddress;
	
	@FindBy(name = "city")
	
	WebElement txtCity;
	
	@FindBy(name = "state")
	
	WebElement txtState;
	
	@FindBy(name = "pinno")
	
	WebElement txtPinno;
	
	@FindBy(name = "telephoneno")
	
	WebElement txtMobileNo;
	
	@FindBy(name = "emailid")
	
	WebElement txtEmailId;
	
	@FindBy(name = "password")
	
	WebElement txtPassword;
	
	@FindBy(name = "sub")
	
	WebElement btnSubmit;
	
	public void clickAddNewCustomer()
	{
		txtAddNewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender()
	{
		rdGender.click();
	}
	
	public void custdob(String mm, String dd, String yy)
	{
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yy);
	}
	
	public void custAddress(String caddress)
	{
		txtAddress.sendKeys(caddress);
	}
	
	public void custCity(String ccity)
	{
		txtCity.sendKeys(ccity);
	}
	
	public void custState(String cstate)
	{
		txtState.sendKeys(cstate);
	}
	
	public void custPinno(String cpinno)
	{
		txtPinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custMobileno(String cmobileno)
	{
		txtMobileNo.sendKeys(cmobileno);
	}
	
	public void custEmailId(String cemailid)
	{
		txtEmailId.sendKeys(cemailid);
	}
	
	public void custPassword(String cpassword)
	{
		txtPassword.sendKeys(cpassword);
	}
	
	public void custSubmit()
	{
		btnSubmit.click();
	}
	
}
