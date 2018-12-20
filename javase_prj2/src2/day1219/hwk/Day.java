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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Day {
	public String showmsg;

	public Day() {
		showmsg = JOptionPane.showInputDialog("���丮�� �Է� :");
		File file = new File(showmsg);
		File[] filelist = file.listFiles();

		if (file.isDirectory()) {
			List<File> list = new ArrayList<File>();

			for (File f : filelist) {
				if (f.getName().endsWith(".java")) {
					list.add(f);
				} // end if
			}

			int selectMenu = JOptionPane.showConfirmDialog(null, "java������" + list.size() + "�� �����մϴ�. �����Ͻðڽ��ϱ�?");

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
			System.out.println("��� Ȯ��");
		}
		
	} // Day1219
	
	
	public static void main(String[] args) {
		new Day();
	}// main

}// class
