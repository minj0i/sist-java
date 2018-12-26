package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import evt.MainControlEvt;

/**
 * 18.12.25 1차 작성 완료 - 의도한대로 구동은 잘 됨 예외처리상황을 몇개 추가해야 할 듯 , 파일 길이를 받아와 출력해야함
 * 18.12.26 2차 작성 완료 - 예외처리 완료, 파일길이 출력 완료 
 * @author 이재찬
 */
@SuppressWarnings("serial")
public class InputLineDialog extends JDialog implements ActionListener {
	private MainControlEvt mce; // mce 변수 추가됨 (클래스명세서에 추가 - mce에 입력되는 값 전달 및 frame에 super로 띄우기 위해
	private JTextField jtfStart, jtfEnd;
	private JButton jbtnOk, jbtnCancle; // JButton 추가됨 (클래스명세서에 추가 - 이벤트 입력에 맞는 dialog행동을 위해

	public InputLineDialog(MainControlEvt mce) { // 생성자 dialog에 맞게 변경 .
		super(mce.getMcv(), "라인입력 - Dialog", true);
		this.mce = mce;
		mce.setStartLine(-1);//창을 그냥 끌때 이전값이 입력되기 떄문에 입력창이 켜질때 값을 -1로 초기화
		mce.setEndLine(-1);
		
		JLabel jlblInfo1 = new JLabel("출력할 정보의 라인");
		JLabel jlblInfo2 = new JLabel("범위를 입력해주세요.");
		JLabel jlblFileInfo1 = new JLabel("이 파일의 최대 길이는");
		JLabel jlblFileInfo2 = new JLabel();
		jtfStart = new JTextField();
		jtfEnd = new JTextField();
		jbtnOk = new JButton("확인");
		jbtnCancle = new JButton("취소");

		// 파일의 크기를 읽어와 라인 입력을 유도함
		jlblFileInfo2.setText(mce.getFr().getMaxLine() + "입니다.");

		setLayout(null);

		jlblInfo1.setBounds(40, 35, 130, 20);
		jlblInfo2.setBounds(40, 55, 130, 20);
		jlblFileInfo1.setBounds(190, 35, 130, 20);
		jlblFileInfo2.setBounds(190, 55, 130, 20);
		jtfStart.setBounds(340, 30, 100, 20);
		jtfEnd.setBounds(340, 60, 100, 20);
		jbtnOk.setBounds(100, 110, 80, 30);
		jbtnCancle.setBounds(320, 110, 80, 30);

		add(jlblInfo1);
		add(jlblInfo2);
		add(jlblFileInfo1);
		add(jlblFileInfo2);
		add(jtfStart);
		add(jtfEnd);
		add(jbtnOk);
		add(jbtnCancle);

		jbtnOk.addActionListener(this);
		jbtnCancle.addActionListener(this);

		setBounds(100, 100, 500, 200);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		boolean actionFlag = false;
		
		if (ae.getSource() == jbtnOk) {
			try {
				actionFlag = limitInputMaxLine();
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(mce.getMcv(), "정수만 입력해야합니다.", "입력 오류", JOptionPane.ERROR_MESSAGE); 
			}
			
			//재대로된 값 입력될 시 창 종료
			if(actionFlag)
				this.dispose();
		}

		if (ae.getSource() == jbtnCancle) {
			this.dispose();
		}
	}

	// mce.getFr().getMaxLine() 의 범위를 벗어날 때 처리하는 메서드
	private boolean limitInputMaxLine() throws NumberFormatException {
		int startLine = Integer.parseInt(jtfStart.getText());
		int endLine = Integer.parseInt(jtfEnd.getText());
		int maxLine = mce.getFr().getMaxLine();
		boolean methodFlag = false;

		if (startLine < 0) {
			JOptionPane.showMessageDialog(mce.getMcv(), "시작라인은 0 이상의 정수여야 합니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
		} else {
			if (maxLine < endLine) {
				JOptionPane.showMessageDialog(mce.getMcv(), "끝라인은 " + maxLine + "이하의 정수여야 합니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
			} else {
				if(startLine > endLine) {
					JOptionPane.showMessageDialog(mce.getMcv(), "시작라인의 값이 끝 라인보다 클 수 없습니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
				}else {
					mce.setStartLine(startLine);
					mce.setEndLine(endLine);
					methodFlag=true;
				}
			}
		}
		
		return methodFlag;
	}

}
