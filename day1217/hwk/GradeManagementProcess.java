package day1217;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 성적 관리 시스템 Process<br>
 * @author owner
 */
public class GradeManagementProcess implements ActionListener, KeyListener {
	private GradeManagementView gms;
	private List<GradeManagementVO> gmvo = new ArrayList<GradeManagementVO>();
	
	public GradeManagementProcess(GradeManagementView gms) {
		this.gms = gms;
	} // GradeManagementProcess

	@Override
	public void actionPerformed(ActionEvent ae) {
		boolean[] flag = {
				gms.getJtfInput().getText().equals("1"), 
				gms.getJtfInput().getText().equals("2"), 
				gms.getJtfInput().getText().equals("3")
		};
		
		if (ae.getSource() == gms.getBtnInput()) {
			if (flag[0]) {
				inputData();
			} else if (flag[1]) {
				outputData();
			} else if (flag[2]) {
				gms.dispose();
			} // end else
		} // end if
		
		gms.getJtfInput().setText("");
		gms.getJtfInput().requestFocus();
	} // actionPerformed
	
	private void inputData() {
		try {
			String data = JOptionPane.showInputDialog(gms, "데이터 입력\n\n예) 이름, 자바 점수, 오라클 점수");
			System.out.println(data);
			String[] splitData = data.split(",");
			
			for (int i = 0; i < splitData.length; i++) {
				splitData[i] = splitData[i].trim();
			} // end for
			
			if (splitData.length > 3) {
				JOptionPane.showMessageDialog(gms, "데이터가 너무 많습니다.", "데이터 초과", JOptionPane.ERROR_MESSAGE);
				return;
			} // end if
			
			if (splitData[0].length() < 2) {
				JOptionPane.showMessageDialog(gms, "이름을 제대로 입력해주세요.", "이름 입력", JOptionPane.ERROR_MESSAGE);
				return;
			} // end if
			
			if (Integer.parseInt(splitData[1]) > 100 || Integer.parseInt(splitData[1]) < 0) {
				JOptionPane.showMessageDialog(gms, "점수 입력 범위를 벗어났습니다.", "점수 입력", JOptionPane.ERROR_MESSAGE);
				return;
			} // end if
			
			if (Integer.parseInt(splitData[2]) > 100 || Integer.parseInt(splitData[2]) < 0) {
				JOptionPane.showMessageDialog(gms, "점수 입력 범위를 벗어났습니다.", "점수 입력", JOptionPane.ERROR_MESSAGE);
				return;
			} // end if
			
			gmvo.add(new GradeManagementVO(splitData[0], 
					Integer.parseInt(splitData[1]), 
					Integer.parseInt(splitData[2])));
		} catch (NullPointerException npe) {
			return;
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			JOptionPane.showMessageDialog(gms, "데이터를 다시 입력해주세요.", "데이터 부족", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(gms, "점수를 입력해주세요.", "숫자 입력", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) { 
			JOptionPane.showMessageDialog(gms, "알 수 없는 에러!!!", "Error", JOptionPane.ERROR_MESSAGE);
		} // end catch
	} // inputData
	
	private void outputData() {
		if (gmvo.size() == 0) {
			JOptionPane.showMessageDialog(null, "데이터가 없습니다.");
		} else {
			// 1. JTextArea 생성 (컬럼 수, 행 수를 설정)
			JTextArea jta = new JTextArea(10, 48);
			jta.setEditable(false);
			jta.append("번호\t이름\t자바\t오라클\t총점\t평균\n");
			
			// MessageDialog 올리기
			for (int i = 0; i < gmvo.size(); i++) {
				gmvo.get(i).setSumScore(gmvo.get(i).getJavaScore() + gmvo.get(i).getOracleScore());
				gmvo.get(i).setAvgScore((double)(gmvo.get(i).getJavaScore() + gmvo.get(i).getOracleScore()) / 2);
				
				jta.append((i + 1) + "\t" + gmvo.get(i).getName() + "\t" + gmvo.get(i).getJavaScore() + 
						"\t" + gmvo.get(i).getOracleScore() + "\t" + gmvo.get(i).getSumScore() + 
						"\t" + gmvo.get(i).getAvgScore() + "\n");
			} // end for
			
			jta.append("--------------------------------------------------------------------------------------------------------------------\n");
			
			int sumScore = 0;
			double avgScore = 0;
			
			// 전체 총점, 평균 구하기
			for (int i = 0; i < gmvo.size(); i++) {
				sumScore = sumScore + gmvo.get(i).getSumScore();
				avgScore = avgScore + gmvo.get(i).getAvgScore();
			} // end for
			
			avgScore = avgScore / gmvo.size();
			
			jta.append("\t\t\t\t총점 : " + sumScore + "\t평균 : " + avgScore);
			
			// 2. JScrollPane
			JScrollPane jsp = new JScrollPane(jta);
			
			// 3. MessageDialog의 두번째 매개 컴포넌트를 할당
			JOptionPane.showMessageDialog(null, jsp);
		} // end else
	} // outputData

	@Override
	public void keyTyped(KeyEvent ke) {
		
	} // keyTyped

	@Override
	public void keyPressed(KeyEvent ke) {
		
	} // keyPressed

	@Override
	public void keyReleased(KeyEvent ke) {
		int inputCode = ke.getKeyCode();
		
		System.out.println("inputCode : " + inputCode);
		switch (inputCode) {
		case KeyEvent.VK_1: 
			inputData();	
			break;
		case KeyEvent.VK_2: 
			outputData();
			break;
		case KeyEvent.VK_3:
			gms.dispose();
		} // end switch
		
		gms.getJtfInput().setText("");
		gms.getJtfInput().requestFocus();
	} // keyReleased
	
} // class
