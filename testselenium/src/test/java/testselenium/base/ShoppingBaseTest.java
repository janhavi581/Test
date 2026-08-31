package testselenium.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeMethod;

import testselenium.listeners.AdvertisementListener;
import testselenium.utils.ConfigReader;

import org.testng.annotations.AfterMethod;

public class ShoppingBaseTest
{
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriver originalDriver = new ChromeDriver();

        AdvertisementListener listener =
                new AdvertisementListener(originalDriver);

        driver = new EventFiringDecorator<>(listener)
                .decorate(originalDriver);

        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("shoppingurl"));
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
