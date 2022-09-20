package com.qstore.cases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qstore.base.Base;
import com.qstore.dataprovider.DataProviders;
import com.qstore.pages.AccountCreationPage;
import com.qstore.pages.HomePage;
import com.qstore.pages.IndexPage;
import com.qstore.pages.LoginPage;
import com.qstore.utility.Log;

public class AccountCreationPageTest extends Base{
	
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
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
	
	@Test(groups = "Sanity",dataProvider = "email",dataProviderClass = DataProviders.class)
	public void verifyAccountCreationTest(String email) {
		Log.startTestCase("verifyCreateAccountPageTest");
		indexPage = new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createNewAccount(email);
		boolean res = accountCreationPage.verifyAccountCreatePage();
		Assert.assertTrue(res);
		Log.endTestCase("verifyCreateAccountPageTest");
	}
	
	@Test(groups = "Regression",dataProvider = "newAccountDetailsData",dataProviderClass = DataProviders.class)
	public void createAccountTest(HashMap<String, String> hashMapValue) throws Throwable{
		Log.startTestCase("createAccountTest");
		indexPage = new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createNewAccount(hashMapValue.get("Email"));
		accountCreationPage.createAccount(
				hashMapValue.get("Gender"), 
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Company"),
				hashMapValue.get("Address"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("Zipcode"),
				hashMapValue.get("Country"),
				hashMapValue.get("MobilePhone"));
		homePage=accountCreationPage.verifyRegistrationPage();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account",homePage.getCurURL());
		Log.endTestCase("createAccountTest");
	}
}
