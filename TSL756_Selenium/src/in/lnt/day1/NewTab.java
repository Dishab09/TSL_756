package in.lnt.day1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class NewTab {
	public static void main(String[] args) {

		// System.setProperty("webdriver.gecko.driver","C:\\Users\\vshadmin\\Desktop\\Jars\\geckodriver.exe");
		WebDriver driver = BrowserSetup.browserStart("chrome", "https://www.seleniumhq.org/");
		String ParentID = driver.getWindowHandle();

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(" //*[@id=\"menu_download\"]/a"));
		// to hold in a group Action a
		Action a = action.moveToElement(element).keyDown(Keys.CONTROL).click().build();
		a.perform();

		Set<String> allWin = driver.getWindowHandles();
		Iterator<String> itr = allWin.iterator();
		while (itr.hasNext()) {
			String ID = itr.next();
			System.out.println(ID);
			if (!(ID.equals(ParentID))) {
				driver.switchTo().window(ID);
				System.out.println("You are on" + driver.getTitle());
				driver.close();
			}
			driver.switchTo().window(ParentID);
		}
	}
}