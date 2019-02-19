package WebAutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Controls.CoreBase;

public class SampleTest extends CoreBase {
  @Test
  public void test()  {
	  Dimension d = new Dimension(800,480);
	 driver.manage().window().setSize(d);
	 Actions ac= new Actions(driver);
  }
}
