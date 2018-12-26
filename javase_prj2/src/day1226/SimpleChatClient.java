package day1226;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleChatClient extends JFrame implements ActionListener {

	private JTextArea jta;
	private JTextField jtf;

	private Socket client; // ������ �����ϱ� ����
	private DataInputStream readStream; // ������ �����͸� �б����� ��Ʈ��
	private DataOutputStream writeStream; // ������ �����͸� ���������� ��Ʈ��

	public SimpleChatClient() {
		super(":::::::::::::::ä�� Ŭ���̾�Ʈ::::::::::::::::::");

		jta = new JTextArea();
		jta.setBorder(new TitledBorder("��ȭ����"));
		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("��ȭ�Է�"));
		// ��ȭ���뺯��Ұ�
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);

		// ��ũ�Ѻ��̱�
		JScrollPane jsp = new JScrollPane(jta);

		add("Center", jsp);
		add("South", jtf);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}// windowClosing
		});


		setBounds(100, 100, 300, 400);
		setVisible(true);
		jtf.requestFocus();// Ŀ���� jtf�� ��ġ��Ų��.
		
		try {
			connectToServer();
			readMsg();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		jtf.addActionListener(this);
	}// SimpleChatServer

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sendMsg();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}// actionPerformed

	public void close() throws IOException {
		try {
			if (readStream != null) {
				readStream.close();
			}
			if (writeStream != null) {
				writeStream.close();
			}
		} finally {
			if (client != null) {
				client.close();
			}
		}
	}// close

	/**
	 * 2. ������ �����Ͽ� ������ �����ϰ� ��ȭ�� �аų� ������ ���� 4. ��Ʈ���� �����Ѵ�.
	 * 
	 * @throws IOException
	 */
	public void connectToServer() throws IOException {
		// 2.
		client = new Socket("127.0.0.1", 65535);
		// 4. ��Ʈ������
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
	}// connectToServer

	/**
	 * �������� �������� �޼����� ���ѷ����� �о� ���δ�.
	 */
	public void readMsg() throws IOException {
		String revMsg = "";
		while (true) {
			revMsg = readStream.readUTF();
			// ��ȭâ�� �о���� �޼����� ���
			jta.append("[server �޼���]: " + revMsg + "\n\r");

		} // end while
	}// readMsg

	/**
	 * �ۼ��� �޼����� ������ ������ ��
	 */
	public void sendMsg() throws IOException {
		// �ۼ��� �޼����� �����ͼ�
		String sendMsg = jtf.getText().trim();
		// ��Ʈ���� ����ϰ�
		writeStream.writeUTF(sendMsg);
		// ��Ʈ���� ������ �������� ����
		writeStream.flush();
		// �ۼ��� �޼����� ä��â�� �ø���.
		jta.append("[client �޼���]:"+sendMsg+"\n");
		// T.F�� ������ �����Ѵ�.
		jtf.setText("");
	}// sendMsg

	public static void main(String[] args) {
		new SimpleChatClient();
//		SimpleChatClient scc = new SimpleChatClient();
//		try {
//			scc.connectToServer();
//			scc.readMsg();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}// main

}// class
