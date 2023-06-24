package com.testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer;
import com.utility.libraryfunction;
import com.utility.objectrespositery;
import com.utility.objectrespositery2;
import com.utility.libraryfunction;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

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

public class ValidatingFileUpload extends libraryfunction{

	
	@Test(priority = -1)
	public void ValidatingFileUploadOperation() throws InterruptedException {
		System.out.println("inside ValidatingFileUpload");
		driver.navigate().to(objpropertifile.getProperty("FileDownload"));
		waitForPageToLoad();
		Actions objofAction=new Actions(driver);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		WebElement element=libraryfunction.FindElementByLocator(objectrespositery2.FileDownload100KB);
		objofAction.click(element).build().perform();
		Thread.sleep(8000);
		File objOfFile= new File(System.getProperty("user.dir"));
		File[] AllListOfFiles= objOfFile.listFiles();
		System.out.println("AllListOfFiles :"+ AllListOfFiles);
		boolean Filefound=false;
		File Obj_File = null;
		for (File individualFile : AllListOfFiles) {
			String FileName = individualFile.getName();
			System.out.println("FileName:" + FileName);
			if (FileName.contains("file-sample")) {
				Filefound = true;
				Obj_File = new File(FileName);
			}
		}
		
			
			Assert.assertTrue(Filefound, "downloaded file is not found");
			//Obj_file.deleteOnExit();
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
