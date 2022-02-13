package runner;

import org.testng.annotations.BeforeTest;

import com.testNG.base.Annotations;

import cucumber.api.CucumberOptions;

@CucumberOptions(features="src/test/java/features/Test.feature",
				 glue={"com.steps"}, 
				 monochrome=true)

public class LoginUsingCucumber extends Annotations{
	
	
	
	@BeforeTest
	public void setData() {		
		testcaseName = "TC_001 - Login";
		testcaseDec = "Login to the application";
		author = "Dhandapani";
		category = "smoke";
	} 

}




