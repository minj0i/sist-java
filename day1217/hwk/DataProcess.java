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
		inputMenuNum = JOptionPane.showInputDialog("메뉴선택\n1. 입력 2. 출력 3. 종료");
		switch (inputMenuNum) {
		case "1":
			inputMenu();
			break;
		case "2":
			printMenu();
			break;
		case "3":
			JOptionPane.showMessageDialog(null, "입력 프로그램을 종료합니다.");
			break;
		default:
			JOptionPane.showMessageDialog(null, "메뉴 외의 입력입니다.\n다시 입력하세요");
			break;
		}

		return inputMenuNum;
	}

	public void inputMenu() {
		inputData = JOptionPane.showInputDialog("데이터입력\n예) 이름, 자바점수, 오라클점수");
		stdVO svo = new stdVO();
		String[] tempData = inputData.split(",");
		int tempListNum = 0;

		if (tempData.length != 3) {
			JOptionPane.showMessageDialog(this, "입력데이터의 형태는\n이름,자바점수,오라클점수여야합니다.", "입력오류", JOptionPane.ERROR_MESSAGE);
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
			jta.append("번호\t");
			jta.append("이름\t");
			jta.append("자바점수\t");
			jta.append("오라클점수\t");
			jta.append("총점\t");
			jta.append("평균\n");
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
			jta.append("전체총점 : ");
			jta.append(String.valueOf(tempAllSum) + "\t");
			jta.append("전체평균 : ");
			jta.append(String.valueOf((double) tempAllSum / list.size()) + "\t");

			JScrollPane jsp = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null, jsp);//부모창이Dialog라서null
		} else {
			JOptionPane.showMessageDialog(null, "데이터가 없습니다.");
		}

	}

	public static void main(String[] args) {
		DataProcess dp = new DataProcess();

		while (!dp.inputMenuNum.equals("3")) {
			dp.inputMenuNum = dp.selectMenu();

		}

	}

}
