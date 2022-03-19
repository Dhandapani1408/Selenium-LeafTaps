package com.testNG.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.selenium.base.SeleniumBase;
import com.utils.ExcelLibrary;



public class Annotations extends SeleniumBase{
	
	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws Exception {
		return ExcelLibrary.readExcelData(excelFileName,sheetName);
	}	
  
  @BeforeMethod
  public void beforeMethod() {
	startApp("chrome", "http://leaftaps.com/opentaps");
	
  }

  @AfterMethod
  public void afterMethod() {
	  close();
  }
}
