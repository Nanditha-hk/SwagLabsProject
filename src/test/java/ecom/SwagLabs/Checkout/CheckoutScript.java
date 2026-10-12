package ecom.SwagLabs.Checkout;


import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import baseclass.Baseclass;
import objRepo.CartPom;
import objRepo.Checkout;
import objRepo.LoginPom;
import objRepo.ProductPom;
import utilities.ExcelUtility;


public class CheckoutScript extends Baseclass {
	@Test(groups = {"functional"})
	public void VerifyCheckout() throws IOException, InterruptedException
	{
		LoginPom log = new LoginPom(driver);
		ProductPom pro = new ProductPom(driver);
		CartPom cart = new CartPom(driver);
		Checkout checkout = new Checkout(driver);
		
		//login 
		log.Enterusername(prop.getProperty("username"));
		log.Enterpassword(prop.getProperty("password"));
		log.Enterlogin();
		
		//product
		pro.getProductpage();
		pro.getBagpack();
		pro.getAddtocart();
		pro.getCartIcon();
		
		//cart
		cart.VerifyProduct();
		cart.checkout();
		
		//checkout		
		checkout.getfirstname(ExcelUtility.getData("sheet1", 1, 0));
		checkout.getlastname(ExcelUtility.getData("sheet1", 1, 1));
		checkout.getpincode(ExcelUtility.getData("sheet1", 1, 2));
		checkout.getbutton();
		

		Assert.assertTrue(checkout.verifyPurchaseButton(), "Checkout information page not displayed");

		checkout.getPurchase();

		//Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"), "Order was not placed successfully");
	}
	@Test(groups = {"integration"})
		public void VerifyCheckout1() throws IOException, InterruptedException
		{
			LoginPom log = new LoginPom(driver);
			ProductPom pro = new ProductPom(driver);
			CartPom cart = new CartPom(driver);
			Checkout checkout = new Checkout(driver);
			
			//login 
			log.Enterusername(prop.getProperty("username"));
			log.Enterpassword(prop.getProperty("password"));
			log.Enterlogin();
			
			//product
			pro.getProductpage();
			pro.getBagpack();
			pro.getAddtocart();
			pro.getCartIcon();
			
			//cart
			cart.VerifyProduct();
			cart.checkout();
			
			//checkout		
			checkout.getfirstname(ExcelUtility.getData("sheet1", 2, 0));
			checkout.getlastname(ExcelUtility.getData("sheet1", 2, 1));
			checkout.getpincode(ExcelUtility.getData("sheet1", 2, 2));
			checkout.getbutton();
			

			Assert.assertTrue(checkout.verifyPurchaseButton(), "Checkout information page not displayed");

			checkout.getPurchase();

			//Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"), "Order was not placed successfully");
		}
}