package day1219;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileŬ���� - ������ ���� ��� - ���丮 ���� - ���� ����
 * 
 * @author owner
 */
public class UseFiles {

	public UseFiles() {
		String path = "c:/dev/temp/java_read.txt";
		// 1.����
		File file = new File(path);
		System.out.println(file);
		if (file.exists()) { // ������ ������ ��
			System.out.println("���� ���:" + file.getAbsolutePath());
			try {
				System.out.println("�Թ� ���:" + file.getCanonicalPath());
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}//end catch
			System.out.println("���: "+file.getPath());
			System.out.println("������: "+file.getParent());//c:/dev/temp
			System.out.println("���ϸ�: "+file.getName());//java_read.txt
			
			System.out.println(file.isFile()?"����":"���丮");
			System.out.println(file.isDirectory()?"���丮":"����");
			
			System.out.println("���ϱ��� : "+file.length()+"byte");
			System.out.println("����"+(file.canExecute()?"����":"�Ұ���"));
			System.out.println("�б�"+(file.canRead()?"����":"�Ұ���"));
			System.out.println("����"+(file.canWrite()?"����":"�Ұ���"));
			System.out.println(file.isHidden()?"����":"�ȼ���");
			System.out.println("������������: "+file.lastModified());
			//lastModified�� long������ ������ ������
			Date d = new Date(file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
			System.out.println("������������: "+ sdf.format(d));
		} else {
			System.out.println("��θ� Ȯ�����ּ���");
		}//end else
	}// UseFiles

	public static void main(String[] args) {
		new UseFiles();
	}// main

}// class
