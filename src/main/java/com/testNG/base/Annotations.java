package com.testNG.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.selenium.base.SeleniumBase;
import com.utils.ExcelLibrary;



public class Annotations extends SeleniumBase{
	
	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return ExcelLibrary.readExcelData(excelFileName);
	}	
  
  @BeforeMethod
  public void beforeMethod() {
	startApp("chrome", "http://leaftaps.com/opentaps");
	node = test.createNode(testcaseName);
  }

  @AfterMethod
  public void afterMethod() {
	  close();
  }
}
