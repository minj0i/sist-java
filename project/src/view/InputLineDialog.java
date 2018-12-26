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
 * 18.12.25 1�� �ۼ� �Ϸ� - �ǵ��Ѵ�� ������ �� �� ����ó����Ȳ�� � �߰��ؾ� �� �� , ���� ���̸� �޾ƿ� ����ؾ���
 * 18.12.26 2�� �ۼ� �Ϸ� - ����ó�� �Ϸ�, ���ϱ��� ��� �Ϸ� 
 * @author ������
 */
@SuppressWarnings("serial")
public class InputLineDialog extends JDialog implements ActionListener {
	private MainControlEvt mce; // mce ���� �߰��� (Ŭ������������ �߰� - mce�� �ԷµǴ� �� ���� �� frame�� super�� ���� ����
	private JTextField jtfStart, jtfEnd;
	private JButton jbtnOk, jbtnCancle; // JButton �߰��� (Ŭ������������ �߰� - �̺�Ʈ �Է¿� �´� dialog�ൿ�� ����

	public InputLineDialog(MainControlEvt mce) { // ������ dialog�� �°� ���� .
		super(mce.getMcv(), "�����Է� - Dialog", true);
		this.mce = mce;
		mce.setStartLine(-1);//â�� �׳� ���� �������� �ԷµǱ� ������ �Է�â�� ������ ���� -1�� �ʱ�ȭ
		mce.setEndLine(-1);
		
		JLabel jlblInfo1 = new JLabel("����� ������ ����");
		JLabel jlblInfo2 = new JLabel("������ �Է����ּ���.");
		JLabel jlblFileInfo1 = new JLabel("�� ������ �ִ� ���̴�");
		JLabel jlblFileInfo2 = new JLabel();
		jtfStart = new JTextField();
		jtfEnd = new JTextField();
		jbtnOk = new JButton("Ȯ��");
		jbtnCancle = new JButton("���");

		// ������ ũ�⸦ �о�� ���� �Է��� ������
		jlblFileInfo2.setText(mce.getFr().getMaxLine() + "�Դϴ�.");

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
				JOptionPane.showMessageDialog(mce.getMcv(), "������ �Է��ؾ��մϴ�.", "�Է� ����", JOptionPane.ERROR_MESSAGE); 
			}
			
			//���ε� �� �Էµ� �� â ����
			if(actionFlag)
				this.dispose();
		}

		if (ae.getSource() == jbtnCancle) {
			this.dispose();
		}
	}

	// mce.getFr().getMaxLine() �� ������ ��� �� ó���ϴ� �޼���
	private boolean limitInputMaxLine() throws NumberFormatException {
		int startLine = Integer.parseInt(jtfStart.getText());
		int endLine = Integer.parseInt(jtfEnd.getText());
		int maxLine = mce.getFr().getMaxLine();
		boolean methodFlag = false;

		if (startLine < 0) {
			JOptionPane.showMessageDialog(mce.getMcv(), "���۶����� 0 �̻��� �������� �մϴ�.", "�Է� ����", JOptionPane.ERROR_MESSAGE);
		} else {
			if (maxLine < endLine) {
				JOptionPane.showMessageDialog(mce.getMcv(), "�������� " + maxLine + "������ �������� �մϴ�.", "�Է� ����", JOptionPane.ERROR_MESSAGE);
			} else {
				if(startLine > endLine) {
					JOptionPane.showMessageDialog(mce.getMcv(), "���۶����� ���� �� ���κ��� Ŭ �� �����ϴ�.", "�Է� ����", JOptionPane.ERROR_MESSAGE);
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