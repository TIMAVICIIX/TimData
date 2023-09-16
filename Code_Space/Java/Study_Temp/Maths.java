import java.util.*;

public class Maths{
	public float x;
	Maths(float x){
		this.x=x;
	}
	public static void main(String[] args){
		Maths m=new Maths(-3.4f);
		System.out.println("X="+Math.abs(m.x));
		 ArrayList<Integer> Arr=new ArrayList<Integer>();
      		 Arr.add(1);
      	 	Arr.add(3);
    	  	Arr.remove(0);
       		System.out.println("Arr1="+Arr.get(0)+"\nIs Empty?"+Arr.isEmpty());
	}
}