package in.lnt.day1;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown
{
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
	WebDriver driver = new  ChromeDriver();
	driver.get("http://www.blazedemo.com/");
	
	Select select =new Select(driver.findElement(By.name("fromPort")));
	//select.selectByIndex(4);
//	select.selectByValue("Paris");
	//select.selectByVisibleText("Boston");
	System.out.println(driver.findElement(By.name("fromPort")).getText());
//int age[]
	List<WebElement> ls=select.getOptions();
	
	for(int i=0;i<ls.size();i++ )
	{
		System.out.println(ls.get(i).getText());
		
	}
//CSS Path::::	html body div.container table.table tbody tr td input.btn.btn-small
	new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Rome");
	driver.findElement(By.cssSelector("input[value='Find Flights']")).click();
	
	driver.findElement(By.cssSelector("input[value='Choose This Flight']")).click();
	
	driver.findElement(By.cssSelector("input#inputName")).sendKeys("Chetan Faltu");
	driver.findElement(By.cssSelector("input#address")).sendKeys("Hairan gali pareshan road");
	driver.findElement(By.cssSelector("input#city")).sendKeys("Pagal-Khana");
	driver.findElement(By.cssSelector("input#state")).sendKeys("Maharashtra");
	driver.findElement(By.cssSelector("input#zipCode")).sendKeys("12345");
new Select(driver.findElement(By.name("cardType"))).selectByVisibleText("Visa");
driver.findElement(By.cssSelector("input#creditCardNumber")).sendKeys("1234567865");
driver.findElement(By.cssSelector("input#creditCardMonth")).sendKeys("9");
driver.findElement(By.cssSelector("input#creditCardYear")).sendKeys("2018");
driver.findElement(By.cssSelector("input#nameOnCard")).sendKeys("Champak Chetan");
 driver.findElement(By.cssSelector("input#rememberMe")).click();
 driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
 
}

}
