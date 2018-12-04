package day1128;

/**
 * 행마다 열의 갯수가 다른 가변 배열
 * @author owner
 */
public class VariableArray {

	public VariableArray() {
		//1.선언) 데이터형[][] 배열명=null;
		int[][] arr = null;
		//2.생성) 행의 갯수만 설정. 배열명 = new 데이터형[행의 수][];
		arr= new int[4][];
//		System.out.println(arr.length+" / "+arr[0].length);//0행의 열이 없어 Error
//		System.out.println(arr.length+" / "+arr[0]);
		System.out.println("행의 수 : "+arr.length);
		//3.행마다 열을 생성) 배열명[행의번호] = new 데이터형[열의갯수];(생성된 1차원배열이 행에 들어가는것)
		arr[0] = new int[3];
		arr[1] = new int[4];
		arr[2] = new int[1];
//		arr[3] = new int[6];
//		arr[3] = new int[6] {1,2,3,4,5,6}; Error
		//초기화를 하려면 열의 갯수는 설정하지 않는다.
//		arr[3] = {1,2,3,4,5,6};//생략도 되지 않는다?아마도
		arr[3] = new int[] {1,2,3,4,5,6};
		
		//4.값 할당) 
		arr[0][2]=10;
		arr[1][3]=20;
		arr[2][0]=30;
		
		//5.값 사용)		
		System.out.println(arr[0][0]+" / "+arr[0][1]+" / "+arr[0][2]);
		
		//<일괄처리=>모든방의 값을 한번에 출력)
		//모든 방의 값 출력 : 일괄처리
		for(int i=0; i<arr.length; i++) {//행
			for(int j=0; j<arr[i].length; j++) {//열
				System.out.printf("arr[%d][%d]=%-5d", i,j,arr[i][j]);
			}//end for
			System.out.println();
		}//end for
		
	}//VariableArray
	
	
	/**
	 * 가변 배열의 기본형 형식사용
	 */
	public void priType() {
		System.out.println("--------------------------------------");
		//문법) 데이터형[][] 배열명 = {{값,},{,,,},{,,,,},{,,,}};
		//행구분 괄호로 묶여지는 값의 갯수를 다르게 설정.
		String[][] arr = {{"딸기"},{"포도","참외","수박","복숭아"},
							{"사과","배","감"},{"귤"}};
		String[] title= {"봄","여름","가을","겨울"};
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(title[i]+" : ");
			for(int j=0; j<arr[i].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}//end for
			System.out.println();
		}//end for
		
		
		
	}//priType
	
	
	public static void main(String[] args) {
//		new VariableArray();
		new VariableArray().priType();
		
		
		
		
	}//main
}//class
