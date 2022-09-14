package com.qa.creatio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.creatio.base.BasePage;
import com.qa.creatio.util.ElementActions;

public class GoogleFormPage extends BasePage{
	
	WebDriver driver;
	ElementActions elementActions;
	
	By firstName = By.name("firstname");
	By lastName = By.name("lastname");
//	By gender1 = By.id("sex-0");
//	By gender2 = By.id("sex-1");
	By date = By.id("datepicker");
//	By profession1 = By.id("profession-0");
//	By profession2 =By.id("profession-1");
	
	public GoogleFormPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(driver);
	}
	
	public void writeInGoogleForm(String fName, String lName, String dat) {
		
		elementActions.sendKeysElement(firstName, fName);
		elementActions.sendKeysElement(lastName, lName);
		
	//	elementActions.clickOnElement(gender1);
		//elementActions.clickOnElement(gender2);
		elementActions.sendKeysElement(date, dat);
		
		
		
	}
	
}
