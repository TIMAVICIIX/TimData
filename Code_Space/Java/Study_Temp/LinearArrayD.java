import java.util.Arrays;
import static java.lang.System.out;

public class LinearArrayD {

    public static void main(String[] args){
        LinearArrayD inputData=new LinearArrayD();
        inputData.Ghost();

    }


        private final int[] _num_part;
        private final int[] _num_consist;
        private int _count;
        private final boolean[] _antiArray;

        LinearArrayD(){
            _num_part=new int[4];
            _num_consist=new int[12];
            _antiArray=new boolean[4];
            _count=1000;
            Arrays.fill(_antiArray,false);
        }

        void Ghost() {

            int _countCopy;
            int _consist=0;
            boolean head01=false;
            boolean head02=false;
            boolean layer01=false;
            boolean layer02=false;
            boolean _puts=false;

            for (; _count < 10000; _count++) {

                _countCopy=_count;

                for (int i = _num_part.length - 1; _countCopy != 0; _countCopy /= 10, i--) {
                    _num_part[i] = _countCopy % 10;
                }


                for (int i = 0; i < _num_part.length - 1; i++) {
                    for(int j=i+1;j<_num_part.length;j++){

                        _num_consist[_consist++]=_num_part[i]*10+_num_part[j];

                        _num_consist[_consist++]=_num_part[j]*10+_num_part[i];

                    }
                }


               for(int i=0;i<_num_consist.length-1;i++){
                   for(int j=i;j<_num_consist.length;j++){
                       if((_num_consist[i]*_num_consist[j])==_count){

                           for(int c=0;c<_antiArray.length;c++){

                               /*out.println(_num_consist[i]%10+" "+_num_consist[i]/10);
                               out.println(_num_part[c]);*/


                               if(!(_antiArray[c])){
                                   if ((_num_consist[i] / 10 ==_num_part[c])&&!head01) {
                                       _antiArray[c] = true;
                                       head01=true;
                                   }
                                   else if((_num_consist[i]%10==_num_part[c]&&!layer01)){
                                       _antiArray[c]=true;
                                       layer01=true;
                                   }


                               }

                              /*out.println(_antiArray[c]);
                                out.println();*/
                           }

                           for(int c=0;c<_antiArray.length;c++) {

                               /*out.println(_num_consist[j]%10+" "+_num_consist[j]/10);
                               out.println(_num_part[c]);*/

                               if (!(_antiArray[c])) {
                                   if ((_num_consist[j] / 10 ==_num_part[c])&&!head02) {
                                       _antiArray[c] = true;
                                       head02=true;
                                   }
                                   else if((_num_consist[j]%10==_num_part[c]&&!layer02)){
                                       _antiArray[c]=true;
                                       layer02=true;
                                   }
                               }
                               /*out.println(_antiArray[c]);
                               out.println();*/

                           }

                           if(_antiArray[0] && _antiArray[1] && _antiArray[2] && _antiArray[3]) {

                               if (!_puts) {

                                   _puts=true;

                                   /*for (boolean temp : _antiArray) {
                                       out.print(temp + " ");
                                   }
                                   out.println();

                                   out.println(_num_consist[i] + " " + _num_consist[j]);*/

                                   out.println(_count);
                                   out.println();
                               }
                           }

                           Arrays.fill(_antiArray,false);
                           head01=head02=layer02=layer01=false;
                       }
                   }
               }

                _consist=0;
               _puts=false;

            }

        }
}