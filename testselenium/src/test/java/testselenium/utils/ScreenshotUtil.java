package testselenium.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {
	
//public - it can be called from anywhere, static → can call it using ScreenshotUtils.takeScreenshot() without creating an object,WebDriver driver → receives the current browser driver.
	//String screenshotName → receives the name you want for the screenshot.
	
	
	public static void takeScreenshot(WebDriver driver, String screenshotName)
	{
		//Converts the driver into TakesScreenshot so Selenium can take a screenshot.
		TakesScreenshot ts = (TakesScreenshot) driver;
		
//takes the screenshot and stores it temporarily as a File.
//getScreenshotAs() → takes the screenshot.
//OutputType.FILE → tells Selenium to give the screenshot as a File.
		File source = ts.getScreenshotAs(OutputType.FILE);
//Creates the location/path where we want to save the screenshot.
		Path destination = Paths.get(System.getProperty("user.dir"), "screenshot", screenshotName + ".jpeg");

		try {
			//Creates the screenshots folder if it doesn't already exist.
			Files.createDirectories(destination.getParent());
			Files.copy(source.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Screenshot Save " + destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
