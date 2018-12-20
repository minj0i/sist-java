package day1219;

import java.io.File;

/**
 * 폴더 생성, 파일 삭제
 * @author owner
 */
public class UseFile2 {

	public void createDirectory() {
		File file=new File("c:/minjeong/kim");
		if(file.mkdirs()) {
			System.out.println("폴더생성성공");
		}else {
			System.out.println("폴더생성실패 - 같은이름의 폴더 존재");//이미 만들어놨으면 같은 이름의 폴더가 존재하기 때문에 실패
		}
		
	}//createDirectory
	public void removeFile() {
		File file = new File("c:/dev/temp/a.txt");
		boolean flag = file.delete();
		if(flag) {
		System.out.println("파일이 지워졌어요");
		}else {
			System.out.println("파일이 안지워졌어요");
		}//end else
	}//removeFile
	
	
	public static void main(String[] args) {
		UseFile2 uf2= new UseFile2();
		uf2.createDirectory();
		System.out.println("-----------------");
		uf2.removeFile();
	}//main

}//class
