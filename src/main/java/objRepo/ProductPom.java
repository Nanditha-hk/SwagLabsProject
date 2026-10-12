package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPom {
	WebDriver driver;
	public ProductPom(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Products']")
	private WebElement Productpage;

	@FindBy(xpath = "//div[text() = 'Sauce Labs Backpack']")
	private WebElement Bagpack;
	
	@FindBy(id = "add-to-cart")
	private WebElement addtocart;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement CartIcon;
	
	public void getProductpage() {
		System.out.println(Productpage.isDisplayed());
	}

	public void getBagpack() {
		Bagpack.click();
	}

	public void getAddtocart() {
		addtocart.click();
	}

	public void getCartIcon() {
		CartIcon.click();
	}
	

}
