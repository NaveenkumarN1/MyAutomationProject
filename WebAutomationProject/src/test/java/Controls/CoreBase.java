package Controls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CoreBase {
	
	public WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{
		 WebDriverManager.chromedriver().setup();
		 DesiredCapabilities cap = new DesiredCapabilities();
	        cap.setJavascriptEnabled(true);
	        ChromeOptions opt = new ChromeOptions();
	        opt.merge(cap);
		   driver =new ChromeDriver(opt);
				//driver.get("http://www.way2automation.com/demo.html");
		  // driver.get("http://automationpractice.com/index.php");
				//driver.get("http://demo.guru99.com/test/table.html");
				//driver.get("http://demo.guru99.com/test/image_upload/index.php");
				driver.get("Http://Newtours.Demoaut.Com/");
			  //driver.findElement(By.xpath("http://www.way2automation.com/demo.html")).click();
			  driver.manage().window().maximize();
	}
	
	// @AfterTest
	   public void closeBrowser()
	    {
		   ReportManager.extent.flush();
	      driver.quit();
	    }
	 
	 public  void  takeSnapShot(WebDriver webdriver,String filepath) throws Exception
	 {
		 String location="D://Learning/GIT/WebAutomation/WebAutomationProject/ScreenShots/";
		 DateFormat datef = new SimpleDateFormat("dd-mm-yy hh-mm-ss");
		 Date date = new Date();
		 TakesScreenshot scrshot= ((TakesScreenshot)webdriver);
		 File scrn=scrshot.getScreenshotAs(OutputType.FILE);
		 String filename="Selenium";
		 File dest = new File(location+filename+datef.format(date)+".png");
		 
		 FileUtils.copyFile(scrn,dest);
	 }
	 
	 public boolean isSortedAse(ArrayList<String> arr)
	 {
		 for(int i=1;i<arr.size();i++)
		 {
			 if(arr.get(i-1).compareTo(arr.get(i))<0)
			 {
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 public  XSSFWorkbook wb; 
		public static XSSFSheet sh=null;
		
		Hashtable<String,Integer> dic= new Hashtable<String,Integer>();

	  public  String[][] dataInput(String filename,String sheetname,String testcaseName) throws IOException
		 {
			 File f= new File(filename);
			 FileInputStream fi=new FileInputStream(f);
			 wb= new XSSFWorkbook(fi);
			sh =wb.getSheet(sheetname);
			 
			 int rowcount= sh.getLastRowNum();
			 Row rowdata=sh.getRow(0);
			 int cellcount=rowdata.getLastCellNum();
			// Cell celldata=rowdata.getCell(0);
			int ci=0,cj=0;
			 DataFormatter formatter = new DataFormatter();
			 String s[][]=new String[rowcount][cellcount];
			 for(int i=1;i<rowcount;i++,ci++)
			 {
				 Row r =sh.getRow(i);
				
				 System.out.println(r);
		
				 for(int j=1;j<cellcount;j++,cj++)
				 {
					//if(rowdata.getCell(0) != null && rowdata.getCell(0).toString()==testcaseName)
					 s[ci][cj]=formatter.formatCellValue(r.getCell(j));
							
				 }
			 }
			 
			 return s;
		
		 }
	  public static String ReadCell(int column, int row) {
		  
		                                  return sh.getRow(row).getCell(column).getStringCellValue();
		  
		                  }

		 public Hashtable<String, Integer> readColumn()
		 {
			 for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
			 {
				 dic.put(ReadCell(k,0), k);
			 }
			 return dic;
		 }
		 
		 public String getData(String TestcaseID)
		 {
			 String value=null;
			 if(readColumn().equals(TestcaseID))
			 {
				 for(int m=0;m>sh.getLastRowNum();m++)
				 value=ReadCell(0,m);
			 }
			 return value;
		 }
		 
		 @DataProvider(name="loginData")
			
			public Object[][] loginData() throws IOException {
				Object[][] arrayObject = dataInput("D:\\Learning\\Files\\DataSheet.xlsx","Sheet1","test01");
				return arrayObject;
			}
	

	 

}
