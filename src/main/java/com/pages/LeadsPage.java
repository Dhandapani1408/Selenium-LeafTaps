package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath="//*[@id='findLeads']//child::div//*[text()='Name and ID']")
	WebElement findLeads_NameAndID;
	
	@FindBy(xpath="//*[@id='findLeads']//child::div//input[@name='id']")
	WebElement findLeads_Input_LeadId;
	
	@FindBy(xpath="//*[@id='findLeads']//child::div//input[@name='firstName']")
	WebElement findLeads_Input_firstName;
	
	@FindBy(xpath="//*[@id='findLeads']//child::div//input[@name='lastName']")
	WebElement findLeads_Input_lastName;
	
	@FindBy(xpath="//*[@id='findLeads']//child::div//input[@name='companyName']")
	WebElement findLeads_Input_companyName;
	
	@FindBy(xpath="//*[@id='findLeads']//child::div//*[text()='Find Leads']")
	WebElement findLeads_Button;
	
	
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
	
	public LeadsPage clickFindLeads() {
		click(findLeads);
		return this;
	}
	
	public LeadsPage findLeadsByNameAndId() {
		click(findLeads_NameAndID);
		clearAndType(findLeads_Input_LeadId, leadID);
		clearAndType(findLeads_Input_firstName, firstName);
		clearAndType(findLeads_Input_lastName, lastName);
		clearAndType(findLeads_Input_companyName, companyName);
		click(findLeads_Button);
		return this;
	} 
	
	public void validateResultByFindLeads() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='findLeads']//child::div//*[text()='Lead List']/following::a[text()='"+leadID+"']")));
		WebElement firstResultLeadId = locateElement("xpath", "//*[@id='findLeads']//child::div//*[text()='Lead List']/following::a[text()='"+leadID+"']");
		verifyExactText(firstResultLeadId, leadID);
	}
	
	public void validateFirstRowResults() {
		By xpathFirstLead = By.xpath("((//*[@class='x-grid3']//table)[2]//tr//td//child::a)[1]");
		By xpathFirstFname = By.xpath("((//*[@class='x-grid3']//table)[2]//tr//td//child::a)[3]");
		By xpathFirstLname = By.xpath("((//*[@class='x-grid3']//table)[2]//tr//td//child::a)[4]");
		By xpathFirstCompanyName = By.xpath("((//*[@class='x-grid3']//table)[2]//tr//td//child::a)[5]");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(xpathFirstLead));
		WebElement eleFirstLead = driver.findElement(xpathFirstLead);
		WebElement eleFirstFname = driver.findElement(xpathFirstFname);
		WebElement eleFirstLname = driver.findElement(xpathFirstLname);
		WebElement eleFirstCompanyName = driver.findElement(xpathFirstCompanyName);
		verifyExactText(eleFirstLead, leadID);
		verifyExactText(eleFirstFname, firstName);
		verifyExactText(eleFirstLname, lastName);
		verifyExactText(eleFirstCompanyName, companyName);
		
	}
	
}
