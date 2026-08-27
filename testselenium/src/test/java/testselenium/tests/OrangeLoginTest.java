package testselenium.tests;

import org.testng.annotations.Test;

import testselenium.base.LoginOrangeBaseTest;
import testselenium.pages.LoginOrangePage;
import org.testng.Assert;

public class OrangeLoginTest extends LoginOrangeBaseTest
{
	@Test
	public void login()
	{
		LoginOrangePage lp = new LoginOrangePage(driver);
		lp.enterUserName("Admin");
		lp.enterPAss("admin123");
		lp.clickLogn();
		
		
		
	}
	
	@Test
	public void invalidLoginCredentials()
	{
		LoginOrangePage lop = new LoginOrangePage(driver);
		lop.enterUserName("Admin");
		lop.enterPAss("pass123");
		lop.clickLogn();
		
		String expectedText = "Invalid credentials";
		
		String actualText = lop.getInvalidMessage();
		System.out.println(actualText);
		
		Assert.assertEquals(actualText,expectedText);
		System.out.println(actualText);
		
	}
	
	

}
