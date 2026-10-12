package ecom.SwagLabs.Cart;

import org.testng.annotations.Test;
import org.testng.Assert;

import baseclass.Baseclass;
import objRepo.CartPom;
import objRepo.LoginPom;
import objRepo.ProductPom;

public class CartScript extends Baseclass {

    @Test(groups = "functional")
    public void VerifyCartScript() throws Exception {
        LoginPom log = new LoginPom(driver);
        ProductPom pro = new ProductPom(driver);
        CartPom cart = new CartPom(driver);

        log.Enterusername(prop.getProperty("username"));
        log.Enterpassword(prop.getProperty("password"));
        log.Enterlogin();

        pro.getBagpack();
        pro.getAddtocart();
        pro.getCartIcon();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"), "Product not added to cart");

        System.out.println("Product added to cart");
        cart.checkout();
    }

    @Test(groups = "integration")
    public void VerifyCartScript1() throws Exception {
        LoginPom log = new LoginPom(driver);
        ProductPom pro = new ProductPom(driver);
        CartPom cart = new CartPom(driver);

        log.Enterusername(prop.getProperty("username"));
        log.Enterpassword(prop.getProperty("password"));
        log.Enterlogin();

        pro.getBagpack();
        pro.getAddtocart();
        pro.getCartIcon();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"), "Cart page URL is incorrect");

        System.out.println("Cart page URL is correct");
        cart.checkout();
    }

    @Test(groups = "smoke")
    public void VerifyCartScript2() throws Exception {
        LoginPom log = new LoginPom(driver);
        ProductPom pro = new ProductPom(driver);
        CartPom cart = new CartPom(driver);

        log.Enterusername(prop.getProperty("username"));
        log.Enterpassword(prop.getProperty("password"));
        log.Enterlogin();

        pro.getBagpack();
        pro.getAddtocart();
        pro.getCartIcon();

        Assert.assertTrue(cart.VerifyCheckoutButton(), "Checkout option is not displayed");

        System.out.println("Checkout option is displayed");
        cart.checkout();
    }

    @Test(groups = "system")
    public void VerifyCartScript3() throws Exception {
        LoginPom log = new LoginPom(driver);
        ProductPom pro = new ProductPom(driver);
        CartPom cart = new CartPom(driver);

        log.Enterusername(prop.getProperty("username"));
        log.Enterpassword(prop.getProperty("password"));
        log.Enterlogin();

        pro.getBagpack();
        pro.getAddtocart();
        pro.getCartIcon();

        Assert.assertTrue(cart.VerifyProduct(), "Cart does not display the selected product");

        System.out.println("Selected product is displayed in the cart");
        cart.checkout();
    }
}