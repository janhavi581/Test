package testselenium.tests;

import org.testng.annotations.Test;

import testselenium.base.ShoppingBaseTest;
import testselenium.pages.ShoppingLoginPage;
import testselenium.pages.ShoppingProductPage;
import testselenium.utils.ConfigReader;

public class ShoppingProductTest extends ShoppingBaseTest 
{
	@Test
	public void productPageActions()
	{
		ShoppingLoginPage sp=new ShoppingLoginPage(driver);
		sp.clickLoginLink();
		
		String emaill = ConfigReader.getProperty("email");
		String password = ConfigReader.getProperty("shpass");
		
		sp.enterEmail(emaill);
		sp.enterPass(password);
		sp.clickLoginBt();
		
		ShoppingProductPage  spp = new ShoppingProductPage (driver);
		spp.clickProductPageLink();
		spp.verifyProductPage();
		spp.searchProduct("tshirt");
		//spp.selectProduct();
		spp.verifySearchProduct("tshirt");
	}
	
	@Test
	public void searchInvalidProduct()
	{
		ShoppingLoginPage sp=new ShoppingLoginPage(driver);
		sp.clickLoginLink();
		
		String emaill = ConfigReader.getProperty("email");
		String password = ConfigReader.getProperty("shpass");
		
		sp.enterEmail(emaill);
		sp.enterPass(password);
		sp.clickLoginBt();
		
		ShoppingProductPage  spp = new ShoppingProductPage (driver);
		spp.clickProductPageLink();
		spp.verifyProductPage();
		spp.searchProduct("@#RGDFHDSFZG");
		spp.verifyNoProductsFound();
	}
	
	@Test
	public void checkBrandProducts()
	{
		ShoppingLoginPage sp=new ShoppingLoginPage(driver);
		sp.clickLoginLink();
		
		String emaill = ConfigReader.getProperty("email");
		String password = ConfigReader.getProperty("shpass");
		
		sp.enterEmail(emaill);
		sp.enterPass(password);
		sp.clickLoginBt();
		
		ShoppingProductPage  spp = new ShoppingProductPage (driver);
		spp.clickProductPageLink();
		spp.verifyProductPage();
		
		spp.selectBrand();
		spp.verifyBrandResult("Polo");
	}

}
