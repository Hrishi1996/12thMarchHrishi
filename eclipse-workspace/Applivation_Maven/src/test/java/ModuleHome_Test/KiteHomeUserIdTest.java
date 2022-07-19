package ModuleHome_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import KiteHomePoM.KiteHomePage;
import KiteLoginPOMClasses.KiteLogin1Page;
import KiteLoginPOMClasses.KiteLogin2Page;
import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;


public class KiteHomeUserIdTest extends BaseClass
{
	KiteLogin1Page login1;
	KiteLogin2Page login2;
	KiteHomePage home;
	int testCaseId;
	@Parameters("browserName")
	@BeforeClass
	public void initializeApplication(String browserName) throws IOException
	{
		initializeBrowser(browserName);
		login1=new KiteLogin1Page(driver);
		login2=new KiteLogin2Page(driver);
		home=new KiteHomePage(driver);
	}
	@BeforeMethod
	public void loginToApplication() throws IOException
	{
		login1.inpKiteLogin1PageUserID(UtilityClass.getDataFromPF("UserId"));
		login1.inpKiteLogin1PagePassword(UtilityClass.getDataFromPF("Password"));
		login1.clickKiteLogin1PageLoginBtn();
		
		login2.inpKiteLogin2PagePin(UtilityClass.getDataFromPF("Pin"));
		login2.clickKiteLogin2PageContinueBtn();
	}
	
	@Test
	public void verifyUserId() throws EncryptedDocumentException, IOException
	{
		testCaseId=59;
		String actUserid=home.getActUserId();
		String expUserId=UtilityClass.getTestDataFromExcel(1, 3);
		Assert.assertEquals(actUserid, expUserId);
	}
	
	@AfterMethod
	public void logoutAndScreenShotForFailedTests(ITestResult results) throws IOException
	{
		if(results.getStatus()==ITestResult.FAILURE) 
		{
			UtilityClass.captureScreenShot(driver, testCaseId);
		}
		home.clickLogOutBtn();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}

}
