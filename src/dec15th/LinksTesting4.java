package dec15th;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTesting4 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		WebElement block= driver.findElement(By.xpath("//div[text()='Make Money with Us']/parent::div"));
		
		List<WebElement> allLinks=block.findElements(By.tagName("a"));
		
		for(int i=0;i<allLinks.size();i++)
		{
			WebElement link=allLinks.get(i);
			
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
			
			//link.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("arguments[0].click();", link);
			
			Thread.sleep(1000);
			
			 System.out.println(driver.getTitle());
			 
			 System.out.println(driver.getCurrentUrl());
			 
			 driver.navigate().back();
			 
			 Thread.sleep(1000);
			 
			 block= driver.findElement(By.xpath("//div[text()='Make Money with Us']/parent::div"));
				
			 allLinks=block.findElements(By.tagName("a"));
			 
		}
		
		driver.quit();

	}

}
