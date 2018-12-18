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
 * ���� ���� �ý��� Process<br>
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
			String data = JOptionPane.showInputDialog(gms, "������ �Է�\n\n��) �̸�, �ڹ� ����, ����Ŭ ����");
			System.out.println(data);
			String[] splitData = data.split(",");
			
			for (int i = 0; i < splitData.length; i++) {
				splitData[i] = splitData[i].trim();
			} // end for
			
			if (splitData.length > 3) {
				JOptionPane.showMessageDialog(gms, "�����Ͱ� �ʹ� �����ϴ�.", "������ �ʰ�", JOptionPane.ERROR_MESSAGE);
				return;
			} // end if
			
			if (splitData[0].length() < 2) {
				JOptionPane.showMessageDialog(gms, "�̸��� ����� �Է����ּ���.", "�̸� �Է�", JOptionPane.ERROR_MESSAGE);
				return;
			} // end if
			
			if (Integer.parseInt(splitData[1]) > 100 || Integer.parseInt(splitData[1]) < 0) {
				JOptionPane.showMessageDialog(gms, "���� �Է� ������ ������ϴ�.", "���� �Է�", JOptionPane.ERROR_MESSAGE);
				return;
			} // end if
			
			if (Integer.parseInt(splitData[2]) > 100 || Integer.parseInt(splitData[2]) < 0) {
				JOptionPane.showMessageDialog(gms, "���� �Է� ������ ������ϴ�.", "���� �Է�", JOptionPane.ERROR_MESSAGE);
				return;
			} // end if
			
			gmvo.add(new GradeManagementVO(splitData[0], 
					Integer.parseInt(splitData[1]), 
					Integer.parseInt(splitData[2])));
		} catch (NullPointerException npe) {
			return;
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			JOptionPane.showMessageDialog(gms, "�����͸� �ٽ� �Է����ּ���.", "������ ����", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(gms, "������ �Է����ּ���.", "���� �Է�", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) { 
			JOptionPane.showMessageDialog(gms, "�� �� ���� ����!!!", "Error", JOptionPane.ERROR_MESSAGE);
		} // end catch
	} // inputData
	
	private void outputData() {
		if (gmvo.size() == 0) {
			JOptionPane.showMessageDialog(null, "�����Ͱ� �����ϴ�.");
		} else {
			// 1. JTextArea ���� (�÷� ��, �� ���� ����)
			JTextArea jta = new JTextArea(10, 48);
			jta.setEditable(false);
			jta.append("��ȣ\t�̸�\t�ڹ�\t����Ŭ\t����\t���\n");
			
			// MessageDialog �ø���
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
			
			// ��ü ����, ��� ���ϱ�
			for (int i = 0; i < gmvo.size(); i++) {
				sumScore = sumScore + gmvo.get(i).getSumScore();
				avgScore = avgScore + gmvo.get(i).getAvgScore();
			} // end for
			
			avgScore = avgScore / gmvo.size();
			
			jta.append("\t\t\t\t���� : " + sumScore + "\t��� : " + avgScore);
			
			// 2. JScrollPane
			JScrollPane jsp = new JScrollPane(jta);
			
			// 3. MessageDialog�� �ι�° �Ű� ������Ʈ�� �Ҵ�
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
