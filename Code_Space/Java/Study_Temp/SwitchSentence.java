import java.util.*;

public class SwitchSentence{
	public static void main(String[] args){
		int month=-1;
		System.out.println("请输入月份：");
		Scanner scanner=new Scanner(System.in);
		month=scanner.nextInt();
		
		switch(month){

		case 1:
		case 2:
		case 12:
			System.out.println("冬季");break;
		case 3:
		case 4:
		case 5:
			System.out.println(" 春季");break;
		case 6:
		case 7:
		case 8:
			System.out.println("夏季");break;
		case 9:
		case 10:
		case 11:
			System.out.println("秋季");break;
		default:
			System.out.println("没有这个季节！！！");
		}
	scanner.close();
	}
}