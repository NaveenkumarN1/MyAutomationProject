package Controls;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public  class TestDataManager {
	public  XSSFWorkbook wb; 
	public static XSSFSheet sh=null;
	
	Hashtable<String,Integer> dic= new Hashtable<String,Integer>();
@Test
  public  Object[][] dataInput(String filename,String sheetname) throws IOException
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
		 Object s[][]=new String[rowcount][cellcount];
		 for(int i=0;i<rowcount;i++)
		 {
		 Map<Object,Object> Mapse= new HashMap<Object,Object>();
	
			 for(int j=0;j<cellcount;j++)
			 {
				//if(rowdata.getCell(0) != null && rowdata.getCell(0).toString()==testcaseName)
				 //s[i][j]=formatter.formatCellValue(r.getCell(j));
				 Mapse.put(sh.getRow(0).getCell(j).toString(), sh.getRow(i+1).getCell(j).toString());
						
			 }
			 s[i][0]=Mapse;
		 }
		 
		 return s;
	
	 }
  /*public static String ReadCell(int column, int row) {
	  
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
	 }*/
	 
	 //@DataProvider(name="loginData")
		
		//public Object[][] loginData() throws IOException {
			//Object[][] arrayObject = dataInput(":\\Learning\\Files\\DataSheet.xlsx","Sheet1");
			//return arrayObject;
		//}
  public static void Main(String args[]) throws IOException
  {
	  TestDataManager obj = new TestDataManager();
	  obj.dataInput("D:\\Learning\\Files\\DataSheet.xlsx", "Sheet1");
  }
}
