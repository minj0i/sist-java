package day1217.hwk;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Work1217 {

   private String selectMenu;

   private JList<String> list;
   private DefaultListModel dlm;

   public Work1217() {
      list = new JList<String>();
      dlm = new DefaultListModel();
      inputCount();
   }// Work1217

   public void inputCount() {
      // 1. 생성시 InputDialog를 통해 메뉴 선정
            selectMenu = JOptionPane.showInputDialog(null, "1.입력               2.출력                  3.종료", "메뉴선택",
                  JOptionPane.DEFAULT_OPTION);

            // 2. 입력된 메뉴의 유효성 검증
            if (selectMenu != null && !selectMenu.isEmpty()) { // 입력값이 null이 아니며 비어있는 값이 아닐 경우 업무 처리

               if (selectMenu.equals("1")) { // 1번 선택
                  // 이름, 점수 입력
                  String inputData = JOptionPane.showInputDialog(null, "예) 이름, 자바점수, 오라클점수", "데이터입력",
                        JOptionPane.DEFAULT_OPTION);

                  if (inputData == null || inputData.replaceAll(" ", "").split(",").length != 3) {
                     JOptionPane.showMessageDialog(null, "다시한번 입력하세요.", "값 입력 오류", JOptionPane.ERROR_MESSAGE);
                     inputCount();
                  } else {
                     String[] resultData = inputData.replaceAll(" ","").split(",");
                     int total = Integer.parseInt(resultData[1])+Integer.parseInt(resultData[2]);
                     int avg = total/2;
                     String saveData = resultData[0]+"\t"+resultData[1]+"\t"+resultData[2]+
                           "\t"+String.valueOf(total)+
                           "\t"+String.valueOf(avg);
                     dlm.addElement(saveData);
                     System.out.println("입력된 값 : "+dlm.size());
                     inputCount();
                  } // end else

               } else if (selectMenu.equals("2")) { // 2번 선택
                  if (dlm.size() == 0) {
                     JOptionPane.showMessageDialog(null, "저장된 값이 없습니다.", "값 로딩 오류", JOptionPane.ERROR_MESSAGE);
                     inputCount();
                  } else {
                     JTextArea jta = new JTextArea(10, 60);
                     jta.setEditable(false);
                     jta.append("번호\t이름\t자바\t오라클\t총점\t평균\n");
                     for(int i=0; i < dlm.size(); i++) {
                        jta.append((i+1)+"\t"+dlm.get(i)+"\n");
                     }//end for
                     
                     JScrollPane jsp = new JScrollPane(jta);
                     JOptionPane.showMessageDialog(null, jsp, "결과", JOptionPane.DEFAULT_OPTION);
                     inputCount();
                  }//end else

               } else if (selectMenu.equals("3")) { // 3번 선택
                  return;
               } else {
                  JOptionPane.showMessageDialog(null, "메뉴를 선택하지 않았거나 값이 유효하지 않음.", "메뉴선택", JOptionPane.ERROR_MESSAGE);
                  inputCount();
               }
            } else {
               JOptionPane.showMessageDialog(null, "메뉴를 선택하지 않았거나 값이 유효하지 않음.", "메뉴선택", JOptionPane.ERROR_MESSAGE);
               inputCount();
            } // end else
   }// inputCount

   public static void main(String[] args) {
      new Work1217();
   }

}