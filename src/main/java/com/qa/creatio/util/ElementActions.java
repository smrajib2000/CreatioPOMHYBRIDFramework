package com.qa.creatio.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.creatio.base.BasePage;
import com.qa.creatio.commons.Constants;

public class ElementActions extends BasePage{
	
	WebDriver driver;
	
	public ElementActions(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By selector) {
		WebElement element = null;
	
		try {
		WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_EXPLICITLY_WAIT);
		wait.until(ExpectedConditions.presenceOfElementLocated(selector));
		element = driver.findElement(selector);
		}catch(Exception e) {
			System.out.println("Element not found");
			System.out.println(e.getMessage());
		}
		return element;
	}
	
	public void sendKeysElement(By selector, String value) {
		try {
		getElement(selector).sendKeys(value);
		}catch(Exception e) {
			System.out.println("Some issue with SendKeys");
		}
	}
	
	public void clickOnElement(By selector) {
		getElement(selector).click();
	}
	
	public String getTextElement(By selector) {
		return getElement(selector).getText();
	}
	
}
