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
public class OrderConfirmationPage extends BaseClass {

	@FindBy(xpath = "//div[@id=\"payment\"]/div/div/button")
	WebElement confirmOrders;

	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSuccess confirmOrder() {
		Action.fluentWait(getDriver(), confirmOrders, 30);
		Action.JSClick(getDriver(), confirmOrders);
		return new OrderSuccess();
	}

}
