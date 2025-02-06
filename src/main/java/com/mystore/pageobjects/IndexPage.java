package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"customer_menu_top\"]/li")
	WebElement signInBtn;

	@FindBy(xpath = "//img[@alt=\"Automation Test Store\"]")
	WebElement storeLogo;

	@FindBy(xpath = "//*[@id=\"filter_keyword\"]")
	WebElement searchInputFiled;

	@FindBy(xpath = "//*[@id=\"search_form\"]/div/div")
	WebElement searchButton;

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage clickOnSign() throws Throwable {
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(), storeLogo);

	}

	public String getStoreTitle() {
		String storeTitle = getDriver().getTitle();
		return storeTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchInputFiled,productName);
		Action.click(getDriver(),searchButton);
		return new SearchResultPage();
	}
}