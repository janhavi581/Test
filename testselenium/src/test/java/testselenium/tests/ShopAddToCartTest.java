package testselenium.tests;

import org.testng.annotations.Test;

import testselenium.base.ShoppingBaseTest;
import testselenium.pages.ShoppingLoginPage;
import testselenium.pages.shopAddToCartPage;
import testselenium.utils.ConfigReader;

public class ShopAddToCartTest extends ShoppingBaseTest
{
	@Test
	public void addToCartActions()
	{
		ShoppingLoginPage sp=new ShoppingLoginPage(driver);
		sp.clickLoginLink();
		
		String emaill = ConfigReader.getProperty("email");
		String password = ConfigReader.getProperty("shpass");
		
		sp.enterEmail(emaill);
		sp.enterPass(password);
		sp.clickLoginBt();
		
		shopAddToCartPage sa = new shopAddToCartPage(driver);
		sa.clickCartLink();
		sa.verifyCartPage();
		
		
	}

}
