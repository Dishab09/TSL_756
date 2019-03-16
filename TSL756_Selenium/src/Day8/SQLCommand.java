package Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SQLCommand {
	private WebDriver driver;
	public  SQLCommand(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	private By e_type=By.name("p_t04");
	private By e_run=By.xpath("//*[@value='Run']");
	private By e_getting=By.linkText("Logout");
	private By e_sql=By.xpath("//*[@title='SQL']");
	private By e_sqlcomm=By.xpath("//*[@title='SQL Commands']");
	void startSql()
	{
		driver.findElement(e_sql).click();
	}
	void startsqlComm()
	{
		driver.findElement(e_sqlcomm).click();
	}
	void executeCommand()
	{
		driver.findElement(e_type).sendKeys("select 2+3 from dual");
		driver.findElement(e_run).click();
	}
	
	void logoutProcess()
	{
		driver.findElement(e_getting).click();
		System.out.println("logout done");
	}

}



