package WebAutomationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
  @Test
  public void BrowserTest() {
	 // System.setProperty("WebDriver.Chrome.driver", arg1)
	  //WebDriverManager.chromedriver().setup();
	  //WebDriver driver= new ChromeDriver();
	  System.setProperty("webdriver.gecko.driver","D:\\Learning\\Software\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	  FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\Firefox.exe");
		options.setLogLevel(FirefoxDriverLogLevel.TRACE);
		WebDriver driver =  new FirefoxDriver(options);
	  driver.get("http://seleniumpractice.blogspot.in");
	  driver.quit();
  }
}
