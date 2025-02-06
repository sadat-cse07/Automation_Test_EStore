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
public class OrderPage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[4]")
	WebElement subTotal;

	@FindBy(xpath = "//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[6]")
	WebElement totalPrice;

	@FindBy(id = "cart_checkout2")
	WebElement orderConfirm;

	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public double getSubTotal() {
		Action.fluentWait(getDriver(), subTotal, 10);
		String subtotal1 = subTotal.getText();
		String unit1 = subtotal1.replaceAll("[^a-zA-Z0-9]", "");
		double finalsubtotal = Double.parseDouble(unit1);
		return finalsubtotal / 100;
	}
	
	public double getTotal() {
		Action.fluentWait(getDriver(), totalPrice,10);
		String totalPrice1 = totalPrice.getText();
		String unit = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice / 100;
	}
	
	public LoginPage orderConfirm() {
		Action.JSClick(getDriver(), orderConfirm); 
		return new LoginPage();
	}

}
