package day0114;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * ������ ������ ������ �����ϴ� ���� Ŭ���̾�Ʈ
 * @author owner
 */
@SuppressWarnings("serial")
public class FileClient extends JFrame implements ActionListener{

	private JButton btnSelectFile;
	private DefaultListModel<String> dlmFileList;
	
	public FileClient() {
		super("��������");
		btnSelectFile = new JButton("���ϼ���");
		
		dlmFileList = new DefaultListModel<String>();
		JList<String> listFile = new JList<String>(dlmFileList);
		JScrollPane jspFilelist = new JScrollPane(listFile);
		jspFilelist.setBorder(new TitledBorder("������ ����"));
		
		JPanel panel = new JPanel();
		panel.add(btnSelectFile);
		
		add("Center", jspFilelist);
		add("South", panel);
		
		btnSelectFile.addActionListener(this);
		
		setBounds(100, 100, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//FileClient
	
	public void selectFile() {
		FileDialog fdOpen = new FileDialog(this, "���ϼ���", FileDialog.LOAD);
		fdOpen.setVisible(true);
		String fPath= fdOpen.getDirectory();
		String fName = fdOpen.getFile();
		
		if(fName!=null) {
		//�̹��� ����(jpg, gif, png, bmp)�� ����
		//������ ������ ���� ������ �ƴ� ��� ���â�� �����
		String ext=fName.substring(fName.lastIndexOf(".")+1).toLowerCase();
		String[] arrCompare = {"jpg", "jpeg", "gif", "png", "bmp"};
		
		boolean extFlag = false;
			
		for(String tempExt: arrCompare) {
			if(tempExt.equals(ext)) {
				extFlag=true;
			}//extFlag
		}//end for
		
		if(!extFlag) {
			JOptionPane.showMessageDialog(this, fName+"�� ���۰����� ������ �ƴմϴ�.\n �̹����� �������ּ���");
			return;
		}//end if
		
		//���� ����!!!
		try {
			sendFile(new File(fPath+"/"+fName));
			JOptionPane.showMessageDialog(this, fName+"������ �����Ͽ����ϴ�.");
			dlmFileList.addElement(fName);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
			
		}//end if
		
		
	}//selectFile
	
	private void sendFile(File file) throws UnknownHostException, IOException {
		//������ ����
		Socket socketClient = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		
		try {
		String ip = JOptionPane.showInputDialog("���� ip ");
		socketClient=new Socket("211.63.89."+ip, 10000);

		String fName = file.getName(); 
		//1.���ϸ��� ����
		dos = new DataOutputStream(socketClient.getOutputStream());
		dos.writeUTF(fName);
		dos.flush();
		
		//3. ������ ������ byte[] ���� ���� ����
		int dataCnt = 0;
		byte[] tempData = new byte[512];
		int dataLen = 0;
		
		fis = new FileInputStream(file);//������ ����
		while((dataLen=fis.read(tempData))!=-1) { //������ �� �� �������ϴ��� ����
			dataCnt++;
		}//end if
		System.out.println("������ �迭�� ����: " + dataCnt);
		fis.close();//�ѹ� ���������� ������(�������� ��)
		
		dos.writeInt(dataCnt);//������ �о���� �迭�� Ƚ��(����)�� �����Ѵ�.: �������� �̸�ŭ�� ���ž�.
		dos.flush();
		
		//5.���Ͽ��� �о���� ������ �����Ѵ�.
		dataLen=0;
		fis=new FileInputStream(file);//������ �ѹ� ���� �������� ������ �ٽ� ���ش�.
		//�̷��� ��� fis�� ���� �ݱ� ������ �迭�� list�� ��Ƽ� ���� ��
		while((dataLen=fis.read(tempData))!=-1) {
			dos.write(tempData,0,dataLen);
			dos.flush();
			dataCnt--;
		}//end while
		System.out.println("����Ƚ��"+dataCnt);
		
		}finally {
			if(fis!=null) {fis.close();}//end if
			if(dos!=null) {dos.close();}//end if
			if(socketClient!=null) {socketClient.close();}//end if
		}
		
	}//SendFile
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		selectFile();
	}//actionPerformed
	
	public static void main(String[] args) {
		new FileClient();
	}//main

}//class
