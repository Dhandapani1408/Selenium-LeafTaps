package com.steps;

import com.pages.HomePage;
import com.pages.LeadsPage;
import com.pages.LoginPage;
import com.testNG.base.Annotations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class Steps extends Annotations{

	static LoginPage login = new LoginPage();
	static HomePage homePage = new HomePage();
	static LeadsPage leadsPage = new LeadsPage();
	
	@Given("Enter the Username as (.*)$")
	public void enterUserName(String userName){
		login.enterUserName(userName);
	}
	
	@Given("Enter the password as (.*)$")
	public void enterPassword(String password){
		login.enterPassWord(password);
	}
	
	@Given("Click on the login button")
	public void clickLogin(){
		login.clickLogin().clickCRMSFA();
	}
	
	@When("Click on Leads menu")
	public void clickLeadsMenu()  {
		homePage.clickLeadsMenu();
	}

	@When("Click on Create Leads") 
	public void clickCreateLeads(){
		leadsPage.clickCreateLeads();
	}
	
	@When("Enter the LastName as (.*)$") 
	public void enterLastName(String fName) {
		leadsPage.enterLastName(fName);
	}
	
	@When("Enter the FirstName as (.*)$") 
	public void enterFirstName(String lName) {
		leadsPage.enterFirstName(lName);
	}
	
	@When("Enter the CompanyName as (.*)$") 
	public void enterCompanyName(String compNm) {
		leadsPage.enterCompanyName(compNm);
	}
	
	@When("Click on Submit for Create Leads") 
	public void clickSubmitCreateLeads(){
		leadsPage.clickSubmitForCreateLead();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@When("Validate lead is created" )
	public void validateCreatedLead(){
		leadsPage.validateCreatedCompanyName().validateCreatedFirstName().validateCreatedLastName();
	}
}
