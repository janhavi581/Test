package testselenium.tests;

import org.testng.annotations.Test;

import testselenium.base.PlaygroundPracBaseTest;
import testselenium.pages.PlaygroundPage;

public class PlaygroundTest extends PlaygroundPracBaseTest
{
	@Test
	public void performActions()
	{
		PlaygroundPage pp=new PlaygroundPage(driver);
		pp.clickIframe();
		pp.enterNameIframe("Runika");
		pp.clickAlert();
		
		
	}
}
