package Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SQL_Command {
	private WebDriver driver;
	void SQl_Command(WebDriver idriver)
	{
		this.driver=idriver;
		
		
	}
	private By e_Logout=By.linkText("Logout");
	
	public void LogoutProcess()
	{
		driver.findElement(e_Logout).click();
	}
}
