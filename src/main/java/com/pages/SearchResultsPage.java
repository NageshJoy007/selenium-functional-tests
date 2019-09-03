package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	
	@FindBy (xpath="(//h2[@class='productitem--title']/a)[1]")
	public WebElement productTitle;
	
	WebDriver driver;
	
	public SearchResultsPage (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String getProductName(){
		return productTitle.getText();
	}
	
	
	
}
