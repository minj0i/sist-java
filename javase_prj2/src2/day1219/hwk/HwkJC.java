package day1219.hwk;

import java.io.File;

import javax.swing.JOptionPane;

public class HwkJC {

   public String inputPath() throws NullPointerException {
      String path = JOptionPane.showInputDialog("��θ� �Է��Ͻÿ�");
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
         chooseDig = JOptionPane.showConfirmDialog(null, "java ������ " + javaFileNum + "�� �����մϴ�. �����Ͻðڽ��ϱ�?");
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
         JOptionPane.showMessageDialog(null, "�ڹ� ������ �����ϴ�.");
      }
   }

   public static void main(String[] args) {
      HwkJC jd = new HwkJC();
      String path;
      int javaFileNum;
      //Ȥ�� ���� ��ΰ� ���� ���� �����ϱ�
      try {
         path = jd.inputPath();
         javaFileNum = jd.haveExtension(path);

         jd.deleteJavaFiles(javaFileNum, path);
      } catch (NullPointerException e) {
         JOptionPane.showMessageDialog(null, "���� ��� �Դϴ�.");
      }

   }

}