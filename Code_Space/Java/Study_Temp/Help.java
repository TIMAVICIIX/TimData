import static java.lang.System.out;

public class Help {
    public static void main(String[] args){
      String str="789";
      char[] b=str.toCharArray();

      out.print("��һ�ַ�����");
      for(char temp:b){
          out.print(temp);
      }

      int num2=Integer.parseInt(str);
      int num3=Integer.valueOf(str);
      out.print("\n�ڶ��ַ���"+num2+"\n�����ַ�����"+num3);
    }
}