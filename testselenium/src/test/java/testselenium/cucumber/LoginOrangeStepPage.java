package testselenium.cucumber;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testselenium.base.BaseTest;
import testselenium.base.LoginOrangeBaseTest;
import testselenium.hooks.Hooks;
import testselenium.pages.LoginOrangePage;

public class LoginOrangeStepPage
{
	
	LoginOrangeBaseTest bs = new LoginOrangeBaseTest();
	LoginOrangePage lo;
	
	@Given("User is on Orange Login Page")
	public void user_is_on_login_page()
	{
		Hooks.driver.get("https://opensource-demo.orangehrmlive.com/");
		bs.setUp();
			lo=new LoginOrangePage(bs.driver);
	}
	@When("User enters UserName {string}")
	public void user_enters_username(String user)
	{
		lo.enterUserName(user);
	}
	@When("User enters Password {string}")
	public void user_enters_password(String pass)
	{
		lo.enterPAss(pass);
	}
			
	@When("User click on Login button")
	public void user_click_on_Login_button()
	{
		lo.clickLogn();
	}
	@Then("User should be login successfully")
	public void User_should_be_login_successfully()
	{
		String actual = bs.driver.getTitle();
		String expected ="OrangeHRM";
		System.out.println("The Title is " +actual);
		Assert.assertEquals(actual,expected);
		bs.tearDown();
		
	}
	

}
