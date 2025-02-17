package com.learnautomation.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helpers;

public class loginTestCRM extends BaseClass {

	@Test(priority = 1)
	public void LoginApp() throws InterruptedException, IOException {

		logger = report.createTest("Login to OrangeHRM");

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");

		loginpage.loginRSA(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));

		logger.pass("Login Successfull");

	}
}
