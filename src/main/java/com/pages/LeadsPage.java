package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testNG.base.Annotations;


public class LeadsPage extends Annotations{

	public LeadsPage() {
		PageFactory.initElements(driver, this); 
	}

	@FindBy(xpath="//a[text()='Create Lead']")
	WebElement createLead;
	
	@FindBy(xpath="//a[text()='My Leads']")
	WebElement myLeads;
	
	@FindBy(xpath="//a[text()='Find Leads']")
	WebElement findLeads;
	
	@FindBy(xpath="//a[text()='Merge Leads']")
	WebElement mergeLeads;
	
	@FindBy(xpath="//a[text()='Upload Leads']")
	WebElement uploadLeads;
	
	@FindBy(xpath="//a[text()='Request Catalog ']")
	WebElement requestCatalog;
	
	@FindBy(xpath="//*[@id='createLeadForm_companyName']")
	WebElement createLeadForm_companyName;
	
	@FindBy(xpath="//*[@id='createLeadForm_firstName']")
	WebElement createLeadForm_firstName;
	
	@FindBy(xpath="//*[@id='createLeadForm_lastName']")
	WebElement createLeadForm_lastName;
	
	@FindBy(xpath="//*[@id='createLeadForm_dataSourceId']")
	WebElement createLeadForm_dataSourceId;
	
	@FindBy(xpath="//*[@id='createLeadForm_generalProfTitle']")
	WebElement createLeadForm_generalProfTitle;
	
	@FindBy(xpath="//*[@id='createLeadForm_industryEnumId']")
	WebElement createLeadForm_industryEnumId;
	
	@FindBy(xpath="//*[@name='submitButton']")
	WebElement createLeadsSubmitButton;
	
	@FindBy(xpath="//*[@id='createLeadForm_description']")
	WebElement createLeadForm_description;
	
	@FindBy(xpath="//*[@id='createLeadForm_birthDate']")
	WebElement createLeadForm_birthDate;
	
	@FindBy(xpath="//*[@id='createLeadForm_departmentName']")
	WebElement createLeadForm_departmentName;
	
	@FindBy(xpath="//*[@id='createLeadForm_generalToName']")
	WebElement createLeadForm_generalToName;

	@FindBy(xpath="//*[@id='viewLead_companyName_sp']")
	WebElement viewLead_companyName_sp;
	
	@FindBy(xpath="//*[@id='viewLead_firstName_sp']")
	WebElement viewLead_firstName_sp;
	
	@FindBy(xpath="//*[@id='viewLead_lastName_sp']")
	WebElement viewLead_lastName_sp;
	
	@FindBy(xpath="//*[@id='viewLead_statusId_sp']")
	WebElement viewLead_statusId_sp;
	
	
	static String firstName=null;
	static String lastName=null;
	static String companyName=null;
	static String leadID=null;
	public LeadsPage clickCreateLeads() {
		click(createLead);
		return this;
	}
	
	public LeadsPage enterCompanyName(String companyNm) {
		companyName = companyNm;
		clearAndType(createLeadForm_companyName, companyNm);
		return this;
	}
	
	public LeadsPage enterFirstName(String firstNm) {
		firstName = firstNm;
		clearAndType(createLeadForm_firstName, firstNm);
		return this;
	}
	
	public LeadsPage enterLastName(String lastNm) {
		lastName = lastNm;
		clearAndType(createLeadForm_lastName, lastNm);
		return this;
	}
	
	public LeadsPage clickSubmitForCreateLead() {
		click(createLeadsSubmitButton);
		return this;
	}
	
	public LeadsPage validateCreatedCompanyName() {
		verifyPartialText(viewLead_companyName_sp, companyName);
		try {
			String[] split = viewLead_companyName_sp.getText().split(" ");
			leadID = split[split.length-1].replaceAll("[^a-zA-Z0-9]", "");
		}catch(Exception e) {
			reportStep("Unable to get LeadId for created Lead!!!", "fail");
			e.printStackTrace();
			throw new RuntimeException();	
		}
		
		return this;
	}
	
	public LeadsPage validateCreatedFirstName() {
		verifyPartialText(viewLead_firstName_sp, firstName);
		return this;
	}
	
	public LeadsPage validateCreatedLastName() {
		verifyPartialText(viewLead_lastName_sp, lastName);
		return this;
	}
	
	
}
