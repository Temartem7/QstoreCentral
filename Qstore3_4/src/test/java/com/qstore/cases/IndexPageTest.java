package com.qstore.cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qstore.base.Base;
import com.qstore.pages.IndexPage;
import com.qstore.utility.Log;

public class IndexPageTest extends Base{
	
	IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		starting(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void ending() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() {
		Log.startTestCase("verifyLogo");
		indexPage=new IndexPage();
		boolean res=indexPage.verifyLogo();
		Assert.assertTrue(res);
		Log.endTestCase("verifyLogo");
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String actualTitle=indexPage.getStoreTitle();
		Assert.assertEquals(actualTitle, "My Store");
		Log.endTestCase("verifyTitle");
	}
}
