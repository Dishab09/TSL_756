package in.lnt.day1;

import org.testng.annotations.Test;

import util.BrowserSetup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class All anotations {
  @Test
  public void f() {
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
  }

  @AfterMethod
 
	  public void AfterMethod(ITestResult result)
	  {
	  System.out.println(ITestResult.SUCCESS);
	  System.out.println(ITestResult.SKIP);
	if(result.getStatus()==ITestResult.FAILURE)
	{
		System.out.println("Taking ScreenShot");
		BrowserSetup.getScreenShot(result.getName());
	}
	  
  }
  

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
	  
	  
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
