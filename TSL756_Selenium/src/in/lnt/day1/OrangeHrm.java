package in.lnt.day1;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHrm {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		Actions action = new Actions(driver);
		//Implicit Time  for waiting
		//WebDriverWait wt = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");
		 driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		 
		 action.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).perform();;
		 action.moveToElement(driver.findElement(By.linkText("Organization"))).perform();
		 action.click(driver.findElement(By.linkText("General Information"))).perform();
		 driver.findElement(By.id("welcome")).click();
		 //Thread.sleep(3000);
		 
		 //Explicit Wait by selenium
		// wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
//wt.until(ExpectedConditions.visi)
		 driver.findElement(By.linkText("Logout")).click();
		 
		 
	}

	}


