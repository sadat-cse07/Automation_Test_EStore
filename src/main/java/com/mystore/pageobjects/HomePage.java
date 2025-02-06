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
public class HomePage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/ul/li[4]/a")
	WebElement wishlist;
	
	@FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/div/div[2]/div/div[1]/div/a")
	WebElement orderHistory;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateWishlist() {
		Action.fluentWait(getDriver(), wishlist, 10);
		return Action.isDisplayed(getDriver(), wishlist);
	}

	public boolean validateOrderHistory() {
		Action.fluentWait(getDriver(), orderHistory, 10);
		return Action.isDisplayed(getDriver(), orderHistory);
	}
	
	public String getCurrentUrl() {
		String homePageUrl= getDriver().getCurrentUrl();
		return homePageUrl;
	}
	
}
