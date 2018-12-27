package evt;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import view.InputLineDialog;
import view.MainControlView;
import view.ReportDialogView;

/**
 * 18.12.25 1�� �ۼ� �Ϸ� - ������ ���� �����ؾ� �Ǵ� �κ��̶� �߰��߰� ������ �ʹ� ���� �ν��Ͻ�ȭ�� Ŭ������ ������ �̵��� ��
 * �� �Ű��� �� �� �ؿ� �ּ��� �ڵ���� �߰��� �����ϴ� �κп� ���� ������ ����Ǿ� ����
 * 
 * 18.12.26 2�� �ۼ� �Ϸ� - ���� ���� �Ϸ�. ����ϴ� �����͸� ���� �պ��� �� 
 * 
 * 18.12.27 fileForm �޼��� �߰� 
 * 
 * @author ������
 */
public class MainControlEvt implements ActionListener {
	private MainControlView mcv;
	private String filePath; // ���� �н��� VO�� ����
	private int startLine; // startLine ���� �߰��� (Ŭ���������� �߰� - 6�������� �̿��ϴ� ����
	private int endLine; // endLine ���� �߰��� (Ŭ���������� �߰� - 6�������� �̿��ϴ� ����
	private String[] tempProblem;// tempResult ���� �߰���(Ŭ���������� �߰� - Report�� �������� ���� ���� ����� �ӽ÷� �����ϴ� ����
	private String[] tempResult;// tempResult ���� �߰���(Ŭ���������� �߰� - Report�� �������� ���� ���� ����� �ӽ÷� �����ϴ� ����
	private boolean flag;// flag ���� �߰���(Ŭ���������� �߰� - view�� �ּ� �ѹ� ����Ǿ����� �Ǵ�
	
	private FileRead fr;// FileRead ���� �߰��� (Ŭ���� ������ �߰� - log ��ü�� ����� data)
	private FileRead SelectedFr;// FileRead ���� �߰��� (Ŭ���� ������ �߰� - log �Ϻθ� ����� data)

	public MainControlEvt(MainControlView mcv) {
		this.mcv = mcv;
		startLine = -1;
		endLine = -1;
		tempProblem = new String[6];
		tempResult = new String[6];
		flag = false;

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mcv.getJbtnView()) {
			showReport();
		}

		if (ae.getSource() == mcv.getJbtnReport()) {
			printReport();
		}
		// �α׾ƿ���ư �߰��ؾߵǴ°��� .. ?
	}

	/**
	 * view ��ư�� ������ �� �����ϴ� �޼��� <br>
	 * ���ϴ��̾�α� > ������ �о�� ����� �� �ִ� �����ͷ� ���� > ���â ���
	 */
	public void showReport() {
		// ���� ���̾�α׸� ��� ��
		FileDialog fd = new FileDialog(this.mcv, "���� ����", FileDialog.LOAD);
		fd.setVisible(true);

		String path = fd.getDirectory();
		String name = fd.getFile();

		if (path != null) {
			filePath = path + name;// ���� ������ path�� �ν��Ͻ������� ����

			// fileReadHandling���� log���� ����� ������ ����
			fileReadHandling();

			// InputLineDialog�� ����.
			InputLineDialog ild = new InputLineDialog(this);

			//�����Է��� ����� ������ ���� ������ ����
			if(startLine != -1 && endLine != -1) {
				// selectedFileReadHandling���� log�� �Ϻθ� ����� ������ ����
				selectedFileReadHandling();
				
				// ���â (�α׺м� view 6����¥�� ) ����� @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
				ReportDialogView rdv = new ReportDialogView(this);
				
				//tempResult = "�������� �����";
				// 3. view�� ����Ǿ����� ����
				flag = true;

			}else {
				JOptionPane.showMessageDialog(mcv, "�ùٸ� ���ΰ��� �Է����� �ʾҽ��ϴ�.", "�����Է� ����", JOptionPane.ERROR_MESSAGE); 
				
			}
		} else {// ������ ���������� ����ó��
			JOptionPane.showMessageDialog(mcv, "������ �дµ� �����߽��ϴ�.", "���� �ҷ����� ����", JOptionPane.ERROR_MESSAGE); 
		}
	}

	/**
	 * ���� �о���̴� �޼���
	 */
	public void fileReadHandling() {
		try {
			fr = new FileRead(filePath);
			fr.logToSet();
			fr.logToList();
			fr.setMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * ���� �о���̴� �޼��� (������ ����
	 */
	public void selectedFileReadHandling() {
		try {
			SelectedFr = new FileRead(filePath, startLine, endLine);
			SelectedFr.logToSet();
			SelectedFr.logToList();
			SelectedFr.setMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * ����Ʈ ��� �޼���
	 */
	public void printReport() {
		// �ּ� view�� �ѹ� ����� ���Ŀ� �޼��尡 ����Ǿ����
		if (flag) {
			createDirectory();// c:/dev/report ���� ���� (������ ������ �����ϴ� �۾�) - day1219 Usefile2 ����

			try {
				useFileOutputStream();// "report_������¥.dat" ������ �����Ͽ� 1~6���� �۾��� write
			} catch (IOException e) {
				JOptionPane.showMessageDialog(mcv, "���� ��� �� ����ġ ���� ������ �߻��߽��ϴ�.", "���� ��� ����", JOptionPane.ERROR_MESSAGE); 
			}

		} else {
			JOptionPane.showMessageDialog(mcv, "view��ư�� ���� ������ �а� ���ȭ���� ����� �� \n����Ʈ�� ����� �� �ֽ��ϴ�.", "���� ��� ����", JOptionPane.ERROR_MESSAGE); 
		}
	}

	/**
	 * �������� �޼��� �߰� - Ŭ���� ������ ��� - day1219 Usefile2 ����
	 */
	private void createDirectory() {
		File directory = new File("c:/dev/report");
		directory.mkdirs();
	}

	/**
	 * ������� �޼��� �߰� - Ŭ���� ������ ��� - day1220 UseFileOutputStream2 ����
	 * @throws IOException
	 */
	private void useFileOutputStream() throws IOException {
		File fileOutput = new File(fileDateNaming());// ������¥ ����� �ڵ� �߰��ؾ���

		// ������ ���ٸ� �����ϰ�, �ִٸ� �����.
		BufferedWriter bw = null;
		boolean flagFile = true; // ������ ���� ��
		boolean[] temp = { true, false, false };// ��, �ƴϿ�, ���
		int select = -1;

		if (fileOutput.exists()) {// ������ ���� �� ��
			select = JOptionPane.showConfirmDialog(mcv, "���� �̸��� ������ �����մϴ�. \n����ðڽ��ϱ�?");
			flagFile = temp[select];
		}

		if (flagFile) {
			try {
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOutput),"UTF-8"));
				
				bw.write(fileForm()); // ����� �Է� ���ش�. (ReportDialogEvt�� ����� �޾ƿ� ��� ���¿� �°� ������ ������
				bw.flush();
				JOptionPane.showMessageDialog(mcv, "������ ���������� ��µǾ����ϴ�!", "���� ��� ����", JOptionPane.INFORMATION_MESSAGE);
			} finally {
				if (bw != null)
					bw.close();
			}
		}
	}

	/**
	 * ���� ����� �̻ڰ� �ٹ̴� �޼���
	 * @return
	 */
	private String fileForm() {
		StringBuilder sb = new StringBuilder();
		String fileName = fileDateNaming();
		fileName = fileName.substring(fileName.lastIndexOf("/")+1, fileName.length());
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		sb.append("-----------------------------------------------------------\n");
		sb.append("���ϸ�(").append(fileName).append(") log (������ ��¥ ").append(sdf.format(d)).append(")\n");
		sb.append("-----------------------------------------------------------\n");
		for(int i=0; i<tempResult.length; i++) {
			sb.append(tempProblem[i]+"\n");
			sb.append(tempResult[i]+"\n\n");
			
		}
		
		
		return sb.toString();
	}
	
	/**
	 * ���� �̸��� ������¥ �߰��ϴ� �޼���- Ŭ���� ������ ���
	 * @return
	 */
	private String fileDateNaming() {
		String s = "c:/dev/report/report_.dat";
		StringBuilder sb = new StringBuilder(s);
		String today;
		Date d;
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");

		d = new Date();
		today = sdf.format(d);

		sb.insert(s.lastIndexOf("."), today);

		return sb.toString();

	}

	////////////////////////////�ʿ��� ������ ���� getter setter�� ,,, 
	
	public void setStartLine(int startLine) { // setter �߰��� (Ŭ���������� �߰� .
		this.startLine = startLine;
	}

	public void setEndLine(int endLine) { // setter �߰��� (Ŭ���������� �߰� .
		this.endLine = endLine;
	}

	public MainControlView getMcv() { // getter �߰��� (Ŭ���������� �߰� .
		return mcv;
	}

	public String getFilePath() {
		return filePath;
	}
	
	public FileRead getFr() {
		return fr;
	}

	public FileRead getSelectedFr() {
		return SelectedFr;
	}

	public void setTempResult(String tempResult[]) {
		this.tempResult = tempResult;
	}

	public void setTempProblem(String[] tempProblem) {
		this.tempProblem = tempProblem;
	}

	public int getStartLine() {
		return startLine;
	}

	public int getEndLine() {
		return endLine;
	}

}
