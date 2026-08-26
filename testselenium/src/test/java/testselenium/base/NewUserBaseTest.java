package testselenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class NewUserBaseTest 
{
public WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/login.php");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	


}
