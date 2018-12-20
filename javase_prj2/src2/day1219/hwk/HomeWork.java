/*
 * ���α׷��� ����Ǹ� 

"���丮�� �Է� : " �޼����� ��µǰ� 
����ڰ� ���丮 "��) c:/dev" �� �Է����� ��
���丮���  �ش� ���丮�� ���� ������
 JOptionPane.showMessageDioalog�� ��� �ϴ� ���α׷� �ۼ�

��� 
�̸�           ����   ũ��        ���������� �����ѳ�¥
apis           ����    
test.java     ����   164byte    yyyy-MM-dd a hh:mm

���丮�� �ƴ϶�� "������ ������� �ʽ��ϴ�." console���
 */
package day1219.hwk;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HomeWork {
	private JTextArea jta;
	private JScrollPane jsp;
	private File file;
	
	public void directoryInfo() {
		Date d;
		System.out.println("���丮���� �Է� : ");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder viewData=new StringBuilder();
		viewData
			.append("-----------------------------------------")
			.append("-----------------------------------------\n")
			.append("�̸�\t\t\t����\tũ��\t���������� ������ ��¥\n")
			.append("-----------------------------------------")
			.append("-----------------------------------------\n");
		
		try {
			String str=br.readLine(); //str=���� ���丮��.
			file=new File(str);
			boolean flag=file.isDirectory();
			
			if(flag) {//���丮�̸�
				
				File[] filelist=file.listFiles();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd a HH:mm");
				for(int i=1;i<filelist.length;i++) {
					d = new Date(filelist[i].lastModified());
					if(filelist[i].isDirectory()) {
						viewData.append(filelist[i].getName()).append("\t")
						.append("\t").append("����").append("\t")
						.append("").append("\t")
						.append(sdf.format(d)).append("\n");
					}else {
						viewData.append(filelist[i].getName()).append("\t")
						.append("\t").append("����").append("\t")
						.append(filelist[i].length()+"byte").append("\t")
						.append(sdf.format(d)).append("\n");
					}
					
				}//end for
				
				
				jta=new JTextArea(20,50);
				jta.append(viewData.toString());//ȭ���� ������ �����͸� JTA�� �ٿ��ش�.
				jsp=new JScrollPane(jta);
				JOptionPane.showMessageDialog(null, jsp);
				
			}else {
				System.out.println("������ ������� �ʽ��ϴ�.");
			}//end else
					
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}

	public static void main(String[] args) {
		new HomeWork().directoryInfo();
	}//main

}//class
