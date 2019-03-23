package day0316;

public class no1 {
	public int[]solution(int money){
		int[] unit= {50000,10000,5000,1000,500,100,50,10,1};
		int[] answer = new int[9];
		
		for(int i=0; i<unit.length; i++) {
			int count=money/unit[i];
			answer[i]=count;
			System.out.println(answer[i]);
		}
		return answer;
	}

	public static void main(String[] args) {
		no1 no = new no1();
		no.solution(50237);
	}
}
