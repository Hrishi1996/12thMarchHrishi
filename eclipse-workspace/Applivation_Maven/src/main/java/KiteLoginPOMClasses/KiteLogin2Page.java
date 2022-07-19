package KiteLoginPOMClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin2Page
{
	@FindBy(xpath = "//a[@class='logo kite-logo']") private WebElement logo;
	@FindBy(xpath = "//div[@class='form-header text-center']/h2") private WebElement userid;
	@FindBy(xpath = "//span[@class='icon icon-lock']") private WebElement lockIcon;
	@FindBy(css = "#pin") private WebElement pin;
	@FindBy(xpath = "//button[@type='submit']") private WebElement continueBtn;
	@FindBy(xpath = "//a[text()='Forgot 2FA?']") private WebElement forgotlink;
	
	public KiteLogin2Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyKiteLogin2Pagelogo()
	{
		boolean logoCheck=logo.isDisplayed();
		return logoCheck;
	}
	
	public String verifyKiteLogin2Pageuserid()
	{
		String actUserId=userid.getText();
		return actUserId;
	}
	
	public boolean verifyKiteLogin2PagelockIcon()
	{
		boolean lockIconCheck=lockIcon.isDisplayed();
		return lockIconCheck;
	}
	
	public boolean verifyKiteLogin2PagePinTextBox()
	{
		boolean pinTextBoxCheck=pin.isDisplayed();
		return pinTextBoxCheck;
	}
	  
	public boolean verifyKiteLogin2PageContinueBtn()
	{
		boolean continueBtnCheck=continueBtn.isDisplayed();
		return continueBtnCheck;
	}
	
	public boolean verifyKiteLogin2PageForgotLink()
	{
		boolean forgotLinkCheck= forgotlink.isDisplayed();
		return forgotLinkCheck;
	}
	
	public void inpKiteLogin2PagePin(String pinkey) throws IOException
	{
		pin.sendKeys(pinkey);
	}
 
	public void clickKiteLogin2PageContinueBtn()
	{
		continueBtn.click();
	}
	
	
	

}
