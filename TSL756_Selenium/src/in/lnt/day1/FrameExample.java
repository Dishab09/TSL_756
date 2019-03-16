package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.BrowserSetup;

public class FrameExample
{

public static void main(String[] args) throws InterruptedException {
	WebDriver driver =BrowserSetup.browserStart("firefox","file:///C:/Users/vshadmin/Desktop/frame.html");
	driver.switchTo().frame(0);
	driver.findElement(By.name("q")).sendKeys("LNt");
	driver.switchTo().parentFrame();
	driver.switchTo().frame("new");
	driver.findElement(By.name("userName")).sendKeys("123");
	driver.switchTo().defaultContent();
	//	driver.switchTo().parentFrame();
	driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[3]")));
	driver.findElement(By.name("p_t01")).sendKeys("sys");
	driver.findElement(By.name("p_t02")).sendKeys("Newuser123");
	driver.findElement(By.xpath("/html/body/form/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[1]")) .click();
	
	driver.findElement(By.cssSelector("img[title='Logout']")).click();
	Thread.sleep(4000);
	driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
	System.out.println("Login Done");
	
	
}	
	
}
