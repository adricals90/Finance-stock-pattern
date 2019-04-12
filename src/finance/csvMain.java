package finance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;

public class csvMain {
	  
	public static void main(String[] args) {
		csvM num2= new csvM();
		int records=0;
		String fileNme= "aaple2.csv"; // name of the FILE
		File file= new File(fileNme);
		
		
			try {
				Scanner inputStream= new Scanner(file);
				inputStream.nextLine();
				inputStream.nextLine();
				while(inputStream.hasNextLine())
				{
				String data= inputStream.next();
				String[] values= data.split(",");
				
			double open1= Double.parseDouble(values[1]);  // getting data and parsing to arrays
			num2.insertOpen(open1);
			double high= Double.parseDouble(values[2]);
			num2.insertHigh(high);;
			double low= Double.parseDouble(values[3]);
			num2.insertLow(low);
			double close= Double.parseDouble(values[4]);
			num2.insertClose(close);
		    double direI= Double.parseDouble(values[5]);
			num2.dirI(direI);
			double direJ= Double.parseDouble(values[6]);
			num2.dirJ(direJ);

				records++;
			
			}
				inputStream.close();
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			
			}
			

		   System.out.println("Number of records"+records+" ");
		    
		   num2.longP(records);    //when it goes long it checks the condition if we win or lose
		   System.out.println(" ");
		   num2.shortP(records);
		    
	}

}
