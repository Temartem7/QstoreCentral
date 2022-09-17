package com.qstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qstore.base.Base;

public class AddressPage extends Base {

	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//span[.='Proceed to checkout']")
	WebElement proceedToCheckout;

	public ShippingPage clickOnCheckout() {
		proceedToCheckout.click();
		return new ShippingPage();
	}
}
