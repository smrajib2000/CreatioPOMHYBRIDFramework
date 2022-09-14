package com.qa.creatio.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.creatio.base.BasePage;
import com.qa.creatio.pages.GoogleFormPage;
import com.qa.creatio.util.ExcelUtil;

public class writeInGoogleFormTest {
	BasePage basePage;
	WebDriver driver;
	Properties prop;
	GoogleFormPage googleFormPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.intialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url1"));
		googleFormPage = new GoogleFormPage(driver);
	}
	
	@DataProvider(name = "getContactsData")
	public Object[][] getContactsTestData() {
		Object contactsData[][] = ExcelUtil.getTestDataFromExcel("Contacts");
		return contactsData;
	}
	
	@Test(dataProvider = "getContactsData")
	public void fillUpFormTest(String firstName, String lastName, String date) {
		googleFormPage.writeInGoogleForm(firstName,lastName,date);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
