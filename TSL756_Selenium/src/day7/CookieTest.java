package day7;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import util.Base;

public class CookieTest extends Base {
  @Test
  public void Google() {
	  driver.get("http://google.com");
	  Set<Cookie>allCookies=driver.manage().getCookies();
	  for(Cookie C:allCookies)
	  {
		  System.out.println("Cookie name is"+C.getName());
		  System.out.println("Cookie Domain is"+C.getDomain());
		  System.out.println("Cookie Expiry is"+C.getExpiry());
		  System.out.println("Cookie value is "+C.getValue());
		  System.out.println("Cookie Path is"+C.getPath());
	  }
	  
	  
  }
}
