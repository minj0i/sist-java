package evt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/**
 *
 * @author �̺���
 */
public class FileRead {

   private String tempLog;
   private MainControlVO mcvo;
   private String[] tempArr;
   private Integer maxLine;

   /**
    * file�ּҸ� String���� �޾Ƽ� tempArr�� split�Ͽ� ����
    * 
    * @param fileName
    * @throws IOException
    */
   public FileRead(String filePath) throws IOException {
      mcvo = new MainControlVO();
      File file = new File(filePath);
      if (file.exists()) {
         BufferedReader br = null;
         try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            tempLog = "";
            String temp = "";
            maxLine = 0;
            while ((temp = br.readLine()) != null) {// �ٴ���(\n)�� �о �о���� ������ �ִٸ�
               tempLog += temp;
               maxLine += 1;
            }
            tempLog = tempLog.replace("[", "");
            tempArr = tempLog.split("]");
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         } finally {
            if (br != null) {
               br.close();
            } // �ݵ�� ������ ����
         }
      } else {
         JOptionPane.showMessageDialog(null, "��γ� ���ϸ��� Ȯ���ϼ���.", "���ϸ� ����", JOptionPane.ERROR_MESSAGE);
      }
   }// FileRead

   public FileRead(String filePath, int startLine, int endLine) throws IOException {
      mcvo = new MainControlVO();
      File file = new File(filePath);
      if (file.exists()) {
         BufferedReader br = null;
         try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            tempLog = "";
            String temp = "";
            int count = 0;// �ټ��� ���� ���� ����
            while ((temp = br.readLine()) != null) {// �ٴ���(\n)�� �о �о���� ������ �ִٸ�
               count += 1;
               if (count < startLine) {// �ټ��� �Էµ� ���� �ټ����� �۴ٸ�
                  // �������� �ʰ� ���� ������.
               } else {// �ټ��� �Էµ� ���� �ټ����� ũ�ٸ�
                  tempLog += temp;// �����Ѵ�
               }
               if (count == endLine) {// �ټ��� �Էµ� ������ �ټ��� ���ٸ�

                  break; // while���� ������.
               }

            }
            tempLog = tempLog.replace("[", "");
            tempArr = tempLog.split("]");
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         } finally {
            if (br != null) {
               br.close();
            } // �ݵ�� ������ ����
         }
      } else {
         JOptionPane.showMessageDialog(null, "��γ� ���ϸ��� Ȯ���ϼ���.", "���ϸ� ����", JOptionPane.ERROR_MESSAGE);
      }
   }// FileRead

   /**
    * tempArr�� ����� String�� ���� Code, Url, Brower, Time���� ������ Set�� ����
    */
   public void logToSet() {
      for (int i = 0; i < tempArr.length; i++) {

         int flag = i % 4;
         switch (flag) {
         case 0:
            mcvo.getCodeSet().add(tempArr[i]);
            break;
         case 1:
            if (tempArr[i].contains("key")) {
               mcvo.getUrlSet().add(tempArr[i].substring(tempArr[i].indexOf("key") + 4, tempArr[i].indexOf("&")));
            }
            break;
         case 2:
            mcvo.getBrowserSet().add(tempArr[i]);
            break;
         case 3:
            mcvo.getTimeSet().add(tempArr[i].substring(11, 13));
            break;
         }

      }

   }// logToSet

   /**
    * tempArr�� ����� String�� ���� Code, Url, Brower, Time���� ������ Set�� ����
    */
   public void logToList() {
      for (int i = 0; i < tempArr.length; i++) {

         int flag = i % 4;
         switch (flag) {
         case 0:
            mcvo.getCodeList().add(tempArr[i]);
            break;
         case 1:
            if (tempArr[i].contains("key")) {
               mcvo.getUrlList().add(tempArr[i].substring(tempArr[i].indexOf("key") + 4, tempArr[i].indexOf("&")));

            }
            break;
         case 2:
            mcvo.getBrowserList().add(tempArr[i]);
            break;
         case 3:
            mcvo.getTimeList().add(tempArr[i].substring(11, 13));
            break;
         }

      }

   }// logToList

   /**
    * ����� Set�� component�� key��, List���� key component�� ������ ī��Ʈ�ؼ� Map�� �ִ� method
    */
   public void setMap() {

      for (String key : mcvo.getCodeSet()) {
         int tempCount = 0;
         String tempKey = key;
         while (mcvo.getCodeList().remove(tempKey)) {// List���� key�� �����ϸ� ����� ī��Ʈ +1
            tempCount += 1;
         }
         mcvo.getCodeMap().put(tempKey, tempCount);// Map�� <key,count>�� �Է�
      }
      for (String key : mcvo.getUrlSet()) {
         int tempCount = 0;
         String tempKey = key;
         while (mcvo.getUrlList().remove(tempKey)) {// List���� key�� �����ϸ� ����� ī��Ʈ +1
            tempCount += 1;
         }
         mcvo.getUrlMap().put(tempKey, tempCount);// Map�� <key,count>�� �Է�
      }
      for (String key : mcvo.getBrowserSet()) {
         int tempCount = 0;
         String tempKey = key;
         while (mcvo.getBrowserList().remove(tempKey)) {// List���� key�� �����ϸ� ����� ī��Ʈ +1
            tempCount += 1;
         }
         mcvo.getBrowserMap().put(tempKey, tempCount);// Map�� <key,count>�� �Է�
      }
      for (String key : mcvo.getTimeSet()) {
         int tempCount = 0;
         String tempKey = key;
         while (mcvo.getTimeList().remove(tempKey)) {// List���� key�� �����ϸ� ����� ī��Ʈ +1
            tempCount += 1;
         }
         mcvo.getTimeMap().put(tempKey, tempCount);// Map�� <key,count>�� �Է�
      }
   }

   public Integer getMaxLine() {
      return maxLine;
   }

   public MainControlVO getMcvo() {
      return mcvo;
   }

}