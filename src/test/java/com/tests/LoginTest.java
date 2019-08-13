package com.tests;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.PageObjectFactory;
import com.utils.BrowserUtil;
import com.utils.TestDataUtil;

public class LoginTest  extends BrowserUtil{
	
	SoftAssert sa = new SoftAssert();
	
	@Test (dataProvider="loginTest",dataProviderClass=TestDataUtil.class, groups={"loginTest","all","smoke"})
	public void loginTest(String url, String userName,String password) throws InterruptedException{
		PageObjectFactory pof = new PageObjectFactory(driver);
		sa.assertTrue(pof.homePage().accessUrl(url), "Access url");
		sa.assertTrue(pof.footerSection().clickOnAcceptCoockiePolicy(), "Accept Cookie Policy");
		sa.assertTrue(pof.headerSection().clickOnLoginOrRegister(), "Click on Login/Register");
		sa.assertTrue(pof.loginPage().loginAsUser(userName, password), "Login as a registered user");
		sa.assertTrue(pof.headerSection().isUserLoggedIn(), "Verify Logout link");
		sa.assertAll();
		
	}

}
