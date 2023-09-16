import java.util.Scanner;
import static java.lang.System.out;

public class InputData {
    public static void main(String[] args){
        byte a;
        short b;
        int c;
        long d;
        float e;
        double f;
        boolean g;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字节类型的整数：");
        a=sc.nextByte();
        System.out.println("你输入的字节类型的整数是:"+a);

        System.out.println("请输入一个短整型的整数：");
        b=sc.nextShort();
        System.out.println("你输入的字节类型的整数是:"+b);

        System.out.println("请输入一个整数：");
        c=sc.nextInt();
        System.out.println("你输入的整数是:"+c);

        System.out.println("请输入一个长整数：");
        d=sc.nextLong();
        System.out.println("你输入的长整数是:"+d);

        System.out.println("请输入一个单精度浮点数：");
        e=sc.nextFloat();
        System.out.println("你输入单精度浮点数是:"+e);

        System.out.println("请输入一个双精度浮点数：");
        f=sc.nextDouble();
        System.out.println("你输入双精度浮点数是:"+f);

        System.out.println("请输入一个布尔类型的值:");
        g=sc.nextBoolean();
        System.out.println("你输入的布尔类型的值是:"+g);
        sc.close();

    }

}
