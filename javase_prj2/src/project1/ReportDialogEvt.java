package project1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JTextArea;

public class ReportDialogEvt extends WindowAdapter {
	private ReportDialogView rdv;
	private String[] result;
	
	public ReportDialogEvt(ReportDialogView rdv) {
		this.rdv = rdv;
		result = null;
		
	}//ReportDialogEvt
	
	public String getMaxKVP(Map<String, Integer> map) {//매개변수로 입력된 map에서
		Set<String> keySet = map.keySet();//모든 key를 set으로 받아내서
		Iterator<String> ita = keySet.iterator();//iterator에 넣는다.
		int maxValue = 0;
		String maxKey = "";
		while (ita.hasNext()) {//모든 key값에 대해서
			String key = ita.next();
			if (map.get(key) > maxValue) {//이전 key값의 value보다 해당 key값의 value가 더 크다면
				maxValue = map.get(key);//최대값으로 교체
				maxKey = key;//키도 저장
			}
		}
		String rtnValue = maxKey+" : "+maxValue+"회";
		return rtnValue;
	}//getMaxKVP
	
	//문제푸는 메소드 
	public String setReport1(MainControlVO MCVO) {
		return
	}
	public String setReport2(MainControlVO MCVO) {
		return
	}
	public String setReport3(MainControlVO MCVO) {
		return
	}
	public String setReport4(MainControlVO MCVO) {
		return
	}
	public String setReport5(MainControlVO MCVO) {
		return
	}
	public String setReport6(MainControlVO MCVO, int start, int end) {
		return
	}

	public String[] getResult() {
		return result;
	}

	public void setResult(String[] result) {
		this.result = result;
	}

	public ReportDialogView getRdv() {
		return rdv;
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		rdv.dispose();
	}//windowClosing
	
	
}//class
