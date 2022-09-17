package com.qstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qstore.base.Base;

public class ShippingPage extends Base{

	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="uniform-cgv")
	WebElement terms;
	
	@FindBy(xpath = "//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckout;
	
	public void checkTheTerms() {
		terms.click();
	}
	
	public PaymentPage clickOnProceedToCheckout() {
		proceedToCheckout.click();
		return new PaymentPage();
	}
}
