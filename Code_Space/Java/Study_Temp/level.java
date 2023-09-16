import java.util.Scanner;
import static java.lang.System.out;

public class level {
    public static void main(String[] args) {

        for (int mainX = 1000;mainX < 10000; mainX++) {

            int x=mainX;
            int numX = 10;
            int count = 10;
            int count_num = 1;
            boolean put=true;

            while (x / numX >= 10) {
                numX *= 10;
                count_num++;
            }
            count_num++;

            count_num /= 2;

            while (count_num != 0) {
                int numY = numX;
                int _tempX = x / numX;

                while (x % numY >= count) {
                    numY /= 10;
                }

                if (_tempX != ((x % numY) / (count / 10))) {
                    put=false;break;
                }

                x %= numX;
                numX /= 10;
                count *= 10;
                count_num--;


            }

            if(put){
                out.println(mainX);
            }

        }
    }
}



