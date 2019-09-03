package com.pages;

import org.openqa.selenium.WebDriver;


public class PageObjectFactory {
	
	HeaderSection headerSection;
	FooterSection footerSection;
	HomePage homePage;
	LoginPage loginPage;
	SearchResultsPage searchResultsPage;
	
	WebDriver driver;
	public PageObjectFactory(WebDriver driver){
		this.driver= driver;
	}
	
	
	public HeaderSection headerSection(){
		if(null==headerSection){
			headerSection=new HeaderSection(driver);
		}return headerSection;
	}
	
	public FooterSection footerSection(){
		if(null==footerSection){
			footerSection=new FooterSection(driver);
		}return footerSection;
	}
	
	public HomePage homePage(){
		if(null==homePage){
			homePage=new HomePage(driver);
		}return homePage;
	}
	
	public LoginPage loginPage(){
		if(null==loginPage){
			loginPage=new LoginPage(driver);
		}return loginPage;
	}
	public SearchResultsPage searchResultsPage(){
		if(null==searchResultsPage){
			searchResultsPage=new SearchResultsPage(driver);
		}return searchResultsPage;
	}
	
	
}
