package day1220;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HDD�� �����ϴ� File�� �����Ͽ� �� ������ �о���϶� ����ϴ�
 * FileInputStream
 * @author owner
 */
public class UseFileInputStream {
	public UseFileInputStream() throws IOException {
		File file = new File("c:/dev/temp/java_read.txt");
		if(file.exists()) {
			BufferedReader br = null; //br�� �ø��� �ʱ�ȭ
			try {
				//��Ʈ���� �����Ͽ� JVM���� HDD�� ���ϰ� ����
				//�Ʒ��ּ�ó���� �κ��� �����ϸ� �ѱ��� ����
//				FileInputStream fis = new FileInputStream(file);
//				int temp=0;
//
//					while((temp=fis.read())!=-1) {//�о���� ������ �����Ѵٸ�
//						System.out.print((char)temp);
//					}//end while
//				//��Ʈ�� ����� �Ϸ� ������ ��Ʈ���� ��� �޸𸮴����� ���´�.
//					fis.close();
				
				////////////12-20-2018 �ڵ� �߰� ////////////////
				//8bit stream�� 16bit stream ���� : �ѱ��� ������ �����ذ�.
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));//Buffer�� ���� �ӵ� ����
				
				String temp = "";
				//�ٴ���(\n ������) �о �о���� ������ �ִٸ� ���
				while((temp=br.readLine())!=null) {
					System.out.println(temp);//���
				}//end while
				
			}finally{
					br.close(); //�ݵ�� ������ ���� - �޸� ���� ����
				}//end finally
			
		
		}else {
			System.out.println("��γ� ���ϸ��� Ȯ���ϼ���");
		}//end else
		
	}//UseFileInputStream
	public static void main(String[] args) {
		try {
		new UseFileInputStream();
		}catch(IOException ie) {
			
		}
	}//main

}//class
