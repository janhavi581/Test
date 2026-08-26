package testselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StudentRegistrationForm 
{

	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
	
		driver.findElement(By.id("name")).sendKeys("roy");
		driver.findElement(By.id("email")).sendKeys("roy123@gmail.com");
		driver.findElement(By.id("gender")).click();
		driver.findElement(By.id("mobile")).sendKeys("96666688768");
		driver.findElement(By.id("dob")).sendKeys("27/10/1992");
		driver.findElement(By.id("subjects")).sendKeys("English");
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		
		
		
		
		
	}

}
