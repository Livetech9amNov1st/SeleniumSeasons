package dec19th;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows3 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		
	}

	@Test
	public void multipleWindowsTest() throws InterruptedException
	{
		
		String homeWindowId=driver.getWindowHandle();
		
		driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).click();
		
		switchToWindow("Not Found");
				
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("adactin");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		//driver.switchTo().window(homeWindowId);
		
		switchToWindow("Adactin.com - Hotel Reservation System");
				 	
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[contains(@src,'ios-button')]")).click();
		
		switchToWindow("TestFlight - Apple");
				
		driver.findElement(By.xpath("//a[text()='Terms of Service']")).click();
		
		Thread.sleep(3000);
		
			switchToWindow("Adactin.com - Hotel Reservation System");
			
	}
	
	private void switchToWindow(String expectedTitle) {
		
		Set<String> allWindowIds=driver.getWindowHandles();
		
		for(String windowId:allWindowIds)
		{
			driver.switchTo().window(windowId);
			
			if(driver.getTitle().equals(expectedTitle))
			{
				break;
			}
		}
		
	}

	@AfterMethod
	public void teardown() throws InterruptedException
	{
		
Thread.sleep(3000);
		
		driver.quit();
	}

}
