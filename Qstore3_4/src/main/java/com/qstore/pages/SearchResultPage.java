package com.qstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qstore.base.Base;

public class SearchResultPage extends Base{

	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement productResult;
	
	@FindBy(xpath="//span[normalize-space()='Add to cart']")
	WebElement addToCart_Btn;
	
	@FindBy(xpath="//span[@class='available-now']")
	WebElement inStock_Btn;
	
	@FindBy(xpath="//i[@class='icon-th-list']")
	WebElement listView_Btn;
	
	@FindBy(xpath="//span[normalize-space()='More']")
	WebElement moreDetails_Btn;
	
	public AddToCartPage clickOnProduct() {
		productResult.click();
		return new AddToCartPage();
	}
	
	public boolean isProductAvailable() {
		return productResult.isDisplayed();
	}
	
	public void changeView() {
		listView_Btn.click();
	}
	
	public AddToCartPage moreDetails() {
		moreDetails_Btn.click();
		return new AddToCartPage();
	}
	
	public void clickOnAddToCartBtn() {
		addToCart_Btn.click();
	}
}
