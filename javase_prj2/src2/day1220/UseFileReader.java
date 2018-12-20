package day1220;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 16bit stream만 사용하여
 * @author owner
 */
public class UseFileReader {

	public void useFileReader() throws IOException {
		BufferedReader br = null;
		try {
			File file = new File("c:/dev/temp/java_read.txt");//canonical path
//			//1. 근원지 파일에 스트림 연결
//			FileReader fr = new FileReader(file);
//			//2. 줄단위 읽어들이는 기능을 가진 스트림 연결
//			br = new BufferedReader(fr);
			
			br = new BufferedReader(new FileReader(file));
			
			String temp="";
			//한줄씩 읽어들여 읽어들인 내용이 존재한다면
			while((temp=br.readLine())!=null) {
				System.out.println(temp);//출력한다
			}
			
		}finally {
			//연결된 stream을 끊는다. 다 썼다면..
			if(br!=null) {br.close();}//end if
		}//end finally
	}//useFileReader
	
	public static void main(String[] args) {
		UseFileReader ufr = new UseFileReader();
		try {
			ufr.useFileReader();
		} catch (IOException ie) {
			ie.printStackTrace();
		}//end catch
	}//main

}//class
