import java.util.Scanner;

public class Max{
		public static void main(String[] args){
			int max;
			int[] NewArray=new int[5];
			Scanner sc=new Scanner(System.in);			

			for(int i=0;i<5;i++){
				System.out.println("Please input num:");
				NewArray[i]=sc.nextInt();
			}

			max=NewArray[0];

			for(int temp:NewArray){
				if(temp>max)
					max=temp;
			}

			System.out.println("The Max is:"+max);
			sc.close();
		
		}
	}