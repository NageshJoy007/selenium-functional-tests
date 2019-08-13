package com.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TakeScreenshotListner implements ITestListener {
	// This method will execute before starting of Test suite.

	public void onStart(ITestContext tr) {

	}

	// This method will execute, Once the Test suite is finished.
	public void onFinish(ITestContext tr) {
	
	}

	// This method will execute only when the test is pass.
	public void onTestSuccess(ITestResult tr) {
		
		// If screenShotOnPass = yes, call captureScreenShot.
		/*
		 * if(BrowserConf.Param.getProperty("screenShotOnPass").equalsIgnoreCase
		 * ("yes")) { captureScreenShot(tr,"pass"); }
		 */
	}

	// This method will execute only on the event of fail test.
	public void onTestFailure(ITestResult tr) {
		// If screenShotOnFail = yes, call captureScreenShot.
		captureScreenShot(tr, "fail");
	}

	// This method will execute before the main test start (@Test)
	public void onTestStart(ITestResult tr) {

	}

	// This method will execute only if any of the main test(@Test) get skipped
	public void onTestSkipped(ITestResult tr) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
	}
	
	
	// Function to capture screenshot.
	public void captureScreenShot(ITestResult result, String status) {
		String destDir = "";
		String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "."
				+ result.getMethod().getMethodName();
		// To capture screenshot.
		Object currentClass = result.getInstance();
		if (currentClass instanceof BrowserUtil) {
			WebDriver driver = ((BrowserUtil) currentClass).driver;
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
			// If status = fail then set folder name "screenshots/Failures"
			if (status.equalsIgnoreCase("fail")) {
				destDir = "SS_Failure";
			}
			// If status = pass then set folder name "screenshots/Success"
			else if (status.equalsIgnoreCase("pass")) {
				destDir = "SS_Success";
			}

			// To create folder to store screenshots
			new File(destDir).mkdirs();
			// Set file name with combination of test class name + date time.
			String destFile = passfailMethod + "-" + dateFormat.format(new Date()) + ".png";

			try {
				// Store file at destination folder location
				String fullPath;
				//FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
				FileHandler.copy(scrFile, new File(destDir + "/" + destFile));
				if (System.getProperty("os.name").toLowerCase().startsWith("mac")) {
					System.out.println("Taking screenshot on mac");
					fullPath = (System.getProperty("user.dir") + "/\\" + destDir + "/" + destFile).replace("/",
							File.separator);
					Reporter.log("<a href=" + "file:///" + fullPath + " >" + "ScreenshotLink" + "</a>");

				} else if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
					fullPath = (System.getProperty("user.dir") + "/" + destDir + "/" + destFile).replace("/",
							File.separator);
					Reporter.log("<a href=" + "file://" + fullPath + " >" + "ScreenshotLink" + "</a>");
				}
				// org.testng.Reporter.log("<a href="+fullPath+"> <img
				// src="+fullPath+" hight='650' width='850'/> </a>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
