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
public class AccountCreationPage extends BaseClass {

//	@FindBy(xpath = "//button[@title=\"Continue\"]")
//	WebElement registerBtn;
	
	@FindBy(xpath = "//span[text()=\" Create Account\"]")
	WebElement formTitle;

	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//	public void clickOnRegister() {
//		Action.click(driver, registerBtn);
//	}
	public boolean validateAccountcreation() {
		return Action.isDisplayed(getDriver(), formTitle);
	}
	
	
}
