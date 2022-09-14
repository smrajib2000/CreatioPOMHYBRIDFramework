package com.qa.creatio.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.creatio.commons.Constants;



public class BasePage {
	
	WebDriver driver;
	Properties prop;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initialize_driver(Properties prop){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\Eclipse with project\\API TESTING\\chromedriver.exe");
			tldriver.set(new ChromeDriver());
			//WebDriverManager.chromedriver().setup();
		
		}
		else if(browserName.equals("firefox")){
			tldriver.set(new FirefoxDriver());
			}
		else if(browserName.equals("ie")){
			tldriver.set(new InternetExplorerDriver());
			}
		else if(browserName.equals("edge")){
			tldriver.set(new EdgeDriver());
			//WebDriverManager.edgedriver().setup();
			}
		else{
			System.out.println("No browser is classified");
		}
		
		getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME_OUT,TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		
		if(prop.getProperty("fullscreenmode").equals("yes")){
		
			getDriver().manage().window().fullscreen();
		}
		
		return getDriver();
		
	}
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	public Properties intialize_properties(){
		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream("E:\\Eclipse with project\\API TESTING\\CreatioByLocatorPOM\\"
										+ "src\\main\\java\\com\\qa\\creatio\\configuration\\config.properties");
			
			prop.load(ip);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

	
}