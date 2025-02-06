/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSuccess extends BaseClass {

	@FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[5]")
	WebElement confirmedMsg;

	public OrderSuccess() {
		PageFactory.initElements(getDriver(), this);
	}

	public String successMessage() throws Throwable {
		Action.fluentWait(getDriver(), confirmedMsg, 10);
		String confirmMsg = confirmedMsg.getText();
		return confirmMsg;

	}
}
