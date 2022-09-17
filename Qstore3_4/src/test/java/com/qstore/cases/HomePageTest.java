package com.qstore.cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qstore.base.Base;
import com.qstore.dataprovider.DataProviders;
import com.qstore.pages.HomePage;
import com.qstore.pages.IndexPage;
import com.qstore.pages.LoginPage;
import com.qstore.utility.Log;

public class HomePageTest extends Base{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		starting(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void ending() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials",dataProviderClass = DataProviders.class)
	public void wishListTest(String uname, String pswd) {
		Log.startTestCase("wishListTest");
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(uname,pswd,homePage);
		boolean res=homePage.verifyMyWishList();
		Assert.assertTrue(res);
		Log.endTestCase("wishListTest");
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials",dataProviderClass = DataProviders.class)
	public void orderHistoryandDetailsTest(String uname, String pswd) {
		Log.startTestCase("orderHistoryandDetailsTest");
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(uname,pswd,homePage);
		boolean res=homePage.verifyOrderHistory();
		Assert.assertTrue(res);
		Log.endTestCase("orderHistoryandDetailsTest");
	}
}
