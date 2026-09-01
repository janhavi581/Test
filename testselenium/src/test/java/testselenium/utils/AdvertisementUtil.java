
package testselenium.utils;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvertisementUtil {

    public static void handleAdvertisement(WebDriver driver) {

        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            String script =
                    "document.querySelectorAll(" +
                    "'iframe[title=\"Advertisement\"], " +
                    "iframe[id^=\"aswift\"], " +
                    "iframe[src*=\"doubleclick\"], " +
                    "iframe[src*=\"googleads\"], " +
                    "[id^=\"aswift\"][id$=\"_host\"]'" +
                    ").forEach(function(ad) {" +
                    "ad.remove();" +
                    "});";

            js.executeScript(script);

            System.out.println("Advertisement handled.");

        } catch (Exception e) {

            System.out.println("No advertisement found.");

        }
    }

    public static void click(WebDriver driver, WebElement element) {

        handleAdvertisement(driver);

        try {

            element.click();

        } catch (ElementClickInterceptedException e) {

            System.out.println(
                    "Click intercepted. Handling advertisement again."
            );

            handleAdvertisement(driver);

            element.click();
        }
    }
}

