package day0316;

public class no7 {
	public String solution(String cryptogram) {
		String answer="";
		String[] words = new String[cryptogram.length()];
		for(int i=0; i<cryptogram.length(); i++) {
			for(int j=0; j<i; j++) {
				char c = cryptogram.charAt(j);
				char d = cryptogram.charAt(j+1);
				System.out.println(c+"/"+d);
				if(c==d) {
					System.out.println();
				}
			}
			System.out.println(answer+"°ª");
		}
		return answer;
	}
	public static void main(String[] args) {
		no7 no = new no7();
		no.solution("browoanoommnaon");
	}
}
