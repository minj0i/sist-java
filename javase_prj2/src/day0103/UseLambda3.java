package day0103;

public class UseLambda3 {

	public static void main(String[] args) {
		
		Thread t=new Thread(()->{
				for(int i=0; i<1000;i++){
					System.out.println(i);
				}//end for
			});
		Thread t1=new Thread(()->{
			for(int i=0; i<1000;i++){
				System.out.println("t1 i="+i);
			}//end for
		});
		t.start();
		t1.start();
		
		for(int i=0; i<1000;i++){
			System.out.println("main i="+i);
		}//end for
		
	}//main
}//class
