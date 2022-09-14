package com.qa.creatio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.creatio.base.BasePage;
import com.qa.creatio.util.ElementActions;
import com.qa.creatio.util.JavaScriptUtil;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	ElementActions elementActions;
	JavaScriptUtil jsUtil;
//	@FindBy(id="edit-name")
//	WebElement emailID;
//	
//	@FindBy(id="edit-pass")
//	WebElement password;
//	
//	@FindBy(id="edit-submit")
//	WebElement loginBtn;
//	
//	@FindBy(linkText = "or create an account")
//	WebElement createAccount;
	
	By username = By.id("edit-name");
	By password = By.id("edit-pass");
	By loginBtn = By.id("edit-submit");
	By createAccountLink = By.linkText("or create an account");
			
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(driver);
		jsUtil = new JavaScriptUtil(driver);
		
	}
	
	public String VerifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean VerifyCreateAccountLink() {
		return elementActions.getElement(createAccountLink).isDisplayed();
	}

	public HomePage doLogin(String un, String pwd) {
		elementActions.sendKeysElement(username,un);
		elementActions.sendKeysElement(password, pwd);
		//elementActions.clickOnElement(loginBtn);
		jsUtil.clickElementByJS(elementActions.getElement(loginBtn));
		return new HomePage(driver);
		
	}
}
