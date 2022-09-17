package com.qstore.cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qstore.base.Base;
import com.qstore.dataprovider.DataProviders;
import com.qstore.pages.AddToCartPage;
import com.qstore.pages.AddressPage;
import com.qstore.pages.IndexPage;
import com.qstore.pages.LoginPage;
import com.qstore.pages.OrderConfirmationPage;
import com.qstore.pages.OrderPage;
import com.qstore.pages.OrderSummaryPage;
import com.qstore.pages.PaymentPage;
import com.qstore.pages.SearchResultPage;
import com.qstore.pages.ShippingPage;
import com.qstore.utility.Log;

public class EndToEndTest extends Base{

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;

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
	public void endToEndTest(String productName) throws Throwable {
		Log.startTestCase("endToEndTest");
		indexPage=new IndexPage();
		searchResultPage = indexPage.searchProduct(productName);
		searchResultPage.changeView();
		addToCartPage=searchResultPage.moreDetails();
		boolean img = addToCartPage.verifyImage();
		Assert.assertTrue(img);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckout();
		loginPage=orderPage.clickOnCheckout();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"),addressPage);
		shippingPage=addressPage.clickOnCheckout();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckout();
		orderSummaryPage=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummaryPage.clickOnConfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMessage= "Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMessage);
		Log.endTestCase("endToEndTest");
	}
}
