package runner;

import org.testng.annotations.BeforeTest;

import com.testNG.base.Annotations;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/Login.Feature", 
				 glue = { "com.steps" }, 
				 monochrome = true)

public class RunnerClass extends Annotations {

	@BeforeTest
	public void setData() {
		testcaseName = "001 - Login";
		testcaseDec = "Login to the application";
		author = "Dhandapani";
		category = "smoke";
	}

}
