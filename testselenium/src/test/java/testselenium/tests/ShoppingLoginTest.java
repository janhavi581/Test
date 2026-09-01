package testselenium.tests;

import org.testng.annotations.Test;

import testselenium.base.ShoppingBaseTest;
import testselenium.pages.ShoppingLoginPage;
import testselenium.utils.ConfigReader;

public class ShoppingLoginTest extends ShoppingBaseTest
{
	@Test(priority=1)
	public void login()
	{
		ShoppingLoginPage sp=new ShoppingLoginPage(driver);
		sp.clickLoginLink();
		
		String emaill = ConfigReader.getProperty("email");
		String password = ConfigReader.getProperty("shpass");
		
		sp.enterEmail(emaill);
		sp.enterPass(password);
		sp.clickLoginBt();
		sp.verifyLogin();
	}
	@Test (priority=2)
	public void invalidLogin()
	{
		ShoppingLoginPage sp=new ShoppingLoginPage(driver);
		sp.clickLoginLink();
		sp.enterEmail("ffdxyhjg#@gffsdxyhct");
		sp.enterPass("ffdxyh");
		sp.clickLoginBt();
		sp.verifyInvalidLoginErrorMessage();
	}

}
