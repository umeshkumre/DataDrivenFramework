package com.ddf.pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ddf.utility.Utility;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUserName(String uname) throws IOException
	{
	    driver.findElement(By.id(Utility.fetchLocatorValue("login_username_name"))).sendKeys(uname);
	}
	
	public void enterPassword(String pass) throws IOException
	{
		driver.findElement(By.xpath(Utility.fetchLocatorValue("login_password_xpath"))).sendKeys(pass);
	}
	
	public void clickOnlogin() throws IOException
	{
		driver.findElement(By.xpath(Utility.fetchLocatorValue("login_LoginBtn_xpath"))).click();
	}
	

}
