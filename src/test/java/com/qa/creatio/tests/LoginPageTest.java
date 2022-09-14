package com.qa.creatio.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.creatio.base.BasePage;
import com.qa.creatio.commons.Constants;
import com.qa.creatio.pages.LoginPage;
import com.qa.creatio.util.CommonUtil;

public class LoginPageTest {
	
	BasePage basePage;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup() {
		basePage = new BasePage();
		prop = basePage.intialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		CommonUtil.shortWait();
		loginPage = new LoginPage(driver);
		
	}
	
	@Test(priority = 1)
	public void VerifyLoginPageTitleTest() {
		String title = loginPage.VerifyLoginPageTitle();
		System.out.println("Login Page title is: "+ title);
		Assert.assertEquals(title, Constants.LOGINPAGE_TITLE, "Title did not match");
	}
	
	@Test(priority = 2)
	public void verifyCreateAccountLinkTest() {
		Assert.assertTrue(loginPage.VerifyCreateAccountLink(), "Create account link is not visible");
	}
	
	@Test(priority = 3)
	public void doLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
