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
import com.mystore.utility.Log;

/**
 * 
 */
public class LoginPageTest extends BaseClass {

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

	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = { "Smoke", "Sanity" })
	public void loginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User is going to signIn");
		loginPage = indexPage.clickOnSign();
		Log.info("enter user name and password");
//		homePage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		homePage = loginPage.login(uname, pswd);
		String actualUrl = homePage.getCurrentUrl();
		String expectedUrl = "https://automationteststore.com/index.php?rt=account/account";
		Log.info("Validation check");
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.endTestCase("loginTest");
	}
}
