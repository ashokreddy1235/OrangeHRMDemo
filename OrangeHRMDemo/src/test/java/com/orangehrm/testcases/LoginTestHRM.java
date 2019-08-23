/**
 * 
 */
package com.orangehrm.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.pages.BaseClass;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utility.BrowserFactory;
import com.orangehrm.utility.ExcelDataProvider;
import com.orangehrm.utility.Helper;

/**
 * @author ashokp
 *
 */
public class LoginTestHRM extends BaseClass
{
	@DataProvider(name="userCredentials")
	public static Object[][] getData()
	{
		return ExcelDataProvider.readExcelData();
	}
	
	
	
	@Test(dataProvider="userCredentials")
	public void loginApp(String username,String Password,String expValue)
	{
		logger = report.createTest("Login to HRM");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		loginPage.loginToHRM(username, Password,expValue);
		logger.pass("Login Success");
		
	}

}
