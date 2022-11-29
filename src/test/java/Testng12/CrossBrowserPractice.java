package Testng12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserPractice {
	public WebDriver driver;
	@Parameters("browser")
	@Test
	public void crossbrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("chromedriver sucessfuly");
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Automation\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("firefoxdriver sucessfuly");
		}
		driver.get("https://demo.automationtesting.in/Frames.html");
		
		String title  = driver.getTitle();
		System.out.println(title);
		driver.quit();
	}
}

