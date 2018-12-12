package day1212;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ���� ������ �̺�Ʈ�� ������ �߻��ϸ�, �� �̺�Ʈ�� ���Ͽ� ó���ϴ� ���<br>
 * �̺�Ʈ�� �߻���Ų �ּҸ� �� - ��� �̺�Ʈ���� ��밡��:getSource()<br>
 * �̺�Ʈ�� �߻���Ų ��ü�� Label�� �� - ActionEvent������ ��밡��: getActionCommand()
 * 
 * @author owner
 */
@SuppressWarnings("serial")
//1. Window Component�� ���, Eventó�� Listener�� ����
public class EventCompare extends Frame implements ActionListener {
//2. �̺�Ʈ�� �����ִ� Component�� ���� - ���� �ø��� ������ method�ȿ��� ���ϱ� ���ؼ�
	private Button btnOpen;
	private Button btnSave;
	private Label lblOutput;

	public EventCompare() {
		super("���ϴ��̾�α� ���");
		// 3.����
		btnOpen = new Button("������");
		btnSave = new Button("������");
		lblOutput = new Label("���â : ");
		// 4.��ġ
		Panel panel = new Panel();// Contianer Component
		panel.add(btnOpen);
		panel.add(btnSave);

		add("Center", panel);
		add("South", lblOutput);

		// �̺�Ʈ ���
		btnOpen.addActionListener(this);
		btnSave.addActionListener(this);

		// 6.������ ũ�� ����
		setBounds(100, 100, 500, 100);

		// 7.����ȭ
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}// windowClosing
		});
	}// EventCompare������

	@Override
	public void actionPerformed(ActionEvent ae) {
//		System.out.println("�̺�Ʈ�߻�"+ae);
		/////////////////// �ּҺ�/////////////////////
//		if(ae.getSource()==btnOpen) {
//			System.out.println("����");
//		}//end if
//		
//		if(ae.getSource()==btnSave) {
//			System.out.println("����");
//		}//end if
//		System.out.println("�̺�Ʈ �߻� ��ü�� Label"+ae.getActionCommand());
		//////////////// Label��////////////////////
		String label = ae.getActionCommand();
		if (label.equals("������")) {
//			System.out.println("����!!!!");
			// window Component�� ������ ���ÿ� ����ڿ��� �������� �ʴ´�.
			FileDialog fdOpen = new FileDialog(this, "����", FileDialog.LOAD);
			// ����ȭ
			fdOpen.setVisible(true);

			String path = fdOpen.getDirectory();
			String name = fdOpen.getFile();
			//������ ������ �������� 
			if (name != null) {
				lblOutput.setText("���� ����: " + path + name);
				// Ÿ��Ʋ���� ���� ����
				setTitle("���ϴ��̾�α� ��� - ����: " + name);
				} // end if
		}
		if (label.equals("������")) {
//			System.out.println("����!!!!");
			FileDialog fdSave = new FileDialog(this, "����", FileDialog.SAVE);
			// ����ȭ
			fdSave.setVisible(true);

			String path = fdSave.getDirectory();
			String name = fdSave.getFile();
			if (name!= null) {
			lblOutput.setText("���� ����: " + path + name);
			// Ÿ��Ʋ���� ���� ����
			setTitle("���ϴ��̾�α� ��� - ����: " + name);
			}//end if !=
		} // end if

	}// actionPerformed

	public static void main(String[] args) {
		new EventCompare();
	}// main

}// class
