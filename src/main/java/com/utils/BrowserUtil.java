package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	public WebDriver driver;

	@Parameters({ "browserName" })
	@BeforeMethod(alwaysRun = true)
	public void openBroser(String browserName) {

		if (browserName.toLowerCase().startsWith("c")) {

			ChromeOptions options = new ChromeOptions();
		// 	below line of code to run your tests in headless mode
			 options.addArguments("headless");
			 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		} else if (browserName.toLowerCase().startsWith("f")) {
			
			FirefoxOptions options = new FirefoxOptions();
		// 	below line of code to run your tests in headless mode
			// options.addArguments("-headless");
			 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}
