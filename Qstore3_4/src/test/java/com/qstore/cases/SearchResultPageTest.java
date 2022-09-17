package com.qstore.cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qstore.base.Base;
import com.qstore.dataprovider.DataProviders;
import com.qstore.pages.IndexPage;
import com.qstore.pages.SearchResultPage;
import com.qstore.utility.Log;

public class SearchResultPageTest extends Base{

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		starting(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void ending() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke",dataProvider = "searchProduct",dataProviderClass = DataProviders.class)
	public void productAvailabilityTest(String productName) {
		Log.startTestCase("productAvailabilityTest");
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct(productName);
		boolean res = searchResultPage.isProductAvailable();
		Assert.assertTrue(res);
		Log.endTestCase("productAvailabilityTest");
	}
}
