package ecom.SwagLabsNegative;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.Baseclass;
import objRepo.CartPom;
import objRepo.Checkout;
import objRepo.LoginPom;
import objRepo.ProductPom;
import utilities.ExcelUtility;
import utilities.WebDriverUtility;

public class NegativeCheckout extends Baseclass {

    WebDriverUtility wUtil = new WebDriverUtility();

    
    @Test(groups = {"integration", "Negative"})
    public void verifyNegativeCheckout() throws Exception
    {
        LoginPom log = new LoginPom(driver);
        ProductPom pro = new ProductPom(driver);
        CartPom cart = new CartPom(driver);
        Checkout checkout = new Checkout(driver);
        ExcelUtility excel = new ExcelUtility();

        log.Enterusername(prop.getProperty("username"));
        log.Enterpassword(prop.getProperty("password"));
        log.Enterlogin();

        pro.getProductpage();
        pro.getBagpack();
        pro.getAddtocart();
        pro.getCartIcon();

        Thread.sleep(2000);

        cart.VerifyProduct();
        cart.checkout();

        checkout.getfirstname(excel.getData("sheet1", 3, 0));
        checkout.getlastname("");
        checkout.getpincode(excel.getData("sheet1", 3, 2));
        checkout.getbutton();

        Thread.sleep(2000);

        wUtil.takingScreenshot(driver, "verifyNegativeCheckout1");

        Assert.assertTrue(checkout.verifyErrorMessage(),
                "Error message not displayed for empty last name");

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"),
                "User navigated to the next page with empty last name");
    }
    
    
    @Test(groups = {"smoke", "Negative"})
    public void VerifyCheckout3() throws Exception
    {
        LoginPom log = new LoginPom(driver);
        ProductPom pro = new ProductPom(driver);
        CartPom cart = new CartPom(driver);
        Checkout checkout = new Checkout(driver);
        ExcelUtility excel = new ExcelUtility();

        log.Enterusername(prop.getProperty("username"));
        log.Enterpassword(prop.getProperty("password"));
        log.Enterlogin();

        pro.getProductpage();
        pro.getBagpack();
        pro.getAddtocart();
        pro.getCartIcon();

        cart.VerifyProduct();
        cart.checkout();

        checkout.getfirstname("");
        checkout.getlastname(excel.getData("sheet1", 4, 1));
        checkout.getpincode(excel.getData("sheet1", 4, 2));
        checkout.getbutton();

        Thread.sleep(2000);

        wUtil.takingScreenshot(driver, "VerifyCheckout4");

        Assert.assertTrue(checkout.verifyErrorMessage(),
                "Error message not displayed for empty first name");

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"),
                "User navigated to the next page with empty first name");
    }

    @Test(groups = {"system", "Negative"})
    public void VerifyCheckout5() throws Exception
    {
        LoginPom log = new LoginPom(driver);
        ProductPom pro = new ProductPom(driver);
        CartPom cart = new CartPom(driver);
        Checkout checkout = new Checkout(driver);
        ExcelUtility excel = new ExcelUtility();

        log.Enterusername(prop.getProperty("username"));
        log.Enterpassword(prop.getProperty("password"));
        log.Enterlogin();

        pro.getProductpage();
        pro.getBagpack();
        pro.getAddtocart();
        pro.getCartIcon();

        cart.VerifyProduct();
        cart.checkout();

        checkout.getfirstname(excel.getData("sheet1", 5, 0));
        checkout.getlastname(excel.getData("sheet1", 5, 1));
        checkout.getpincode("");
        checkout.getbutton();

        Thread.sleep(2000);

        wUtil.takingScreenshot(driver, "VerifyCheckout5");

        Assert.assertTrue(checkout.verifyErrorMessage(),
                "Error message not displayed for empty postal code");

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"),
                "User navigated to the next page with empty postal code");
    }
    
}
