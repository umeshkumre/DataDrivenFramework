package com.ddf.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ddf.utility.Utility;

public class BaseClass {
	
	public WebDriver driver;

	@BeforeMethod
	public void launchBrowser() throws IOException
	
	{
		if(Utility.fetchPropertyValue("browserName").toString().contentEquals("chrome"))
		{
		   System.setProperty("webdriver.chrome.driver","D:\\Browser_drivers\\Chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(Utility.fetchPropertyValue("browserName").toString().contentEquals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\Browser_drivers\\gecko.exe");
			driver=new FirefoxDriver();
		}
		else
		{    
			System.setProperty("webdriver.chrome.driver","D:\\Browser_drivers\\Chromedriver.exe");
		    driver=new ChromeDriver();
		}
		
		driver.get(Utility.fetchPropertyValue("ApplicationURL").toString());

	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}
