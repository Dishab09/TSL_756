package day7JUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.sun.java.swing.plaf.windows.resources.windows;

import util.Base;

public class Scrolling extends Base{
	
  @Test
  public void f() throws InterruptedException{
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  driver.get("http://seleniumhq.org");
	  js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.linkText("Selenium blog")));
	  		Thread.sleep(4000);
	  		js.executeScript("window.scrollBy(0, -700)");
	  		Thread.sleep(4000);
	  		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  		
	  		Thread.sleep(4000);
	  		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	  		Thread.sleep(4000);
	  		js.executeScript("arguments[0].click(0);",driver.findElement(By.linkText("Selenium blog")));
	  		
  }
}
