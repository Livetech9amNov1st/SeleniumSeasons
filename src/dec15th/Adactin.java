package dec15th;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Adactin {
	
	@Test(priority=1)
	public void loginTest()
	{
		System.out.println("Browser started ...");
		System.out.println("App Launched ...");
		Assert.assertTrue(false);
		System.out.println("Login Successful ...");
		System.out.println("Browser Closed...");
		
	}
	
	@Test(priority=0)
	public void registrationTest()
	{
		System.out.println("Browser started ...");
		System.out.println("App Launched ...");
		System.out.println("Registration Successful ...");
		System.out.println("Browser Closed...");
		
	}
	
	@Test(priority=2)
	public void forgotPasswordTest()
	{
		System.out.println("Browser started ...");
		System.out.println("App Launched ...");
		System.out.println("Forgot Password Successful ...");
		System.out.println("Browser Closed...");
		
	}
	
	@Test(priority=3,dependsOnMethods="loginTest")
	public void changePasswordTest()
	{
		System.out.println("Browser started ...");
		System.out.println("App Launched ...");
		System.out.println("Change Password Successful ...");
		System.out.println("Browser Closed...");
		
	}

}
