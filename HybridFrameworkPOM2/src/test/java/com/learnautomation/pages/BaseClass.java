package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helpers;
import com.learnautomation.utility.configDataProvider;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public configDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {
		Reporter.log("Setting Done - Test can be started", true);

		excel = new ExcelDataProvider();
		config = new configDataProvider();

		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(
				System.getProperty("user.dir") + "/Reports/OrangeHRM_" + Helpers.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);

		Reporter.log("Test can be started", true);
	}

	@BeforeClass
	public void setup() {

		Reporter.log("Trying to start browser - geeting application ready", true);

		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());

		Reporter.log("Browser and application is up and running", true);
	}

	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);

		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException {
		Reporter.log("Test is about to end", true);
		
		if (result.getStatus() == ITestResult.FAILURE) {

			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helpers.CaptureScreenShot(driver)).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			logger.pass("Test Pass",
					MediaEntityBuilder.createScreenCaptureFromPath(Helpers.CaptureScreenShot(driver)).build());

		}
		report.flush();
		
		Reporter.log("Test completed>>> Reports Generated", true);
	}

}
