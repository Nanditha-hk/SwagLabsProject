package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
	WebDriver driver;
	public Checkout(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "first-name")
	private WebElement fname;
	
	@FindBy(id = "last-name")
	private WebElement lname;
	
	@FindBy(id = "postal-code")
	private WebElement pincode;
	
	@FindBy(id = "continue")
	private WebElement button;
	
	@FindBy(id="finish")
	private WebElement purchase;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement errorMessage;
	
	public void getfirstname(String value)
	{
		fname.sendKeys(value);
	}
	
	public void getlastname(String value)
	{
		lname.sendKeys(value);
	}
	
	public void getpincode(String value)
	{
		pincode.sendKeys(value);
	}
	
	public void getbutton()
	{
		button.click();
	}
	
	public boolean verifyPurchaseButton()
	{
		return purchase.isDisplayed();
	}
	
	public boolean verifyErrorMessage()
	{
		return errorMessage.isDisplayed();
	}

	
	public void getPurchase() {
		purchase.click();
	}
}