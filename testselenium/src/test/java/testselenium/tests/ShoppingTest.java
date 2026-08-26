package testselenium.tests;

import org.testng.annotations.Test;

import testselenium.base.ShoppingBaseTest;
import testselenium.pages.ShoppingPage;

public class ShoppingTest extends ShoppingBaseTest
{
	@Test
	public void selectProduct()
	{
		ShoppingPage sp = new ShoppingPage(driver);
		sp.clickProd();
		sp.selectProduct();
		sp.viewCart();
		sp.verifyCart();
		sp.checkOutBut();
		sp.clickLoginLink();
		
		sp.enterEmail("mestryjanhavi98@gmail.com");
		sp.enterPass("Keval@890");
		sp.clickLoginBt();
		sp.verifyLogin();
	}

}
