package ModuleLogin_Test;


import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import KiteLoginPOMClasses.KiteLogin1Page;
import KiteLoginPOMClasses.KiteLogin2Page;
import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;



public class Login2PageTest extends BaseClass
{
	int testCaseId;
	KiteLogin1Page login1;
	KiteLogin2Page login2;
	
	@BeforeClass
	@Parameters("browserName")
	public void openBrowser(String browserName) throws IOException
	{
		initializeBrowser(browserName);
		login2=new KiteLogin2Page(driver);
		login1=new KiteLogin1Page(driver);
		login1.inpKiteLogin1PageUserID(UtilityClass.getDataFromPF("UserId"));
		login1.inpKiteLogin1PagePassword(UtilityClass.getDataFromPF("Password"));
		login1.clickKiteLogin1PageLoginBtn();
	}
	
	@Test
	public void verifyLogo()
	{
		testCaseId=4;
		boolean logoCheck=login2.verifyKiteLogin2Pagelogo();
		Assert.assertTrue(logoCheck);
		Reporter.log("Logo is present on Login2 page");
	}
	
	@Test
	public void verifyUserIdTextBox() throws IOException
	{
		testCaseId=5;
		String actUserId=login2.verifyKiteLogin2Pageuserid();
		String expUserId=UtilityClass.getDataFromPF("UserId");
		Assert.assertEquals(actUserId, expUserId);
		Reporter.log("User Id is as per expected");
	}
	
	@Test
	public void verifyLockIcon()
	{
		testCaseId=6;
		Assert.assertTrue(login2.verifyKiteLogin2PagelockIcon());
		Reporter.log("lockIcon is present");
	}
	
	@Test
	public void verifyPinTextBox()
	{
		testCaseId=7;
		Assert.assertTrue(login2.verifyKiteLogin2PagePinTextBox());
		Reporter.log("pin textbox is present");
	}
	
	@Test
	public void verifyContinueBtn()
	{
		testCaseId=8;
		Assert.assertTrue(login2.verifyKiteLogin2PageContinueBtn());
		Reporter.log("Continue button is enabled");
	}
	
	@Test
	public void verifyForgot2FALink()
	{
		testCaseId=9;
		Assert.assertTrue(login2.verifyKiteLogin2PageForgotLink());
		Reporter.log("Forgot 2FA link is Visible");
	}
	
	@AfterMethod
	public void captureScreenShotForFailedTestCases(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreenShot(driver, testCaseId);
			Reporter.log("ScreenShot Captured for TestCaseId "+testCaseId,true);
		}
	}
	
	@AfterClass
	public void closeApp()
	{
		driver.close();
	}
	
	

	
	
}
