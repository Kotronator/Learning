package assigment3ai;
import java.util.ArrayList;


public class Main {
	
	public static   ArrayList<String> classofCar= new ArrayList<String>();
	
	static ArrayList<String> buying=new ArrayList<String>();
	static ArrayList<String> maint=new ArrayList<String>();
	static ArrayList<String> doors=new ArrayList<String>();
	static ArrayList<String> persons=new ArrayList<String>();
	static ArrayList<String> lug_boot=new ArrayList<String>();
	static ArrayList<String> safety=new ArrayList<String>();
	static ArrayList<ArrayList<String>> attributes=new ArrayList<ArrayList<String>>();
	
	
	
	

	public static void main(String[] args) throws CloneNotSupportedException {
		///////////////////////
            buying.add("vhigh");
            buying.add("high");
            buying.add("med");
            buying.add("low");

            maint.add("vhigh");
            maint.add("high");
            maint.add("med");
            maint.add("low");

            doors.add("2");
            doors.add("3");
            doors.add("4");
            doors.add("5more");

            persons.add("2");
            persons.add("4");
            persons.add("more");

            lug_boot.add("small");
            lug_boot.add("med");
            lug_boot.add("big");

            safety.add("low");
            safety.add("med");
            safety.add("high");

            attributes.add(buying);
            attributes.add(maint);
            attributes.add(doors);
            attributes.add(persons);
            attributes.add(lug_boot);
            attributes.add(safety);
            ///////////////////////

            classofCar.add("unacc");
            classofCar.add("acc");
            classofCar.add("good");
            classofCar.add("vgood");

            Parser parser = new Parser();

            Data data = new Data(parser.ReadParser("src//datalist.txt"));
            ArrayList<String> a=new ArrayList<String>();
            a.add("vhigh");
            a.add("vhigh");
            a.add("2");
            a.add("more");
            a.add("small");
            a.add("low");
            CarEntry c1=new CarEntry(null,a);
            testBayes(data,c1);

            System.out.println("entr:"+Data.getEntropyOfData(data));
            for (int i = 0; i < 6; i++) {
                    System.out.println("entrOfDoor:"+Data.getEntropyAttribute(data,i));
            }

            ID3 id3 = new ID3();
            ID3.ID3Node root = id3.createRootNode(data);
            System.out.println(root);
            root.expand(data, null);
            for (ID3.ID3Node node : root.children)
            {
                System.out.println(node);
            }
		
		
		
	}
	
	public static void testBayes(Data data, CarEntry car)
	{
		
			System.out.println(BayesCal.decide(data, car));
		
	}

}
