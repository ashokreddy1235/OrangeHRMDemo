/**
 * 
 */
package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author ashokp
 *
 */
public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(name="txtUsername") WebElement username;
	@FindBy(name="txtPassword") WebElement password;
	@FindBy(name="Submit") WebElement submit;
	@FindBy(xpath="//span[@id='spanMessage']") WebElement spanMessage;
	
	public void loginToHRM(String appUserName, String appPassword, String expValue)
	{
		username.sendKeys(appUserName);
		password.sendKeys(appPassword);
		submit.click();
		String actValue = spanMessage.getText();
		System.out.println("Span Message:"+actValue);
		
		
	}
	
	
	

}
