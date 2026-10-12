
package objRepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPom {

    WebDriver driver;

    public CartPom(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement Bagpack;

    @FindBy(id = "checkout")
    private WebElement checkoutbutton;



public boolean VerifyProduct()
{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    return wait.until(ExpectedConditions.refreshed(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[text()='Sauce Labs Backpack']")
        )
    )).isDisplayed();
}



    public boolean VerifyCheckoutButton()
    {
        return checkoutbutton.isDisplayed();
    }

    public void checkout()
    {
        checkoutbutton.click();
    }
}
