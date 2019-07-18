/**
 * 
 */
package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.orangehrm.utility.BrowserFactory;
import com.orangehrm.utility.ConfigDataProvider;
import com.orangehrm.utility.Helper;

/**
 * @author ashokp
 *
 */
public class BaseClass 
{
	public WebDriver driver;
	public ConfigDataProvider config;
	
	@BeforeSuite
	public void setupSuite()
	{
		config = new ConfigDataProvider();
	}
	
	@BeforeClass
	public void setup()
	{
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getUrl());
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
		Helper.captureScreenshot(driver);
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
		Helper.captureScreenshot(driver);
		}
		
		
		
	}
	
	
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}

}
