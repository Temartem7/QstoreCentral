package com.qstore.cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qstore.base.Base;
import com.qstore.dataprovider.DataProviders;
import com.qstore.pages.AddToCartPage;
import com.qstore.pages.IndexPage;
import com.qstore.pages.SearchResultPage;
import com.qstore.utility.Log;

public class AddToCartPageTest extends Base{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		starting(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void ending() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression","Sanity"},dataProvider = "getProduct",dataProviderClass = DataProviders.class)
	public void addToCartTest(String productName) throws Throwable {
		Log.startTestCase("addToCartTest");
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct(productName);
		searchResultPage.changeView();
		addToCartPage=searchResultPage.moreDetails();
		boolean img = addToCartPage.verifyImage();
		Assert.assertTrue(img);
		addToCartPage.clickOnAddToCart();
		boolean msg = addToCartPage.verifyAddToCart();
		Assert.assertTrue(msg);
		addToCartPage.clickOnCheckout();
		Log.endTestCase("addToCartTest");
	}
}
