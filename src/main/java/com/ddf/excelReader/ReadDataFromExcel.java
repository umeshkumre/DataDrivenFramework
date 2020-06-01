package com.ddf.excelReader;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ddf.base.BaseClass;
import com.ddf.pages.LoginPage;

public class ReadDataFromExcel  {
	
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
