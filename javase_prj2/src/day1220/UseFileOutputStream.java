package day1220;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * JVM���� �߻��� �����Ͱ� ����, byte[]�� ��쿡 File�� �����ϴ� FileOutputStream ���.
 * 
 * @author owner
 */
public class UseFileOutputStream {

	public void useFileOutputStream() throws IOException {
		int i = 65;
		// 1.File class ����
		File file = new File("c:/dev/temp/java_write.txt");

		FileOutputStream fos = null;

		try {
			boolean flag= false;
			if (file.exists()) {
				boolean[] temp = {false, true, true};//switch case ��� �迭���� �־� �� ��
				int select =JOptionPane.showConfirmDialog(null, "����ðڽ��ϱ�?");
					flag=temp[select];
				} // end if
			// 2.FileOutputStream�� ���� -> �Էµ� ��ο� ������ �����ȴ�.
			// ������ ���ٸ� �����ϰ�, ������ �ִٸ� ���� ����.
			if(!flag) {
			fos = new FileOutputStream(file);
			fos.write(i);//���� ��Ʈ���� ���. ���� ���� ���ڰ� ���
			fos.flush();
			System.out.println("���ϱ�� �Ϸ�");
			
			}//end if
		}finally {
			// fos.close(); ��Ʈ���� ����� ������ �ִٸ�, �����ϰ� ������ ����
			if (fos != null) {fos.close();} // end if
		} // end finally
	}// useFileOutputStream

	public static void main(String[] args) {
		UseFileOutputStream ufos = new UseFileOutputStream();
		try {
			ufos.useFileOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// main

}// class
