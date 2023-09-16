import java.util.Scanner;

public class Logic01{
	public static void main(String[] args){
		for(int i=1;i<=100;i++){
			if(i%3==0&&i%7==0)
				System.out.println("The Num:"+i);
		}
	}
}