package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver lDriver) {
		
		this.driver =lDriver;
		
		}
	
	
	@FindBy(name="username")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement upass;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;
	
	//new code added
	public void loginRSA(String userEmail, String userPass) throws InterruptedException {
		try{
			Thread.sleep(2000);	
		}catch(InterruptedException e)
		{
			
		}
		
		uname.sendKeys(userEmail);
		upass.sendKeys(userPass);
		loginButton.click();
	}
	
	
	
	
}
