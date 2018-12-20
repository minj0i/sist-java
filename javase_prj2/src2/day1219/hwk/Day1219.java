/*
 * JOptionPane.showInputDialog를 사용하여 경로를 입력 받는다.

입력받은 경로에  확장자가 java인 파일이 존재한다면 

 JOptionPane.showConfirmDialog를 사용하여  삭제여부를 묻는다.

 출력 메세지  "java 파일이 x개 존재합니다. 삭제하시겠습니까?"
 "예"를 누르면 해당 파일을 삭제하고 , "아니오"나 "취소"가  눌려지면 
종료한다. 
 */
package day1219.hwk;

import java.io.File;
import javax.swing.JOptionPane;

public class Day1219 {
	public String showmsg;
	
	public Day1219() {
		showmsg = JOptionPane.showInputDialog("디렉토리명 입력 :");
		File file = new File(showmsg);
		File[] filelist = file.listFiles();
		int number = 0;
		
		for (int i = 1; i < filelist.length; i++) {
			File getfile = filelist[i];
			boolean java = getfile.getName().contains(".java");

			if (java) {
				number++;
			} // end if
			break;
		} // end for
		
		for (int i = 1; i < filelist.length; i++) {
			File getfile = filelist[i];
			boolean java = getfile.getName().contains(".java");
			int selectMenu = -1;
			if (java) {
				if(number>0)
					selectMenu = JOptionPane.showConfirmDialog(null, "java파일이" + number + "개 존재합니다. 삭제하시겠습니까?");
					switch (selectMenu) {
					case JOptionPane.OK_OPTION:
						for(int j = 1; j<number; j++) {
						filelist[j].delete();
						}
						break;
					}// end switch
			}//end if
		} // end if

	}// Day1219

	public static void main(String[] args) {
		new Day1219();
	}// main

}// class
