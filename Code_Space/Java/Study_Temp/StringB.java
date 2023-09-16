import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static java.lang.System.out;

public class StringB {

    public static void main(String[] args) {

        if(args[0].length()==1) {
            out.println("输入参数不正确，请输入身份证号码");
            return;
        }

        String idCard=args[0];

        if(args[0].length()!=18) {
            out.println("请输入18位身份证号码");
            return;
        }

        String [][]porCode=new String[9][];

        porCode[1]=new String[6];
        porCode[1][1]="北京";
        porCode[1][2]="天津";
        porCode[1][3]="河北";
        porCode[1][4]="山西";
        porCode[1][5]="内蒙古";

        porCode[2]=new String[4];
        porCode[2][2]="吉林";
        porCode[2][3]="黑龙江";

        porCode[3]=new String[8];
        porCode[3][1]="上海";
        porCode[3][2]="江苏";
        porCode[3][3]="浙江";
        porCode[3][4]="安徽";
        porCode[3][5]="福建";
        porCode[3][6]="江西";
        porCode[3][7]="山东";

        porCode[4]=new String[7];
        porCode[4][1]="河南";
        porCode[4][2]="湖北";
        porCode[4][3]="湖南";
        porCode[4][4]="广东";
        porCode[4][5]="广西";
        porCode[4][6]="海南";

        porCode[5]=new String[5];
        porCode[5][0]="重庆";
        porCode[5][1]="四川";
        porCode[5][2]="贵州";
        porCode[5][3]="云南";
        porCode[5][4]="西藏";

        porCode[6]=new String[6];
        porCode[6][1]="陕西";
        porCode[6][2]="甘肃";
        porCode[6][3]="青海";
        porCode[6][4]="宁夏";
        porCode[6][5]="新疆";

        porCode[8]=new String[3];
        porCode[8][1]="香港";
        porCode[8][2]="澳门";

        String firstRegionCode=args[0].substring(0,1);
        String secondRegionCode=args[0].substring(1,2);
        int frc=Integer.valueOf(firstRegionCode);
        int src=Integer.valueOf(secondRegionCode);

        if(frc>8||frc<1){
            out.println("地区代码输入错误，请重新输入！");
            return;
        }

        if(frc==5){
            if(src>4||src<1){
                out.println("地区代码输入错误，请重新输入！");
            }
        }else{
            if(src>7||src<1){
                out.println("地区代码输入错误，请重新输入！");
            }
        }

        String regionName=porCode[frc][src];

        out.println("身份证所属号码地区是："+regionName);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");

        Calendar calendar=Calendar.getInstance();

        String birthdayStr=args[0].substring(8,15);
        String yearStr=args[0].substring(6,10);
        String monthStr=args[0].substring(10,12);
        String dateStr=args[0].substring(12,14);

        int year=Integer.parseInt(yearStr);
        int month=Integer.parseInt(monthStr);
        int date=Integer.parseInt(dateStr);


        if(month==2){
            if(year%4==0&&(year%100!=0||year%400==0)){
                if(!(date>0&&date<30)){
                    out.println("生日错误！");
                    return;
                }
            }else{
                if(!(date>0&&date<29)){
                    out.println("生日错误！");
                    return;
                }
            }
        }else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            if(!(date<32&&date>0)){
                out.println("生日错误！");
                return;
            }
        }else{
            if(!(date<31&&date>0)){
                out.println("生日错误！");
            }
        }

        calendar.set(year,month-1,date);
        Date birthday=calendar.getTime();
        String birthdayStr1=sdf.format(birthday);
        out.println("出生日期是："+birthdayStr1);


        char[] args_alter=args[0].toCharArray();

        for(int i=6;i<14;i++){
            args_alter[i]='*';
        }

        for(char temp:args_alter){
            out.print(temp);
        }
    }

}
