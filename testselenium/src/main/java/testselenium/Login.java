package testselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) throws InterruptedException 
	{
	
        
        WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		String url=driver.getCurrentUrl();
		System.out.println("The Current URL is" +url);
		//driver.manage().window().minimize();
		Thread.sleep(3000);
		driver.navigate().to("https://www.vctcpune.com/");
		Thread.sleep(5000);
		String title=driver.getTitle();
		System.out.println("The title is"+title);
		
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
		Thread.sleep(5000);
		driver.navigate().refresh();
		driver.close();
		
		
	}

}
