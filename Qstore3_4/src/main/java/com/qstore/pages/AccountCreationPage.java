package com.qstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qstore.base.Base;

public class AccountCreationPage extends Base {

	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//h1[.='Create an account']")
	WebElement formTitle;

	public boolean verifyAccountCreatePage() {
		return formTitle.isDisplayed();
	}
}
