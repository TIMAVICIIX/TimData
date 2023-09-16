import java.util.Random;
import static java.lang.System.out;

public class Array2 {
    public static void main(String[] args){
        int i,j;
        int[][] a=new int[3][3];
        int[][] b=new int[3][3];

        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                a[i][j]=(int)(Math.random()*100);
            }
        }

        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                b[i][j]=a[j][i];
            }
        }

        for(int[] temp:a){
            for(int _temp:temp){
                out.print(_temp+" ");
            }
            out.println();
        }
	out.println();

        for(int[] temp:b){
            for(int _temp:temp){
                out.print(_temp+" ");
            }
            out.println();
        }
    }
}



