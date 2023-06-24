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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidatingMouseRightClick extends libraryfunction{

	
	@Test(priority = -1)
	public void ValidatingRightClick() throws InterruptedException {
		System.out.println("inside ValidatingRightClick");
		driver.navigate().to(objpropertifile.getProperty("mouseOpeartionRightClick"));
		waitForPageToLoad();
		
		
		WebElement Rightclick= libraryfunction.FindElementByLocator(objectrespositery2.MouseRightClickOperation);
		Actions ObjofActions= new Actions(driver);
		ObjofActions.contextClick(Rightclick).build().perform();
			libraryfunction.FindElementByLocator(objectrespositery2.MouseDelteOption).click();
			Alert ObjofAlert=driver.switchTo().alert();
			String AlertTextValue=ObjofAlert.getText();
			System.out.println("AlertTextValue :"+ AlertTextValue);
			Assert.assertEquals(AlertTextValue, objpropertifile.getProperty("mouseOpeartionRightclickDeleteActionText"));
			ObjofAlert.accept();
		
		
		
	}
	
	@Test(priority = 1)
	public void VallidatingDoubleClickOperation() throws InterruptedException {
		System.out.println("inside VallidatingDoubleClickOperation");
		driver.navigate().to(objpropertifile.getProperty("mouseOpeartionDoubleClick"));
		waitForPageToLoad();
		
		//js.executeScript("window.scrollBy(0,500)");// scroll vertically downwards
		//js.executeAsyncScript("windows.scrollBy(0,-500)");//scroll vertically upwards
		//js.executeAsyncScript("windows.scrollBy(300,0)");//scroll horizontally left
		//js.executeAsyncScript("windows.scrollBy(-300,0)");//scroll horizontally right
		WebElement FrameElement=libraryfunction.FindElementByLocator(objectrespositery2.IframeDoubleClick);
		libraryfunction.ScrollIntoViewWithWebElement(FrameElement);
		driver.switchTo().frame(FrameElement);
		WebElement DobleClickButton= libraryfunction.FindElementByLocator(objectrespositery2.DoubleClickTheBox);
		Actions objOfAction=new Actions(driver);
		objOfAction.doubleClick(DobleClickButton).build().perform();
		String BackgroundColorOfBox= DobleClickButton.getCssValue("background-color");
		System.out.println("background-color :"+ BackgroundColorOfBox);
		Assert.assertEquals(BackgroundColorOfBox, objpropertifile.getProperty("BoxYellowColor"));
	}
	
	
	@Test(priority = 1)
	public void VallidatingDragAndDropOperation() throws InterruptedException {
		System.out.println("inside VallidatingDragAndDropOperation");
		driver.navigate().to(objpropertifile.getProperty("mouseOperationDragAndDrop"));
		waitForPageToLoad();
		WebElement Iframe=libraryfunction.FindElementByLocator(objectrespositery2.IframeDoubleClick);
		driver.switchTo().frame(Iframe);
		Actions objOfAction=new Actions(driver);
		WebElement DrragableElement=libraryfunction.FindElementByLocator(objectrespositery2.DraggableOperation);
		WebElement DroppableElement=libraryfunction.FindElementByLocator(objectrespositery2.DroppableOperation);
		//objOfAction.dragAndDrop(DrragableElement, DroppableElement).build().perform();;
		objOfAction.clickAndHold(DrragableElement);
	   objOfAction.moveToElement(DrragableElement);
	   objOfAction.release(DroppableElement).build().perform();
		
		
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
