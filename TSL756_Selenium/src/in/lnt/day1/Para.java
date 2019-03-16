package in.lnt.day1;

import org.testng.annotations.Test;

import util.BrowserSetup;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Para 
{
	WebDriver driver;
  @Test(dataProvider="dp")
public void Login(String userName, String password) 
  {
driver.get("http://127.0.0.1:8080/htmldb");
	  driver.findElement(By.xpath("//*[@type='text']")).sendKeys(userName);
	  driver.findElement(By.xpath("//*[@type='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//*[@value='Login']")).click();
	  driver.findElement(By.linkText("Logout")).click();
	  driver.findElement(By.partialLinkText("Log")).click();
	  
	  
  }

  @DataProvider
  public Object[][] dp()
  {
	  Object data[][]=new Object[4][2];
	  Excel excel= new Excel("D:\\abc.xlsx");
	  for(int i=0;i<=excel.rowCount("Sheet1");i++)
	  {
		  data[i][0]=excel.Read("Sheet1", i, 0);
		  data[i][1]=excel.Read("Sheet1", i, 1);
	  }
    			//data[0][0]="sys";
    				//data[0][1]="Newuser123";
    			/*	data[1][0]="system";
    				data[1][1]="Newuser123";
    				data[2][0]="sysaaa";
    				data[2][1]="sysa";
    				data[3][0]="sysbbb";
    				data[3][1]="sysb"; */
	  
	
  
    		 return data;
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

  
  @BeforeTest
  public void beforeTest()
  {
	  driver = BrowserSetup.browserStart("chrome");
  }

  @AfterTest
  public void afterTest()
  {
	  driver.quit();
  }

}
