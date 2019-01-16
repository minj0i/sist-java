package day0114;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * 접속자가 보내오는 파일을 저장하는 서버
 * @author owner
 */
@SuppressWarnings("serial")
public class FileServer extends JFrame implements Runnable, ActionListener {

	
	private DefaultListModel<String>/*파일명 들어갈거니까*/ dlmFileList;
	private JButton btnStartServer;
	
	private Thread threadServer; 
	private ServerSocket socketServerFile;
	public FileServer() {
		super("파일 서버");
		dlmFileList = new DefaultListModel<String>();
		JList<String> listFile = new JList<>(dlmFileList);
		btnStartServer=new JButton("서버가동");
		
		JScrollPane jsp = new JScrollPane(listFile);
		jsp.setBorder(new TitledBorder("파일목록"));
		
		JPanel panel = new JPanel();
		panel.add(btnStartServer);
		
		add("Center", jsp);
		add("South", panel);
		
		btnStartServer.addActionListener(this);
		
		setBounds(100, 100, 400, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//FileServer

	
	@Override
	public void run() {
		
		try {
			Socket socketClient = null;
			DataInputStream dis = null;
			StringBuilder fileName =new StringBuilder();
			
			int dataCnt = 0;
			FileOutputStream fos = null;
			File file = null;
			
			byte[] readData = null;
			int dataLen = 0;
			
			try {
				while(true) {
					//접속자 소켓이 존재함.
					socketClient=socketServerFile.accept();
					
					//2.클라이언트가 전송하는 파일명을 저장
					dis=new DataInputStream(socketClient.getInputStream());
					
					fileName.delete(0, fileName.length());//한번 싹 지우고 추가
					fileName.append(dis.readUTF());
					
					//파일명을 겹치지 않도록 변경
					fileName.insert(fileName.lastIndexOf("."), "_".concat(String.valueOf(System.currentTimeMillis())));
					dlmFileList.addElement(fileName.toString()+" "+socketClient.getInetAddress()); //누가 보냈는지 알고 싶으면 getInetAddress를 붙여줌
					
					//4. 클라이언트가 전송하는 배열의 갯수(읽어들일 횟수) 받는다.
					dataCnt = dis.readInt();
//					dlmFileList.addElement(String.valueOf(dataCnt));

					//6. 전송횟수만큼 읽어들여 파일로 출력한다
					file = new File("C:/dev/workspace/javase_prj2/src/day0114/images/"+fileName); //저장될 파일 경로
					
					fos = new FileOutputStream(file);
					readData = new byte[512];
					
					while(dataCnt>0) {
						dataLen= dis.read(readData);//클라이언트가 전송하는 배열의 크기만큼을 받아서
						fos.write(readData,0,dataLen);//파일에 기록
						fos.flush();
						
						dataCnt--;//배열 세트(횟수)를 하나씩 줄여나감 
					}//end while
					
			}//end while
			}finally {
				if(fos!=null) {fos.close();}
				if(dis!=null) {dis.close();}
				if(socketClient!=null) {socketClient.close();}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//run


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(threadServer == null) {
			try {
				socketServerFile = new ServerSocket(10000);//1024번(well-known port) 이후로 잡는게 좋음. 
				dlmFileList.addElement("서버가 10000포트로 실행되었습니다.");
				threadServer=new Thread(this);
				threadServer.start();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this,"포트가 이미 사용 중입니다.");
				e.printStackTrace();
			}//end catch
			
		}else {
			JOptionPane.showMessageDialog(this,"서버가 이미 동작중입니다.");
		}//end else
	}//actionPerformed
	
	public static void main(String[] args) {
		new FileServer();
	}//main
	
}//class
