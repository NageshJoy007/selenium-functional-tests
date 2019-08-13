package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='customer_email']")
	WebElement txtUserName;
	@FindBy(xpath = "//*[@id='customer_password']")
	WebElement txtPassword;
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	WebElement btnSignin;

	public boolean loginAsUser(String userName, String password) {
		txtUserName.sendKeys(userName);
		txtPassword.sendKeys(password);
		btnSignin.click();
		return true;
	}

}
