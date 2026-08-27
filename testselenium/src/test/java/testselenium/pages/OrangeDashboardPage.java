package testselenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import org.openqa.selenium.WebElement;

public class OrangeDashboardPage
{
	public WebDriver driver;
	public WebDriverWait wait;
	
	By pim = By.xpath("//a[@href='/web/index.php/pim/viewPimModule']");
	By add = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	By fname = By.name("firstName");
	By mname = By.name("middleName");
	By lname = By.name("lastName");
	By empid = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By save = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
	By formLoader = By.className("oxd-form-loader");
	By nationality = By.xpath("//label[text()='Nationality']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
	By option = By.xpath("//div[contains(@class,'oxd-select-option')][.//span[text()='Indian']]");
	
	By martialStatus = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
	By marriedOption = By.xpath("//div[contains(@class,'oxd-select-option')]//*[normalize-space()='Married']");
	
	By dob = By.xpath("//input[@placeholder='yyyy-dd-mm']");
	
	By gender=By.xpath("(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[2]");
	
	By bloodGroup = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[3]");
	By bloodTypeOption = By.xpath("//div[contains(@class,'oxd-select-option')]//*[normalize-space()='A+']");
	
	By saveDet = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
	
	By search = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
	
	By empnames=By.xpath("(//input[@placeholder='Type for hints...'])[1]");
	
	By employeeList = By.xpath("(//a[normalize-space()='Employee List'])[1]");
	
	By result = By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']//div[text()='Kestin Keshav']");
	
	
	public OrangeDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}
	
	
	
	public void clickPim()
	{
		wait.until(ExpectedConditions.elementToBeClickable(pim)).click();
		
		
	}
	public void clickAdd()
	{
		wait.until(ExpectedConditions.elementToBeClickable(add)).click();
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoader));
		
	}
	public void enterFname(String firnam)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(fname)).sendKeys(firnam);
		
	}
	public void enterMname(String midnam)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(mname)).sendKeys(midnam);
		
	}
	public void enterlname(String lasnam)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(lname)).sendKeys(lasnam);
		
	}
	public void enterEmpId(String emp)
	{
		driver.findElement(empid).sendKeys(emp);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoader));
	}
	
	private void waitForFormToLoad()
	{
	    wait.until(ExpectedConditions.visibilityOfElementLocated(nationality));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoader));
	}
	
	
	public void clickSave()
	{
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoader));

	    WebElement saveButton = wait.until(
	        ExpectedConditions.elementToBeClickable(save)
	    );

	    saveButton.click();

	    wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoader));
	}
	public void selectNationality()
	{
	    waitForFormToLoad();

	    wait.until(ExpectedConditions.elementToBeClickable(nationality)).click();

	    wait.until(ExpectedConditions.elementToBeClickable(option)).click();
	}
	
	
	public void selectMartialStatus()
	{
		
		waitForFormToLoad();
		
		wait.until(ExpectedConditions.elementToBeClickable(martialStatus)).click();
		wait.until(ExpectedConditions.elementToBeClickable(marriedOption)).click();
	}
	public void enterDob(String dateob)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(dob))
        .sendKeys(dateob);
	}
	public void selectGender()
	{
		driver.findElement(gender).click();
	}
	public void selectBloodGroup()
	{
		wait.until(ExpectedConditions.elementToBeClickable(bloodGroup)).click();

	    wait.until(ExpectedConditions.elementToBeClickable(bloodTypeOption)).click();
	}
	public void saveDetails()
	{
		wait.until(ExpectedConditions.elementToBeClickable(saveDet)).click();
	}
	
	public void clickEmployeeList()
	{
		driver.findElement(employeeList).click();
	}
	public void enterNameInSearch(String empName)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(empnames))
        .sendKeys(empName);
		
	}
	public void clickSearch()
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoader));
		wait.until(ExpectedConditions.elementToBeClickable(search)).click();
		
	}
	public void getResult(String expectedName)
	{
	    WebElement resultElement = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']//div[text()='"
	                     + expectedName + "']")
	        )
	    );

	    String acText = resultElement.getText();

	    Assert.assertEquals(acText, expectedName);
	}
	
}

