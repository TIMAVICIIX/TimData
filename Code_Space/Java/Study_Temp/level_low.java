
import static java.lang.System.out;

public class level_low {
        public static void main(String[] args) {
            for(int i=1000;i<10000;i++){
                if((i/1000)==(i%10)){
                    out.println(i);
                }
            }

        }
}


