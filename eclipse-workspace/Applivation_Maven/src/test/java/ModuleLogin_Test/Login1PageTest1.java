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
import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;



public class Login1PageTest1 extends BaseClass
{
	KiteLogin1Page login1;
	int testCaseId;
	
	@BeforeClass
	@Parameters("browserName")
	public void openBrowser(String browserName) throws IOException
	{
		initializeBrowser(browserName);
		login1=new KiteLogin1Page(driver);		
	}
	
	@Test
	public void VerifyLogoAndText()
	{	
		testCaseId=1;
		boolean logoCheck=login1.verifyKiteLogin1PageLogo();
		boolean loginToKiteText=login1.verifyKiteLogin1PageloginToKiteText();
		Assert.assertTrue(logoCheck);
		Reporter.log("Logo and text for logo is present");
		Assert.assertTrue(loginToKiteText);
		
	}
	
	@Test
	public void verifyForgotAndSignupNowLinks()
	{
		testCaseId=2;
		boolean signUpNowLink=login1.verifyKiteLogin1PageSignUpNowLink();
		boolean forgotLink=login1.verifyKiteLogin1PageForgotLink();
		Assert.assertTrue(signUpNowLink);
		Reporter.log("Sign up now link is present");
		Assert.assertTrue(forgotLink);
		Reporter.log("Forget link is present");
	}
	
	@Test
	public void verifyUnPasswordLoginBtn()
	{
		testCaseId=3;
		boolean userid=login1.verifyKiteLogin1PageuserIdTextBox();
		boolean pwd=login1.verifyKiteLogin1PagePasswordTextBox();
		boolean loginButton=login1.verifyKiteLogin1PageLoginBtn();
		
		Assert.assertTrue(userid);
		Assert.assertTrue(pwd);
		Assert.assertTrue(loginButton);
		Reporter.log("User id , password textBox fields are present",true);
		Reporter.log("login button is available",true);
	}
	
	@AfterMethod
	public void screenshotForFailedTestCases(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreenShot(driver, testCaseId);
			Reporter.log("ScreenShot Captured For test case id= "+testCaseId);
		}
		
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	

}
