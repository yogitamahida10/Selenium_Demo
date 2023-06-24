package com.testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer;
import com.utility.libraryfunction;
import com.utility.objectrespositery;
import com.utility.objectrespositery2;
import com.utility.libraryfunction;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidatingWindows extends libraryfunction{

	
	@Test(priority = -1)
	public void ValidatingWindows() throws InterruptedException {
		System.out.println("inside ValidatingWindows");
		driver.navigate().to(objpropertifile.getProperty("nxtgenaiacademyURL"));
		waitForPageToLoad();
		libraryfunction.FindElementByLocator(objectrespositery2.NewBrowserWindow).click();
		WebDriverWait wait=new WebDriverWait(driver,30);
		Set<String> Allwindows=driver.getWindowHandles();
		for( String IndividualWindow: Allwindows){
			driver.switchTo().window(IndividualWindow);
			String title=driver.getTitle();
			System.out.println("title" +title);
			if(title.equals(objpropertifile.getProperty("NewBrowserWindowTitle")))
			{
				driver.manage().window().maximize();
				Thread.sleep(8000);
				libraryfunction.FindElementByLocator(objectrespositery2.MenuOfNew_BrowserWindow).click();
				libraryfunction.FindElementByLocator(objectrespositery2.About_Me_NewBrowserWindow).click();
			}
				
			
		}
		
		
		
	}
	

	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
		LaunchBrowser();
	}

	

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() throws Exception {
		System.out.println("inside beforeSuite");
		ReadPropertiFile();
	}

	
	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}
