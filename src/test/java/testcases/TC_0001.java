package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.testNG.base.Annotations;

public class TC_0001 extends Annotations{


	
	@BeforeTest
	public void setData() {
		testcaseName = "TC001_LoginAndLogout";
		testcaseDec = "Login into leaftaps";
		author = "dhandapani";
		category = "sanity";
		excelFileName = "TC001";
		sheetName = "Login";
	} 

	@Test(dataProvider="fetchData") 
	public void loginAndLogout(String uName, String pwd) {
		new LoginPage()
		.enterUserName(uName)
		.enterPassWord(pwd) 
		.clickLogin()
		.clickLogout();
		
	}
	


}
