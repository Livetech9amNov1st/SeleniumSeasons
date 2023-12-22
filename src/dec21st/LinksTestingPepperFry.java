package dec21st;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTestingPepperFry {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
		
	}

	@Test
	public void linksTest() throws InterruptedException
	{
		
		String homeWindowId=driver.getWindowHandle();
		
		WebElement block=driver.findElement(By.xpath("//p[text()='Partner With Us']/parent::div"));
		
		List<WebElement> allLinks=block.findElements(By.tagName("a"));
		
		System.out.println("No of Links "+allLinks.size());
		
		for(int i=0;i<allLinks.size();i++)
		{
			WebElement link=allLinks.get(i);
			
			System.out.println(link.getText());
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			
			//js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
			
			//link.click();
			
			js.executeScript("arguments[0].click();", link);
				
			
			System.out.println("No of Tabs "+driver.getWindowHandles().size());
			
			driver.switchTo().window(homeWindowId);
			
			Thread.sleep(3000);
			
		}
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		
		//driver.quit();
		
	}

}
