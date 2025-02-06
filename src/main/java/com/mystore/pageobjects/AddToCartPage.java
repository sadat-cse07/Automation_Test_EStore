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
public class AddToCartPage extends BaseClass {

	@FindBy(id = "product_quantity")
	WebElement quantity;

	@FindBy(id = "option353")
	WebElement size;

	@FindBy(xpath = "//a[contains(@class, 'cart')]")
	WebElement addToCart;

	@FindBy(xpath = "//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[1]/a/img")
	WebElement addToCartMsg;

	@FindBy(id = "cart_checkout1")
	WebElement checkOut;

	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterQuantity(String quant) {
		Action.type(quantity, quant);
	}

	public void selectSize(String size1) {
		Action.selectByVisibleText(size1, size);
	}

	public boolean checkCardImage() {
		return Action.isDisplayed(getDriver(), addToCartMsg);
	}

	public OrderPage clickAddToCart() {
		//Action.fluentWait(driver, addToCart, 10);
		Action.JSClick(getDriver(), addToCart);
		return new OrderPage();
	}

//	public OrderPage clickCheckOut() {
//		Action.JSClick(driver, checkOut);
//		return new OrderPage();
//	}
}
