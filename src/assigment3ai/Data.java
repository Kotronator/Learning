package assigment3ai;
import java.util.ArrayList;

public class Data {
	ArrayList<CarEntry> data;
	
	public Data(ArrayList<CarEntry> array)
	{
            data= new ArrayList<CarEntry>();
		//data = array;
            for (CarEntry array1 : array) {
                data.add(array1);
            }
	}
	
	
	
	
	double getPropClass(String className)
	{
		int counter=0;
		for (CarEntry carEntry : data) {
			if(carEntry.getClassOfEntry().equals(className))
				counter++;
			
		}
                if(counter==0||data.size()==0)
                    return 0;
		return (double)counter/data.size();
	}
        static double getPropClass(Data data,String className)
	{
		int counter=0;
		for (CarEntry carEntry : data.data) {
			if(carEntry.getClassOfEntry().equals(className))
				counter++;
			
		}
                if(counter==0||data.data.size()==0)
                    return 0;
		return (double)counter/data.data.size();
	}

	ArrayList<CarEntry> getEntriesWithClass(String className)
	{
		ArrayList<CarEntry> spesificClassEntries = new ArrayList<CarEntry>();
		for (CarEntry carEntry : data) 
		{
			if(carEntry.getClassOfEntry().endsWith(className))
				spesificClassEntries.add(carEntry);
		}
		
		return spesificClassEntries;
	}
	
	private ArrayList<Double> getListPropabilityOfX_C(CarEntry carEntry)
	{
		ArrayList<CarEntry> spesificClassEntries =getEntriesWithClass(carEntry.getClassOfEntry());
		ArrayList<Double> counters = new ArrayList<Double>();
		for (int i = 0; i < 6; i++) {
			counters.add(new Double(0));
		}
		
		for (CarEntry carEntry2 : spesificClassEntries) {
			for (int i = 0; i < 6; i++) {
				if(carEntry2.getAttribute(i).equals(carEntry.getAttribute(i)))
					//counters.get(i)
					counters.set(i, new Double(counters.get(i).doubleValue()+1));
					//counters.get(i) = new Double(counters.get(i).doubleValue()+1) ;
			}
		}
		
		ArrayList<Double> prob = new ArrayList<Double>();
		for (int i = 0; i < 6; i++) {
			prob.add(new Double(counters.get(i)/spesificClassEntries.size()));
		}
		return prob;
	}
	
	public  double getPropabilityOfX_C(CarEntry carEntry)
	{
		ArrayList<Double> prob = getListPropabilityOfX_C(carEntry);
		double p= prob.get(0);
		for (int i = 1; i <6; i++) {
			p*=prob.get(i);
		}
		return p;
	}
	
	static ArrayList<CarEntry> getEntriesWithAttribute(Data data, int attributeIndex, String  value)
	{
		ArrayList<CarEntry> spesificAttributeEntries = new ArrayList<CarEntry>();
		for (CarEntry carEntry : data.data) 
		{
			if(carEntry.getAttribute(attributeIndex).equals(value))
				spesificAttributeEntries.add(carEntry);
		}
		
		return spesificAttributeEntries;
	}
	
	static double getEntropyOfData(Data data)
	{
		double dataentropy=0;
		for (String className : Main.classofCar) {
	
			double p = getPropClass(data ,className);
                        if (p>1||p<0) {
                            System.err.println("p>1"+p);
                        
                        }
                        if(p==0)
                            dataentropy+=0;
                        else
                            dataentropy+=-(p*log2(p));
                        //double val =
			
		}
		
		return dataentropy;
	}
	
	static double getEntropyAttribute(Data data, int attributeIndex)
	{
		
		double dataentropy=getEntropyOfData(data);
		double sum=0;
		for (String value : Main.attributes.get(attributeIndex)) {
			double px = getPropadilityOfAtribute(data,attributeIndex,value);
			//System.out.println("px"+px);
			ArrayList<CarEntry> data2 = getEntriesWithAttribute(data, attributeIndex, value);
			
			double hx = getEntropyOfData( new Data(data2));
			//System.out.println("hx:"+hx+"|"+data2.size());
			sum+=px*hx;
		}
		
		return dataentropy-sum;
		
	}
	
	static double getPropadilityOfAtribute(Data data,int column, String value)
	{
		int counter=0;
		for (CarEntry car : data.data) {
			
			if(car.getAttribute(column).equals(value))
				counter++;
		}
		
		
		return ((double)counter) /data.data.size();
	}
        
        static ArrayList<Double> getPropabilityOfClasses(Data data)
        {
            
                
            ArrayList<Double> counters = new ArrayList<Double>();
            for (int i = 0; i < Main.classofCar.size(); i++)
            {
                counters.add(new Double(0));
                
            }
            if(data.data.size()==0)
                return counters;
            for (CarEntry car : data.data)
            {
                String className = car.getClassOfEntry();
                for (int i = 0; i < Main.classofCar.size(); i++)
                {
                    if(Main.classofCar.get(i).equals(className))
                    {
                        counters.set(i, counters.get(i)+1);
                    }
                }
                
            }
            
             for (int i = 0; i < Main.classofCar.size(); i++)
                counters.set(i, counters.get(i)/data.data.size());
             return counters;
        }
	
	static double log2(double d) {return Math.log(d);}
	
	
}
