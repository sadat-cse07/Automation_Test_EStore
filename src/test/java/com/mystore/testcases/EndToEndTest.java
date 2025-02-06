/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSuccess;
import com.mystore.pageobjects.SearchResultPage;

/**
 * 
 */
public class EndToEndTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	OrderConfirmationPage orderConfirmationPage;
	OrderSuccess orderSuccess;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = "Regression")
	public void endToendTest(String uname, String pswd) throws Throwable {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("XXL");
		orderPage = addToCartPage.clickAddToCart();
		loginPage = orderPage.orderConfirm();
//		orderConfirmationPage = loginPage.login1(prop.getProperty("user"), prop.getProperty("password"));
		orderConfirmationPage = loginPage.login1(uname, pswd);
		orderSuccess = orderConfirmationPage.confirmOrder();
		String actualMsg = orderSuccess.successMessage();
		String expectedMsg = "Thank you for shopping with us!";
		Assert.assertEquals(actualMsg, expectedMsg);

	}
}
