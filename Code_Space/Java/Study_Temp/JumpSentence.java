import static java.lang.System.out;

public class JumpSentence{
        public static void main(String[] args) {
            for(int i=1;i<10;i++){
                if(i%2!=0){
                    out.println(i);
                }
                else
                    continue;
            }
            out.println("\n显示完毕");
        }
}
