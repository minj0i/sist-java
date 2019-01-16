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
 * 선택한 파일을 서버로 전송하는 파일 클라이언트
 * @author owner
 */
@SuppressWarnings("serial")
public class FileClient extends JFrame implements ActionListener{

	private JButton btnSelectFile;
	private DefaultListModel<String> dlmFileList;
	
	public FileClient() {
		super("파일전송");
		btnSelectFile = new JButton("파일선택");
		
		dlmFileList = new DefaultListModel<String>();
		JList<String> listFile = new JList<String>(dlmFileList);
		JScrollPane jspFilelist = new JScrollPane(listFile);
		jspFilelist.setBorder(new TitledBorder("전송한 파일"));
		
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
		FileDialog fdOpen = new FileDialog(this, "파일선택", FileDialog.LOAD);
		fdOpen.setVisible(true);
		String fPath= fdOpen.getDirectory();
		String fName = fdOpen.getFile();
		
		if(fName!=null) {
		//이미지 파일(jpg, gif, png, bmp)만 전송
		//선택한 파일이 위의 파일이 아닌 경우 경고창을 띄어줌
		String ext=fName.substring(fName.lastIndexOf(".")+1).toLowerCase();
		String[] arrCompare = {"jpg", "jpeg", "gif", "png", "bmp"};
		
		boolean extFlag = false;
			
		for(String tempExt: arrCompare) {
			if(tempExt.equals(ext)) {
				extFlag=true;
			}//extFlag
		}//end for
		
		if(!extFlag) {
			JOptionPane.showMessageDialog(this, fName+"은 전송가능한 파일이 아닙니다.\n 이미지만 선택해주세요");
			return;
		}//end if
		
		//파일 전송!!!
		try {
			sendFile(new File(fPath+"/"+fName));
			JOptionPane.showMessageDialog(this, fName+"파일을 전송하였습니다.");
			dlmFileList.addElement(fName);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
			
		}//end if
		
		
	}//selectFile
	
	private void sendFile(File file) throws UnknownHostException, IOException {
		//서버에 접속
		Socket socketClient = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		
		try {
		String ip = JOptionPane.showInputDialog("서버 ip ");
		socketClient=new Socket("211.63.89."+ip, 10000);

		String fName = file.getName(); 
		//1.파일명을 전송
		dos = new DataOutputStream(socketClient.getOutputStream());
		dos.writeUTF(fName);
		dos.flush();
		
		//3. 전송할 파일의 byte[] 갯수 서버 전송
		int dataCnt = 0;
		byte[] tempData = new byte[512];
		int dataLen = 0;
		
		fis = new FileInputStream(file);//파일을 열고
		while((dataLen=fis.read(tempData))!=-1) { //파일을 몇 번 보내야하는지 센다
			dataCnt++;
		}//end if
		System.out.println("전송할 배열의 갯수: " + dataCnt);
		fis.close();//한번 지나갔으니 끊어줌(지나가면 끝)
		
		dos.writeInt(dataCnt);//서버가 읽어들일 배열의 횟수(갯수)를 전송한다.: 이제부터 이만큼이 갈거야.
		dos.flush();
		
		//5.파일에서 읽어들인 내용을 전송한다.
		dataLen=0;
		fis=new FileInputStream(file);//위에서 한번 쓰고 끊어졌기 때문에 다시 써준다.
		//이렇게 계속 fis를 열고 닫기 싫으면 배열을 list에 담아서 쓰면 됨
		while((dataLen=fis.read(tempData))!=-1) {
			dos.write(tempData,0,dataLen);
			dos.flush();
			dataCnt--;
		}//end while
		System.out.println("전송횟수"+dataCnt);
		
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
