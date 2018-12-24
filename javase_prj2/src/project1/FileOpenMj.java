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
			FileDialog fdOpen = new FileDialog(lf, "��������", FileDialog.LOAD);
			fdOpen.setVisible(true);

			String filePath = fdOpen.getDirectory();
			String fileName = fdOpen.getFile();

			if (filePath != null) {// ������������ ����
				///////////////// 12-20-2018 ��Ʈ������ ������ ������ �д� �ڵ� �߰�///////////////////

				// ������ ���Ϸ� ���ϰ�ü ����.
				File file = new File(filePath + fileName);


				// ������ ��ο� �̸��� Frame�� TitleBar�� ����
				lf.setTitle("�޸��� - ���� " + filePath + fileName);
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
