package Day8;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import util.Base;

public class dependsExample extends Base{
  @Test
  public void f1() {
	  driver.get("http://google.com");
	  //System.out.println("In Test");
	  AssertJUnit.assertTrue(true);
	  
  }
  @Test(dependsOnMethods="f1")
  public void f2()
  {
	  boolean display=driver.findElement(By.name("q")).isDisplayed();
	  //System.out.println("In Test 2");
  AssertJUnit.assertTrue(display);
  }
  @Test(dependsOnMethods="f2")
  public void f3()
  {
	  //System.out.println("In Test 3");
	  String data="MODI";
	  System.out.println("In Test 3");
	  driver.findElement(By.name("q")).sendKeys(data);
	  new WebDriverWait(driver,20).
	  until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
	  driver.findElement(By.name("btnK")).click(); 
	  AssertJUnit.assertEquals(driver.getTitle(),data+" - Google Search");
  
  }
  
  
  
}
