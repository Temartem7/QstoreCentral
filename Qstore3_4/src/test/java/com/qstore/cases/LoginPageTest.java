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

public class LoginPageTest extends Base {

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

	@Test(dataProvider = "credentials",dataProviderClass=DataProviders.class, groups = {"Smoke","Sanity"})
	public void loginTest(String uname, String pswd) {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Enter Email and Password");
		homePage = loginPage.login(uname, pswd,homePage);
		String actualURL = homePage.getCurURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login Successful");
		Log.endTestCase("loginTest");
	}
}
