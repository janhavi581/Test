package testselenium.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import testselenium.utils.AdvertisementUtil;

public class AdvertisementListener implements WebDriverListener
{

    private WebDriver driver;

    public AdvertisementListener(WebDriver driver) {
        this.driver = driver;
    }
	@Override
    public void beforeClick(WebElement element)
	{

        WebDriver driver = ((org.openqa.selenium.WrapsDriver) element)
                .getWrappedDriver();

        AdvertisementUtil.handleAdvertisement(driver);

}
}