package testselenium.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testselenium.base.LoginOrangeBaseTest;
import testselenium.listeners.TestListener;
import testselenium.pages.LoginOrangePage;
import testselenium.pages.OrangeDashboardPage;
import testselenium.utils.ConfigReader;
import testselenium.utils.ScreenshotUtil;

@Listeners(TestListener.class)
public class DashboardOrangeTest extends LoginOrangeBaseTest
{
	@DataProvider(name="employeeData")
	public Object[][] employeeData()
	{
		return new Object[][]{
			{"Amit","Anil","Sank","89"},
			{"Rajesh","Ram","Patil","99"},
			{"Sham","Dilip","Sinhi","79"},
				};
			
		}
	@Test(dataProvider="employeeData")
	public void dashboardActions(String fname, String mname, String lname, String empid) throws InterruptedException
	{
		
		LoginOrangePage lp = new LoginOrangePage(driver);
		lp.enterUserName(ConfigReader.getProperty("username"));
		lp.enterPAss(ConfigReader.getProperty("password"));
		
		ScreenshotUtil.takeScreenshot(driver,"beforLogin");
		lp.clickLogn();
		ScreenshotUtil.takeScreenshot(driver,"afterLogin");
		
		 Assert.assertTrue(driver.getCurrentUrl().contains("orangehrm"));
		 Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		OrangeDashboardPage op = new OrangeDashboardPage(driver);
		
		op.clickPim();
		op.clickAdd();
		
		op.enterFname(fname);
		op.enterMname(mname);
		op.enterlname(lname);
		op.enterEmpId(empid);
		
		ScreenshotUtil.takeScreenshot(driver,"beforeSave");
		op.clickSave();
		ScreenshotUtil.takeScreenshot(driver,"afterSave");
		
		
		
		op.selectNationality();
		op.selectMartialStatus();
		op.enterDob("1996-24-06");
		op.selectGender();
		
		
		op.saveDetails();
		
		op.clickEmployeeList();
		
		String expectedName = fname + " " + mname;
		
		op.enterNameInSearch(expectedName);
		op.clickSearch();
		op.getResult(expectedName);
		
		System.out.println("Jenkins CI Test - Dashboard test completed successfully");
		
		
		
		
		
	
	
	
	}

	

	
	
	
	

}

