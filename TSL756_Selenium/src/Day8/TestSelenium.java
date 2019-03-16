package Day8;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.Base2;

public class TestSelenium extends Base2 {
	  @Test
	  public void f() throws Exception {

		  //WebDriver driver;
		  
		  Login login= new Login(driver);
		  driver.get("http://127.0.0.1:8080/htmldb");
		  login.LoginProcess("sys", "Newuser123");
		  System.out.println("login done");
		  
		  SQLCommand sql= new  SQLCommand(driver);
		  driver.get("http://127.0.0.1:8080/htmldb");
		//  LN.LoginProcess("sys", "Newuser123");
	//	  Assert.assertTrue(driver.findElement(e_getting)).selectByVisibleText("20");
		  
		  sql.startSql();
		  Thread.sleep(1000);
		  sql.startsqlComm();
		  Thread.sleep(1000);
		  sql.executeCommand();
		  Thread.sleep(1000);
		   sql.logoutProcess();
		  Thread.sleep(1000);
	  }
	}
