package com.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.PageObjectFactory;
import com.utils.BrowserUtil;
import com.utils.TestDataUtil;

public class ProductSearchTest  extends BrowserUtil{
	
	SoftAssert sa = new SoftAssert();
	
	@Test (dataProvider="productSearchTest",dataProviderClass=TestDataUtil.class, groups={"productSearchTest","all","smoke"})
	public void productSearchTest(String url, String searchString, String productTitle) throws InterruptedException{
		PageObjectFactory pof = new PageObjectFactory(driver);
		sa.assertTrue(pof.homePage().accessUrl(url), "Access url");
		sa.assertTrue(pof.footerSection().clickOnAcceptCoockiePolicy(), "Accept Cookie Policy");
		sa.assertTrue(pof.headerSection().searchForProduct(searchString), "Search a product");
		sa.assertTrue(pof.headerSection().getActiveBreadCrumName().toLowerCase().contains(searchString.toLowerCase()), "Is searchString in Active Breadcrumb");
		sa.assertEquals(pof.searchResultsPage().getProductName(), productTitle, "Is search result contains right product");
		sa.assertAll();
	}
	
}
