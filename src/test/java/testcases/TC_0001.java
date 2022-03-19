package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.testNG.base.Annotations;

public class TC_0001 extends Annotations{

	
	@BeforeTest
	public void setData() {
		testcaseName = "LoginAndLogout";
		author = "dhandapani";
		category = "sanity";
		excelFileName = "TC001";
		sheetName = "Login";
		
	} 

	@Test(dataProvider="fetchData") 
	public void loginAndLogout(String sNo,String testDesc,String uName, String pwd) {
		node = test.createNode(sNo+" "+testDesc);
		
		new LoginPage()
		.enterUserName(uName)
		.enterPassWord(pwd) 
		.clickLogin()
		.clickLogout();
		
	}
	


}
