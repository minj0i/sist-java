package day1219;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File클래스 - 파일의 정보 얻기 - 디렉토리 생성 - 파일 삭제
 * 
 * @author owner
 */
public class UseFiles {

	public UseFiles() {
		String path = "c:/dev/temp/java_read.txt";
		// 1.생성
		File file = new File(path);
		System.out.println(file);
		if (file.exists()) { // 파일이 존재할 때
			System.out.println("절대 경로:" + file.getAbsolutePath());
			try {
				System.out.println("규범 경로:" + file.getCanonicalPath());
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}//end catch
			System.out.println("경로: "+file.getPath());
			System.out.println("폴더명: "+file.getParent());//c:/dev/temp
			System.out.println("파일명: "+file.getName());//java_read.txt
			
			System.out.println(file.isFile()?"파일":"디렉토리");
			System.out.println(file.isDirectory()?"디렉토리":"파일");
			
			System.out.println("파일길이 : "+file.length()+"byte");
			System.out.println("실행"+(file.canExecute()?"가능":"불가능"));
			System.out.println("읽기"+(file.canRead()?"가능":"불가능"));
			System.out.println("쓰기"+(file.canWrite()?"가능":"불가능"));
			System.out.println(file.isHidden()?"숨김":"안숨김");
			System.out.println("마지막수정일: "+file.lastModified());
			//lastModified는 long형으로 나오기 때문에
			Date d = new Date(file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
			System.out.println("마지막수정일: "+ sdf.format(d));
		} else {
			System.out.println("경로를 확인해주세요");
		}//end else
	}// UseFiles

	public static void main(String[] args) {
		new UseFiles();
	}// main

}// class
