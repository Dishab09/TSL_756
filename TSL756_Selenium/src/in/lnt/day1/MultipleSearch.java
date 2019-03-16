package in.lnt.day1;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class MultipleSearch 
{
	public static void main(String[] args) throws Exception
	{
		WebDriver driver = BrowserSetup.browserStart("chrome","https://nseindia.com/");
		Actions action = new Actions(driver);
		//driver.findElement(By.xpath("//*[@id=\"keyword\"]")).sendKeys("Reliance Industries Limited");
		//to hold in a group Action a
		//Action a =	action.moveToElement(search)
		//.sendKeys(search, "Reliance Industries Limited").build();
		
		FileInputStream inFile = new FileInputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(inFile);
		XSSFSheet sheet = book.getSheet("Sheet1");
		for(int i=1; i<=sheet.getLastRowNum(); i++)
		{
				String data = sheet.getRow(i).getCell(0).toString();
				System.out.println(data);
				driver.findElement(By.xpath("//*[@id=\"keyword\"]")).sendKeys(data);
				driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]")).click();
				WebElement e = driver.findElement(By.id("faceValue"));
				System.out.println("Face Value Is" + e.getText());
				BrowserSetup.getScreenShot("NSE");
				sheet.getRow(i).createCell(4).setCellValue(e.getText());
		}
		FileOutputStream op = new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
		book.write(op);
//		driver.findElement(By.xpath("//*[@id=\"keyword\"]")).sendKeys("Mahindra & Mahindra Limited");
//		driver.findElement(By.xpath("//*[contains(text(),'Mahindra & Mahindra Limited')]")).click();
//		WebElement e = driver.findElement(By.id("faceValue"));
//		System.out.println("Face Value Is" + e.getText());
//		BrowserSetup.getScreenShot("NSE");
//		
//		
//		driver.findElement(By.xpath("//*[@id=\"keyword\"]")).sendKeys("Bajaj Finserv Limited");
//		driver.findElement(By.xpath("//*[contains(text(),'Bajaj Finserv Limited')]")).click();
//		WebElement e1 = driver.findElement(By.id("faceValue"));
//		System.out.println("Face Value Is" + e1.getText());
//		BrowserSetup.getScreenShot("NSE");
//		
//		driver.findElement(By.xpath("//*[@id=\"keyword\"]")).sendKeys("Hindustan Unilever Limited");
//		driver.findElement(By.xpath("//*[contains(text(),'Hindustan Unilever Limited')]")).click();
//		WebElement e2 = driver.findElement(By.id("faceValue"));
//		System.out.println("Face Value Is" + e2.getText());
//		BrowserSetup.getScreenShot("NSE");
//		
//		driver.findElement(By.xpath("//*[@id=\"keyword\"]")).sendKeys("GAIL");
//		driver.findElement(By.xpath("//*[contains(text(),'GAIL')]")).click();
//		WebElement e3 = driver.findElement(By.id("faceValue"));
//		System.out.println("Face Value Is" + e3.getText());
//		BrowserSetup.getScreenShot("NSE");
//		
	}

}
