package com.qstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qstore.base.Base;

public class AddToCartPage extends Base{

	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "quantity_wanted")
	WebElement quantity;

	@FindBy(id = "bigpic")
	WebElement productImage;

	@FindBy(id = "group_1")
	WebElement size;

	@FindBy(xpath = "//span[.='Add to cart']")
	WebElement addToCart_Btn;
	
	@FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement addToCartMessage;

	@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
	WebElement proceedToCheckout_Btn;
	
	public void enterQuantity(String Quantity) {
		quantity.click();
		quantity.clear();
		quantity.sendKeys(Quantity);
	}
	
	public void selectSize(String Size) {
		size.click();
		Select select = new Select(size);
		select.selectByVisibleText(Size);
	}

	public void clickOnAddToCart() throws Throwable{
		addToCart_Btn.click();
		Thread.sleep(3000);
	}
	
	public boolean verifyAddToCart() {
		return addToCartMessage.isDisplayed();
	}

	public boolean verifyImage() {
		return productImage.isDisplayed();
	}
	
	public OrderPage clickOnCheckout() {
		proceedToCheckout_Btn.click();
		return new OrderPage();
	}
}
