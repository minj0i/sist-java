/*
 * 프로그램이 실행되면 

"디렉토리명 입력 : " 메세지가 출력되고 
사용자가 디렉토리 "예) c:/dev" 를 입력했을 때
디렉토리라면  해당 디렉토리내 파일 정보를
 JOptionPane.showMessageDioalog에 출력 하는 프로그램 작성

출력 
이름           유형   크기        마지막으로 수정한날짜
apis           폴더    
test.java     파일   164byte    yyyy-MM-dd a hh:mm

디렉토리가 아니라면 "파일은 취급하지 않습니다." console출력
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
		System.out.println("디렉토리명을 입력 : ");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder viewData=new StringBuilder();
		viewData
			.append("-----------------------------------------")
			.append("-----------------------------------------\n")
			.append("이름\t\t\t유형\t크기\t마지막으로 수정한 날짜\n")
			.append("-----------------------------------------")
			.append("-----------------------------------------\n");
		
		try {
			String str=br.readLine(); //str=받은 디렉토리명.
			file=new File(str);
			boolean flag=file.isDirectory();
			
			if(flag) {//디렉토리이면
				
				File[] filelist=file.listFiles();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd a HH:mm");
				for(int i=1;i<filelist.length;i++) {
					d = new Date(filelist[i].lastModified());
					if(filelist[i].isDirectory()) {
						viewData.append(filelist[i].getName()).append("\t")
						.append("\t").append("폴더").append("\t")
						.append("").append("\t")
						.append(sdf.format(d)).append("\n");
					}else {
						viewData.append(filelist[i].getName()).append("\t")
						.append("\t").append("파일").append("\t")
						.append(filelist[i].length()+"byte").append("\t")
						.append(sdf.format(d)).append("\n");
					}
					
				}//end for
				
				
				jta=new JTextArea(20,50);
				jta.append(viewData.toString());//화면을 구성한 데이터를 JTA에 붙여준다.
				jsp=new JScrollPane(jta);
				JOptionPane.showMessageDialog(null, jsp);
				
			}else {
				System.out.println("파일은 취급하지 않습니다.");
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
