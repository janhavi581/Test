package testselenium.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShoppingProductPage 
{
	public WebDriverWait wait;
	public WebDriver driver;
	
	
	@FindBy(xpath="//a[@href='/products']")
	WebElement prodLink;
	
	@FindBy(xpath="//input[@id='search_product']")
	WebElement search;
	
	@FindBy(xpath="//button[@id='submit_search']")
	WebElement searchIcon;
	
	@FindBy(xpath="(//i[@class='fa fa-plus-square'])[4]")
	WebElement viewProd;
	
	@FindBy(xpath="//span[normalize-space()='Tshirts']")
	WebElement tshirt;
	
	@FindBy(xpath="//div[@class='productinfo text-center']/p")
	List<WebElement> prodNames;
	
	@FindBy(xpath="//a[@href='/brand_products/Polo']")
	WebElement brand;
	
	@FindBy(xpath="//h2[contains(normalize-space(),'Brand -') and contains(normalize-space(),'Products')]")
	WebElement brandProductHeading;
	
	public ShoppingProductPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickProductPageLink()
	{
		wait.until(ExpectedConditions.elementToBeClickable(prodLink)).click();
	}
	public void verifyProductPage()
	{
		String ac = driver.getCurrentUrl();
		System.out.println("The Actual Text is " +ac);
		String ex = "https://automationexercise.com/products";
		Assert.assertEquals(ac, ex);
	}
	
	public void searchProduct(String prod)
	{	
		wait.until(ExpectedConditions.visibilityOf(search)).sendKeys(prod);
		wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
		
		
	}
	
	public void selectProduct()
	{
		wait.until(ExpectedConditions.elementToBeClickable(viewProd)).click();
	}
	
	
	public void verifySearchProduct(String expectedProduct)
	{
	    List<WebElement> products = wait.until(
	            ExpectedConditions.visibilityOfAllElements(prodNames)
	    );

	    Assert.assertTrue(
	            products.size() > 0,
	            "No products found for search: " + expectedProduct
	    );

	    String expected = expectedProduct
	            .toLowerCase()
	            .replaceAll("[^a-z0-9]", "");

	    for(WebElement product : products)
	    {
	        String actualProduct = product.getText();

	        System.out.println("Product found: " + actualProduct);

	        String actual = actualProduct
	                .toLowerCase()
	                .replaceAll("[^a-z0-9]", "");

	        Assert.assertTrue(
	                actual.contains(expected),
	                "Product does not match search: " + actualProduct
	        );
	    }
	}
	
	
	
	
	public void verifyNoProductsFound()
	{
	    List<WebElement> products = driver.findElements(
	            By.xpath("//div[@class='productinfo text-center']/p")
	    );

	    String ac = String.valueOf(products.size());
	    String ex = "0";

	    System.out.println("Actual product count: " + ac);

	    Assert.assertEquals(
	            ac,
	            ex,
	            "Products are displayed for invalid search"
	    );
	}
	public void selectBrand()
	{
		wait.until(ExpectedConditions.elementToBeClickable(brand)).click();
	}
	public void verifyBrandResult(String expectedBrand)
	{
		String ac = wait.until(
		        ExpectedConditions.visibilityOf(brandProductHeading)).getText();
		System.out.println("The actual Text is " +ac);
		
		
		String ex="Brand - " + expectedBrand + " PRODUCTS";
		
		ac = ac.replaceAll("\\s+", " ").trim();
	    ex = ex.replaceAll("\\s+", " ").trim();
		
		System.out.println("Actual Text: " + ac);
	    System.out.println("Expected Text: " + ex);

	    Assert.assertEquals(ac.toLowerCase(),ex.toLowerCase(),"Brand product heading is not correct");
	}
	}
	

