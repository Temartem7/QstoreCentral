package com.qstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qstore.base.Base;

public class LoginPage extends Base{

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "email")
	public WebElement email_Field;

	@FindBy(id = "passwd")
	public WebElement password_Field;

	@FindBy(id = "SubmitLogin")
	public WebElement signIn_Btn;

	@FindBy(id = "email_create")
	WebElement emailForNewAccount;

	@FindBy(id = "SubmitCreate")
	WebElement createNewAccount_Btn;
	
	public HomePage login(String username, String password, HomePage homePage) {
		email_Field.sendKeys(username);
		password_Field.sendKeys(password);
		signIn_Btn.click();
		homePage = new HomePage();
		return homePage;
	}
	
	public AddressPage login1(String username, String password,AddressPage addressPage) {
		email_Field.sendKeys(username);
		password_Field.sendKeys(password);
		signIn_Btn.click();
		addressPage= new AddressPage();
		return addressPage;
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		emailForNewAccount.sendKeys(newEmail);
		createNewAccount_Btn.click();
		return new AccountCreationPage();
	}
}
