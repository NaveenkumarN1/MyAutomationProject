package WebAutomationTest;

import java.io.IOException;

import org.sikuli.hotkey.Keys;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import Controls.CoreBase;

public class ImageComparision {
  @Test
  public void imageComp() throws FindFailed, IOException {
	  Screen s = new Screen();
	  Pattern testimage=new Pattern("D:\\Learning\\Sikuli\\testimage.png");
	  Pattern start = new Pattern("D:\\Learning\\Sikuli\\start.png");
	  Pattern notepad= new Pattern("D:\\Learning\\Sikuli\\notepad.png");
	  Pattern notepadmax= new Pattern("D:\\Learning\\Sikuli\\notepadmax.png");
	  s.click(start);
	
	  s.click(notepad);
	  s.click(notepadmax);

	  //s.type(Keys.F11);
	  Finder f= new Finder(s.capture().getImage());
	  s.capture().save("D:\\Learning\\Sikuli\\", "actualimage");
	  
	  //String image1=s.capture().getImage();
	  f.find(testimage);
	  if(f.hasNext())
	  {
		  Match m=f.next();
		  System.out.println("image matched" + " "+ (m.getScore() *100) + "%");
	  }
	  else
	  {
		  System.out.println("not match");
	  }
	 // String testimage2=.toString();
	  /*if(image1.compareTo(testimage2)==0)
	  {
		  System.out.println(image1 + "and" + testimage + " " + "are same");
	  }
	  else
	  {
		  System.out.println(image1 + "and" + testimage + " " + "are not same");
	  }*/
  }
}
