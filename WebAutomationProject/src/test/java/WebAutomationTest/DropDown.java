package WebAutomationTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Controls.CoreBase;

public class DropDown extends CoreBase{
  @Test
  public void selectDropDown() {
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
		 
         // Actions ac= new Actions(driver);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//div[@id='login']//input[@name='username']")).sendKeys("988632004");
		  driver.findElement(By.xpath("//div[@id='login']//input[@name='password']")).sendKeys("naveen@1");
		  driver.findElement(By.xpath("//div[@id='login']//input[@value='Submit']")).click();
		 
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  
		  WebElement ele=driver.findElement(By.xpath("//h2[contains(text(),'Dropdown')]"));
		  je.executeScript("arguments[0].scrollIntoView();",ele);
		  je.executeScript("arguments[0].click();", ele);
			
		  driver.findElement(By.xpath("//h2[contains(text(),'Dropdown')]")).click();
		//  -----------------------tc1----------------------
		  driver.findElement(By.xpath("//a[contains(text(),'Select Country')]")).click();
		  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"example-1-tab-1\"]/div/iframe")));
		  //Select se = new Select(driver.findElement(By.xpath("//body/select")));
		  
		  List<WebElement> ne= driver.findElements(By.tagName("option"));
		  ArrayList<String> ar=new ArrayList<String>();
		  for(WebElement ele2:ne)
		  {
			
			  
             ar.add(ele2.getText());
		    
		  }
		  ar.remove("Please Select");
		  for(int i=1;i<=ar.size()-1;i++)
		  {
			
			  
           System.out.println(ar.get(i));
		    
		  }
			boolean sorti= isSortedAse(ar);
			
			System.out.println(sorti);

		  //se.selectByVisibleText("Angola");
		  
		  //-------------------------tc2---------------
		 // driver.switchTo().defaultContent();*/
		 /* driver.findElement(By.xpath("//a[contains(text(),'Enter Country')]")).click();
		  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"example-1-tab-2\"]/div/iframe")));
		  WebElement ele1=driver.findElement(By.xpath("/html/body/div[1]/span/input"));
		  ele1.click();
		  ele1.sendKeys(Keys.CONTROL+ "a");
		  ele1.sendKeys(Keys.DELETE);
		  ele1.sendKeys("Angola");
		  ele1.sendKeys(Keys.TAB);*/
		  
		  
  }
}
