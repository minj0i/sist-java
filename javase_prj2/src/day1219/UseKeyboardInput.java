package day1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사용자가 입력한 키도브 값을 처리하는 System.in
 * @author owner
 */
public class UseKeyboardInput {
	public UseKeyboardInput() {
	
		System.out.println("아무키나 누르고 엔터");
		
		//8bit stream과 16bit stream연결
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		try {
			//입력 값 중 최초 입력 문자 하나 받기
//			int input= System.in.read(); //블록메소드
//			System.out.println("입력값: "+input);
			
			//입력된 모든 문자열 받기 (단, 한글은 받을 수 없다)
//			int input=0;
//			while(true) {
//				input = System.in.read();
//				System.out.println((char)input);//한글은 안됨
//				if(input == 13) {
//					break;
//				}//end if			
//			}//end while
			
			//16bit stream을 사용하여 입력데이터를 줄단위로 읽어들임(한글도 가능)
			String str = br.readLine();
			
			System.err.println(str);

			//스트림사용이 끝났으면 스트림의 연결을 끊는다.
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//UseKeyboardInput
	
	public static void main(String[] args) {
		new UseKeyboardInput();
	}//main

}//class
