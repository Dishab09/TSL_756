package in.lnt.day1;

import org.testng.annotations.Test;

import util.BrowserSetup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Oracle {
	WebDriver driver;
	
	  @Test(dataProvider = "dp")
	  public void Login(String UN, String PW) 
	  {
		  driver.get("http://127.0.0.1:8080/htmldb");
		  driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).clear();
		  driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).sendKeys(UN);
		  driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).clear();
		  driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).sendKeys(PW);
		  driver.findElement(By.xpath("//*[@value='Login']")).click();
		  driver.findElement(By.linkText("Logout")).click();
		  driver.findElement(By.partialLinkText("Log")).click();
	  }
	

		@DataProvider
		public Object[][] dp() throws Exception
		{
			
			
		
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		Connection C=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Newuser123");
		ResultSet rs=C.createStatement().executeQuery("Select count(*) from Login");
		rs.next();
		Object data[][]=new Object[rs.getInt(1)][2];
		int i=0;
		ResultSet  R=C.createStatement().executeQuery("select * from Login");
		while(R.next())
		{
			data[i][0]=R.getString(1);
			data[i]][1]=R.getString(2);
			i++;
		}
		return data;
	}
	@AfterMethod
	
	public void Aftermethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("Taking Screenshot");
			BrowserSetup.getScreenShot(result.getName());
		}
	
	@BeforeTest
	public void beforeTest()
	{
		driver=BrowserSetup.browserStart("chrome");
		
		}

	  @AfterTest
	  public void afterTest()
	  {
		  driver.quit();
	  }

	}

	}
}
