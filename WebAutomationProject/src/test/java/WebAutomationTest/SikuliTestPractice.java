package WebAutomationTest;



import org.openqa.selenium.By;
import org.sikuli.hotkey.Keys;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import Controls.CoreBase;

public class SikuliTestPractice extends CoreBase  {
	Screen s=new Screen();
 // @Test
 /* public void notepad() throws FindFailed {
	  Screen s=new Screen();
	  Pattern pa = new Pattern("D:\\Learning\\Sikuli\\notepad.png");
	  Pattern pa1 = new Pattern("D:\\Learning\\Sikuli\\minimize.png");
	 Pattern pa2 = new Pattern("D:\\Learning\\Sikuli\\start.png");
	  Pattern pa3 = new Pattern("D:\\Learning\\Sikuli\\notepadtext.png");
     // s.type(Keys.WIN + 'r' );
	 s.click(pa2);
	  s.click(pa);
	 // s.click(pa3);
	 s.type(pa3,"this is my first test");*/
	 
      // s.closePrompt();

  //}
  
 /* public void cmdPromt() throws FindFailed
  {
	  Pattern start = new Pattern("D:\\Learning\\Sikuli\\start.png");
	  Pattern windowserach = new Pattern("D:\\Learning\\Sikuli\\windowsearch.png");
	  Pattern cmdeditor = new Pattern("D:\\Learning\\Sikuli\\cmdeditor.png");
	  s.click(start);
	  s.type(windowserach,"cmd");
	  s.type(Keys.ENTER);
	  s.type(cmdeditor,"exit");
	  s.type(Keys.ENTER);
	
  }*/
  @Test
  public void fileUpload() throws FindFailed
  {
	  String filepath="D:\\Learning\\Sikuli\\files\\";
	  String filename="Naveen.txt";
	  Pattern inputfilepath=new Pattern("D:\\Learning\\Sikuli\\inputfilepath.png");
	  Pattern openbutton=new Pattern("D:\\Learning\\Sikuli\\openbutton.png");
	  driver.findElement(By.xpath("//*[@id=\"photoimg\"]")).click();
	  s.wait(inputfilepath, 20);
	  s.type(inputfilepath,filepath+filename);
	  s.click(openbutton);
	
	  
	  
  }
}
