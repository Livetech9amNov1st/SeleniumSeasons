package dec21st;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptDemo2 {
	

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
	public void loginTest() throws InterruptedException
	{
		
		findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz009");
		findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz123");
		findElement(By.xpath("//input[@name='login']")).click();
			
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		
		driver.quit();
		
	}
	
	public WebElement  findElement(By by) throws InterruptedException
	{
		WebElement element=driver.findElement(by);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid red;');", element);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 3px solid red;');", element);
		
			
		return element;
		
	}

}
