package day1217.hwk;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class DataProcess extends JFrame {
	private String inputMenuNum;
	private String inputData;
	private List<stdVO> list;
	private JTextArea jta;

	public DataProcess() {
		list = new ArrayList<stdVO>();
		inputMenuNum = new String();
		inputMenuNum = "";
		inputData = new String();
		jta = new JTextArea(10, 60);
		jta.setEditable(false);
	}

	public String selectMenu() {
		inputMenuNum = JOptionPane.showInputDialog("�޴�����\n1. �Է� 2. ��� 3. ����");
		switch (inputMenuNum) {
		case "1":
			inputMenu();
			break;
		case "2":
			printMenu();
			break;
		case "3":
			JOptionPane.showMessageDialog(null, "�Է� ���α׷��� �����մϴ�.");
			break;
		default:
			JOptionPane.showMessageDialog(null, "�޴� ���� �Է��Դϴ�.\n�ٽ� �Է��ϼ���");
			break;
		}

		return inputMenuNum;
	}

	public void inputMenu() {
		inputData = JOptionPane.showInputDialog("�������Է�\n��) �̸�, �ڹ�����, ����Ŭ����");
		stdVO svo = new stdVO();
		String[] tempData = inputData.split(",");
		int tempListNum = 0;

		if (tempData.length != 3) {
			JOptionPane.showMessageDialog(this, "�Էµ������� ���´�\n�̸�,�ڹ�����,����Ŭ���������մϴ�.", "�Է¿���", JOptionPane.ERROR_MESSAGE);
			return;
		}

		tempListNum = list.size() + 1;
		svo.setNum(tempListNum);
		svo.setName(tempData[0]);
		svo.setJavaScore(Integer.parseInt(tempData[1]));
		svo.setOracleScore(Integer.parseInt(tempData[2]));
		svo.setSum(svo.getJavaScore() + svo.getOracleScore());
		svo.setAvr((double) svo.getSum() / 2);
		list.add(svo);

	}

	public void printMenu() {
		if (list.size() != 0) {
			stdVO svo = new stdVO();
			int tempAllSum = 0;
			jta.setText("");
			jta.append("��ȣ\t");
			jta.append("�̸�\t");
			jta.append("�ڹ�����\t");
			jta.append("����Ŭ����\t");
			jta.append("����\t");
			jta.append("���\n");
			for (int i = 0; i < list.size(); i++) {
				svo = list.get(i);
				jta.append(String.valueOf(svo.getNum()) + "\t");
				jta.append(svo.getName() + "\t");
				jta.append(String.valueOf(svo.getJavaScore()) + "\t");
				jta.append(String.valueOf(svo.getOracleScore()) + "\t");
				jta.append(String.valueOf(svo.getSum()) + "\t");
				jta.append(String.valueOf(svo.getAvr()) + "\n");
				tempAllSum += svo.getSum();
			}
			jta.append("------------------------------------------------------------------------------\n");
			jta.append("��ü���� : ");
			jta.append(String.valueOf(tempAllSum) + "\t");
			jta.append("��ü��� : ");
			jta.append(String.valueOf((double) tempAllSum / list.size()) + "\t");

			JScrollPane jsp = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null, jsp);//�θ�â��Dialog��null
		} else {
			JOptionPane.showMessageDialog(null, "�����Ͱ� �����ϴ�.");
		}

	}

	public static void main(String[] args) {
		DataProcess dp = new DataProcess();

		while (!dp.inputMenuNum.equals("3")) {
			dp.inputMenuNum = dp.selectMenu();

		}

	}

}
