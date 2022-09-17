package com.qstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qstore.base.Base;

public class OrderPage extends Base{

	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//span[@id='product_price_1_1_0']")
	WebElement unitPrice;

	@FindBy(id = "total_price")
	WebElement totalPrice;

	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement proceedToCheckout;
	
	public double getUnitPrice() {
		String unitPrice1 = unitPrice.getText();
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", ""); // replace $ sign with blank
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice / 100; // returns 1651/100 = 16.51
	}

	public double getTotalPrice() {
		String totalPrice1 = unitPrice.getText();
		String total = totalPrice1.replaceAll("[^a-zA-Z0-9]", ""); // replace $ sign with blank
		double finalTotalPrice = Double.parseDouble(total);
		return finalTotalPrice / 100; // returns 1651/100 = 16.51
	}

	public LoginPage clickOnCheckout() {
		proceedToCheckout.click();
		return new LoginPage();
	}
}
