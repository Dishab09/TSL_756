package in.lnt.day1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;


import util.BrowserSetup;

public class ScreenShot
{
public static void main(String[] args) {
	

	WebDriver driver = BrowserSetup.browserStart("firefox","http://jqueryui.com/droppable/");
	Actions action = new Actions(driver);
	driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	WebElement srcElement=driver.findElement(By.id("draggable"));
	WebElement desElement=driver.findElement(By.id("droppable"));
	action.dragAndDrop(srcElement, desElement).perform();
	driver.switchTo().defaultContent();
	

    /* 
     File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     //The below method will save the screen shot in d drive with name "screenshot.png"
     timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());  
     FileUtils.copyFile(scrFile, new File("D:\\TestingDen\\Screenshots\\"+timeStamp+".png"));
     }*/
	
//	TakesScreenshot screen = (TakesScreenshot)driver;
//	
//	File src = screen.getScreenshotAs(OutputType.FILE);
//	
//	try {
//		FileHandler.copy(src, new File(".\\DragNdrop8.png"));
//	} catch (IOException e) {
//		System.out.println("Error");
//	}
	BrowserSetup.getScreenShot("DragNdropr");
	
}
}
