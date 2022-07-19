package KiteHomePoM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage 
{
	@FindBy(xpath = "//span[@class='user-id']") private WebElement userId;
	@FindBy(xpath = "//a[text()=' Logout']") private WebElement logOutBtn;
	
	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getActUserId()
	{
		String actUserId=userId.getText();
		return actUserId;
	}
	
	public void clickLogOutBtn()
	{
		userId.click();
		logOutBtn.click();
	}

}
