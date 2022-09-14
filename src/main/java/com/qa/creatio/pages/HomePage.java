package com.qa.creatio.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.creatio.base.BasePage;

public class HomePage extends BasePage{
	WebDriver driver;
	
	@FindBy (xpath = "//*[@id='edit-type']/div/div[1]/label")
			WebElement homepageHeader;

	@FindBy(xpath = "//*[@id='user-header-menu-block']/div[2]/ul/li/a")
	WebElement accountName;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getHomePageHeaderValue() {
		return homepageHeader.getText();
	}
	
	public String getLoggedInAccountName() {
		return accountName.getText();
	}
}
