package WebAutomationTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import Controls.CoreBase;
import Controls.ReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame extends CoreBase {
	ExtentTest logger;
	@Test
  public void SwitchFrame() throws Exception {
		
		
	 /* System.setProperty("webdriver.gecko.driver","D:\\Learning\\Software\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	  FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\Firefox.exe");
		options.setLogLevel(FirefoxDriverLogLevel.TRACE);*/
		//WebDriver driver =  new FirefoxDriver(options);
		
	   logger=ReportManager.reports().createTest("FRAME");
	  
	  JavascriptExecutor je =(JavascriptExecutor) driver;
	  //je.executeScript("window.scrollBy(0,600)");
	  //driver.findElement(By.xpath("//h2[contains(text(),'Frames and Windows')]")).click();
	 String Parenthandle=driver.getWindowHandle();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//a[contains(text(),'Registration')]")).click();
	 logger.log(Status.INFO,"button clicked");
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  Set<String> handles= driver.getWindowHandles();
	  for(String handle1:handles)
	  {
		 //String se=driver.getTitle();
		// System.out.println(se);
		 if(handle1!=Parenthandle)
		 {
			 driver.switchTo().window(handle1);
		 }
	  }
	 // driver.switchTo().activeElement();
	 //WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Signin')]")); 
	//WebDriverWait wait = new WebDriverWait(driver, 60);
	 // wait.until(ExpectedConditions.visibilityOf(element));
	 // Alert al =driver.switchTo().alert();
	 //driver.findElement(By.xpath("//input[@name='name']")).sendKeys("na");
	  //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  //driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[1]/iframe")));
     //Actions ac= new Actions(driver);
    // ac.moveToElement(driver.findElement(By.xpath("/html/body/div[4]/div"))).click().build().perform();
     
	  //driver.switchTo().frame(0);
	 // String currentFrameName = (String)(je.executeScript("return window.frameElement.name"));
	  
	  //System.out.println("switch to frame"+currentFrameName);
	// je.executeScript("var el=arguments[0]; setTimeout(function() { el.click(); },100);", element);
	 WebElement element= driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/div/div[1]/p/a"));
	 WebDriverWait wc = new WebDriverWait(driver,120);
	  wc.until(ExpectedConditions.visibilityOf(element));
	  
	  //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  element.click();
	 
	 
	 // je.executeScript("arguments[0].click()", element);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//div[@id='login']//input[@name='username']")).sendKeys("988632004");
	  driver.findElement(By.xpath("//div[@id='login']//input[@name='password']")).sendKeys("naveen@1");
	  driver.findElement(By.xpath("//div[@id='login']//input[@value='Submit']")).click();
	  logger.log(Status.INFO, "login sucessfull");
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 //je.executeScript("window.scrollBy(0,300)");
	  WebElement ele=driver.findElement(By.xpath("//h2[contains(text(),'Frames and Windows')]"));
	  je.executeScript("arguments[0].scrollIntoView();",ele);
	 // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  je.executeScript("arguments[0].click();", ele);
	  driver.findElement(By.xpath("//h2[contains(text(),'Frames and Windows')]")).click();
	
	  je.executeScript("window.scrollBy(0,200)");
	  driver.findElement(By.xpath("//a[contains(text(),'Frameset')]")).click();
	  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"example-1-tab-3\"]/div/iframe")));
	  driver.findElement(By.cssSelector("body:nth-child(2) div.farme_window p:nth-child(1) > a:nth-child(1)")).click();
	  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  Set<String> handles1= driver.getWindowHandles();
	  int count=0;
	  for(String handle1:handles1)
	  {
		 String se=driver.getTitle();
		System.out.println(se);
		 if(handle1!=Parenthandle)
		 {
			count++; 
			 
		 }
		 if(count==3)
		 {
			 driver.switchTo().window(handle1);
		 }
	  }
	  System.out.println(count);
	  driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frame[2]")));
	  String Str=driver.findElement(By.cssSelector("body:nth-child(2) div:nth-child(2) > p:nth-child(1)")).getText();
	  this.takeSnapShot(driver,"D://Learning/GIT/WebAutomation/WebAutomationProject/ScreenShots/");
	  System.out.println(Str);
	  Assert.assertEquals(Str, "Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text.");
	  logger.log(Status.PASS, "Testcase passed");
	  //driver.switchTo().frame(1);
	  //je.executeScript("window.scrollBy(0,200)");
	  
	}
	  
	
  }


