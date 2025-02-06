/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class SearchResultPage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[2]/div[2]/a/img")
	WebElement searchProductName;

	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean isProductavialable() {
		return Action.isDisplayed(getDriver(), searchProductName);
	}

	public AddToCartPage clickOnProduct() {
		Action.click(getDriver(), searchProductName);
		return new AddToCartPage();
	}

}
