package testselenium.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;


import testselenium.base.LoginOrangeBaseTest;
import testselenium.utils.ScreenshotUtil;

public class TestListener implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result)
	{
	
		
		System.out.println("The Failed Test: " + result.getName());
		
		LoginOrangeBaseTest bt =
                (LoginOrangeBaseTest) result.getInstance();
		
		ScreenshotUtil.takeScreenshot(bt.driver, result.getName());
		
	}
	
}

