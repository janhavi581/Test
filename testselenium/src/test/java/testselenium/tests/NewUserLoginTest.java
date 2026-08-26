package testselenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testselenium.base.NewUserBaseTest;
import testselenium.pages.NewUserLoginPage;

public class NewUserLoginTest extends NewUserBaseTest
{
	
	@Test
	public void createNewUser()
	{
	
	NewUserLoginPage nl = new NewUserLoginPage(driver);
	nl.clickNewUser();
	nl.enterFirstName("Janhavi");
	nl.enterLastName("Mestry");
	nl.enterUserName("Janhavi1234");
	nl.enterPassword("Janhavi@1234");
	nl.clickRegister();
	
	
	
	
	}
}
