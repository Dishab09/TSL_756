package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","Driver\\chromedriver.exe");
		WebDriver webDriver= new ChromeDriver();//only parent methods are access	
		webDriver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:1512520610394997120::NO:::");
		webDriver.findElement(By.name("p_t01")).sendKeys("sys");
		webDriver.findElement(By.name("p_t02")).sendKeys("Newuser123");
		
		webDriver.findElement(By.xpath("/html/body/form/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[1]")) .click();
		
		String title = webDriver.getTitle();
		System.out.println("I'm on " +title+" page");
	//	webDriver.findElement(By.name("q")).sendKeys("artuu");
		Thread.sleep(5000);
		webDriver.quit();
		
	}}

		//FirefoxDriver fireFoxDriver=new FirefoxDriver();
		/*
		System.setProperty("webdriver.gecko.driver","C:\\Users\\vshadmin\\Desktop\\Jars\\geckodriver.exe");
		WebDriver webDriver= new FirefoxDriver();//only parent methods are access	
		webDriver.get("https://www.seleniumhq.org/");
		webDriver.findElement(By.linkText("Download")).click();
		
		String title = webDriver.getTitle();
		System.out.println("I'm on " +title+" page");
		webDriver.findElement(By.name("q")).sendKeys("artuu");
		Thread.sleep(5000);
		webDriver.quit();*/


