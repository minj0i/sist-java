package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import evt.MainControlEvt;

/**
 * MainControlView ���� �Ϸ� 18.12.25
 * �߰� ������ �κ� ����
 * �ٵ� �ʹ� ���ѵ�.. �� �߰��Ұ� (�׸�������) ���� �ľ��� �� 
 * @author ������
 */
@SuppressWarnings("serial")
public class MainControlView extends JFrame {
	private JButton jbtnView, jbtnReport;

	public MainControlView() {
		super("�α׺м�-����â");
		jbtnView = new JButton("View");
		jbtnReport = new JButton("Report");

		JPanel jp = new JPanel();
		jp.add(jbtnView);
		jp.add(jbtnReport);

		add("South", jp);

		// �̺�Ʈ ó��
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
