package com.steps;

import com.pages.LoginPage;
import com.testNG.base.Annotations;

import cucumber.api.java.en.Given;


public class Steps extends Annotations{

	LoginPage login = new LoginPage();
	
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
		login.clickLogin();
	}
	
	
}
