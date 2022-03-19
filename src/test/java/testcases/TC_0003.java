package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.testNG.base.Annotations;

public class TC_0003 extends Annotations{

	@BeforeTest
	public void setData() {
		testcaseName = "TC003_FindLead";
		testcaseDec = "Login into leaftapsa and Find Leads";
		author = "dhandapani";
		category = "sanity";
		excelFileName = "TC001";
		sheetName = "Find";
	} 

	@Test(dataProvider="fetchData") 
	public void loginAndFind(String uName, String pwd,String compName,String fName,String lName) {
		new LoginPage()
		.enterUserName(uName)
		.enterPassWord(pwd) 
		.clickLogin().clickCRMSFA().clickLeadsMenu().clickCreateLeads()
		.enterCompanyName(compName).enterFirstName(fName).enterLastName(lName).clickSubmitForCreateLead()
		.validateCreatedCompanyName().validateCreatedFirstName().validateCreatedLastName()
		.clickFindLeads().findLeadsByNameAndId().validateFirstRowResults();
		
	}

}
