package com.qstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qstore.base.Base;

public class AccountCreationPage extends Base {

	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//h1[.='Create an account']")
	WebElement formTitle;
	
	@FindBy(id = "uniform-id_gender1")
	WebElement mr;
	
	@FindBy(id = "id_gender2")
	WebElement mrs;

	@FindBy(id = "customer_firstname")
	WebElement firstName;

	@FindBy(id = "customer_lastname")
	 WebElement lastName;

	@FindBy(id = "passwd")
	WebElement passWord;

	@FindBy(name = "days")
	WebElement days;

	@FindBy(name = "months")
	WebElement months;

	@FindBy(name = "years")
	WebElement years;

	@FindBy(name = "firstname")
	WebElement customerNirstName;

	@FindBy(name = "lastname")
	WebElement customerLastName;

	@FindBy(name = "company")
	WebElement companyName;

	@FindBy(name = "address1")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "id_state")
	WebElement state;

	@FindBy(name = "postcode")
	WebElement postCode;

	@FindBy(name = "id_country")
	WebElement country;

	@FindBy(name = "phone")
	WebElement phone;

	@FindBy(name = "phone_mobile")
	WebElement mobile;

	@FindBy(name = "alias")
	WebElement ref;

	@FindBy(name = "submitAccount")
	WebElement registerBtn;
	

	public boolean verifyAccountCreatePage() {
		return formTitle.isDisplayed();
	}
	
	Select selectDays = new Select(days);
	Select selectMonths = new Select(months);
	Select selectYears = new Select(years);
	Select selectState = new Select(state);
	Select selectCountry = new Select(country);
	
	public void createAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year,
			String comPany, 
			String addr, 
			String cityString, 
			String stateName, 
			String zip, 
			String countryName,
			String mobilePhone) throws Throwable {
		
		if(gender.equalsIgnoreCase("Mr")) {
			mr.click();
		} else {
			mrs.click();
		}
		
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		firstName.sendKeys(pswd);
		selectDays.selectByValue(day);
		selectMonths.selectByValue(month);
		selectYears.selectByValue(year);
		selectState.selectByVisibleText(stateName);
		selectCountry.selectByVisibleText(countryName);
		companyName.sendKeys(comPany);
		address.sendKeys(addr);
		city.sendKeys(cityString);
		postCode.sendKeys(zip);
		mobile.sendKeys(mobilePhone);
	}
	
	public HomePage verifyRegistrationPage() {
		registerBtn.click();
		return new HomePage();
	}
	
	public boolean verifyAccountCreationPage() {
		return formTitle.isDisplayed();
	}
}
