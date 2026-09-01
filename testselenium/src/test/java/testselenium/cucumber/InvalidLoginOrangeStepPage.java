package testselenium.cucumber;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testselenium.base.LoginOrangeBaseTest;
import testselenium.hooks.Hooks;
import testselenium.pages.LoginOrangePage;

public class InvalidLoginOrangeStepPage 
{
	LoginOrangeBaseTest lo;
	LoginOrangePage lp;
	@Given("user is on login page")
	public void user_is_on_login_page()
	{
		Hooks.driver.get("https://opensource-demo.orangehrmlive.com/");
		lo=new LoginOrangeBaseTest();
		lo.setUp();
		lp=new LoginOrangePage(lo.driver);
	}
	@When("user enters invalid username {string}")
	public void user_enters_invalid_username(String user)
	{
		lp.enterUserName(user);
	}
	@When("user enters invalid password {string}")
	public void user_enters_invalid_password(String pass)
	{
		lp.enterPAss(pass);
	}
	@When("user click on submit button")
	public void user_click_on_submit_button()
	{
		lp.clickLogn();
	}
	@Then("login is unsuccessful")
	public void login_is_unsuccessful()
	{
		String actual = lo.driver.getTitle();
		System.out.println("The Title is " +actual);
		String expected ="dashboard";
		Assert.assertNotEquals(actual,expected);
		lo.tearDown();
	}

}
