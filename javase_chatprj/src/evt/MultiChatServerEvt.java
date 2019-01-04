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
//	private Thread threadServer; // �����ڿ� ���� ó���� �ϱ����� Thread
	private Thread threadServer1;
	private Thread threadServer2;
	private Thread threadServer3;
	private Thread threadServer4;

//	private ServerSocket server;// PORT ����
//	private List<MultiChatServerHelper> listClient;// ��� �����ڸ� ������ List
	private ServerSocket server1;// PORT ����
	private List<MultiChatServerHelper> listClient1;// �ش� ���� �����ڸ� ������ List
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
//		// ���� ������ ���� ������ ������ �޴´�.
//		try {
//			server = new ServerSocket(35000);// 0~65535���� PORT�� ���� �� �ִ�.
//			DefaultListModel<String> dlmTemp = mcsv.getDlmChatList();
//			dlmTemp.addElement("������ 35000 PORT�� ���� ���� ��...");
//
//			Socket someClient = null;// �������� ������ ������ ��ü
//			InetAddress ia = null;// �������� ip address�� ������� ��ü
//
//			MultiChatServerHelper mcsh = null;// ������ ������ �޾� ��Ʈ���� �����ϰ�, ��ȭ�� �аų� ��� �����ڿ��� �����ϴ� ��
//			for (int cnt = 0;; cnt++) {
//				someClient = server.accept();
//
//				// ����, ������ ȭ��, ���Ӽ����� �Ҵ��Ͽ� Helper class ����
//				mcsh = new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient, mcsv.getJspList());
//				// ������ ���� �̸��� ���� ��ü�� ������ �����ϱ� ���� List�� �߰�
//				listClient.add(mcsh);
//				// �������� �޼����� �о���̱� ���� Thread ����
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
					server1 = new ServerSocket(35000);// 0~65535���� PORT�� ���� �� �ִ�.
					DefaultListModel<String> dlmTemp = mcsv.getDlmChatList1();
					dlmTemp.addElement("������ 35000 PORT�� ���� ���� ��...");

					Socket someClient = null;// �������� ������ ������ ��ü

					MultiChatServerHelper mcsh = null;// ������ ������ �޾� ��Ʈ���� �����ϰ�, ��ȭ�� �аų� ��� �����ڿ��� �����ϴ� ��
					for (int cnt = 0;; cnt++) {
						someClient = server1.accept();

						// ����, ������ ȭ��, ���Ӽ����� �Ҵ��Ͽ� Helper class ����
						mcsh = new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient1,
								mcsv.getJspList1());
						// ������ ���� �̸��� ���� ��ü�� ������ �����ϱ� ���� List�� �߰�
						listClient1.add(mcsh);
						mcsh.chatJoinNick();//������ �г��� ����
						// �������� �޼����� �о���̱� ���� Thread ����
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
					server2 = new ServerSocket(35001);// 0~65535���� PORT�� ���� �� �ִ�.
					DefaultListModel<String> dlmTemp = mcsv.getDlmChatList2();
					dlmTemp.addElement("������ 35001 PORT�� ���� ���� ��...");

					Socket someClient = null;// �������� ������ ������ ��ü

					MultiChatServerHelper mcsh = null;// ������ ������ �޾� ��Ʈ���� �����ϰ�, ��ȭ�� �аų� ��� �����ڿ��� �����ϴ� ��
					for (int cnt = 0;; cnt++) {
						someClient = server2.accept();

						// ����, ������ ȭ��, ���Ӽ����� �Ҵ��Ͽ� Helper class ����
						mcsh = new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient2,
								mcsv.getJspList2());
						// ������ ���� �̸��� ���� ��ü�� ������ �����ϱ� ���� List�� �߰�
						listClient2.add(mcsh);
						mcsh.chatJoinNick();//������ �г��� ����
						// �������� �޼����� �о���̱� ���� Thread ����
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
					server3 = new ServerSocket(35002);// 0~65535���� PORT�� ���� �� �ִ�.
					DefaultListModel<String> dlmTemp = mcsv.getDlmChatList3();
					dlmTemp.addElement("������ 35002 PORT�� ���� ���� ��...");
					
					Socket someClient = null;// �������� ������ ������ ��ü
					
					MultiChatServerHelper mcsh = null;// ������ ������ �޾� ��Ʈ���� �����ϰ�, ��ȭ�� �аų� ��� �����ڿ��� �����ϴ� ��
					for (int cnt = 0;; cnt++) {
						someClient = server3.accept();
						
						// ����, ������ ȭ��, ���Ӽ����� �Ҵ��Ͽ� Helper class ����
						mcsh = new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient3,
								mcsv.getJspList3());
						// ������ ���� �̸��� ���� ��ü�� ������ �����ϱ� ���� List�� �߰�
						listClient3.add(mcsh);
						mcsh.chatJoinNick();//������ �г��� ����
						// �������� �޼����� �о���̱� ���� Thread ����
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
					server4 = new ServerSocket(35003);// 0~65535���� PORT�� ���� �� �ִ�.
					DefaultListModel<String> dlmTemp = mcsv.getDlmChatList4();
					dlmTemp.addElement("������ 35003 PORT�� ���� ���� ��...");
					
					Socket someClient = null;// �������� ������ ������ ��ü
					
					MultiChatServerHelper mcsh = null;// ������ ������ �޾� ��Ʈ���� �����ϰ�, ��ȭ�� �аų� ��� �����ڿ��� �����ϴ� ��
					for (int cnt = 0;; cnt++) {
						someClient = server4.accept();
						
						// ����, ������ ȭ��, ���Ӽ����� �Ҵ��Ͽ� Helper class ����
						mcsh = new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient4,
								mcsv.getJspList4());
						// ������ ���� �̸��� ���� ��ü�� ������ �����ϱ� ���� List�� �߰�
						listClient4.add(mcsh);
						mcsh.chatJoinNick();//������ �г��� ����
						
						// �������� �޼����� �о���̱� ���� Thread ����
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
				JOptionPane.showMessageDialog(mcsv, "ä�� ������ �̹� �������Դϴ�.");
			}
		}

		if (ae.getSource() == mcsv.getJbtCloseServer()) {
			switch (JOptionPane.showConfirmDialog(mcsv, "ü�ü����� �����ϰڽ��ϱ�? \n�����Ͻø� ��� �������� ������ �������ϴ�.")) {
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
		// �ҹ������� ���� �ڵ�
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
