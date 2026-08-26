package testselenium.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testselenium.base.NewUserBaseTest;
import testselenium.pages.LoginOrangePage;
import testselenium.pages.NewUserLoginPage;
import org.testng.Assert;

public class NewUSerSeleniumStepPage 
{
	NewUserBaseTest bs =new NewUserBaseTest();
	NewUserLoginPage nbp;
	
	
	@Given ("user_is_on_selenium_login_page")
	public void user_is_on_selenium_login_page()
	{
		bs.setUp();
		nbp=new NewUserLoginPage(bs.driver);
		
		
	}
   @When ("user_click_on_new_user")
   public void user_click_on_new_user()
   {
	   nbp.clickNewUser();
	   
   }
   @When ("user_enter_username {string}")
   public void user_enter_username(String user)
   {
	   nbp.enterUserName(user);
   }
   @When ("user_enter_first_name {string}")
   public void user_enter_first_name(String fname)
   {
	   nbp.enterFirstName(fname);
   }
   @When ("user_enter_password {string}")
   public void user_enter_password(String pass)
   {
	   nbp.enterPassword(pass);
   }
   @When ("user_enter_last_name {string}")
   public void user_enter_last_name(String lname)
   {
	   nbp.enterLastName(lname);
   }
   @When ("user_click_on_register")
   public void user_click_on_register()
   {
	   nbp.clickRegister();
   }
   @Then ("new user_should_register_successfully")
   public void new_user_should_register_successfully()
	{
		String ac = bs.driver.getCurrentUrl();
		System.out.println(" The Actual URL is : " + ac);
		String ex ="https://www.tutorialspoint.com/selenium/practice/register.php#";
		Assert.assertEquals(ac,ex);
		bs.tearDown();
	}
}
