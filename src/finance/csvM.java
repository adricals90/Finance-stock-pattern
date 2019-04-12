package finance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class csvM {
	
	int arraySize=3734;// 15 years of data
	double[] open=new double[arraySize]; 
	double[] high=new double[arraySize]; 
	double[] low=new double[arraySize]; 
	double[] close=new double[arraySize]; 
	double[] dirI= new double [arraySize];
	double[] dirJ= new double [arraySize];
	double[] winPer= new double [arraySize];
	double[] losePer= new double [arraySize];

	int a=0,b=0,c=0,d=0,e=0,f=0;
	int Ave=0;
	
	int [] store2= new int[arraySize];
	int row=2;
	public void insertOpen(double num)
	{
		open[a]=num;
		a++;
	}

	public void insertHigh(double num1)
	{
		high[b]=num1;
		b++;
	}
	public void insertLow(double num2)
	{
		
		low[c]=num2;
		c++;
	}
	public void insertClose(double num3)
	{
		
		close[d]=num3;
		d++;
	}
	public void dirI(double num4)
	{
		
		dirI[e]=num4;
		e++;
	}
	public void dirJ(double num5)
	{
		dirJ[f]=num5;
		f++;
	}
	
	public void shortP(int numStocks)
	{
		int totalShort=0;
		int totalWinS=0;
		int totalLosS=0;
		
		double aveWin=0;
		double aveLos=0;
		
		for(int j=1;j<=numStocks-3;j++){
	
		if((dirJ[j]==0)&&(dirI[j]==0)){
		
			if((dirJ[j+1]==0)&&(dirI[j+1]==0)){
			
					if(open[j+2]>close[j+2]){
				
						  
							winPer[j+2]=((open[j+2]-close[j+2])/open[j+2])*100;

							System.out.println((j+4)+"  "+winPer[j+2]+" %"+"  win");
							totalShort++;
							totalWinS++;
					}else
					{
				losePer[j+2]=((close[j+2]-open[j+2] )/open[j+2])*100;
				System.out.println((j+5)+"  "+losePer[j+2]+" %"+" lose");
				totalShort++;
				totalLosS++;
					}
				}
			}
	   }
		
		
		aveWin=average(winPer, arraySize);
		aveLos=average(losePer, arraySize);
		System.out.println("win % " + aveWin);
		System.out.println("lose % " +aveLos);
		System.out.println("total number of buy/sell transactions: " + totalShort);
		System.out.println("Number of transactions for winning  " + totalWinS);
		System.out.println("number of transactions for lose " + totalLosS);
		System.out.println("Weighted Average: "+weAvg(aveWin,aveLos,totalWinS,totalLosS,totalShort)+" %");

	}
	
	public void longP(int numSto)
	{
		int totalNum=0;
		int totalWinL=0;
		int totalLosL=0;
		double av=0;
		double av2=0;
		for(int k=1;k<=numSto-3;k++){
		if((dirJ[k]==1)&&(dirI[k]==1)){
			
			if((dirJ[k+1]==1)&&(dirI[k+1]==1)){
				
		  	    	    if(open[k+2]<close[k+2]){		

				winPer[k+2]=( (close[k+2]-open[k+2])/ open[k+2] )*100;
				
				System.out.println((k+5)+"   "+winPer[k+2]+" % "+" win");
				totalNum++;
				totalWinL++;	
			}else
			{
				losePer[k+2]=((open[k+2]-close[k+2])/open[k+2])*100;
				System.out.println((k+5)+"   "+losePer[k+2]+" % "+" lose ");
				totalNum++;
				totalLosL++;
			}
		}
		}
		}
		av=average(winPer, arraySize);
		av2=average(losePer, arraySize);
		System.out.println("win % " + av);
		System.out.println("lose % " +av2);
		System.out.println("total number of buy/sell transactions: " + totalNum);
		System.out.println("Number of transactions for winning " + totalWinL);
		System.out.println("number of transactions for lose " + totalLosL);
		System.out.println("Weighted Average: "+weAvg(av,av2,totalWinL,totalLosL,totalNum)+" %");		
	}
	
	public double average(double arr[], int size)
	{
		int count = 0;
		double sum = 0.0;
		for(int i=0; i<size; i++)
		{
			if(arr[i] != 0.0)
			{
				count++;
				sum += arr[i];
			}
		}
		double avg = sum / count;
		
		return avg;
			
	}
	
	public double weAvg(double win, double lose, int numW, int numL, int totalN)
	{
		double wAvg;
		wAvg=((win*numW)-(lose*numL))/totalN;
		
		return wAvg;
	}
	
}
