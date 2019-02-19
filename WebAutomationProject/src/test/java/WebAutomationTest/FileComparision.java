package WebAutomationTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileComparision {
	
	public void fileComp() throws IOException
	{
		BufferedReader reader1 =new BufferedReader(new FileReader("D:\\Learning\\Files\\Naveen.txt"));
		BufferedReader reader2 =new BufferedReader(new FileReader("D:\\Learning\\Files\\Naveen1.txt"));
		
		String line1=reader1.readLine();
		String line2=reader2.readLine();

		boolean istrue=true;
		int linecount=1;
		
		while(line1!=null || line2!=null)
		{
			if(line1 == null || line2 == null)
			{
				istrue=false;
				break;
			}
			else if(!line1.equalsIgnoreCase(line2))
			{
				istrue=false;
				break;
			}
			line1=reader1.readLine();
			line2=reader2.readLine();
			linecount++;
		}  
		if(istrue)
		{
			System.out.println("contents in files are equal");
		}
		else
		{
			System.out.println("contents in files are not equal at line" + " " + linecount);
			System.out.println("contents in file1 are not equal" + " " +line1 );
			System.out.println("contents in file2 are not equal" + " " +line2 );

		}
		
		reader1.close();
		reader2.close();
		

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileComparision obj = new FileComparision();
		obj.fileComp();
	}

}
