/*
 * JOptionPane.showInputDialog�� ����Ͽ� ��θ� �Է� �޴´�.

�Է¹��� ��ο�  Ȯ���ڰ� java�� ������ �����Ѵٸ� 

 JOptionPane.showConfirmDialog�� ����Ͽ�  �������θ� ���´�.

 ��� �޼���  "java ������ x�� �����մϴ�. �����Ͻðڽ��ϱ�?"
 "��"�� ������ �ش� ������ �����ϰ� , "�ƴϿ�"�� "���"��  �������� 
�����Ѵ�. 
 */
package day1219.hwk;

import java.io.File;
import javax.swing.JOptionPane;

public class Day1219 {
	public String showmsg;
	
	public Day1219() {
		showmsg = JOptionPane.showInputDialog("���丮�� �Է� :");
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
					selectMenu = JOptionPane.showConfirmDialog(null, "java������" + number + "�� �����մϴ�. �����Ͻðڽ��ϱ�?");
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
