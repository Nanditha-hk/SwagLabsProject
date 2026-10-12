package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom {
	WebDriver driver;
	public LoginPom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	private WebElement uname;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "login-button")
	private WebElement login;
	
	
	public void Enterusername(String value)
	{
		uname.sendKeys(value);
	}
	public void Enterpassword(String value)
	{
		password.sendKeys(value);
	}
	public void Enterlogin()
	{
		login.click();
	}	
}
