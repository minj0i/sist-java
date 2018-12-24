package project1;

import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class FileOpen extends JFrame implements ActionListener {
	private JLabel filePath1, filePath2, to;
	private JButton open1, open2, addFile, delete, confirm;
	private JTextField startLine, endLine;

	public FileOpen() {
		super("���ϼ���");
		// 1.������Ʈ ����
		filePath1 = new JLabel("");
		filePath2 = new JLabel("");
		to = new JLabel("~");
		open1 = new JButton("����");
		open2 = new JButton("����");
		addFile = new JButton("�߰�");
		delete = new JButton("����");
		confirm = new JButton("Ȯ��");


		startLine = new JTextField("");
		endLine = new JTextField("");
		
		//2.��ġ������ ����(����) : BorderLayout
		setLayout(null);
		
		
		//3.��ġ
		//TitledBorder�� ���� ����
		add(filePath1).setBounds(10,10,200,30);
		add(filePath2).setBounds(10,70,200,30);
		add(open1).setBounds(230,10,70,30);
		add(open2).setBounds(230,70,70,30);
		add(addFile).setBounds(300,10,70,30);
		add(delete).setBounds(300,70,70,30);
		add(confirm);
		add(startLine).setBounds(80,200,70,30);
		add(to).setBounds(180,200,70,30);
		add(endLine).setBounds(200,200,70,30);
		add(confirm).setBounds(290, 250, 70, 30);
		//5.������ ũ�� ����
		setBounds(200, 100, 400, 350);
		setResizable(false); //ũ�� ������ ����
		
		//6.����ڿ��� �����ֱ�
		setVisible(true);
		
		//7.����ó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//windowClosing
		});
	
	}// FileOpen

	public void openFile() throws FileNotFoundException, IOException {
		boolean flagOpen = false;
		if (!flagOpen) {
			FileDialog fdOpen = new FileDialog(this, "��������", FileDialog.LOAD);
			fdOpen.setVisible(true);

			String filePath = fdOpen.getDirectory();
			String fileName = fdOpen.getFile();

			if (filePath != null) {// ������������ ����
				///////////////// 12-20-2018 ��Ʈ������ ������ ������ �д� �ڵ� �߰�///////////////////

				// ������ ���Ϸ� ���ϰ�ü ����.
				File file = new File(filePath + fileName);

				// ������ ��ο� �̸��� Frame�� TitleBar�� ����
			} // end if
		} // end if
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
//				openFile();
	}// actionPerformed

	public static void main(String[] args) {
		new FileOpen();
	}//main
	
}// class
