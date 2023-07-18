package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//Elements 
	
	@FindBy(xpath = "//a[@href='/login']")
	WebElement signInLink;
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	WebElement clickloginbtn;

	@FindBy(xpath = " //a[contains(text(),'Logged in as ')]")
	WebElement loginAs;
	
	//Methods 
	
	public void clickloginpage()
	{
		signInLink.click();
	}
	public void setEmail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}

	public void clickLoginbtn() 
	{
		clickloginbtn.click();
	}

	public boolean Uservalidate()
	{
		return loginAs.isDisplayed();
		
		//Assert.assertTrue(loginAs.isDisplayed());
		
	}
	

}
