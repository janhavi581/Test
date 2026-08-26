package testselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Form {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("janhavi");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("mestryjanhavi98@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-check-input mt-0'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("9322666329");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("28-10-1998");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='subjects']")).sendKeys("English");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-check-input mt-0'])[6]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("( //*[contains(text(),'Elements')])[2]")).click();
		
				
	
				
		driver.close();
		
		

	}

}
