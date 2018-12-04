package day1128;


/**
 * 4강의장 학생들의 성적처리 프로그램<br>
 * @author owner
 */
public class ScoreProcess {
	
//	private String[] nameArr= {"이재찬","정택성","이재현","김건우","공선의"};	//안에서도 밖에서도 가능
//	private int[] scoreArr = {89, 77, 99, 64, 50};
	
	public ScoreProcess() {
		String[] nameArr= {"이재찬","정택성","이재현","김건우","공선의"};//안에서도 밖에서도 가능
		int[] scoreArr =  {89, 76, 99, 64, 50};
		int totalScore=0;// 총점을 누적 합하기 위한 변수
		int maxScore = 0;// 최고점수
		int minScore = 101;// 최하점수
		int temp = 0;// 정렬값을 임시로 저장할 변수
		
		
		//모든 방의 값 출력
		System.out.println("번호\t이름\t점수");
		System.out.println("--------------------");
		
		for(int i=0;i<nameArr.length;i++) {
			System.out.printf("%d\t%s\t%d\n", i+1,nameArr[i],scoreArr[i]);
			//출력시 0부터 시작하기 때문에 i+1을 표기해 줌으로 1부터 출력되게 만들수 있다.
			//출력시 칸이 맞지않아도 글꼴때문일 뿐 글의 줄을 맞추지 않는당..
			totalScore+=scoreArr[i]; //totalScore=totalScore+scoreArr[i];

			//최고점수가 현재 순환중인 방의 값보다 작다면 
			if(maxScore<scoreArr[i]) {
				//현재 순환중인  방의 값으로 최고점수를 변경해 준다.
				maxScore=scoreArr[i];
			}//end if
			
			//최고점수가 현재 순환중인 방의 값보다 크다면
			if(minScore>scoreArr[i]) {
				//현재 순환중인  방의 값으로 최고점수를 변경해 준다.
				minScore=scoreArr[i];
			}//end if
		}//end for
		//응시인원출력하고싶음
		System.out.println("응시인원 : "+nameArr.length+"명");
		//총점을 구하고싶음
		System.out.printf("총점 [%5d] 평균 [%.2f] \n",totalScore,
							(double)totalScore/nameArr.length);
		//totalScore/nameArr.length=정수이므로 %.2f 소숫점자리를 볼수 없다.
		//따라서 Casting 하여 소숫점자리까지 출력한다.
//		System.out.println(totalScore/nameArr.length);//75.6이라 소숫점이 나오지 않는다.

		//최고점를 구하고 싶음
		//:처음방의 값을 변수에 저장하고 옆방의 값과 비교(if)하여 변수값 작다면(조건) 옆방의 값으로 변수의 값을 변경하고(수행)
		//변경된 변수의 값으로 그다음방의 값을 비교하여 변경하는 작업을 끝까지 수행(반복)한다. 
		//딱떨어지는 값이면 switch추천/ 안떨어지면 if
		System.out.printf("최고점 :[%3d] 최하점 :[%d]\n",maxScore,minScore);
		//최하점은 101점과 비교하여 꺽쇠만 반대되게 바꾸면 구할수 있다.
		
		//점수를 정렬하고 싶다...오름차순/내림차순   =>선택 정렬
//		:처음 방의값과 옆방의 값을 비교하여 옆방의 값이 뒷방의 값보다 작다면 옆방의 값과 뒷방의 값을 
//		바꾼다. 이 작업이 끝방까지 된후 두번째 방부터 또다시 반복
		
		for(int i=0;i<scoreArr.length-1;i++) {
			for(int j=i+1; j <scoreArr.length;j++) {
				if(scoreArr[i] < scoreArr[j]) {  //앞방의 값이 뒷방보다 작다면
					temp=scoreArr[i];
					scoreArr[i]=scoreArr[j];
					scoreArr[j]=temp;
				}//end if
			}//end for
		}//end for

//		소영이 코드
//		for(int i = 0; i < scoreArr.length-1; i++) {
//			for(int j = i+1; j < scoreArr.length; j++) {
//				if(scoreArr[i] < scoreArr[j]) { //앞방의 값이 뒷방보다 작다면 내림차순, 크다면 오름차순
//					temp = scoreArr[i];
//					scoreArr[i]=scoreArr[j];
//					scoreArr[j]=temp;
//					
//				}//end if
//			}//end for-j
//		}//end for-i
		
		for (int i=0;i<scoreArr.length; i++) {
			System.out.printf("%-4d",scoreArr[i]);
		}//end for
		
		System.out.println();
	
		
	}//ScoreProcess

	public static void main(String[] args) {
		new ScoreProcess();
		System.out.println("---------------------------------");
		//1-9 띠를 반환  "양띠"
		int birth=1999;
		String[] zodiac = {"원숭이","닭","개","돼지","쥐","소",
								"호랑이","토끼","용","뱀","말","양띠"};
		System.out.println(zodiac[birth%12]);
		
	}//main
}//class
