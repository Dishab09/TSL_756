package in.lnt.day1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OracleCSS {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();// only parent methods are access
		webDriver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:1512520610394997120::NO:::");
		{
			FileInputStream inFile = new FileInputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
			XSSFWorkbook book = new XSSFWorkbook(inFile);
			XSSFSheet sheet = book.getSheet("Sheet1");
			for(int i=1; i<=sheet.getLastRowNum(); i++)
			{
				String data = sheet.getRow(i).getCell(0).toString();
				System.out.println(data);
				String data1 = sheet.getRow(i).getCell(1).toString();
				System.out.println(data1);

				webDriver.findElement(By.cssSelector("input#P11_USERNAME")).clear();
				webDriver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(data);
				webDriver.findElement(By.cssSelector("input[type = 'password']")).clear();
				webDriver.findElement(By.cssSelector("input[type = 'password']")).sendKeys(data1);
				webDriver.findElement(By.cssSelector("input[value='Login']")).click();
				if (webDriver.getTitle(). equals("Oracle")){
					webDriver.findElement(By.cssSelector("img[title='Logout']")).click();
					webDriver.findElement(By.cssSelector("a.htmldbInstruct")).click();
					System.out.println("Login Successful");
					sheet.getRow(i).createCell(3).setCellValue("Login Successful");
				}else{
					System.out.println("Login not Successful");
					sheet.getRow(i).createCell(3).setCellValue("Login not Successful");
				}
				FileOutputStream op = new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
				book.write(op);
			}	
		}
	}}
