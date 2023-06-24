package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class libraryfunction {
	
	public static Properties objpropertifile;
	public static WebDriver driver;
	


public static void ReadPropertiFile() throws Exception {
		
		try {
			FileInputStream objFileInputStream= new FileInputStream(new File(System.getProperty("user.dir")+ "//src//test//resources//ConfigurationProperty.properties"));
			objpropertifile= new Properties();
			objpropertifile.load(objFileInputStream);
			System.out.println(objpropertifile.getProperty("browser"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}


public static void LaunchBrowser() {
	System.out.println("in Launch of browser");
	String browser=objpropertifile.getProperty("browser");
	System.out.println("selected Browser is:" + browser);
	switch (browser)
	{
	case "chrome":
		
		WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		ChromeOptions objofChromeOptions= new ChromeOptions();
		objofChromeOptions.setAcceptInsecureCerts(true);
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
		objofChromeOptions.setExperimentalOption("prefs", chromePrefs);
		driver = new ChromeDriver(objofChromeOptions);
		
		break;
		
	case "edge":
		
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
	case "opera":
		
		WebDriverManager.operadriver().setup();
		driver=new OperaDriver();
		break;
		
	case "IE":
		
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		break;
		
		
		
		}
	driver.get(" http://demo.borland.com/gmopost/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}
public static WebElement FindElementByLocator(String OrepLocator) {
	System.out.println("OrepLocator:" + OrepLocator);
	String locator = OrepLocator.split("&")[0];
	String value = OrepLocator.split("&")[1];
	System.out.println("locator:" + locator);
	System.out.println("value:" + value);
	By Obj = null;
	switch (locator) {
	case "id":
		Obj = By.id(value);
		break;
	case "xpath":
		Obj = By.xpath(value);
		break;
	case "name":
		Obj = By.name(value);
		break;
	case "linkText":
		Obj = By.linkText(value);
		break;
	case "className":
		Obj = By.className(value);
		break;
	case "cssSelector":
		Obj = By.cssSelector(value);
		break;
	case "partialLinkText":
		Obj = By.partialLinkText(value);
		break;
	case "tagName":
		Obj = By.tagName(value);
		break;
	}
	return driver.findElement(Obj);

}

public static WebElement FindElementUsingHeadLess(WebDriver unitDriver, String OrepLocator) {
	By search = null;
	System.out.println(OrepLocator);
	String locator = OrepLocator.split("&")[0];
	String value = OrepLocator.split("&")[1];
	System.out.println(locator);
	System.out.println(value);
	if (locator.equals("name")) {
		search = By.name(value);
	} else if (locator.equals("id")) {
		search = By.id(value);
	} else if (locator.equals("xpath")) {
		search = By.xpath(value);
	} else if (locator.equals("tagName")) {
		search = By.tagName(value);
	} else if (locator.equals("className")) {
		search = By.className(value);
	} else if (locator.equals("partialLinkText")) {
		search = By.partialLinkText(value);
	} else if (locator.equals("cssSelector")) {
		search = By.cssSelector(value);
	} else if (locator.equals("linkText")) {
		search = By.linkText(value);
	}
	return unitDriver.findElement(search);
}

public static List<WebElement> FindElementsByLocator(String OrepLocator) {
	System.out.println("OrepLocator:" + OrepLocator);
	String locator = OrepLocator.split("&")[0];
	String value = OrepLocator.split("&")[1];
	System.out.println("locator:" + locator);
	System.out.println("value:" + value);
	By Obj = null;
	switch (locator) {
	case "id":
		Obj = By.id(value);
		break;
	case "xpath":
		Obj = By.xpath(value);
		break;
	case "name":
		Obj = By.name(value);
		break;
	case "linkText":
		Obj = By.linkText(value);
		break;
	case "className":
		Obj = By.className(value);
		break;
	case "cssSelector":
		Obj = By.cssSelector(value);
		break;
	case "partialLinkText":
		Obj = By.partialLinkText(value);
		break;
	case "tagName":
		Obj = By.tagName(value);
		break;
	}
	return driver.findElements(Obj);

}


public static void waitForPageToLoad() {
	ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
			return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		}
	};
	// explicit wait -> Applicable for one webEllement
	WebDriverWait wait = new WebDriverWait(driver, 60);// 60 seconds
	wait.until(pageLoadCondition);
}
public static void ScrollIntoViewWithWebElement(WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();",element);
	
}
}

