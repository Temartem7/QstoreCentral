package com.qstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qstore.base.Base;

public class OrderConfirmationPage extends Base {

	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath = "//strong[@class='dark'][.='Your order on My Store is complete.']")
	WebElement confirmationMessage;
	
	public String validateConfirmMessage() { 
		String confirmationMsg=confirmationMessage.getText();
		return confirmationMsg;
	}
}
