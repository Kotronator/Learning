package assigment3ai;
import java.util.ArrayList;


public class ID3 {
	
ArrayList<Integer> unusedAtrbutes= new ArrayList<Integer>(6);

    public ID3()
    {
        for (int i = 0; i < 6; i++)
        {
            unusedAtrbutes.add(new Integer(i));
        }
    }
	
        
    public int decide(Data totalData ,Data data, int usedAttribute, ArrayList<Integer> unusedAtrbutes)
    {

            return 0;
    }

    public ID3Node createRootNode(Data data)
    {
        double max=0;
        int atributeIndexUsed=0;
        for (int i = 0; i < 6; i++) {
            double dataEntropy = Data.getEntropyAttribute(data,i);
            if(dataEntropy>max)
            {
                atributeIndexUsed=i;
                max =dataEntropy;
            }
        }
        return new ID3Node(data, atributeIndexUsed, unusedAtrbutes);
    }

    class ID3Node
    {
        Data data;
        //int usedAttributeValue;
        int usedAttribute;
        ArrayList<ID3Node> children;
        ArrayList<Integer> unusedAtrbutes;
        private ArrayList<Double> stats;

        ID3Node(Data data, int usedAttribute , /*int usedAttributeValue,*/ArrayList<Integer> unusedAtrbutes)
        {
            children= new ArrayList<ID3Node>();
            this.data=data;
            //this.usedAttributeValue=usedAttributeValue;
            this.usedAttribute=usedAttribute;
            this.unusedAtrbutes=unusedAtrbutes;
            this.unusedAtrbutes.remove(new Integer(usedAttribute));
            this.stats= Data.getPropabilityOfClasses(data);
            boolean finalState = false;
            for (int i = 0; i < 4; i++)
            {
                if(stats.get(i)==1)
                    finalState=true;
                
            }
            
//            if(data.data.size()>=0&& unusedAtrbutes.size()>0&&!finalState)
//                this.expand(data, null);
            
        }


        void expand(Data totalData ,CarEntry carentry)
        {
                //double max=0;
                //int maxIndex=0;
//                    for (int i = 0; i < Main.attributes.size(); i++)
//                    {
//                        double val = Data.getEntropyAttribute(totalData, maxIndex);
//                        if(val>max)
//                        {
//                            max=val;
//                            maxIndex=i;
//                            
//                        }      
//                    }
//                    unusedAtrbutes.remove(new Integer(maxIndex));
            for (String children1 : Main.attributes.get(usedAttribute))
            {
                double max=0;
                int atributeIndexUsed=0;
                Data restrictedData=(new Data(Data.getEntriesWithAttribute(totalData, usedAttribute, children1)));
                //System.out.println("Data:"+data);
                for (Integer index : unusedAtrbutes)
                {

                    double dataEntropy = Data.getEntropyAttribute(restrictedData, index);

                    if(dataEntropy>max)
                    {
                        atributeIndexUsed=index;
                        max =dataEntropy;
                    }
                }
                children.add(new ID3Node(restrictedData, atributeIndexUsed, unusedAtrbutes));

            }
        }

             @Override
        public String toString()
        {
            
            String message="";
            message+="Attribute Used:"+this.usedAttribute+"\n";
            double total =0;
            for (int i = 0; i < Main.classofCar.size(); i++)
            {
                message += Main.classofCar.get(i)+":"+stats.get(i)+"\n";
                total+=stats.get(i);

            }
            message+="total:"+total;
            return message;

        }

    }

   
        
        

}
