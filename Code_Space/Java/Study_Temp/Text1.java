import static java.lang.System.out;

public class Text1 {

    public static void main(String[] args) {
            Rectangle rectangle=new Rectangle();
            rectangle.SetWidth(3.0f);
            rectangle.SetHight(5.0f);

            float area=rectangle.Area();

            out.println("Rectangle's Width is:"+rectangle.getWidth());
            out.println("Rectangle's Height is:"+rectangle.getHight());
            out.println("Area is:"+area);

            Rectangle r2=new Rectangle();
            r2.SetWidth(4.5f);
            r2.SetHight(8.0f);
            out.println("r2's Width:"+r2.getWidth());
            out.println("r2's Height:"+r2.getHight());
            out.println("r2's Area is:"+r2.Area());

        Rectangle r3=new Rectangle();
        r3.SetWidth(10.5f);
        r3.SetHight(20.0f);
        out.println("r3's Width:"+r3.getWidth());
        out.println("r3's Height:"+r3.getHight());
        out.println("r3's Area is:"+r3.Area());

    }

}
