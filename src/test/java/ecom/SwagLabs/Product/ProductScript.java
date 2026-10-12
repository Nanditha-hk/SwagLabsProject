package ecom.SwagLabs.Product;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.Baseclass;
import objRepo.LoginPom;
import objRepo.ProductPom;

public class ProductScript extends Baseclass {
	@Test(groups = {"functional", "integration"})
	public void VerifyProduct() throws Exception {
		
		LoginPom log = new LoginPom(driver);
		ProductPom pro = new ProductPom(driver);
		
		log.Enterusername(prop.getProperty("username"));
		log.Enterpassword(prop.getProperty("password"));
		log.Enterlogin();
		
		pro.getBagpack();
		pro.getAddtocart();
		pro.getCartIcon();
		Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
		System.out.println("Cart page opened");
	}
	
	@Test(groups = "smoke")
	public void VerifyProduct1() throws Exception {
		
		LoginPom log = new LoginPom(driver);
		ProductPom pro = new ProductPom(driver);
		
		log.Enterusername(prop.getProperty("username"));
		log.Enterpassword(prop.getProperty("password"));
		log.Enterlogin();
		
		pro.getBagpack();
		pro.getAddtocart();
		pro.getCartIcon();	
	}
	
	@Test(groups = "system")
	public void VerifyProduct2() throws Exception {
		
		LoginPom log = new LoginPom(driver);
		ProductPom pro = new ProductPom(driver);
		
		log.Enterusername(prop.getProperty("username"));
		log.Enterpassword(prop.getProperty("password"));
		log.Enterlogin();
		
		pro.getBagpack();
		pro.getAddtocart();
		pro.getCartIcon();

	}
}
