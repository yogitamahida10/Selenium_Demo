package com.testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer;
import com.utility.libraryfunction;
import com.utility.objectrespositery;
import com.utility.libraryfunction;
import com.utility.objectrespositery;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
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

public class ValidatingAlerts extends libraryfunction{

	@SuppressWarnings("deprecation")
	@Test(priority = -1)
	public void ValidatingAlerts() {
		System.out.println("inside ValidatingAlerts");
		driver.navigate().to(objpropertifile.getProperty("AlertURL"));
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.findElement(By.id(objectrespositery.AlertButton)).click();
		Alert objAlert = driver.switchTo().alert();
		String textAlert1  = objAlert.getText();
		System.out.println("textAlert1:"+textAlert1);
		Assert.assertEquals(textAlert1,objpropertifile.getProperty("Alert1Text"));
		objAlert.accept();
	}
	

	@Test(priority = 0)
	public void ValidatingTimerAlerts() {
		System.out.println("inside ValidatingTimerAlerts");
		driver.findElement(By.id(objectrespositery.TimerAlertButton)).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert objAlert = driver.switchTo().alert();
		String textTimerAlert  = objAlert.getText();
		System.out.println("textTimerAlert:"+textTimerAlert);
		Assert.assertEquals(textTimerAlert,objpropertifile.getProperty("Alert2Text"));
		objAlert.accept();
	}
	
	@Test(priority = 1)
	public void ValidatingConfirmBoxAlerts() {
		System.out.println("inside ValidatingConfirmBoxAlerts");
		driver.findElement(By.id(objectrespositery.ConfirmAlertButton)).click();
		//Explicit Wait : Applicable for one webElement , it will wait until Expected Conditions are satisfied 
		//up to a maximum of given time duration
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert objAlert = driver.switchTo().alert();
		String textConfirmBoxAlert  = objAlert.getText();
		System.out.println("textConfirmBoxAlert:"+textConfirmBoxAlert);
		Assert.assertEquals(textConfirmBoxAlert,objpropertifile.getProperty("Alert3Text"));
		objAlert.dismiss();
		String confirmAlertResult = driver.findElement(By.id(objectrespositery.ConfirmButtonCancelResult)).getText();
		System.out.println("confirmAlertResult:"+confirmAlertResult);
		Assert.assertEquals(confirmAlertResult,objpropertifile.getProperty("Alert3ResultTextCancel"));
	}

	
	@Test(priority = 2)
	public void ValidatingPromptBoxAlerts() {
		System.out.println("inside ValidatingPromptBoxAlerts");
		driver.findElement(By.id(objectrespositery.PromptAlertButton)).click();
		//Explicit Wait : Applicable for one webElement , it will wait until Expected Conditions are satisfied 
		//up to a maximum of given time duration
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert objAlert = driver.switchTo().alert();
		objAlert.sendKeys(objpropertifile.getProperty("Alert4Textbox"));
		objAlert.accept();
		String PromptAlertResult = driver.findElement(By.id(objectrespositery.PromptAlertResult)).getText();
		System.out.println("PromptAlertResult:"+PromptAlertResult);
		Assert.assertEquals(PromptAlertResult,objpropertifile.getProperty("Alert4Result"));
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
