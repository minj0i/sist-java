package evt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class FileRead {

   private String tempLog;
   private MainControlVO mcvo;
   private String[] tempArr;
   private Integer maxLine;

   /**
    * file주소를 String으로 받아서 tempArr에 split하여 저장
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
            while ((temp = br.readLine()) != null) {// 줄단위(\n)로 읽어서 읽어들인 내용이 있다면
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
            } // 반드시 연결을 종료
         }
      } else {
         JOptionPane.showMessageDialog(null, "경로나 파일명을 확인하세요.", "파일명 오류", JOptionPane.ERROR_MESSAGE);
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
            int count = 0;// 줄수를 세기 위한 변수
            while ((temp = br.readLine()) != null) {// 줄단위(\n)로 읽어서 읽어들인 내용이 있다면
               count += 1;
               if (count < startLine) {// 줄수가 입력된 시작 줄수보다 작다면
                  // 저장하지 않고 값을 버린다.
               } else {// 줄수가 입력된 시작 줄수보다 크다면
                  tempLog += temp;// 저장한다
               }
               if (count == endLine) {// 줄수가 입력된 마지막 줄수와 같다면

                  break; // while문을 나간다.
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
            } // 반드시 연결을 종료
         }
      } else {
         JOptionPane.showMessageDialog(null, "경로나 파일명을 확인하세요.", "파일명 오류", JOptionPane.ERROR_MESSAGE);
      }
   }// FileRead

   /**
    * tempArr에 저장된 String을 각각 Code, Url, Brower, Time으로 나누어 Set에 저장
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
    * tempArr에 저장된 String을 각각 Code, Url, Brower, Time으로 나누어 Set에 저장
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
    * 저장된 Set의 component를 key로, List에서 key component의 갯수를 카운트해서 Map에 넣는 method
    */
   public void setMap() {

      for (String key : mcvo.getCodeSet()) {
         int tempCount = 0;
         String tempKey = key;
         while (mcvo.getCodeList().remove(tempKey)) {// List에서 key가 존재하면 지우고 카운트 +1
            tempCount += 1;
         }
         mcvo.getCodeMap().put(tempKey, tempCount);// Map에 <key,count>를 입력
      }
      for (String key : mcvo.getUrlSet()) {
         int tempCount = 0;
         String tempKey = key;
         while (mcvo.getUrlList().remove(tempKey)) {// List에서 key가 존재하면 지우고 카운트 +1
            tempCount += 1;
         }
         mcvo.getUrlMap().put(tempKey, tempCount);// Map에 <key,count>를 입력
      }
      for (String key : mcvo.getBrowserSet()) {
         int tempCount = 0;
         String tempKey = key;
         while (mcvo.getBrowserList().remove(tempKey)) {// List에서 key가 존재하면 지우고 카운트 +1
            tempCount += 1;
         }
         mcvo.getBrowserMap().put(tempKey, tempCount);// Map에 <key,count>를 입력
      }
      for (String key : mcvo.getTimeSet()) {
         int tempCount = 0;
         String tempKey = key;
         while (mcvo.getTimeList().remove(tempKey)) {// List에서 key가 존재하면 지우고 카운트 +1
            tempCount += 1;
         }
         mcvo.getTimeMap().put(tempKey, tempCount);// Map에 <key,count>를 입력
      }
   }

   public Integer getMaxLine() {
      return maxLine;
   }

   public MainControlVO getMcvo() {
      return mcvo;
   }

}