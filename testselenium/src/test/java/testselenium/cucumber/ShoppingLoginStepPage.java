package testselenium.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testselenium.base.ShoppingBaseTest;
import testselenium.hooks.Hooks;
import testselenium.pages.ShoppingLoginPage;
import testselenium.utils.ConfigReader;

public class ShoppingLoginStepPage
{
	
	
	ShoppingLoginPage slp;
	
	
	@Given ("user is on shopping page")
	public void user_is_on_shopping_page()
	{
		Hooks.driver.get("https://automationexercise.com/");
		slp= new ShoppingLoginPage(Hooks.driver);
		
	
	}
	
	@When ("user click on login link")
	public void user_click_on_login_link()
	{
		slp.clickLoginLink();
	}
	@When ("user enter email") 
	public void user_enter_email()
	{
		String email = ConfigReader.getProperty("email");
		slp.enterEmail(email);
		
	}
	@When ("user enter password") 
	public void user_enter_password()
	{
		String password = ConfigReader.getProperty("shpass");
		slp.enterPass(password);
	}
	@When ("user click on login button")
	public void user_click_on_login_button()
	{
		slp.clickLoginBt();
	}
	@Then ("the login should be successful") 
	
	public void the_login_should_be_successful()
	{
		slp.verifyLogin();
	}
	
	
	
	@When ("user enter invalid email {string}") 
	public void user_enter_invalid_email(String ema)
	{
		slp.enterEmail(ema);
	}
	@When ("user enter invalid password {string}") 
	public void user_enter_invalid_password(String pass)
	{
		slp.enterPass(pass);
	}
	
	@Then ("the invalid login error message should be displayed")
	public void the_invalid_login_error_message_should_be_displayed()
	{
		slp.verifyInvalidLoginErrorMessage();
	}

}
