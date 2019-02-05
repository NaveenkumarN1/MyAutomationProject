package WebAutomationTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import Controls.CoreBase;

public class MouseHouver extends CoreBase {
  @Test
  public void houver() {
	 WebElement ele= driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
	 Actions ac= new Actions(driver);
	 ac.moveToElement(ele).perform();
	// WebElement ele1=  driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a"));
 List<WebElement> moptions= driver.findElements(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul//ul/li"));
  for(WebElement op: moptions)
  {
	  String nl=op.getText();
	  if(nl.equalsIgnoreCase("Summer Dresses"))
	  ac.click(op).build().perform();
  }
	 //JavascriptExecutor je = (JavascriptExecutor)driver;
	// je.executeScript("arguments[0].click()",ele1);
	 
  }
}
