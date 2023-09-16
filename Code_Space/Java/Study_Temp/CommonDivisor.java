import java.util.Scanner;
import static java.lang.System.out;

public class CommonDivisor{
   public static void main(String[] args){
       Scanner scanner=new Scanner(System.in);
       out.println("请输入第一个数：");
       int n1=scanner.nextInt();
       out.println("请输入第二个数：");
       int n2=scanner.nextInt();

       int max;
       int min;
       int temp;

       if(n1>n2){
           max=n1;
           min=n2;
       }
       else{
           max=n2;
           min=n1;
       }

       out.println(n1+" "+n2+"（递归）最大公约数为："+Sent_Back(max,min));

       //while Method
       temp=min;
       while(true){
           if(min%temp==0&&max%temp==0){
               min=temp;break;
           }
           else{
               temp--;
           }
       }
       out.println(n1+" "+n2+"（while循环）最大公约数为："+min);
   }


   //Sent_Back Method
   static int Sent_Back(int _max,int _min){
        int _k=_max%_min;
        if(_k!=0){
            _max=_min;
            _min=_k;
            Sent_Back(_max,_min);
        }
            return _min;
   }
}
