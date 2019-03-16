package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.BrowserSetup;

public class Oracle {
	WebDriver driver;
	Connection C;
	
	PreparedStatement stmt;
	  @Test(dataProvider = "dp")
	
	 
	public void Login(String Username, String Password) throws Exception
	  {
		  driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:13922085214085754694::NO:::");
		  driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).clear();
		  driver.findElement(By.xpath("//*[@id='P11_USERNAME']")).sendKeys(Username);
		  driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).clear();
		  driver.findElement(By.xpath("//*[@id='P11_PASSWORD']")).sendKeys(Password);
		  driver.findElement(By.xpath("//*[@value='Login']")).click();
		  stmt=C.prepareStatement("Update login set status=? where Username=? and Password=?");
		  stmt.setString(1, Username);
		  stmt.setString(2, Password);
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
			data[i][1]=R.getString(2);
			i++;
		}
		return data;
	}
	@AfterMethod
	
	public void Aftermethod(ITestResult result)
	{
	try {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("Taking Screenshot");
			BrowserSetup.getScreenShot(result.getName());
			stmt.setString(1, "Fail");
		  }
		  else
		{
				stmt.setString(1, "Pass");
		}
		  stmt.executeUpdate();
	}

catch (SQLException e) {
	
	e.printStackTrace();
}

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

