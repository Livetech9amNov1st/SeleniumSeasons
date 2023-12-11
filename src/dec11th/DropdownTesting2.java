package dec11th;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTesting2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		
		//using Select Class
		
		WebElement drop=driver.findElement(By.id("searchDropdownBox"));
		
		Select s1=new Select(drop);
		
		
		//s1.selectByIndex(11);
		
		//s1.selectByValue("search-alias=stripbooks");
		
		s1.selectByVisibleText("Books");
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("books");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
