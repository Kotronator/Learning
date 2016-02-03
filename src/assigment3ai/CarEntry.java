package assigment3ai;
import java.util.ArrayList;


public class CarEntry 
{
	private String classOfEntry;
	ArrayList<String> data;
	
	public CarEntry(String classOfEntry, ArrayList<String> array)
	{
		
		this.classOfEntry = classOfEntry;
		data = array;
		
	}
	
	public CarEntry(CarEntry carEntry)
	{
		
		classOfEntry = carEntry.getClassOfEntry();
		data = carEntry.getData();
		
	}
	
	
	
	
	@Override
	public Object clone() 
	{
		
		ArrayList<String> dataCopy = new ArrayList<String>();
		for (String attribute : data) 
		{
			dataCopy.add(attribute);
		}
				
		CarEntry entry = new CarEntry(classOfEntry, dataCopy);
		
		
		return entry;
	}
	
	public String getClassOfEntry()
	{
		return classOfEntry;
	}
	
	public void setClassOfEntry(String name)
	{
		classOfEntry = name;
	}
	
	public String getAttribute(int attribute)
	{
		return data.get(attribute);
	}
	
	public ArrayList<String> getData()
	{
		return data;
	}

}
