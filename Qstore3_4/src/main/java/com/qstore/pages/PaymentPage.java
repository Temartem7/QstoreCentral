package com.qstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qstore.base.Base;

public class PaymentPage extends Base{

	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement payByCheckMethod;
	
	public OrderSummaryPage clickOnPaymentMethod() {
		bankWireMethod.click();
		return new OrderSummaryPage();
	}
}
