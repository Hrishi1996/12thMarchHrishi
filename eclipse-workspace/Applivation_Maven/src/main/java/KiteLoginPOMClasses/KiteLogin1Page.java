package KiteLoginPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin1Page
{
	@FindBy(xpath = "//input[@id='userid']") private WebElement userId;
	@FindBy(xpath = "//input[@id='password']") private WebElement password;
	@FindBy(xpath = "//button[@type='submit']") private WebElement loginBtn;
	@FindBy(xpath = "//a[contains(text(),'Forgot user')]") private WebElement forgotLink;
	@FindBy(xpath = "//h2[text()='Login to Kite']") private WebElement loginToKiteText;
	@FindBy(xpath = "//a[@class='logo kite-logo']") private WebElement Logo;
	@FindBy(xpath = "//a[@class='text-light']") private WebElement signUpNowLink;

	public KiteLogin1Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyKiteLogin1PageuserIdTextBox()
	{
		boolean useridCheck=userId.isDisplayed();
		return useridCheck;
	}
	
	public void inpKiteLogin1PageUserID(String UN)
	{
		userId.sendKeys(UN);
	}
	
	public boolean verifyKiteLogin1PagePasswordTextBox()
	{
		boolean passwordCheck = password.isEnabled();
		return passwordCheck;
	}

	public void inpKiteLogin1PagePassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public boolean verifyKiteLogin1PageLoginBtn() 
	{
		boolean loginCheck=loginBtn.isDisplayed();
		return loginCheck;
	}
	
	public void clickKiteLogin1PageLoginBtn() 
	{
		loginBtn.click();
	}
	
	public boolean verifyKiteLogin1PageForgotLink()
	{
		boolean forgotLinkCheck=forgotLink.isDisplayed();	
		return forgotLinkCheck;
	}
	
	public boolean verifyKiteLogin1PageSignUpNowLink()
	{
		boolean signUpNowCheck=signUpNowLink.isDisplayed();
		return signUpNowCheck;
	}

	public boolean verifyKiteLogin1PageloginToKiteText()
	{
		boolean loginToKiteTextCheck=loginToKiteText.isDisplayed();
		return loginToKiteTextCheck;
	}
	
	public boolean verifyKiteLogin1PageLogo()
	{
		boolean logoCheck=Logo.isDisplayed();
		return logoCheck;
	}
	
}
