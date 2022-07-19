package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	public static String getDataFromPF(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Shree\\eclipse-workspace\\Applivation_Maven\\PropertyFile.properties");
		Properties p=new Properties();
		p.load(file);
		String data=p.getProperty(key);
		return data;
	}
	public static String getTestDataFromExcel(int rowIndex,int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Shree\\eclipse-workspace\\Applivation_Maven\\TestData\\TestDataForKite.xlsx");
		String testData=WorkbookFactory.create(file).getSheet("Credentials").getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return testData;
	}
	
	public static void captureScreenShot(WebDriver driver,int testCaseId) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Shree\\eclipse-workspace\\Applivation_Maven\\ScreenShots\\TestCaseID"+testCaseId+".jpg");
		FileHandler.copy(src, dest);	 
	}
	
	public static void switchToIframe(WebDriver driver, String ifarmeId)
	{
		driver.switchTo().frame(ifarmeId);
	}
	public static void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	
	

}
