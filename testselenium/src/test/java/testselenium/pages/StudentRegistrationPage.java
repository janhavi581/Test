package testselenium.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;

public class StudentRegistrationPage 
{
	WebDriver driver;
	WebDriverWait wait;
	By name = By.id("name");
	By email=By.id("email");
	By gender= By.id("gender");
	By mobile=By.id("mobile");
	By dob=By.id("dob");
	By sub=By.id("subjects");
	By hobby= By.xpath("(//input[@type='checkbox'])[3]");
	
	public StudentRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public void enterName(String nam)
	{
		driver.findElement(name).sendKeys(nam);
		
	}
	public void enterEmail(String ema)
	{
		driver.findElement(email).sendKeys(ema);
	}
	public void selectGender()
	{
		driver.findElement(gender).click();
	}
	public void enterMobiNo(String mobNo)
	{
		driver.findElement(mobile).sendKeys(mobNo);
	}
	public void enterDob(String date)
	{
		driver.findElement(dob).sendKeys(date);
	}
	public void enterSub(String subject)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(sub)).sendKeys(subject);
		
	}
	
	public void selectHobby()
	{
		wait.until(ExpectedConditions.elementToBeClickable(hobby)).click();
	}
	
	public String getPagetitle()
	{
		return driver.getTitle();
	}
}
