package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class KeyWords {
	private WebDriver driver;
	
	public KeyWords(WebDriver idriver)
	{
		this.driver=idriver;
	}
public void openURL(String url)
{
	driver.get(url);
}
public void type(String Locator, String text)
{
	driver.findElement(element(Locator)).sendKeys(text);
}
public void click(String Locator)
{
	driver.findElement(element(Locator)).click();;
}
public void dropdown(String Locator, String visibletext)
{
	new Select(driver.findElement(element(Locator))).selectByVisibleText(visibletext);
}
public void getScreenShot(String string) {
	// TODO Auto-generated method stub
	
}

public By element(String Value)
{
	  By B=null;
	  if(Value.endsWith("_:linktext"))
		  B=By.linkText(Value.split("_:")[0]);
	  else if (Value.endsWith("_:xpath"))
		  B=By.xpath(Value.split("_:")[0]);
	  else if (Value.endsWith("_:id"))	 
			B=  By.id(Value.split("_:")[0]);
	  else if (Value.endsWith("_:name"))	 
			B=  By.name(Value.split("_:")[0]);
	  else if (Value.endsWith("_:css"))	 
			B=  By.cssSelector(Value.split("_:")[0]);
	  else 
		  System.out.println("Invalid Locator");
	 
	  return B;
}

}
