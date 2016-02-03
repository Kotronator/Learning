package assigment3ai;

import java.util.ArrayList;
import java.util.Iterator;


public class BayesCal
{
	
	
	
	
	public static String decide(Data totalData ,CarEntry carentry)
	{
		
		String className=null;
		
		double maxprob = 0, propability=0;
		ArrayList<CarEntry> standardCars=new ArrayList<CarEntry>();
		for (int i = 0; i < Main.classofCar.size(); i++)
		{
			
			CarEntry car1 = (CarEntry)carentry.clone();
			car1.setClassOfEntry(Main.classofCar.get(i));
			standardCars.add(car1);
		}
		for (CarEntry carEntry : standardCars) 
		{
			propability=totalData.getPropClass(carEntry.getClassOfEntry()) * totalData.getPropabilityOfX_C( carEntry);
			if(propability>=maxprob)
			{
				maxprob=propability;
				className=carEntry.getClassOfEntry();
			}
		}
		return className;
	}
	
}
