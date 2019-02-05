package WebAutomationTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Controls.CoreBase;

public class Resizable extends CoreBase {
  @Test
  public void Resize() {
	  JavascriptExecutor je =(JavascriptExecutor) driver;
		 
	 String Parenthandle=driver.getWindowHandle();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//a[contains(text(),'Registration')]")).click();
	
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  Set<String> handles= driver.getWindowHandles();
	  for(String handle1:handles)
	  {
		
		 if(handle1!=Parenthandle)
		 {
			 driver.switchTo().window(handle1);
		 }
	  }
	  WebElement element= driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/div/div[1]/p/a"));
		 WebDriverWait wc = new WebDriverWait(driver,120);
		  wc.until(ExpectedConditions.visibilityOf(element));
		  element.click();
		 
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//div[@id='login']//input[@name='username']")).sendKeys("988632004");
		  driver.findElement(By.xpath("//div[@id='login']//input[@name='password']")).sendKeys("naveen@1");
		  driver.findElement(By.xpath("//div[@id='login']//input[@value='Submit']")).click();
		 
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  
		 
		  WebElement ele=driver.findElement(By.xpath("//h2[contains(text(),'Resizable')]"));
		  je.executeScript("arguments[0].scrollIntoView();",ele);
		 
		  je.executeScript("arguments[0].click();", ele);
		 
		  driver.findElement(By.xpath("//h2[contains(text(),'Resizable')]")).click();
		  driver.findElement(By.xpath("//a[contains(text(),'Default functionality')]")).click();
		  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"example-1-tab-1\"]/div/iframe")));
		  System.out.println("Switch to frame");
		 WebElement from1 =driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		 // WebElement to =driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));
		  Actions ac=new Actions(driver);
		 ac.clickAndHold(from1).moveByOffset(10, 40).release(from1).build().perform();
  }
}
