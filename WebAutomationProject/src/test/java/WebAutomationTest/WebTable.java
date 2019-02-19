package WebAutomationTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Controls.CoreBase;

public class WebTable extends CoreBase {
  @Test
  public void dynamiWebTable() {
	  WebElement mytable=driver.findElement(By.tagName("tbody"));
	  
	  List<WebElement> row_num= mytable.findElements(By.tagName("tr"));
	  
	  for(int row=0;row<row_num.size();row++)
	  {
		  List<WebElement> col_num= row_num.get(row).findElements(By.tagName("td"));
		  for(int col=0;col<col_num.size();col++)
		  {
			  if(col_num.get(col).getText().equals("4"))
			  System.out.println("column number" + col + " " + "row num"+ row + " " + col_num.get(col).getText());
			  
		  }
	  
	  }
  }
}
