import java.util.Scanner;

public class LinearArray{
	public static void main(String[] args){
		int[] a={1,2,3,4,5,6,7,8,9,10};
		int i;
		for(int temp:a){
			System.out.print(temp+" ");
		}
		System.out.println();
		Scanner sc=new Scanner(System.in);
		for(i=0;i<10;i++){
			System.out.println("Input num:");
			a[i]=sc.nextInt();
		}
		i=0;
		while(i<10){
		System.out.print(a[i]);
		i++;
			
		}
		System.out.println();
		

	}
}