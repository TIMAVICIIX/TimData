import java.util.Random;
import static java.lang.System.out;

public class StudentScore {
    final private float[][] score;
    final private float[] sum_score;

    public static void main(String[] args){
        StudentScore inputData=new StudentScore();
    }

    StudentScore(){
        Random random=new Random();
        score=new float[20][5];
        sum_score=new float[20];

        for(int i=0;i<20;i++){
            for(int j=0;j<5;j++){
                score[i][j]=random.nextFloat()*101;
            }
        }
    Sum();
    Print();
    }

    void Print(){
        int count=1;
        for(int i=0;i<20;i++){
            out.print(count+": ");
            for(int j=0;j<5;j++){
                out.print(String.format(" %.2f  ",score[i][j]));
            }
            out.println();
            count++;
        }

        out.println("Sum:");
        for(int i=0;i<20;i++){
            out.println(String.format("%d: %.2f ",i+1,sum_score[i]));
        }

        out.println("Averge:");
        for(int i=0;i<20;i++){
            float sum=0;
            for(int j=0;j<5;j++){
                sum+=score[i][j];
            }
            out.println(String.format("%d: %.2f ",i+1,sum/5));
        }
    }

    void Sum(){
        for(int i=0;i<20;i++){
            int count=0;
            for(int j=0;j<5;j++){
                count+=score[i][j];
            }
            sum_score[i]=count;
        }
    }


}



