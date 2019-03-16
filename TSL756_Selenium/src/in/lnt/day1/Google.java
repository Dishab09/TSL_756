package in.lnt.day1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;
public class Google 
{
	public static void main(String[] args) {
	//		WebDriver driver = BrowserSetup.browserStart("chrome","http://www.amazon.in/");
//		Actions action = new Actions(driver);
//		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
//		
//		action.moveToElement(search)
//		.sendKeys(search, " mobile")
//		.sendKeys(search, Keys.ENTER)
//		.perform();
//				
		WebDriver driver = BrowserSetup.browserStart("chrome","https://nseindia.com/");
		Actions action = new Actions(driver);
		WebElement search = driver.findElement(By.name("q"));
		//to hold in a group Action a
		Action a =	action.moveToElement(search)
		.sendKeys(search, "Reliance Industries Limited")
		.keyUp(Keys.SHIFT)
		.doubleClick(search)
		.contextClick(search)
		.sendKeys(search, Keys.ENTER)
		.build();
		a.perform();
	}
}
