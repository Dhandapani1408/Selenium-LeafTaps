package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testNG.base.Annotations;

public class HomePage extends Annotations{
	
	public HomePage() {
		PageFactory.initElements(driver, this); 
	}
	@CacheLookup
	@FindBy(how=How.XPATH, using="//a[contains(text(),'CRM/SFA')]") 
	WebElement eleCRM;
	
	@FindBy(how=How.XPATH, using="//a[text()='Leads']") 
	WebElement eleMenuLeads;
	
	@FindBy(how=How.XPATH, using="//a[text()='Contacts']") 
	WebElement eleMenuContacts;
	
	@FindBy(how=How.XPATH, using="//a[text()='Accounts']") 
	WebElement eleMenuAccounts;
	
	@FindBy(how=How.XPATH, using="//a[text()='opentaps']") 
	WebElement eleMenuOpentaps;
	
	@FindBy(how=How.XPATH, using="//a[text()='Create Lead']") 
	WebElement eleCreate_LeadShortCut;
	
	@FindBy(how=How.XPATH, using="//a[text()='Create Account']") 
	WebElement eleCreate_AccountShortCut;
	
	@FindBy(how=How.XPATH, using="//a[text()='Create Contact']") 
	WebElement eleCreate_ContactShortCut;
	
	
	public LoginPage clickLogout() {
		WebElement eleLogout = locateElement("class", "decorativeSubmit");
		click(eleLogout);  
		return new LoginPage();
	}
	
	public LeadsPage clickLeadsMenu() {
		click(eleMenuLeads);  
		return new LeadsPage();
	}
	
	public LeadsPage clickCreateLeadsShortCut() {
		click(eleCreate_LeadShortCut);  
		return new LeadsPage();
	}
	
	public HomePage clickCRMSFA() {
		click(eleCRM);  
		return this;
	}
	
	public AccountsPage clickCreateAccountShortCut() {
		click(eleCreate_AccountShortCut);  
		return new AccountsPage();
	}
	
	public AccountsPage clickMenuAccounts() {
		click(eleMenuAccounts);  
		return new AccountsPage();
	}
}
