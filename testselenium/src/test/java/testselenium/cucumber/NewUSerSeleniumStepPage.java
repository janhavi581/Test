package testselenium.cucumber;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testselenium.base.NewUserBaseTest;
import testselenium.pages.NewUserLoginPage;

public class NewUSerSeleniumStepPage {

    NewUserBaseTest bs = new NewUserBaseTest();
    NewUserLoginPage nbp;

    @Given("user is on selenium login page")
    public void user_is_on_selenium_login_page() {

        bs.setUp();
        nbp = new NewUserLoginPage(bs.driver);
    }

    @When("user click on new user")
    public void user_click_on_new_user() {

        nbp.clickNewUser();
    }

    @When("user enter username {string}")
    public void user_enter_username(String user) {

        nbp.enterUserName(user);
    }

    @When("user enter first name {string}")
    public void user_enter_first_name(String fname) {

        nbp.enterFirstName(fname);
    }

    @When("user enter password {string}")
    public void user_enter_password(String pass) {

        nbp.enterPassword(pass);
    }

    @When("user enter last name {string}")
    public void user_enter_last_name(String lname) {

        nbp.enterLastName(lname);
    }

    @When("user click on register")
    public void user_click_on_register() {

        nbp.clickRegister();
    }

    @Then("new user should register successfully")
    public void new_user_should_register_successfully() {

        String ac = bs.driver.getCurrentUrl();

        System.out.println("The Actual URL is : " + ac);

        String ex = "https://www.tutorialspoint.com/selenium/practice/register.php#";

        Assert.assertEquals(ac, ex);

        bs.tearDown();
    }
}