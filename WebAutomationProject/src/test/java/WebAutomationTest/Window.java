package WebAutomationTest;

import java.awt.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {
  @Test
  public void SwitchFrame() throws Exception {
	  WebDriverManager.chromedriver().setup();
      WebDriver driver =new ChromeDriver();
      driver.get("http://www.google.com");
      JavascriptExecutor je= (JavascriptExecutor) driver;
   je.executeScript("window.open('http://seleniumpractise.blogspot.com/')");
    //  driver.navigate().to("http://seleniumpractise.blogspot.com/");
     // driver.get("http://seleniumpractise.blogspot.com/");
      //driver.navigate().to("http://seleniumpractise.blogspot.com/");
   je.executeScript("window.open('https://www.seleniumhq.org/')");
      driver.manage().window().maximize();
      String handle= driver.getWindowHandle();
      Set<String> Handles= driver.getWindowHandles();
      for (String handle1 :Handles ) {
    	 // driver.getWindowHandles()
    	  String strTitle = driver.getTitle();
         System.out.println(strTitle);
        // if(handle1!=handle) {
        if(strTitle.contains("Selenium - Web Browser Automation"))
        		{
        	String Child1=driver.getWindowHandle();
          driver.switchTo().window(Child1);
        }
          }
      driver.switchTo().window(handle);
      driver.close();
	 /* try
	  {
	     
		  driver.findElement(By.xpath("//a[@href='http://seleniumpractise.blogspot.com/2017/']//preceding::span[@class='zippy']")).click();
	      driver.findElement(By.xpath("//li[@class='archivedate expanded']//ul[4]//li[1]//a[1]//span[1]")).click();
	      je.executeScript("window.scrollBy(0,200)");
	      driver.findElement(By.linkText("Frames in Selenium WebDriver")).click();
	      driver.switchTo().frame(0);
	      driver.switchTo().window(handle);
	      driver.close();
	      //driver.switchTo().window(nameOrHandle)
	      //(driver.findElement(By.xpath("//iframe[@id='google']")));
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	/* finally
	  {
		  driver.quit();
	  }*/
  }
}
