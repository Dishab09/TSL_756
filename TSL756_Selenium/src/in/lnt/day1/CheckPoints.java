package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckPoints {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// only parent methods are access
		driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:1512520610394997120::NO:::");
		WebElement E = driver.findElement(By.id("P11_USERNAME"));
		boolean isdisplayed = E.isDisplayed();
		boolean isenabled = E.isEnabled();
		
		String sz = E.getAttribute("size");
		String typ = E.getAttribute("type");
		
		//Test Pass
		if(isdisplayed == true && isenabled == true && sz.equals("30") && typ.equals("text"))
			
			//test fails
		//	if(isdisplayed == true && isenabled == true && sz.equals("30") && typ.equals("radio"))
		System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
	
	}

}