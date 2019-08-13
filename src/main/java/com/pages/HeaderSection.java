package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderSection {

	@FindBy(xpath = "//a[contains(text(),'Login/Register')]")
	public WebElement linkLoginOrRegister;
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	public WebElement linkLogout;

	WebDriver driver;

	public HeaderSection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean clickOnLoginOrRegister() {
		linkLoginOrRegister.click();
		return true;
	}

	public boolean isUserLoggedIn() {
		return linkLogout.isDisplayed();
	}

}
