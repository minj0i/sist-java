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
		super("파일선택");
		// 1.컴포넌트 생성
		filePath1 = new JLabel("");
		filePath2 = new JLabel("");
		to = new JLabel("~");
		open1 = new JButton("열기");
		open2 = new JButton("열기");
		addFile = new JButton("추가");
		delete = new JButton("삭제");
		confirm = new JButton("확인");


		startLine = new JTextField("");
		endLine = new JTextField("");
		
		//2.배치관리자 설정(해제) : BorderLayout
		setLayout(null);
		
		
		//3.배치
		//TitledBorder로 묶고 싶음
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
		//5.윈도우 크기 설정
		setBounds(200, 100, 400, 350);
		setResizable(false); //크기 변경을 막음
		
		//6.사용자에게 보여주기
		setVisible(true);
		
		//7.종료처리
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
			FileDialog fdOpen = new FileDialog(this, "문서열기", FileDialog.LOAD);
			fdOpen.setVisible(true);

			String filePath = fdOpen.getDirectory();
			String fileName = fdOpen.getFile();

			if (filePath != null) {// 선택한파일이 있음
				///////////////// 12-20-2018 스트림으로 파일의 내용을 읽는 코드 추가///////////////////

				// 선택한 파일로 파일객체 생성.
				File file = new File(filePath + fileName);

				// 파일의 경로와 이름을 Frame에 TitleBar에 설정
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
