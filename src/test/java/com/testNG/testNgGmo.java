package com.testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNgGmo {
	WebDriver driver;

	@Test(priority = -1)
	public void testGmo() {

		driver.get("http://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("title is :" + title);
		Assert.assertEquals(title, "Welcome to Green Mountain Outpost");

	}

	@Test(priority = 0, dependsOnMethods = { "testGmo" })
	public void EnterGMOOnlineExternalframebackpack() {
		System.out.println("inside Testcase2");
		driver.findElement(By.name("bSubmit")).click();
		String Entercatalogtitile = driver.findElement(By.xpath("//h1[text()='OnLine Catalog']")).getText();
		System.out.println("Entercatalogtitile:  " + Entercatalogtitile);
		// Assert.assertEquals(Entercatalogtitile, "OnLine Catalo");//Hard code
		// Assertion: stop execution immediately

		SoftAssert objofSoftAssert = new SoftAssert();
		objofSoftAssert.assertEquals(Entercatalogtitile, "OnLine Catalo");// softAssertion: continue the execution even
																			// after assertion failed.

		driver.findElement(By.name("QTY_BACKPACKS")).sendKeys("5");
		// driver.findElement(By.xpath("//input[@value='Place An
		// Order']")).click();//Relative path
		driver.findElement(By.xpath(
				"/html[1]/body[1]/form[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/center[1]/table[1]/tbody[1]/tr[1]/td[1]/p[1]/input[2]"))
				.click();// Absolute path
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		String PlaceOrdertitle = driver.getTitle();
		System.out.println("PlaceOrdertitle: " + PlaceOrdertitle);
		Assert.assertEquals(PlaceOrdertitle, "Place Order");

	}

	@Test
	public void UnitPriceVallidation() {
		String UnitPrice= driver.findElement(By.xpath("/html[1]/body[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/center[1]/table[1]/tbody[1]/tr[2]/td[4]")).getText();
		System.out.println("Unit Price is:" + UnitPrice);
		UnitPrice=UnitPrice.substring(2).trim();
		float UnitPriceFloatValue= Float.parseFloat(UnitPrice);
		System.out.println("UnitPriceFloatValue is: "+ UnitPriceFloatValue);
		float CalculatedTotalprice=UnitPriceFloatValue*5;
		System.out.println("CalculatedTotalprice : "+ CalculatedTotalprice);
		
		String TotalPriceFromWeb=driver.findElement(By.xpath("//tbody/tr[2]/td[5]")).getText();
		System.out.println(" TotalPriceFromWeb : "+ TotalPriceFromWeb);
		TotalPriceFromWeb=TotalPriceFromWeb.substring(2).trim();
		float TotalPriceFlaotValue=Float.parseFloat(TotalPriceFromWeb);
		System.out.println(" TotalPriceFlaotValue: "+ TotalPriceFlaotValue);
		Assert.assertEquals(TotalPriceFlaotValue, CalculatedTotalprice);

		
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod ");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod ");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass ");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass ");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest ");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest ");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite ");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite ");
	}

}
