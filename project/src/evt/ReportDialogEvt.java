package evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

import view.ReportDialogView;;

/**
 * 
 * @author 다같이
 */
public class ReportDialogEvt extends WindowAdapter implements ActionListener {
   private ReportDialogView rdv;

   /**
    * 생성자에서 호출한 각 문제별 메서드의 결과값을
    * MainControl의 TempResult로 세팅 - 이재찬
    * @param rdv
 	*/
   public ReportDialogEvt(ReportDialogView rdv) {
      this.rdv = rdv;
      String[] result = new String[6];
      FileRead fr = rdv.getMce().getFr(); // 각 문제별 메서드에 정제된 데이터를 메개변수로 뿌려줌
      FileRead SelectedFr = rdv.getMce().getSelectedFr(); // 6번 문제 메서드에 필요한 데이터를 메개변수로 사용

      // 문제 결과 임시 저장
      result[0] = setReport1(fr);
      result[1] = setReport2(fr);
      result[2] = setReport3(fr);
      result[3] = setReport4(fr);
      result[4] = setReport5(fr);
      result[5] = setReport6(SelectedFr);

      // 결과창에 각 문제별 결과를 ReportDialogView의 JTextArea에 출력
      rdv.getReport1().setText(result[0]);
      rdv.getReport2().setText(result[1]);
      rdv.getReport3().setText(result[2]);
      rdv.getReport4().setText(result[3]);
      rdv.getReport5().setText(result[4]);
      rdv.getReport6().setText(result[5]);

      // 최종결과 setting
      rdv.getMce().setTempResult(result);

   }// ReportDialogEvt

   /**
    * 이봉현 구현 메서드 
    * @param map
    * @return
    */
   public String getMaxKVP(Map<String, Integer> map) {// 매개변수로 입력된 map에서
      Set<String> keySet = map.keySet();// 모든 key를 set으로 받아내서
      int maxValue = 0;
      String maxKey = "";
      for (String key : keySet) {
         if (map.get(key) > maxValue) {// 이전 key값의 value보다 해당 key값의 value가 더 크다면
            maxValue = map.get(key);// 최대값으로 교체
            maxKey = key;// 키도 저장
         }
      }
      String rtnValue = maxKey + " : " + maxValue + "회";
      return rtnValue;
   }// getMaxKVP

   /**
    * 이봉현 구현 메서드 
    * @param map
    * @return
    */
   public int getSumValue(Map<String, Integer> map) {// 매개변수로 입력된 map에서
      int sumValue = 0;
      Set<String> keySet = map.keySet();// 모든 key를 set으로 받아내서
      for (String key : keySet) {
         sumValue += map.get(key);// 값을 더해준다.
      }
      return sumValue;
      
   }

   
   /**
    * 1번문제 - 박은영
    * @param fr
 	* @return
 	*/
   public String setReport1(FileRead fr) {
      Map<String, Integer> map = fr.getMcvo().getUrlMap();
      String value = getMaxKVP(map);
      return value;
      
   }

   /**
    * 2번문제 - 백인재
    * @param fr
 	* @return
 	*/
   public String setReport2(FileRead fr) {

	   Map<String,Integer> map=fr.getMcvo().getBrowserMap(); 
		
		int valuesum=getSumValue(map);
		String value = "";
		String pValue = "";

		for (String key : map.keySet()) {
			value = key + " " + map.get(key) + "번 실행("
					+ Math.round(((double) (map.get(key)) / valuesum) * 1000) / 10.0 + "%)\n";
			System.out.println(value);
			pValue += value;
		}

		return pValue;
   }

   /**
    * 3번문제 - 백인재
    * @param fr
 	* @return
 	*/
   public String setReport3(FileRead fr) {

      Map<String, Integer> map = fr.getMcvo().getCodeMap();
      int successNum = (int) map.get("200");
      int failNum = (int) map.get("404");

      String value = "성공횟수 : " + successNum + "\n실패횟수 : " + failNum;

      return value;
   }

   /**
    * 4번문제 - 박은영
    * @param fr
 	* @return
 	*/
   public String setReport4(FileRead fr) {
      Map<String, Integer> mapTime=fr.getMcvo().getTimeMap();
      String timeValue=getMaxKVP(mapTime).substring(0, 2)+"시";//10 : 871회
      
      return timeValue;
   }

   /**
    * 5번문제 - 김민정
    * @param fr
 	* @return
 	*/
   public String setReport5(FileRead fr) {//FileRead의 인스턴스 변수를 받아옴
	   //String, Integer로 된 map에 FileRead의 Code로 구분된 Map을 저장
	   //Map : 키와 값의 쌍, 키는 중복될 수 없으나 값은 중복될 수 있음
      Map<String, Integer> map = fr.getMcvo().getCodeMap(); 

      int cnt = map.get("403");//403을 키로 갖는 값의 수를 cnt에 넣어줌
      double percent = ((cnt / (double) getSumValue(map)) * 100); //위에서 만든 전체값으로 나눠주고
      DecimalFormat df = new DecimalFormat("##.##"); //길어지기 때문에 숫자 형태 정리

      String report5 = "403발생횟수: " + cnt + "회\n비율: " + df.format(percent) + "%"; 

      return report5;
   }// setReport5

   /**
    * 6번문제 - 박은영
    * @param SelectedFr
 	* @return
 	*/
   public String setReport6(FileRead SelectedFr) {
      Map<String, Integer> map = SelectedFr.getMcvo().getUrlMap();
      String value = getMaxKVP(map);
      return value; 
   }

   @Override
   public void windowClosing(WindowEvent we) {
      rdv.dispose();
   }// windowClosing

   @Override
   public void actionPerformed(ActionEvent ae) {
      rdv.dispose();
   }

}// class