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

import com.aventstack.extentreports.Status;

import Controls.CoreBase;

public class DragAndDrop extends CoreBase{
  @Test
  public void Drag1() {
	  JavascriptExecutor je =(JavascriptExecutor) driver;
	  //je.executeScript("window.scrollBy(0,600)");
	  //driver.findElement(By.xpath("//h2[contains(text(),'Frames and Windows')]")).click();
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
		  
		  //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  element.click();
		 
		 
		 // je.executeScript("arguments[0].click()", element);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//div[@id='login']//input[@name='username']")).sendKeys("988632004");
		  driver.findElement(By.xpath("//div[@id='login']//input[@name='password']")).sendKeys("naveen@1");
		  driver.findElement(By.xpath("//div[@id='login']//input[@value='Submit']")).click();
		 
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  
		 //WebElement Draggable =driver.findElement(By.xpath("//h2[contains(text(),'Draggable')]"));
		  //WebElement Draggable1 =driver.findElement(By.xpath("//div[@class='link_icon']"));
		  //je.executeScript("arguments[0].scrollIntoView();", Draggable);
		 //je.executeScript("window.scrollBy(0,500)");
		 // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 //driver.findElement(By.xpath("//h2[contains(text(),'Draggable')]")).click();
		  Actions act= new Actions(driver);
		  //act.moveToElement(Draggable).build().perform();
		 //je.executeScript("arguments[0].click();", Draggable);
		 //je.executeScript("arguments[0].click();", ele);
		  WebElement ele=driver.findElement(By.xpath("//h2[contains(text(),'Draggable')]"));
		  je.executeScript("arguments[0].scrollIntoView();",ele);
		 // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  je.executeScript("arguments[0].click();", ele);
	
		  driver.findElement(By.xpath("//h2[contains(text(),'Draggable')]")).click();
		  driver.findElement(By.xpath("//a[contains(text(),'Default functionality')]")).click();
		  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"example-1-tab-1\"]/div/iframe")));
		  WebElement from= driver.findElement(By.xpath("//p[contains(text(),'Drag me around')]"));
		 // WebElement to= driver.findElement(By.xpath("//*[@id='draggable']"));
		  //driver.findElement(By.xpath("//a[contains(text(),'Default functionality')]")).click();
		  act.dragAndDropBy(from, 400, 50).build().perform();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  driver.switchTo().defaultContent();
		  driver.findElement(By.xpath("//a[contains(text(),'Constrain movement')]")).click();
		  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"example-1-tab-2\"]/div/iframe")));
		  WebElement from1= driver.findElement(By.xpath("//p[contains(text(),'I can be dragged only vertically')]"));
		  act.dragAndDropBy(from1, 0, 100).build().perform();
		  WebElement from2= driver.findElement(By.xpath("//p[contains(text(),'I can be dragged only horizontally')]"));
		  act.dragAndDropBy(from2, 200, 0).build().perform();
		  /*WebElement from3= driver.findElement(By.xpath("//p[contains(text(),'I'm contained within the box')]"));
		  act.dragAndDropBy(from3, 100, 0).build().perform();
		  WebElement from4= driver.findElement(By.xpath("//p[contains(text(),'I'm contained within my parent')]"));
		  act.dragAndDropBy(from4, 0, 80).build().perform();*/
		  driver.switchTo().defaultContent();
		  driver.findElement(By.xpath("//a[contains(text(),'Cursor style')]")).click();
		  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"example-1-tab-3\"]/div/iframe")));
		  WebElement from3= driver.findElement(By.xpath("//p[contains(text(),'I will always stick to the center (relative to the mouse)')]"));
          act.dragAndDropBy(from3, 0, 200).build().perform();
		  driver.switchTo().defaultContent();
		  driver.findElement(By.xpath("//a[contains(text(),'Events')]")).click();
		  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"example-1-tab-4\"]/div/iframe")));
		  WebElement from4= driver.findElement(By.xpath("//p[contains(text(),'Drag me to trigger the chain of events.')]"));
          act.dragAndDropBy(from4, 0, 200).build().perform();
   // drag and sort
          driver.switchTo().defaultContent();
		  driver.findElement(By.xpath("//a[contains(text(),'Draggable + Sortable')]")).click();
		  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"example-1-tab-5\"]/div/iframe")));
		  WebElement from5= driver.findElement(By.xpath("//li[contains(text(),'Item 1')]"));
		  WebElement to= driver.findElement(By.xpath("//li[contains(text(),'Item 4')]"));
		  //act.dragAndDropBy(from5, 0, 149).build().perform();
		  
          act.clickAndHold(from5).moveToElement(to,0,149).release(to).build().perform();
  }
}
