package testselenium.utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AdvertisementUtil
{
	 public static void handleAdvertisement(WebDriver driver)
	 {

	        try {

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(
			            "document.querySelectorAll(" +
			            "'iframe[title=\"Advertisement\"], " +
			            "iframe[id^=\"aswift\"], " +
			            "iframe[src*=\"doubleclick\"], " +
			            "iframe[src*=\"googleads\"]'" +
			            ").forEach(function(ad) {" +
			            "ad.remove();" +
			            "});"
			        );
			
			        System.out.println("Advertisement handled.");
			
			    }
			        catch (Exception e) 
			        {
					
					        System.out.println("No advertisement found.");
		
			        }
}
	 public static  void click(WebDriver driver, WebElement element)
	 {
		 handleAdvertisement(driver);
		 element.click();
	 }
}


