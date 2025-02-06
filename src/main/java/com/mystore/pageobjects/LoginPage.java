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
public class LoginPage extends BaseClass {

	@FindBy(id = "loginFrm_loginname")
	WebElement userName;

	@FindBy(id = "loginFrm_password")
	WebElement userPasswd;

	@FindBy(xpath = "//*[@id=\"loginFrm\"]/fieldset/button")
	WebElement signInBtn;

//	@FindBy(xpath = "//*[@id=\"accountFrm\"]/fieldset/div[1]/label")
//	WebElement createNewAccount;

	@FindBy(xpath = "//*[@id=\"accountFrm\"]/fieldset/button")
	WebElement registerBtn;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String usrname,String passwd) {
		Action.fluentWait(getDriver(), signInBtn, 10);
		Action.type(userName, usrname);
		Action.type(userPasswd, passwd);
		Action.click(getDriver(), signInBtn);
		return new HomePage();
	}
	
	public OrderConfirmationPage login1(String usrname,String passwd) {
		Action.type(userName, usrname);
		Action.type(userPasswd, passwd);
		Action.click(getDriver(), signInBtn);
		return new OrderConfirmationPage();
	}
	
	public AccountCreationPage newAccountCreate() {
		Action.click(getDriver(), registerBtn);
		return new AccountCreationPage();
	}

}
