package Testng12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngDemo {
	
	public WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void openBrowser(String browser)
	{
      
      if(browser.equalsIgnoreCase("chrome"))
      {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		 driver = new ChromeDriver();
		//driver.get("https://www.timesheets.com/");
		//driver.manage().window().maximize();
      }
      else if(browser.equalsIgnoreCase("firefox"))
      {
    	  System.setProperty("webdriver.gecko.driver", "C:\\Automation\\geckodriver.exe");
			driver = new FirefoxDriver();
      }
      
      driver.get("https://www.timesheets.com/");
      
     
      
	}
	
	@Test(priority = 1)
	
	public void verifyTitle()
	
	{    
		String Expect = "Free Time Tracking Software | Timesheets.com is for your Employees.";
		String Actual = driver.getTitle();
		System.out.println(Actual);
		Assert.assertEquals(Actual, Expect);
	}

	
	@Test(priority = 2)
	public void verifyElementDisplay()
	{
		boolean Actual=driver.findElement(By.xpath("(//span[text() = 'Start a Free Trial'])[1]")).isDisplayed();
		Assert.assertEquals(Actual, true);
	}
	
	@Test(priority = 3)
	public void verifyTextOnStartButton()
	{
		String Actual=driver.findElement(By.xpath("(//span[text() = 'Start a Free Trial'])[1]")).getText();
		String expect = "Start a Free Trial";
		Assert.assertEquals(Actual, expect);
	}
	
	@Test(priority = 4)
	public void loginButtonClick()
	{
		driver.findElement(By.xpath("//a[text() = 'Login']")).click();
	   boolean Actual=driver.findElement(By.xpath("//input[@id = 'username']")).isEnabled();
	   Assert.assertEquals(Actual,true);
	
		
	}
	
	@Test(priority = 5,invocationCount = 3,timeOut = 30000)
	public void passwardfield()
	{
		
	   boolean Actual=driver.findElement(By.xpath("//input[@id = 'password']")).isEnabled();
	   Assert.assertEquals(Actual,true);
	
		
	}
	
	@Test(priority = 6)
	public void checkBoxSelect()
	{
		
	   boolean Actual=driver.findElement(By.xpath("//input[@id = 'rememberme']")).isSelected();
	   Assert.assertEquals(Actual,false);
	   driver.navigate().back();
	   
	 }
	
	@Test(priority = 7,groups = "sanity",description = "Verify toatal button on the webpage")
	public void verifyToatalButton() throws InterruptedException
	{
		List<WebElement>buttons=driver.findElements(By.xpath("//span[@class  = 'btn-text']"));
		int count = buttons.size();
		Assert.assertEquals(count, 3);
		Thread.sleep(5000);
	}
	
	@Test(priority  = 8)
	public void verifyFetureEle() throws InterruptedException
	{
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		Thread.sleep(5000);
	   WebElement feture =	driver.findElement(By.xpath("(//a[@class = 'mega-menu-link'])[1]"));
	   Thread.sleep(5000);
		act.moveToElement(feture).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[text() = 'Scheduling'])[1]")).click();
	}
	
	
	
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}

}
