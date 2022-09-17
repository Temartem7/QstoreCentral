package com.qstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qstore.base.Base;

public class HomePage extends Base{

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath = "//span[.='My wishlists']")
	WebElement myWishList;

	@FindBy(xpath = "//span[.='Order history and details']")
	WebElement orderHistory;
	
	public boolean verifyMyWishList() {
		return myWishList.isDisplayed();
	}
	
	public boolean verifyOrderHistory() {
		return orderHistory.isDisplayed();
	}
	
	public String getCurURL() {
		String homePageURL=getDriver().getCurrentUrl();
		return homePageURL;
	}
}
