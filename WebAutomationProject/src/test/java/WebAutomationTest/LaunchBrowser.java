package WebAutomationTest;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
  @Test
  public void BrowserTest() throws InterruptedException {
	 // System.setProperty("WebDriver.Chrome.driver", arg1)
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	 /* System.setProperty("webdriver.gecko.driver","D:\\Learning\\Software\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	  FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\Firefox.exe");
		options.setLogLevel(FirefoxDriverLogLevel.TRACE);
		WebDriver driver =  new FirefoxDriver(options);*/
	  driver.get("http://seleniumpractice.blogspot.in");
	  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  JavascriptExecutor je= (JavascriptExecutor) driver;
	   je.executeScript("window.open('http://www.way2automation.com/demo.html')");
	   driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	   //WebElement element =driver.findElement(By.linkText("Welcome"));
	   driver.switchTo().window("Welcome");
	  driver.close();
  }
}
