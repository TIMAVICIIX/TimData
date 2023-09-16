import static java.lang.System.out;

public class StringA {

	public static void main(String[] args) {
		String str1="Java";
		String str2="Java";
		
		String str3=new String("Java");
		String str4=new String("Java");
		
		String str5="Ja";
		String str6="va";
		
		String str7=str5+str6;
		
		if(str1==str2) {
			out.println("str1&str2 is Equal in Address!");
		}else {
			out.println("str1&str2 no Equal in Address!");
		}
		
		if(str1==str3) {
			out.println("str1&str3 is Equal in Address!");
		}else {
			out.println("str1&str3 no Equal in Address!");
		}
		
		if(str1==str4) {
			out.println("str1&str4 is Equal in Address!");
		}else {
			out.println("str1&str4 no Equal in Address!");
		}
		
		if(str1==str7) {
			out.println("str1&str7 is Equal in Address!");
		}else {
			out.println("str1&str7 no Equal in Address!");
		}
		
		if(str3==str4) {
			out.println("str3&str4 is Equal in Address!");
		}else {
			out.println("str3&str4 no Equal in Address!");
		}
		
		if(str3==str7) {
			out.println("str3&str7 is Equal in Address!");
		}else {
			out.println("str3&str7 no Equal in Address!");
		}
		
		if(str1.equals(str2)) {
			out.println("str1&str2 is Equal!");
		}else {
			out.println("str1&str2 no Equal!");
		}
		
		if(str1.equals(str3)) {
			out.println("str1&str3 is Equal!");
		}else {
			out.println("str1&str3 no Equal!");
		}
		
		if(str1.equals(str4)) {
			out.println("str1&str4 is Equal!");
		}else {
			out.println("str1&str4 no Equal!");
		}
		
		if(str1.equals(str7)) {
			out.println("str1&str7 is Equal!");
		}else {
			out.println("str1&str7 no Equal!");
		}
	}
	
}
