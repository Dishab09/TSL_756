package in.lnt.day1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import util.BrowserSetup;
public class NSE 
{
	public static void main(String[] args) 
	{
		WebDriver driver = BrowserSetup.browserStart("chrome","https://nseindia.com/");
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//*[@id=\"keyword\"]")).sendKeys("Reliance Industries Limited");
		//to hold in a group Action a
		//Action a =	action.moveToElement(search)
		//.sendKeys(search, "Reliance Industries Limited").build();
		driver.findElement(By.xpath("//*[contains(text(),'Reliance Industries Limited')]")).click();;
		BrowserSetup.getScreenShot("NSE");
		WebElement e = driver.findElement(By.id("faceValue"));
		System.out.println("Face Value Is" + e.getText());
		WebElement e1= driver.findElement(By.xpath("//*[@id=\"high52\"]/font"));
		System.out.println("52 week high Is" + e1.getText());
		WebElement e2= driver.findElement(By.xpath("//*[@id=\"low52\"]/font"));
		System.out.println("52 week low Is" + e2.getText());
		//.sendKeys( Keys.ENTER)
		//.build();
		//a.perform();
	}

}
