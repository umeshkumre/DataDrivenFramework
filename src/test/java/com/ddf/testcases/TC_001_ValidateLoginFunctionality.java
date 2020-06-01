package com.ddf.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ddf.base.BaseClass;
import com.ddf.excelReader.ReadDataFromExcel;
import com.ddf.pages.LoginPage;

public class TC_001_ValidateLoginFunctionality extends BaseClass{
	
	@Test(dataProvider = "getData")
	public void validateLogin(String uname,String pass) throws Exception
	{
		LoginPage login=new LoginPage(driver);

		login.enterUserName(uname);
		
		login.enterPassword(pass);
	
		login.clickOnlogin();
	}
	
	/**
	@DataProvider(name="getData")
	public Object[][] getData()
	{
		Object[][] data= {{"uname1","pass1"},{"uname2","pass2"},{"uname3","pass3"}};
	
		return data;
	}
	*/
	@DataProvider(name="getData")
	public static Object[][] getData() throws Exception
	{
		FileInputStream file=new FileInputStream("./TestData/ExcelSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet loginSheet=workbook.getSheet("Sheet1");
		int numOfData=loginSheet.getPhysicalNumberOfRows();
		
		Object[][] testData=new Object[numOfData][2];
		
		for(int i=0;i<numOfData;i++)
		{
			XSSFRow row=loginSheet.getRow(i);
			
			XSSFCell username=row.getCell(0);
			XSSFCell password=row.getCell(1);
			testData[i][0]=username.getStringCellValue();
			testData[i][1]=password.getStringCellValue();
			
		}
		return testData;
		 
	}	

}
