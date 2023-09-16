import java.util.Scanner;
import static java.lang.System.out;

public class Multiplication{
   public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        out.println("请输入一个整数：");
        int _x=scanner.nextInt();

        int _jsum=1;
        int sum=1;
        int i=1;

        do{
            int _temp_sum=1;
            i++;
            for(int _temp=1;_temp<=i;_temp++){
                _temp_sum*=_temp;
            }
            sum+=_temp_sum;
        }while(i<_x);

        i=1;
       do{
           _jsum*=i;
           i++;
       }while(i<=_x);



       out.println(_x+" 的1!+2!...为:"+sum);
        out.println(_x+" 的阶乘为:"+_jsum);
   }
}
