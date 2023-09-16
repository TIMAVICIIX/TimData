import java.util.Scanner;

public class LeapYear{
	public static void main(String[] args){
		Scanner scanner =new Scanner(System.in);
		System.out.println("请输入年:");
		int year=scanner.nextInt();
		boolean isLeapYear=false;
		if(year%4==0||year%400==0){
			isLeapYear=true;
		}
		
		if(isLeapYear){
			System.out.println(year+"是闰年");
		}
		else
			System.out.println(year+"不是闰年");
		scanner.close();
	}
	
}
