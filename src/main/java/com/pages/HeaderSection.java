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
	@FindBy (xpath="//input[@name='q']")
	public WebElement txtSearchBox;
	@FindBy (xpath="(//button[@aria-label='Search' and @type='submit'])[1]")
	public WebElement btnSearch;
	@FindBy (xpath="//nav[@class='breadcrumbs-container']/span[not (contains(@class,'breadcrumbs'))]")
	public WebElement breadcrumbActive;

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
	
	public boolean searchForProduct(String searchString) throws InterruptedException{
		txtSearchBox.click();
		txtSearchBox.sendKeys(searchString);
		btnSearch.click();
		//txtSearchBox.sendKeys(Keys.ENTER);
		return true;
	}
	
	public String getActiveBreadCrumName(){
		return breadcrumbActive.getText();
	}

}
