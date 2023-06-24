package com.testNG;

import org.testng.annotations.Test;

import com.utility.libraryfunction;
import com.utility.objectrespositery2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class VallidatingFrames extends libraryfunction{
  @Test
  public void Validatingsingle() {
	  System.out.println("inside Validatingsingle");
		driver.navigate().to(objpropertifile.getProperty("FramesURL"));
		driver.switchTo().frame("singleframe");
		waitForPageToLoad();
		//.driver.findElement(By.id(objectrespositery2.SingleFrame)).sendKeys(objpropertifile.getProperty("framewithInFrame"));
		
		libraryfunction.FindElementByLocator(objectrespositery2.TextOfSingleFrame).sendKeys("Heloo How are you?");
		driver.switchTo().defaultContent();// used for brigining out the control from frame
		libraryfunction.FindElementByLocator(objectrespositery2.IframewithFrame).click();
		WebElement OuterFrame=libraryfunction.FindElementByLocator(objectrespositery2.OuterFrame);
		driver.switchTo().frame(OuterFrame);
		libraryfunction.FindElementByLocator(objectrespositery2.IframewithFrame).click();
			WebElement InnerFrame=libraryfunction.FindElementByLocator(objectrespositery2.InnerFrame);
			
			driver.switchTo().frame(InnerFrame);
			libraryfunction.FindElementByLocator(objectrespositery2.TextOfSingleFrame).sendKeys("Heloo How are you?");
			driver.switchTo().defaultContent();
			
		
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
		System.out.println("inside beforeTest");
		LaunchBrowser();
	}

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() throws Exception {
	  System.out.println("inside beforeSuite");
		ReadPropertiFile();
  }

  @AfterSuite
  public void afterSuite() {
  }

}
