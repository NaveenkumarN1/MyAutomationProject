package WebAutomationTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Controls.CoreBase;

public class DataDriven extends CoreBase {
  @Test(dataProvider="loginData")
  public void login(Map mapdata ) {
	  String UserName= mapdata.get("UserName").toString();
	  String Password=mapdata.get("Password").toString();
	// String TestCase=mapdata.get("TestCase").toString();
	  driver.findElement(By.name("userName")).sendKeys(UserName);
	  driver.findElement(By.name("password")).sendKeys(Password);
	  
	  System.out.println(mapdata.get("UserName"));
	  System.out.println(mapdata.get("Password"));
	  System.out.println(mapdata.get("TestCase"));
	  

  }
}
