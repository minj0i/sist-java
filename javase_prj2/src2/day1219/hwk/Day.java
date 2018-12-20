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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Day {
	public String showmsg;

	public Day() {
		showmsg = JOptionPane.showInputDialog("디렉토리명 입력 :");
		File file = new File(showmsg);
		File[] filelist = file.listFiles();

		if (file.isDirectory()) {
			List<File> list = new ArrayList<File>();

			for (File f : filelist) {
				if (f.getName().endsWith(".java")) {
					list.add(f);
				} // end if
			}

			int selectMenu = JOptionPane.showConfirmDialog(null, "java파일이" + list.size() + "개 존재합니다. 삭제하시겠습니까?");

			switch (selectMenu) {
			case JOptionPane.OK_OPTION:

				for (int j = 1; j < list.size(); j++) {
					list.get(j).delete();
				}
				break;
			case JOptionPane.NO_OPTION:
				return;
			case JOptionPane.CANCEL_OPTION:
				return;
			}// end switch
		} else {
			System.out.println("경로 확인");
		}
		
	} // Day1219
	
	
	public static void main(String[] args) {
		new Day();
	}// main

}// class
