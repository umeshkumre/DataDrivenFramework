package com.ddf.testcases;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ddf.base.BaseClass;
import com.ddf.excelReader.ReadDataFromExcel;
import com.ddf.pages.LoginPage;

public class TC_002_ValidateLoginFunctionality extends BaseClass{
	
	@Test(dataProvider = "getData",dataProviderClass = ReadDataFromExcel.class)
	public void verifyLogin(String uname,String pass) throws Exception
	{
		LoginPage login=new LoginPage(driver);

		login.enterUserName(uname);
		
		login.enterPassword(pass);
	
		login.clickOnlogin();
	}
	
	
}
