package dec11th;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTesting1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Forgot Password?")).click();
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.findElement(By.id("emailadd_recovery")).isDisplayed());
		
		System.out.println(driver.findElement(By.id("Submit")).isDisplayed());
	 
		driver.quit();
		

	}

}
