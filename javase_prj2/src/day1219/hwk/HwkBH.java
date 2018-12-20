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
    * fileDel List�� .java ������ �־��ش�.
    * @param path ���� ���
    * @return .java ������ ���� �ȿ� ������ true, ������ false�� ��ȯ
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
    * fileDel ���� �׸��� �����.
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
         path = JOptionPane.showInputDialog("��θ� �Է����ּ���.");
         flag = hw2.checkJava(path);//.java ������ �ִ��� Ȯ��
         if(flag) {//.java ������ �ִٸ�
            confirm = JOptionPane.showConfirmDialog(null, "�ڹ������� "+hw2.fileDel.size()+"�� �����մϴ�. ���� �����Ͻðڽ��ϱ�?");
            
            if (confirm == JOptionPane.OK_OPTION) {
               hw2.deleteJava();
               JOptionPane.showMessageDialog(null, "���� ����");
            }else {
               JOptionPane.showMessageDialog(null, "����ϼ̽��ϴ�.");
            }
         }else {//.java ������ ���ٸ�
            JOptionPane.showMessageDialog(null, "�ڹ������� �����ϴ�.");
         }
      } catch (NullPointerException e) {
         JOptionPane.showMessageDialog(null, "���� ����Դϴ�.");
      }
      

   }
}

