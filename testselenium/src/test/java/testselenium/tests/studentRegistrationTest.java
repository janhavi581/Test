package testselenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import testselenium.base.BaseTest;
import testselenium.pages.StudentRegistrationPage;

public class studentRegistrationTest  extends BaseTest
{
	@Test
	public void enterData()
	{
		StudentRegistrationPage sr = new StudentRegistrationPage(driver);
		sr.enterName("Kaustubh");
		sr.enterEmail("Kausubh43@gmail.com");
		sr.selectGender();
		sr.enterMobiNo("965798870889");
		sr.enterDob("23/9/1994");
		sr.enterSub("Maths");
		sr.selectHobby();
		
		String actualTitle= sr.getPagetitle();
		System.out.println(actualTitle);
		String expectedTitle ="Selenium Practice - Student Registration Form";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}

}
