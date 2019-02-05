package Controls;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CoreBase {
	
	public WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{
		 WebDriverManager.chromedriver().setup();
		 DesiredCapabilities cap = new DesiredCapabilities();
	        cap.setJavascriptEnabled(true);
	        ChromeOptions opt = new ChromeOptions();
	        opt.merge(cap);
		   driver =new ChromeDriver(opt);
				//driver.get("http://www.way2automation.com/demo.html");
		   driver.get("http://automationpractice.com/index.php");
			  //driver.findElement(By.xpath("http://www.way2automation.com/demo.html")).click();
			  driver.manage().window().maximize();
	}
	
	// @AfterTest
	   public void closeBrowser()
	    {
		   ReportManager.extent.flush();
	      driver.quit();
	    }
	 
	 public  void  takeSnapShot(WebDriver webdriver,String filepath) throws Exception
	 {
		 String location="D://Learning/GIT/WebAutomation/WebAutomationProject/ScreenShots/";
		 DateFormat datef = new SimpleDateFormat("dd-mm-yy hh-mm-ss");
		 Date date = new Date();
		 TakesScreenshot scrshot= ((TakesScreenshot)webdriver);
		 File scrn=scrshot.getScreenshotAs(OutputType.FILE);
		 String filename="Selenium";
		 File dest = new File(location+filename+datef.format(date)+".png");
		 
		 FileUtils.copyFile(scrn,dest);
	 }

}
