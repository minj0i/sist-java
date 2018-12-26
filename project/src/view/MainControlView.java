package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import evt.MainControlEvt;

/**
 * MainControlView 구성 완료 18.12.25
 * 추가 구현할 부분 없음
 * 근데 너무 휑한디.. 뭐 추가할거 (그림같은거) 없나 파악할 것 
 * @author 이재찬
 */
@SuppressWarnings("serial")
public class MainControlView extends JFrame {
	private JButton jbtnView, jbtnReport;

	public MainControlView() {
		super("로그분석-관리창");
		jbtnView = new JButton("View");
		jbtnReport = new JButton("Report");

		JPanel jp = new JPanel();
		jp.add(jbtnView);
		jp.add(jbtnReport);

		add("South", jp);

		// 이벤트 처리
		MainControlEvt mce = new MainControlEvt(this);
		jbtnView.addActionListener(mce);
		jbtnReport.addActionListener(mce);

		setBounds(100, 100, 500, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public JButton getJbtnView() {
		return jbtnView;
	}

	public JButton getJbtnReport() {
		return jbtnReport;
	}

}
