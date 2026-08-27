package testselenium.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import org.openqa.selenium.WebDriver;

import testselenium.base.LoginOrangeBaseTest;
import testselenium.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("The Failed Test: " + result.getName());

        Object testInstance = result.getInstance();

        if (testInstance instanceof LoginOrangeBaseTest) {

            LoginOrangeBaseTest bt = (LoginOrangeBaseTest) testInstance;

            WebDriver driver = bt.driver;

            if (driver != null) {
                ScreenshotUtil.takeScreenshot(driver, result.getName());
            }
        }
    }
}