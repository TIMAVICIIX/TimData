
import static java.lang.System.out;

public class Java_2 {
    public static void main(String[] args){
       int[][] a=new int[][]{{2,3,4},{4,5,6}};
       int[][] b=new int[][]{{1,5,2,8},{5,9,10,-3},{2,7,-5,-18}};
       int[][] c=new int[2][4];

       for(int i=0;i<2;i++){
           for(int j=0;j<4;j++){
               for(int k=0;k<3;k++)
                   c[i][j]+=a[i][k]*b[k][j];
               out.print(c[i][j]+" ");

           }
           out.println();
       }
    }
}



