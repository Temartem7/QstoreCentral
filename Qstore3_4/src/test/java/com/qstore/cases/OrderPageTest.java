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
import com.qstore.pages.OrderPage;
import com.qstore.pages.SearchResultPage;
import com.qstore.utility.Log;

public class OrderPageTest extends Base{

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		starting(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void ending() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression",dataProvider = "getProduct",dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String productName) throws Throwable {
		Log.startTestCase("verifyTotalPrice");
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(productName);
		searchResultPage.changeView();
		addToCartPage=searchResultPage.moreDetails();
		boolean img = addToCartPage.verifyImage();
		Assert.assertTrue(img);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckout();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
//		Double totalExpectedPrice=(unitPrice*2)+2;
		Double totalExpectedPrice=(unitPrice);
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		Log.endTestCase("verifyTotalPrice");		
	}
}
