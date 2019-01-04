package evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import view.MultiChatServerView;

public class MultiChatServerEvt extends WindowAdapter implements ActionListener {
	private MultiChatServerView mcsv;
//	private Thread threadServer; // 접속자에 대한 처리를 하기위한 Thread
	private Thread threadServer1;
	private Thread threadServer2;
	private Thread threadServer3;
	private Thread threadServer4;

//	private ServerSocket server;// PORT 열기
//	private List<MultiChatServerHelper> listClient;// 모든 접속자를 관리할 List
	private ServerSocket server1;// PORT 열기
	private List<MultiChatServerHelper> listClient1;// 해당 조의 접속자를 관리할 List
	private ServerSocket server2;
	private List<MultiChatServerHelper> listClient2;
	private ServerSocket server3;
	private List<MultiChatServerHelper> listClient3;
	private ServerSocket server4;
	private List<MultiChatServerHelper> listClient4;
	
	public MultiChatServerEvt(MultiChatServerView mcsv) {
		this.mcsv = mcsv;
//		listClient = new ArrayList<MultiChatServerHelper>();
		listClient1 = new ArrayList<MultiChatServerHelper>();
		listClient2 = new ArrayList<MultiChatServerHelper>();
		listClient3 = new ArrayList<MultiChatServerHelper>();
		listClient4 = new ArrayList<MultiChatServerHelper>();
	}

//	@Override
//	public void run() {
//		// 서버 소켓을 열고 접속자 소켓을 받는다.
//		try {
//			server = new ServerSocket(35000);// 0~65535개의 PORT가 열릴 수 있다.
//			DefaultListModel<String> dlmTemp = mcsv.getDlmChatList();
//			dlmTemp.addElement("서버가 35000 PORT를 열고 가동 중...");
//
//			Socket someClient = null;// 접속자의 소켓을 저장할 객체
//			InetAddress ia = null;// 접속자의 ip address를 얻기위한 객체
//
//			MultiChatServerHelper mcsh = null;// 접속자 소켓을 받아 스트림을 연결하고, 대화를 읽거나 모든 접속자에게 전송하는 일
//			for (int cnt = 0;; cnt++) {
//				someClient = server.accept();
//
//				// 소켓, 서버의 화면, 접속순서를 할당하여 Helper class 생성
//				mcsh = new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient, mcsv.getJspList());
//				// 생성된 같은 이름의 소켓 객체를 여러개 관리하기 위해 List에 추가
//				listClient.add(mcsh);
//				// 접속자의 메세지를 읽어들이기 위한 Thread 시작
//				mcsh.start();
//
//			}
//
//		} catch (IOException ie) {
//			ie.printStackTrace();
//		}
//
//	}

	public void setServerSocketToThread1() {
		threadServer1 = new Thread(new Runnable() {
			public void run() {
				try {
					server1 = new ServerSocket(35000);// 0~65535개의 PORT가 열릴 수 있다.
					DefaultListModel<String> dlmTemp = mcsv.getDlmChatList1();
					dlmTemp.addElement("서버가 35000 PORT를 열고 가동 중...");

					Socket someClient = null;// 접속자의 소켓을 저장할 객체

					MultiChatServerHelper mcsh = null;// 접속자 소켓을 받아 스트림을 연결하고, 대화를 읽거나 모든 접속자에게 전송하는 일
					for (int cnt = 0;; cnt++) {
						someClient = server1.accept();

						// 소켓, 서버의 화면, 접속순서를 할당하여 Helper class 생성
						mcsh = new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient1,
								mcsv.getJspList1());
						// 생성된 같은 이름의 소켓 객체를 여러개 관리하기 위해 List에 추가
						listClient1.add(mcsh);
						mcsh.chatJoinNick();//접속자 닉네임 갱신
						// 접속자의 메세지를 읽어들이기 위한 Thread 시작
						mcsh.start();
					}

				} catch (IOException ie) {
					ie.printStackTrace();
				}
			}
		});

		threadServer1.start();
	}

	public void setServerSocketToThread2() {
		threadServer2 = new Thread(new Runnable() {
			public void run() {
				try {
					server2 = new ServerSocket(35001);// 0~65535개의 PORT가 열릴 수 있다.
					DefaultListModel<String> dlmTemp = mcsv.getDlmChatList2();
					dlmTemp.addElement("서버가 35001 PORT를 열고 가동 중...");

					Socket someClient = null;// 접속자의 소켓을 저장할 객체

					MultiChatServerHelper mcsh = null;// 접속자 소켓을 받아 스트림을 연결하고, 대화를 읽거나 모든 접속자에게 전송하는 일
					for (int cnt = 0;; cnt++) {
						someClient = server2.accept();

						// 소켓, 서버의 화면, 접속순서를 할당하여 Helper class 생성
						mcsh = new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient2,
								mcsv.getJspList2());
						// 생성된 같은 이름의 소켓 객체를 여러개 관리하기 위해 List에 추가
						listClient2.add(mcsh);
						mcsh.chatJoinNick();//접속자 닉네임 갱신
						// 접속자의 메세지를 읽어들이기 위한 Thread 시작
						mcsh.start();
					}

				} catch (IOException ie) {
					ie.printStackTrace();
				}
			}
		});

		threadServer2.start();
	}
	
	public void setServerSocketToThread3() {
		threadServer3 = new Thread(new Runnable() {
			public void run() {
				try {
					server3 = new ServerSocket(35002);// 0~65535개의 PORT가 열릴 수 있다.
					DefaultListModel<String> dlmTemp = mcsv.getDlmChatList3();
					dlmTemp.addElement("서버가 35002 PORT를 열고 가동 중...");
					
					Socket someClient = null;// 접속자의 소켓을 저장할 객체
					
					MultiChatServerHelper mcsh = null;// 접속자 소켓을 받아 스트림을 연결하고, 대화를 읽거나 모든 접속자에게 전송하는 일
					for (int cnt = 0;; cnt++) {
						someClient = server3.accept();
						
						// 소켓, 서버의 화면, 접속순서를 할당하여 Helper class 생성
						mcsh = new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient3,
								mcsv.getJspList3());
						// 생성된 같은 이름의 소켓 객체를 여러개 관리하기 위해 List에 추가
						listClient3.add(mcsh);
						mcsh.chatJoinNick();//접속자 닉네임 갱신
						// 접속자의 메세지를 읽어들이기 위한 Thread 시작
						mcsh.start();
					}
					
				} catch (IOException ie) {
					ie.printStackTrace();
				}
			}
		});
		
		threadServer3.start();
	}
	
	
	public void setServerSocketToThread4() {
		threadServer4 = new Thread(new Runnable() {
			public void run() {
				try {
					server4 = new ServerSocket(35003);// 0~65535개의 PORT가 열릴 수 있다.
					DefaultListModel<String> dlmTemp = mcsv.getDlmChatList4();
					dlmTemp.addElement("서버가 35003 PORT를 열고 가동 중...");
					
					Socket someClient = null;// 접속자의 소켓을 저장할 객체
					
					MultiChatServerHelper mcsh = null;// 접속자 소켓을 받아 스트림을 연결하고, 대화를 읽거나 모든 접속자에게 전송하는 일
					for (int cnt = 0;; cnt++) {
						someClient = server4.accept();
						
						// 소켓, 서버의 화면, 접속순서를 할당하여 Helper class 생성
						mcsh = new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient4,
								mcsv.getJspList4());
						// 생성된 같은 이름의 소켓 객체를 여러개 관리하기 위해 List에 추가
						listClient4.add(mcsh);
						mcsh.chatJoinNick();//접속자 닉네임 갱신
						
						// 접속자의 메세지를 읽어들이기 위한 Thread 시작
						mcsh.start();
					}
					
				} catch (IOException ie) {
					ie.printStackTrace();
				}
			}
		});
		
		threadServer4.start();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mcsv.getJbtOpenServer()) {
			if (threadServer1 == null || threadServer2 == null  || threadServer3 == null || threadServer4 == null) {
//				threadServer = new Thread(this);
//				threadServer.start();
				
				setServerSocketToThread1();
				setServerSocketToThread2();
				setServerSocketToThread3();
				setServerSocketToThread4();
			} else {
				JOptionPane.showMessageDialog(mcsv, "채팅 서버가 이미 가동중입니다.");
			}
		}

		if (ae.getSource() == mcsv.getJbtCloseServer()) {
			switch (JOptionPane.showConfirmDialog(mcsv, "체팅서버를 종료하겠습니까? \n종료하시면 모든 접속자의 연결이 끊어집니다.")) {
			case JOptionPane.OK_OPTION:
				mcsv.dispose();
				break;
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent we) {
		mcsv.dispose();
	}

	@Override
	public void windowClosed(WindowEvent we) {
		// 소버소켓을 끊는 코드
		try {
			if (server1 != null) {server1.close();}
			if (server2 != null) {server2.close();}
			if (server3 != null) {server3.close();}
			if (server4 != null) {server4.close();}
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
