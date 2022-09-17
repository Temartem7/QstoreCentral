package com.qstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qstore.base.Base;

public class IndexPage extends Base {

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[@class='login']")
	WebElement signIn_Btn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement storeLogo;

	@FindBy(id = "search_query_top")
	WebElement search_Field;

	@FindBy(name = "submit_search")
	WebElement search_Btn;

	public LoginPage clickOnSignIn() {
		signIn_Btn.click();
		return new LoginPage();
	}

	public boolean verifyLogo() {
		return storeLogo.isDisplayed();
	}

	public String getStoreTitle() {
		String storeTitle = getDriver().getTitle();
		return storeTitle;
	}

	public SearchResultPage searchProduct(String productName) {
		search_Field.sendKeys(productName);
		search_Btn.click();
		return new SearchResultPage();
	}
}
