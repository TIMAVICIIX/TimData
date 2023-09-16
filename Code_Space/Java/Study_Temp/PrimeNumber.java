import java.util.Scanner;
import static java.lang.System.out;

public class PrimeNumber{
   public static void main(String[] args){
      Scanner scanner=new Scanner(System.in);
      out.println("请输入一个正整数：");
      int _n=scanner.nextInt();

      int _k=2;

      while(_k<_n){
          if(_n%_k==0){
              break;
          }
          _k++;
      }

       if(_k==_n){
           out.println(_n+"是素数");
       }
       else{
           out.println(_n+"不是素数");
       }
   }
}
