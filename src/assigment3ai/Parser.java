package assigment3ai;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Parser 
{
	ArrayList<CarEntry> data = new ArrayList<CarEntry>();
	
	public ArrayList<CarEntry> ReadParser(String fileName)
	{
			try
			{
				 RandomAccessFile text = new RandomAccessFile(fileName, "r");
				 String line;
				 while((line=text.readLine())!=null)
				 {
					 int counter=0;
					 ArrayList<String> entryData = new ArrayList<String>();
					 StringTokenizer str= new StringTokenizer(line, ",");
					 while(str.hasMoreElements())
					 {
						 entryData.add(str.nextElement().toString());
						 counter++;
						 
					 }
					 
					 String className = entryData.remove(--counter);				
					 CarEntry carEntry = new CarEntry(className,entryData);
					 
					 data.add(carEntry);
					 
					 
				 }
			}
			catch (IOException ex)
			{
		        ex.printStackTrace();
			
			}
			
			
			return data;
			
			
		
	
	}

}
