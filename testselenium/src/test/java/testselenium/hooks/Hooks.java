package testselenium.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks
{
	public WebDriver driver;
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
	}
	
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	

	

}
