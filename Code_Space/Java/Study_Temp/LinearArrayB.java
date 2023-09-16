import java.util.Scanner;

public class LinearArrayB{
	public static void main(String[] args){
	int i,max,min;
	int[] x=new int[5];
	Scanner sc=new Scanner(System.in);
		for(i=0;i<5;i++){
			System.out.println("Input Num:");
			x[i]=sc.nextInt();
		}
	max=x[0];
	min=x[0];
		for(i=1;i<x.length;i++){
			if(x[i]>max)
				max=x[i];
			if(x[i]<min)
				min=x[i];
		}
	System.out.println("Max:"+max);
	System.out.println("Min"+min);
	}
}