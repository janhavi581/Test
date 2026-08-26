package testselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserLoginPage
{
	WebDriver driver;
	
	By fname = By.id("firstname");
	By lname = By.id("lastname");
	By userName =By.id("username");
	By pass = By.id("password");
	By register = By.xpath("(//input[@class='btn btn-primary'])[1]");
	By newUserBtn = By.xpath("//a[@class='btn btn-primary ms-4']");


public NewUserLoginPage(WebDriver driver)
{
	this.driver=driver;
}
public void clickNewUser()
{
	driver.findElement(newUserBtn).click();
}
public void enterFirstName(String name)
{
	driver.findElement(fname).sendKeys(name);
}
public void enterLastName(String lnamme)
{
	driver.findElement(lname).sendKeys(lnamme);
}
public void enterUserName(String uname)
{
	driver.findElement(userName).sendKeys(uname);
}
public void enterPassword(String passw)
{
	driver.findElement(pass).sendKeys(passw);
}
public void clickRegister()
{
	driver.findElement(register).click();
}

}
