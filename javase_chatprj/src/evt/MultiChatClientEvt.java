package evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import view.MultiChatClientJoinPerson;
import view.MultiChatClientView;

public class MultiChatClientEvt extends WindowAdapter implements ActionListener, Runnable {
	private MultiChatClientView mccv;
	private Socket client;
	private DataInputStream readStram;
	private DataOutputStream writeStream;
	private Thread threadMsg;
	private String nick;
	private String[] joinPeoples;

	public MultiChatClientEvt(MultiChatClientView mccv) {
		this.mccv = mccv;
	}

	@Override
	public void run() {
		if (readStram != null) {
			try {
				String revMsg = "";
				JScrollPane jsp = mccv.getJspTalkDisplay();
				while (true) {// �������� �������� �޼����� �о�鿩
					revMsg = readStram.readUTF();

					if (!joinPeoples(revMsg)) {// ������ �ĺ� ���� �޼������ ü���� �о���� �ʴ´�.
						// ä��â�� �Ѹ���.
						mccv.getJtaTalkDisplay().append(revMsg + "\n");
						// ��ũ�ѹٸ� ���� �Ʒ��� �̵�
						jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
					}
				}
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mccv, "������ ����Ǿ����ϴ�.");
				ie.printStackTrace();
			}
		}
	}

	public void connectToServer() throws UnknownHostException, IOException {
		if (client == null) {
			nick = mccv.getJtfNick().getText().trim();
			if (nick.equals("")) {
				JOptionPane.showMessageDialog(mccv, "��ȭ���� �Է��� �ּ���.");
				mccv.getJtfNick().requestFocus();
				return;
			}
			if (nick.contains(",")) {
				JOptionPane.showMessageDialog(mccv, "��ȭ�� ,�� ����� �� �����ϴ�");
				mccv.getJtfNick().requestFocus();
				return;
			}

			int selectCharRoomForServerPort = mccv.getSelectChatRoom();// Ŭ���̾�Ʈ ����� ������ư���� �޾ƿ� �� ���� ��ư
			String serverIp = "211.63.89.135"; // ���� ���� IP
//			String serverIp = mccv.getJtfServerIp().getText().trim();
//			client = new Socket(serverIp, 35001); // �Է��� ip address�� ��ǻ�Ϳ� ����.
			switch (selectCharRoomForServerPort) {
			case 1:// 1������
				client = new Socket(serverIp, 35000); // �Է��� ip address�� ��ǻ�Ϳ� ����.
				break;
			case 2:// 2������
				client = new Socket(serverIp, 35001);
				break;
			case 3:// 3������
				client = new Socket(serverIp, 35002);
				break;
			case 4:// 4������
				client = new Socket(serverIp, 35003);
				break;
			}

			// ��Ʈ��
			readStram = new DataInputStream(client.getInputStream());
			writeStream = new DataOutputStream(client.getOutputStream());

			// ��ȭ���� ������ ������.
			writeStream.writeUTF(nick);
			writeStream.flush();

			mccv.getJtaTalkDisplay().setText("������ �����Ͽ����ϴ�.\n��ſ� ä�õǼ���.\n");

			// �޼��� �б�
			threadMsg = new Thread(this);
			threadMsg.start();

		} else {
			JOptionPane.showMessageDialog(mccv, client.getInetAddress().getHostAddress() + "������ �̹� ���� ���Դϴ�.");
		}
	}

	/**
	 * ������ �޼����� ������ ��
	 * 
	 * @throws IOException
	 */
	public void sendMsg() throws IOException {
		if (writeStream != null) {
			JTextField jtf = mccv.getJtfTalk();
			// JTF�� �Է��� �޼����� �о���δ�.
			String msg = jtf.getText().trim();
			// String nick = mccv.getJtfNick().getText().trim();
			if (!msg.equals("")) {
				// ��Ʈ���� ����
				writeStream.writeUTF("[ " + nick + " ] : " + msg);
				// ������ ����
				writeStream.flush();
			}
			jtf.setText("");
		}
	}

	public void capture() throws IOException {
		switch (JOptionPane.showConfirmDialog(mccv, "��ȭ ������ �����Ͻðڽ��ϱ�?")) {
		case JOptionPane.OK_OPTION:
			// ��Ʈ���� ����Ͽ� ����
			File saveDir = new File("c:/dev/chat");
			saveDir.mkdirs();
			File saveFile = new File(saveDir.getAbsolutePath() + "/java_chat[" + System.currentTimeMillis() + "].dat");
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(saveFile));
				bw.write(mccv.getJtaTalkDisplay().getText());// ��Ʈ���� ��ȭ���� ���
				bw.flush();// ��Ʈ���� ��ϵ� ������ ����
				JOptionPane.showMessageDialog(mccv, saveDir + "�� ��ȭ������ ��� �Ǿ����ϴ�.");
			} finally {
				if (bw != null) {
					bw.close();
				}
			}
			break;
		}
	}

	/**
	 * ������ ����Ʈ �ۼ� �޼��� �������� ���� �޼����� " a^2d&3#"�� ���ԵǾ� �ִٸ� ü���� �о���� �ʰ� �����ڸ���Ʈ �ۼ�
	 * 
	 * @return
	 */
	public boolean joinPeoples(String msg) {
		boolean flag = false;
		String tempJoinPeoples = "";
		tempJoinPeoples = msg.substring(0, 9);
		if (tempJoinPeoples.equals("  a^2d&3#")) {
			tempJoinPeoples = msg.substring(9, msg.length());
//			System.out.println("������ ��� ���� �޼��� : " + tempJoinPeoples);
			joinPeoples = tempJoinPeoples.split(",");
			flag = true;
		}
		return flag;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mccv.getJbtConnect()) {
			try {
				connectToServer();
			} catch (UnknownHostException uhe) {
				JOptionPane.showMessageDialog(mccv, "������ �� �� �����ϴ�.");
				uhe.printStackTrace();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mccv, "���� ����.");
				ie.printStackTrace();
			}
		}
		if (ae.getSource() == mccv.getJbtCapture()) {
			try {
				if (!mccv.getJtaTalkDisplay().getText().equals("")) {
					capture();
				} else {
					JOptionPane.showMessageDialog(mccv, "������ ��ȭ������ �����ϴ�.");
				}
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mccv, "���Ϸ� �����ϴ� �� ������ �߻��Ͽ����ϴ�.");
				ie.printStackTrace();
			}
		}
		
		if (ae.getSource() == mccv.getJbtChatPersonCheck()) {
			new MultiChatClientJoinPerson(this);
		}

		if (ae.getSource() == mccv.getJbtClose()) {
			mccv.dispose();
		}

		if (ae.getSource() == mccv.getJtfTalk()) {
			try {
				sendMsg();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mccv, "������ ����Ǿ� �޼����� ������ �� �����ϴ�.");
				ie.printStackTrace();
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent we) {
		mccv.dispose();
	}

	@Override
	public void windowClosed(WindowEvent we) {
		try {
			if (readStram != null) {readStram.close();}
			if (writeStream != null) {writeStream.close();}
			if (client != null) {client.close();}
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

	public String[] getJoinPeoples() {
		return joinPeoples;
	}

	public MultiChatClientView getMccv() {
		return mccv;
	}
	
	
}
