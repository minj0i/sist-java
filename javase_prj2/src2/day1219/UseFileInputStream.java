package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HDD에 존재하는 File과 연결하여 그 내용을 읽어들일때 사용하는
 * FileInputStream
 * @author owner
 */
public class UseFileInputStream {
	public UseFileInputStream() {
		File file = new File("c:/dev/temp/java_read.txt");
		if(file.exists()) {
			
			try {
				//스트림을 생성하여 JVM에서 HDD의 파일과 연결
				//아래주석처리한 부분은 실행하면 한글은 깨짐
//				FileInputStream fis = new FileInputStream(file);
//				int temp=0;
//
//					while((temp=fis.read())!=-1) {//읽어들인 내용이 존재한다면
//						System.out.print((char)temp);
//					}//end while
//				//스트림 사용을 완료 했으면 스트림을 끊어서 메모리누수를 막는다.
//					fis.close();
				
				////////////12-20-2018 코드 추가 ////////////////
				//8bit stream과 16bit stream 연결 : 한글이 깨지는 문제해결.
				FileInputStream fis = new FileInputStream(file);//파일과 연결
				InputStreamReader isr = new InputStreamReader(fis);//8bit+16bit연결
				BufferedReader br = new BufferedReader(isr);//Buffer가 들어가면 속도 개선
				
				String temp = "";
				//줄단위(\n 전까지) 읽어서 읽어들인 내용이 있다면 출력
				while((temp=br.readLine())!=null) {
					System.out.println(temp);
				}//end while
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}else {
			System.out.println("경로나 파일명을 확인하세요");
		}//end else
		
	}//UseFileInputStream
	public static void main(String[] args) {
		new UseFileInputStream();
	}//main

}//class
