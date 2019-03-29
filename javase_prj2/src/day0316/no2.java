package day0316;

public class no2 {
	public no2() {
	}
	
	public boolean solution(int[][] lands, int[][]wells, int[]point) {
		boolean answer=false;
		boolean flag1 = false;
		boolean flag2 = false;
		for(int i=0; i<lands.length; i++) {
			for(int j=0; j<lands.length; j++) {
				if(wells[0][j]-point[j]>=0) {
					flag2=true;
				}else {
					flag2=false;
				}
			}
		}
		if(flag1&&flag2) {
			answer=true;
		}
		
		System.out.println(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		no2 no = new no2();
	}//main
}//class
