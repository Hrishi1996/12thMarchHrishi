package LibraryFiles;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass
{
	public WebDriver driver=null;
	ChromeOptions options;
	public void initializeBrowser(String browserName) throws IOException
	{
		//ChromeOptions options=new ChromeOptions();
		//options.addArguments("--disable-notifications");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\Applivation_Maven\\Browsers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("msedge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Shree\\eclipse-workspace\\Framework for Application\\Browsers exe files\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shree\\eclipse-workspace\\Framework for Application\\Browsers exe files\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(UtilityClass.getDataFromPF("URL"));
	}

}
