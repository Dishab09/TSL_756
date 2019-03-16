package day7;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.Base;

public class DeleteCookies extends Base {
  @Test
  public void f() throws InterruptedException
  {
	  driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:12351140983463653098::NO:::");
	  driver.findElement(By.name("p_t01")).sendKeys("sys");
	  driver.findElement(By.name("p_t02")).sendKeys("Newuser123");
	  driver.findElement(By.cssSelector("input[value='Login']")).click();
	    
	  driver.manage().deleteAllCookies();
	 // Assert.assertEquals(driver.getTitle(), "HTML DB Login");
	  driver.navigate().refresh();
	  Assert.assertTrue(driver.findElement(By.name("p_t01")).isDisplayed());
	  try {
		Thread.sleep(200);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 /* Set<Cookie>allCookies=driver.manage().getCookies();
	  for(Cookie C:allCookies)
	  {
		  System.out.println("Cookie name is"+C.getName());
		  System.out.println("Cookie Domain is"+C.getDomain());
		  System.out.println("Cookie Expiry is"+C.getExpiry());
		  System.out.println("Cookie value is "+C.getValue());
		  System.out.println("Cookie Path is"+C.getPath());
	  }*/
	  
	  
  }
}