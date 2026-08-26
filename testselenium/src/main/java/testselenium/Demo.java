package testselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args)
	{
	

	        WebDriver driver = new ChromeDriver();
	        driver.get("https://www.facebook.com");

	        System.out.println("Title: " + driver.getTitle());

	        driver.quit();
	}

}
    
    