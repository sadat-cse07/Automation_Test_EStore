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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * 
 */
public class HomePageTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = "Smoke", dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void wishlistTest(String uname, String pswd) throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSign();
//		homePage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		homePage = loginPage.login(uname, pswd);
		boolean result = homePage.validateWishlist();
		Assert.assertTrue(result);
	}

	@Test(groups = "Smoke")
	public void orderHistoryTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSign();
		homePage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		boolean result = homePage.validateOrderHistory();
		Assert.assertTrue(result);
	}
}
