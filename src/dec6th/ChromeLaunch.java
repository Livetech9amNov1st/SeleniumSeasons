package dec6th;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLaunch {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"D:\\008 LiveTech\\jars\\chromedriver-win64 (4)\\chromedriver-win64\\chromedriver.exe");
		new ChromeDriver();

	}

}
