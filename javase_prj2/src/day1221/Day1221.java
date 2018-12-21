package day1221;

public class Day1221 {

	public static void main(String[] args) {
		
	String s = "c:/dev/temp/Java_read.txt";
	System.out.println(s);
	
//	String s1 = s.substring(0,s.lastIndexOf(".")).concat("_bak.txt");
//	System.out.println(s1);
	
	StringBuilder sb = new StringBuilder(s);
	System.out.println(sb.insert(sb.lastIndexOf("."),"_bak"));
	
	}//main
	
	
}//class
