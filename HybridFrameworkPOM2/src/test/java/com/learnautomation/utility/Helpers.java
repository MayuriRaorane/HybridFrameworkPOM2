package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helpers {

	public static String CaptureScreenShot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String SreenshotPath = System.getProperty("user.dir") + "/Screenshots/OrangeCRM_" + getCurrentDateTime() + ".png";

		try {

			FileHandler.copy(src, new File(SreenshotPath));

		} catch (IOException e) {

			System.out.println("Unable to capture Screenshot");
		}

		return SreenshotPath;
	}

	public static String getCurrentDateTime() {

		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

		Date currentDate = new Date();
		return customFormat.format(currentDate);

	}

	public void handleFrames() {

	}

	public void hadleAlerts() {

	}
}
