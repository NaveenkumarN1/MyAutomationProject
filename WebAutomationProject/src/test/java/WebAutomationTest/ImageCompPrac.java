package WebAutomationTest;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ScreenRegion;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class ImageCompPrac {

  @Test
  public void imageCmp() throws FindFailed, IOException {
	  Screen s = new Screen();
	  Pattern testimage=new Pattern("D:\\Learning\\Sikuli\\testimage.png");
	  Pattern start = new Pattern("D:\\Learning\\Sikuli\\start.png");
	  Pattern notepad= new Pattern("D:\\Learning\\Sikuli\\notepad.png");
	  Pattern notepadmax= new Pattern("D:\\Learning\\Sikuli\\notepadmax.png");
	  Pattern notepadfile= new Pattern("D:\\Learning\\Sikuli\\notepadfile.png");
	  s.click(start);

	// System.out.println("x="+s.getX()+ " "+ "y= "+ " "+ "w= " + s.getW()+ " " + "h= "+ " " +s.getH());
	 // s.capture(0, 0, 1366, 768);
	 // Finder f= new Finder(s.capture(10, 10, 1366, 768).getImage());
	 Finder f= new Finder(s.capture().save("D:\\Learning\\Sikuli\\", "actualimage"));
	  s.highlight();
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
     
	 
	  
  }
}
