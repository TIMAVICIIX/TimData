public class Logic{
	public static void main(String[] args){
		boolean a=true;
		boolean b=false;
		boolean x,y,z;
		
		x=a&&b;
		y=a||b;
		z=!(x&&y);

		System.out.println("x="+x);
		System.out.println("y="+y);
		System.out.println("z="+z);
	}
}