package day1128;

/**
 * 학생의 Oracle,Java,JDBC 과목점수를 처리하는 프로그램
 * @author owner
 */
public class ScoreProcess2 {
	
	private int total;
	private double average;
	private int o_total;
	private int j_total;
	private int jdbc_total;
	private int o_maxScore;
	private int j_maxScore;
	private int jdbc_maxScore;
	private int maxScore;
	private int topstunum;
	private String topstuname;
	private int temp;// 정렬값을 임시로 저장할 변수
	
	
	public ScoreProcess2() {
		total=0;
	}//ScoreProcess2
	
	/**
	 * 점수를 누적 합 시킨다.
	 * @param score
	 */
	public void addTotal(int score) {
		total+=score;
	}//addTotal
	
	/**
	 * 점수를 얻는 일을 함.
	 * @return
	 */
	public int getTotal() {
		return total;
	}//getTotal
	
	/**
	 * 총합 점수를 초기화. 
	 */
	public void resetTotal() {
		total=0;
	}//resetTotal
	
	/**
	 * 1-1)))) 각 학생들의 점수의 평균 구하기
	 * (소수점이 나올수도 있어 출력은 소수이하 한자리 까지만 출력
	 * @param total
	 */
	public void average(int total, int[][] score) {
//		average=(total/3);
		average=(total/score[1].length);
		
	}//average
	/**
	 * 1-1)))) 평균을 얻는 일
	 * @return
	 */
	public double getAverage() {
		return average;
	}//getAverage
	
//	1-1) 해봄..
//	public int average2(int total) {
//		average=(total/3);
//		return average;
//	}// 출력할때에도 매개변수를 넣어주어야 하므로 따로하는게 더 편리하겠다.
	
//	public void subjecttotal(int[][] score) {
//		o_total=o_total+score[i][0];
//		j_total=j_total+score[i][1];
//		jdbc_total=jdbc_total+score[i][2];
//	}//subjecttotal
	
	
	
	////1-5.일등 학생의 이름과 총점, 번호  (총점의 최고점)
	public void topstu(String[] name, int[][] score) {
//		getTotal();
		//학생마다의 토탈을 가져와 총점을 비교하여 최고총점의 학생의 이름을 최종적으로 가지고 반환.
//		if(o_maxScore<score[i][0]) {
//			//현재 순환중인  방의 값으로 최고점수를 변경해 준다.
//			o_maxScore=score[i][0];
//		}//자바의 최고 점수
		
		//행을 돌때 [6][] 만약 총점의 점수가 최고총첨이랑 같을때 총점 i가 name의 i랑 같아 name을 구하고
		//i는 번호.
		for(int i=0; i<score.length; i++) {//행
			
			for(int j=0; j<score[i].length ;j++) {//열	
				addTotal(score[i][j]);
			}
			if(maxScore<getTotal()) {
				//현재 순환중인  방의 값으로 최고점수를 변경해 준다.
				maxScore=getTotal();
				topstunum=i+1;
				topstuname=name[i];
//				System.out.println(maxScore+" "+topstunum+" "+topstuname);
			}//최고값구하고 값 저장.
//			if (getTotal()==maxScore) {
//				System.out.printf("%d\t%s\n",i+1,name[i]);	
//			}//이름과 번호 출력
			resetTotal();
		}
//		System.out.println(maxScore+" "+topstunum+" "+topstuname);
	}//topstu
	
	//1-6.자바점수만 오름차순 정렬하여 출력.
	public void sort(int[][] score) {
		//점수를 정렬하고 싶다...오름차순/내림차순   =>선택 정렬
//		:처음 방의값과 옆방의 값을 비교하여 옆방의 값이 뒷방의 값보다 작다면 옆방의 값과 뒷방의 값을 
//		바꾼다. 이 작업이 끝방까지 된후 두번째 방부터 또다시 반복
		
		for(int i=0;i<score.length-1;i++) {
			for(int j=i+1; j <score.length; j++) {
				if(score[i][1] > score[j][1]) {  
				//앞방의 값이 뒷방보다 작다면 내림차순, 크게비교하면 오름차순 정렬
					temp=score[i][1];
					score[i][1]=score[j][1];
					score[j][1]=temp;
				}//end if
			}//end for
		}//end for
		for (int i=0;i<score.length; i++) {
			System.out.printf("%-4d",score[i][1]);
		}//end for
		System.out.println();
	}
	
	
//	2.이차원 배열을 만들고 (참조형형식으로) 아래와 같이 값을 넣어 출력하는 method 작성.
//	1 1 1 1 1 1 1 1 1 1
//	1 0 0 0 0 0 0 0 0 1
//	1 0 0 0 0 0 0 0 0 1
//	1 0 0 0 0 0 0 0 0 1
//	1 0 0 0 0 0 0 0 0 1
//	1 1 1 1 1 1 1 1 1 1
	public void arrayTest() {
		System.out.println("---------------------------------------------");
//		for(int i=0; i<6; i++) {
//			for(int j=0; j<11; j++) {
//				if((i>0&&i<5) && (j>0&&j<10)) {
//					System.out.print(0);
//				}else {
//					System.out.print(1);
//				}
//			}
//			System.out.println();
//		}
		int[][] arr= new int[6][10];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if((i>0&&i<arr.length-1) && (j>0&&j<arr[0].length-1)) {
					arr[i][j]=0;
				}else {
					arr[i][j]=1;
				}
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
	}
	

	
	public String[] nameData() {
		String[] name = {"김정운","이재현","정택성","노진경","최지우","김건하"};
		return name;
	}//nameData
	
	
	public int[][] scoreData(){
		int[][] score = {{85,86,81},{95,91,100},{89,71,59},
						{97,96,91},{78,74,77},{100,95,68}};
		return score;
	}//scoreData
	
	
	public void printScore(String[] name, int[][] score) {
//		int total=0;
		//1-1.각 학생의 평균을 구하여 출력. (소수점이 나올수도 있어 출력은 소수이하 한자리 까지만 출력
		
		System.out.println("번호\t이름\tOracle\tJava\tJDBC\t총점\t평균");
		
//		System.out.println("번호\t이름\tOracle\tJava\tJDBC\t총점");
		System.out.println("----------------------------------------------------");
		
		for(int i=0; i<score.length; i++) {//행
			System.out.printf("%d\t%s\t",i+1,name[i]);
			for(int j=0; j<score[i].length ;j++) {//열
				System.out.printf("%d\t",score[i][j]);
//				total+=score[i][j];//하지만 프린트라는 업무에 맞지않음.
				addTotal(score[i][j]);
				
//				average=(total/3);	
//				average(total);
				average(total,score);
//				average2(total);
				
				//오라클의 최고점수
				if(o_maxScore<score[i][0]) {
					//현재 순환중인  방의 값으로 최고점수를 변경해 준다.
					o_maxScore=score[i][0];
				}//자바의 최고 점수
				//최고점수가 현재 순환중인 방의 값보다 작다면 
				if(j_maxScore<score[i][1]) {
					//현재 순환중인  방의 값으로 최고점수를 변경해 준다.
					j_maxScore=score[i][1];
				}//end if
				//JDBC의 최고점수
				if(jdbc_maxScore<score[i][2]) {
					//현재 순환중인  방의 값으로 최고점수를 변경해 준다.
					jdbc_maxScore=score[i][2];
				}//end if
								
			}//end for
			
//			System.out.println(total);
//			System.out.println(getTotal());
			System.out.print(getTotal()+"\t");
			
//			System.out.println(average);
			System.out.println(getAverage());
//			System.out.printf("%.1d",getAverage());
//			System.out.println(average2(total));

			o_total=o_total+score[i][0];
			j_total=j_total+score[i][1];
			jdbc_total=jdbc_total+score[i][2];
			
//			total=0;//초기화가 되지않아 쌓임.
			resetTotal();

		}//end for
		System.out.println("----------------------------------------------------");
		
		//2.각 과목당 총점과 총점의 총점
		System.out.printf("과목총점 :\t %d\t%d\t%d\t 총점의 총점 :%d\t \n",o_total,j_total,
							jdbc_total,o_total+j_total+jdbc_total);
		
		//3.각 과목당 평균과 전체 평균(전체 평균은 소수이하 두자리 까지출력)
		System.out.printf("과목 평균:\t %d\t%d\t%d\t전체 평균:\t%.2f\t \n",
							o_total/name.length,j_total/name.length,jdbc_total/name.length,
							(double)(o_total/name.length+j_total/name.length+jdbc_total/name.length)/score[1].length);
		//4.각 과목당 최고 점수를 출력
		System.out.printf("최고 점수\t java[%d] Oracle[%d] JDBC[%d]\n",o_maxScore,j_maxScore,jdbc_maxScore);
		
		//5.일등 학생의 이름과 총점, 번호
		topstu(name, score);
		System.out.println("Top 번호는 ["+topstunum+"] 이름 ["+ topstuname+"] 총점 ["+ maxScore+"]");
//		System.out.printf("Top 번호[%d] 이름[%s] 총점[%d]",topstu(name, score).topstunum,topstu(name, score).topstuname,topstu(name, score).maxScore);
		//6.자바점수만 오름차순 정렬하여 출력.
		sort(score);
		
	
		
		
		
	}//printScore
	
	public static void main(String[] args) {
		ScoreProcess2 sp2 = new ScoreProcess2();
		//처리할 데이터 받기
		String[] name = sp2.nameData();
		int[][] score =sp2.scoreData();
		//처리
		sp2.printScore(name,score);
		
		
		sp2.arrayTest();
		
	}//main
}//class
