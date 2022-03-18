package testcases;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.testNG.base.Annotations;

public class TC_0002_Test extends Annotations{

	@BeforeTest
	public void beforeTest() {
		testcaseName = "TC002_CreateLead";
		testcaseDec = "Create Lead and Validate wheather lead is created";
		author = "dhandapani";
		category = "sanity";
		excelFileName = "TC001";
		sheetName = "Create";
	}
	
	@Test(dataProvider="fetchData") 
	public void createLead(String uName, String pwd,String compName,String fName,String lName) {
		new LoginPage()
		.enterUserName(uName)
		.enterPassWord(pwd) 
		.clickLogin().clickCRMSFA().clickLeadsMenu().clickCreateLeads()
		.enterCompanyName(compName).enterFirstName(fName).enterLastName(lName).clickSubmitForCreateLead()
		.validateCreatedCompanyName().validateCreatedFirstName().validateCreatedLastName();
		
	}

}
