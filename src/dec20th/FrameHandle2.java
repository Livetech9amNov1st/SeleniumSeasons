package dec20th;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle2 {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://www.angelfire.com/super/badwebs/");
		driver.manage().window().maximize();
		
	}

	@Test
	public void frameHandleTest() throws InterruptedException
	{
		//frame(int): int is index starting from 0 
		
		//driver.switchTo().frame(0);
		
		//frame(String): id or name attribute value 
		
		String homeWindowId=driver.getWindowHandle();
		
		driver.switchTo().frame("contents");
		
		driver.findElement(By.xpath("//font[contains(text(),'Hate Frames Page')]/parent::a")).click();
		
		//driver.switchTo().defaultContent();
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("main");
		
		driver.findElement(By.xpath("//b[text()=' example ']/ancestor::a")).click();
		
		driver.switchTo().window(homeWindowId);
		
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		
		driver.quit();
		
	}
}
