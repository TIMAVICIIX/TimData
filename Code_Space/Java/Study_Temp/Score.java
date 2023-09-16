import java.util.Scanner;

public class Score{
	public static void main(String[] args){
		System.out.println("请输入成绩：");
		Scanner scanner=new Scanner(System.in);
		int x=scanner.nextInt();
		switch(10-(x/10)){
		
		case 1:
			System.out.println("你的成绩是："+x+" A");
			break;
		case 2:
			System.out.println("你的成绩是："+x+" B");
			break;
		case 3:
			System.out.println("你的成绩是："+x+" C");
			break;
		case 4:
			System.out.println("你的成绩是："+x+" D");
			break;
		default:
			System.out.println("你的成绩是："+x+" E");

		}
	scanner.close();
	}
}