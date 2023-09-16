public class ArithemticOper{
	public static void main(String []args){
		byte a = 10;
		byte b = 3;
	
		int result=a%b;

		System.out.println("a%b="+result);
		float a1 = 10.0f;
		float b1 = 2.0f;

		float result1=a1%b1;

		System.out.println("a1%b1="+result1);
		
		a++;
		a1++;

		System.out.println("++a="+a);
		System.out.println("++a1="+a1);
		byte c = 10;
		byte d = 20;

		
		int e = c + d;
				
		

		short f = 4;
		short g = 2;
		
		int h = f + g;

		
		float k = 0.0f;
		k=a1/0;

		System.out.println("k="+k);
		int kk = 0;
		kk=a/b;

		System.out.println("kk="+kk);
	}
}
