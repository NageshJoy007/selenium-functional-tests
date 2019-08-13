package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterSection {
	
	@FindBy (xpath="//div[@class='optanon-alert-box-bg']//button[contains(text(),'Accept')]")
	public WebElement linkAcceptCookies;
	
	WebDriver driver;
	public FooterSection (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickOnAcceptCoockiePolicy() throws InterruptedException{
		Thread.sleep(2000);
		linkAcceptCookies.click();
		Thread.sleep(2000);
		return true;
	}
}
