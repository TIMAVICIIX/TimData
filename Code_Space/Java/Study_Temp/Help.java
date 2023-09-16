import static java.lang.System.out;

public class Help {
    public static void main(String[] args){
      String str="789";
      char[] b=str.toCharArray();

      out.print("第一种方法：");
      for(char temp:b){
          out.print(temp);
      }

      int num2=Integer.parseInt(str);
      int num3=Integer.valueOf(str);
      out.print("\n第二种方法"+num2+"\n第三种方法："+num3);
    }
}