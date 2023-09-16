import java.util.*;

public class LinearArrayC{
	public static void main(String[] args){
	int space;
	Scanner sc=new Scanner(System.in);
	System.out.print("Input space:");
	
	space=sc.nextInt();
	
	int[] a=new int[space];
	int[] b=new int[10];
	for(int i=0;i<100;i++){
		a[i]=(int)(Math.random()*(9999-1000+1))+1000;
	}
		for(int temp:a){
			b[temp%10]++;
		}
	
		for(int temp:b){
			System.out.print(temp+" ");
		}
	}
}