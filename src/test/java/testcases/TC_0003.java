package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
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
	public void loginAndFind(String sNo,String testDesc,String uName, String pwd) {
		node = test.createNode(sNo+" "+testDesc);
		
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		
		new LoginPage()
		.enterUserName(uName)
		.enterPassWord(pwd) 
		.clickLogin().clickCRMSFA().clickLeadsMenu().clickCreateLeads()
		.enterCompanyName(firstName).enterFirstName(firstName).enterLastName(lastName).clickSubmitForCreateLead()
		.validateCreatedCompanyName().validateCreatedFirstName().validateCreatedLastName()
		.clickFindLeads().findLeadsByNameAndId().validateFirstRowResults();
		
	}

}
