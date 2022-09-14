package com.qa.creatio.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.creatio.base.BasePage;
import com.qa.creatio.commons.Constants;
import com.qa.creatio.pages.HomePage;
import com.qa.creatio.pages.LoginPage;
import com.qa.creatio.util.CommonUtil;

public class HomePageTest {
	BasePage basePage;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.intialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		CommonUtil.shortWait();
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		CommonUtil.shortWait();
		
	}
	
	@Test(priority = 1)
	public void verfyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page Title is :"+title);
		Assert.assertEquals(title, Constants.HOMEPAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyHomePageHeaderTest() {
		String header = homePage.getHomePageHeaderValue();
		System.out.println("Home Page Header is : "+ header);
		Assert.assertEquals(header, Constants.HOMEPAGE_HEADER);
	}
	
	@Test(priority = 3)
	public void verifyLoggedInAccountNameTest() {
		String accountName = homePage.getLoggedInAccountName();
		System.out.println("Logged in Account name is: "+accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
