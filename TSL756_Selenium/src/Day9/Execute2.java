package Day9;

import org.testng.annotations.Test;

import util.Base2;
import util.KeyWords;

public class Execute2 extends Base2 {
  @Test
  public void f() {
	  KeyWords Key= new KeyWords(driver);
	  Key.openURL("https://opensource-demo.orangehrmlive.com/");
	  Key.type("txtUsername_name", "admin");
	  Key.type("txtPassword_id", "admin123");
	  Key.click("//*[@type='submit']_xpath");
	  Key.click("//*[@id='welcome']_xpath");
	  Key.getScreenShot("Orange");
	  Key.click("Logout_linktext");
	  
  }
}
