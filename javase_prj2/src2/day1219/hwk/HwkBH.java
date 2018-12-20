package day1219.hwk;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class HwkBH extends JFrame {

   private List<File> fileDel;

   public HwkBH() {
      fileDel = new ArrayList<>();
   }
   
   /**
    * fileDel List에 .java 파일을 넣어준다.
    * @param path 폴더 경로
    * @return .java 파일이 폴더 안에 있으면 true, 없으면 false를 반환
    * @throws NullPointerException
    */
   public boolean checkJava(String path) throws NullPointerException{
      boolean flag = false;
      File file = new File(path);
      File[] fileArr = file.listFiles();
      for (File file2 : fileArr) {
         String tempfile = file2.getName();
         if(tempfile.substring(tempfile.length()-5, tempfile.length()).equals(".java")){
            fileDel.add(file2);
         }
         
         if(!fileDel.isEmpty()){
            flag = true;
         }
      }
      
      return flag;
   }
   
   /**
    * fileDel 안의 항목을 지운다.
    * @throws NullPointerException
    */
   public void deleteJava()  throws NullPointerException{
      for (File file2 : fileDel) {
         file2.delete();
      }
   }
   
   
   public static void main(String[] args) {

	   HwkBH hw2 = new HwkBH();
      String path;
      boolean flag;
      int confirm;
      
      try {
         path = JOptionPane.showInputDialog("경로를 입력해주세요.");
         flag = hw2.checkJava(path);//.java 파일이 있는지 확인
         if(flag) {//.java 파일이 있다면
            confirm = JOptionPane.showConfirmDialog(null, "자바파일이 "+hw2.fileDel.size()+"개 존재합니다. 정말 삭제하시겠습니까?");
            
            if (confirm == JOptionPane.OK_OPTION) {
               hw2.deleteJava();
               JOptionPane.showMessageDialog(null, "삭제 성공");
            }else {
               JOptionPane.showMessageDialog(null, "취소하셨습니다.");
            }
         }else {//.java 파일이 없다면
            JOptionPane.showMessageDialog(null, "자바파일이 없습니다.");
         }
      } catch (NullPointerException e) {
         JOptionPane.showMessageDialog(null, "없는 경로입니다.");
      }
      

   }
}

