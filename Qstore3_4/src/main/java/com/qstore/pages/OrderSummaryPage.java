package com.qstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qstore.base.Base;

public class OrderSummaryPage extends Base{

	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//span[.='I confirm my order']")
	WebElement confirmOrder_Btn;

	public OrderConfirmationPage clickOnConfirmOrderBtn() {
		confirmOrder_Btn.click();
		return new OrderConfirmationPage();
	}
}
