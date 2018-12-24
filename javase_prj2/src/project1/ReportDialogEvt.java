package project1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JTextArea;

import project1.hap.MainControlVO;

public class ReportDialogEvt extends WindowAdapter {
	private ReportDialogView rdv;
	private String[] result;
	
	public ReportDialogEvt(ReportDialogView rdv) {
		this.rdv = rdv;
		result = null;
		
	}//ReportDialogEvt
	
	public String getMaxKVP(Map<String, Integer> map) {//�Ű������� �Էµ� map����
		Set<String> keySet = map.keySet();//��� key�� set���� �޾Ƴ���
		Iterator<String> ita = keySet.iterator();//iterator�� �ִ´�.
		int maxValue = 0;
		String maxKey = "";
		while (ita.hasNext()) {//��� key���� ���ؼ�
			String key = ita.next();
			if (map.get(key) > maxValue) {//���� key���� value���� �ش� key���� value�� �� ũ�ٸ�
				maxValue = map.get(key);//�ִ밪���� ��ü
				maxKey = key;//Ű�� ����
			}
		}
		String rtnValue = maxKey+" : "+maxValue+"ȸ";
		return rtnValue;
	}//getMaxKVP
	
	//����Ǫ�� �޼ҵ� 
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
	/**
	 * ���������� ��û(403)�� �߻��� Ƚ��, ���� ���ϱ�
	 * @param MCVO
	 * @return
	 */
	public String setReport5(MainControlVO MCVO) {
		Map map403 = new MCVO.getCodeMap();
		
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
