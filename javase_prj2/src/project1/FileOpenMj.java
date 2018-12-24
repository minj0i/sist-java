package project1;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileOpenMj extends WindowAdapter implements ActionListener {
	private String openPath;
	private LoginFrameMj lf;

	
	public FileOpenMj() {
		openPath = "";
		try {
			openFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// FileOpen

	public void openFile() throws FileNotFoundException, IOException {
		boolean flagOpen = false;
		if (!flagOpen) {
			FileDialog fdOpen = new FileDialog(lf, "문서열기", FileDialog.LOAD);
			fdOpen.setVisible(true);

			String filePath = fdOpen.getDirectory();
			String fileName = fdOpen.getFile();

			if (filePath != null) {// 선택한파일이 있음
				///////////////// 12-20-2018 스트림으로 파일의 내용을 읽는 코드 추가///////////////////

				// 선택한 파일로 파일객체 생성.
				File file = new File(filePath + fileName);


				// 파일의 경로와 이름을 Frame에 TitleBar에 설정
				lf.setTitle("메모장 - 열기 " + filePath + fileName);
			} // end if
		} // end if
	}

	@Override
	public void windowClosing(WindowEvent e) {

	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lf.getloginOk()) {
			try {
				openFile();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end if
	}// actionPerformed
}// class
