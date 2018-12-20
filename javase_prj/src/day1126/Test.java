package day1126;

public class Test {
	int i;
	String s;
    public void temp(int mi, Test t){
        System.out.println(mi);
        t.i=mi;
        t.s="¾È³ç";
    }
    public static void main(String[] args){
        Test t = new Test();
        System.out.println(t.i); 
        t.temp(1000, t);
       System.out.println(t.i+t.s);
	}
}

