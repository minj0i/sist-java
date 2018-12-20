package day1219.hwk;

import java.io.File;

import javax.swing.JOptionPane;

public class HwkJC {

   public String inputPath() throws NullPointerException {
      String path = JOptionPane.showInputDialog("경로를 입력하시오");
      return path;
   }

   public int haveExtension(String path) throws NullPointerException {
      File file = new File(path);
      File[] files = file.listFiles();
      String fileName = "";
      int javaFileNum = 0;

      for (int i = 0; i < files.length; i++) {
         fileName = files[i].getName();
         if (fileName.contains(".java")) {
            javaFileNum++;
         }
      }
      return javaFileNum;
   }

   public void deleteJavaFiles(int javaFileNum, String path) throws NullPointerException {
      File file = new File(path);
      File[] files = file.listFiles();
      int chooseDig = -1;
      String fileName = "";
      if (javaFileNum > 0) {
         chooseDig = JOptionPane.showConfirmDialog(null, "java 파일이 " + javaFileNum + "개 존재합니다. 삭제하시겠습니까?");
         switch (chooseDig) {
         case JOptionPane.OK_OPTION:
            for (int i = 0; i < files.length; i++) {
               fileName = files[i].getName();
               if (fileName.contains(".java")) {
                  files[i].delete();
               }
            }
            break;
         default:
            break;
         }
      }else {
         JOptionPane.showMessageDialog(null, "자바 파일이 없습니다.");
      }
   }

   public static void main(String[] args) {
      HwkJC jd = new HwkJC();
      String path;
      int javaFileNum;
      //혹시 없는 경로가 나올 수도 있으니까
      try {
         path = jd.inputPath();
         javaFileNum = jd.haveExtension(path);

         jd.deleteJavaFiles(javaFileNum, path);
      } catch (NullPointerException e) {
         JOptionPane.showMessageDialog(null, "없는 경로 입니다.");
      }

   }

}