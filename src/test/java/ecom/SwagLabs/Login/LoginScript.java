package ecom.SwagLabs.Login;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.Baseclass;
import objRepo.LoginPom;
import objRepo.LogoutPom;
import utilities.ExcelUtility;
import utilities.WebDriverUtility;
public class LoginScript extends Baseclass {
	WebDriverUtility wUtil = new WebDriverUtility();
 @Test(groups = {"functional","smoke"})

	public void VerifyLoginScript() throws Exception
	{
		LoginPom log = new LoginPom(driver);
		
		
		log.Enterusername(ExcelUtility.getData("Sheet2", 1, 0));
		log.Enterpassword(ExcelUtility.getData("Sheet2", 1, 1));
		log.Enterlogin();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html")," Login Unsuccessful");
		System.out.println("Login Successful");
	}
 



	
	@Test(groups = "integration")
		public void VerifyLoginScript1() throws Exception
		{
			LoginPom log = new LoginPom(driver);
			
			log.Enterusername(ExcelUtility.getData("Sheet2", 2, 0));
			log.Enterpassword(ExcelUtility.getData("Sheet2", 2, 1));
			log.Enterlogin();
			
			Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html")," Page Not Displayed");
			System.out.println("Page Displayed");
			
		}
	
	//Invalid Password
	@Test(groups = {"functional"})
	public void VerifyLoginScriptNegative() throws Exception
	{
	    LoginPom log = new LoginPom(driver);

	    log.Enterusername(ExcelUtility.getData("Sheet2", 3, 0));
	    log.Enterpassword(ExcelUtility.getData("Sheet2", 3, 1));
	    log.Enterlogin();
	    wUtil.takingScreenshot(driver, "VerifyLoginScriptNegative");

	    Assert.assertFalse(driver.getCurrentUrl().contains("inventory.html"),
	            "Login should fail for invalid credentials");

	    System.out.println("Login Unsuccessful as expected");
	}
	
	//Wrong Username
	@Test(groups = {"functional"})
	public void VerifyLoginScriptNegative1() throws Exception
	{
	    LoginPom log = new LoginPom(driver);

	    log.Enterusername(ExcelUtility.getData("Sheet2", 4, 0));
	    log.Enterpassword(ExcelUtility.getData("Sheet2", 4, 1));
	    log.Enterlogin();
	    wUtil.takingScreenshot(driver, "VerifyLoginScriptNegative1");

	    Assert.assertFalse(driver.getCurrentUrl().contains("inventory.html"),
	            "Login should fail for invalid credentials");

	    System.out.println("Login Unsuccessful as expected");
	}
	
	
	
	@Test(groups = "system")
		public void VerifyLoginScript2() throws Exception
		{
			LoginPom log = new LoginPom(driver);
			LogoutPom logo = new LogoutPom(driver);
			
			log.Enterusername(prop.getProperty("username"));
			log.Enterpassword(prop.getProperty("password"));
			log.Enterlogin();
			
			logo.logout();		
			
		}
}