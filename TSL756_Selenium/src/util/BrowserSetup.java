package util;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
public class BrowserSetup{
	static WebDriver driver ;
	public  static WebDriver  browserStart(String name){
		if(name.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			}
		else if(name.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",".\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	public   WebDriver  browserStart(String name, String url){
		WebDriver driver =  browserStart(name);
		driver.get(url);
		return driver;
	}
	public  void getScreenShot(String Name){
		String timeStamp;
		TakesScreenshot  screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		timeStamp = new SimpleDateFormat("yyyy_MMM_dd_hh_mm_ss").format(new Date());
		try{
			FileHandler.copy(src, new File(".\\"+Name+timeStamp+".png"));
		} catch (IOException e){
			System.out.println("Error");
		}
	}
}