package kr.co.sist.memo.run;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.co.sist.memo.view.JavaMemo;

/**
 * 메모장 클래스를 실행하는 일.
 * @author owner
 */
public class RunJavaMemo {

	/////////////2018-12-21 코드 추가(OIS)//////////
	public Font readFontInfo() throws IOException, ClassNotFoundException {
//		BufferedReader br= null;

		ObjectInputStream ois = null;
		Font font = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("c:/dev/temp/memo.dat"));
			font = (Font)ois.readObject();
//			br = new BufferedReader(new FileReader("c:/dev/temp/memo.dat"));
//			String readFont= br.readLine();
//			String[] temp = readFont.split(",");
//			font = new Font(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
		}finally {
			if(ois!=null) {ois.close();}//end if
//			if(br!=null) {br.close();}//end if
		}//end finally
		return font;
		}//readFontInfo
	
	/**
	 * 자바클래스를 실행하는 일 : Java Application
	 * @param args
	 */
	public static void main(String[] args) {
		RunJavaMemo rjm = new RunJavaMemo();
		Font font = null;
		try {
				font = rjm.readFontInfo();
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}catch (IOException e) {
			e.printStackTrace();
		}//
		new JavaMemo(font);
	}//main

}//class
