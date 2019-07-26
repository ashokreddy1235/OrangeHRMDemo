/**
 * 
 */
package com.orangehrm.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
		config = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/OrangeHRM_"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void setup(String browser,String url)
	{
		//driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getUrl());
		driver = BrowserFactory.startApplication(driver, browser, url);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
		logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		
	}
	
	
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
}
