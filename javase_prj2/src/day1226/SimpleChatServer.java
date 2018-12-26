package day1226;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleChatServer extends JFrame implements ActionListener {

	private JTextArea jta;
	private JTextField jtf;

	private ServerSocket server;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;

	public SimpleChatServer() {
		super(":::::::::::::::ä�ü���::::::::::::::::::");

		jta = new JTextArea();
		jta.setBorder(new TitledBorder("��ȭ����"));
		// ��ȭ���뺯��Ұ�
		jta.setEditable(false);
		
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);

		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("��ȭ�Է�"));

		// ��ũ�Ѻ��̱�
		JScrollPane jsp = new JScrollPane(jta);

		add("Center", jsp);
		add("South", jtf);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("����");
				dispose();// ȭ���� ����� �� -> windowClsoed ȣ��
				// System.exit(0); //���� JVM�� �����ִ� ��� �ν��Ͻ��� ����//�ùٸ��� ����
			}// windowClosing

			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("��ȥ~~~~");
				try {
					close();// Ŭ���̾�Ʈ�� �����ϰ��ִ� ��Ʈ��, ����, �������� ����
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}// windowClosed

		});


		setBounds(100, 100, 300, 400);
		setVisible(true);
		jtf.requestFocus();// Ŀ���� jtf�� ��ġ��Ų��.
		try {
			openServer();
			revMsg();
		} catch (SocketException se) {
			System.err.println("�����ڰ� ������ �� ����" + se.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "�������� ����!! �޼����� �о���� �� �����ϴ�.");
			e.printStackTrace();
		}
		jtf.addActionListener(this);
	}// SimpleChatServer

	public void close() throws IOException {
		try {
			if (readStream != null) {
				readStream.close();
			} // end if
			if (writeStream != null) {
				writeStream.close();
			} // end if
			if (client != null) {
				client.close();
			} // end if
		} finally {
			// ������ ���ܰ� �������� ������ ����
			if (server != null) {
				server.close();
			} // end if
		} // end finally
	}// close

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			if (writeStream != null) {// �����ڰ� �����Ͽ� ��Ʈ���� ������ ��쿡��
				sendMsg();// �޼����� ������.
			} else {
				JOptionPane.showMessageDialog(this, "��ȭ��밡 �����ϴ�.");
				jtf.setText("");
			} // end if
		} catch (IOException ie) {
			ie.printStackTrace();
		} // end catch
	}// actionPerformed

	/**
	 * 1. ServerSocket �����ϰ�(PORT����) 2. �����ڼ����� ������(accept) ��ȭ�� �ְ������ �ֵ��� 3. Stream��
	 * ����(DIS, DOS)
	 */
	public void openServer() throws IOException, SocketException {
		// 1.
		server = new ServerSocket(65535);
		jta.setText("�������� ��... �����ڸ� ��ٸ��ϴ�.\n");
		// 3.
		client = server.accept();
		jta.append("Client ����\n");
		// 4. ��Ʈ������
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());

	}// openServer

	/**
	 * �����ڿ��� �޼����� ������ ��
	 * 
	 * @throws IOException
	 */
	public void sendMsg() throws IOException {
		// T.F�� ���� �����ͼ�
		String msg = jtf.getText().trim();
		// ��Ʈ���� ����ϰ�
		writeStream.writeUTF(msg);
		// ��Ʈ���� ������ �������� ����
		writeStream.flush();
		// ���� �� ������ �� ȭ�鿡 ����ϰ�
		jta.append("[ Server �޼��� ]" + msg + "\n\r");
		// �Է��� ���ϵ��� jtf�� �ʱ�ȭ��Ų��.
		jtf.setText("");
	}// sendMsg

	/**
	 * �����ڰ� �������� �޼����� ��� �о���� �Ѵ�.
	 * 
	 * @throws IOException
	 */
	public void revMsg() throws IOException {
		String msg = "";
		while (true) {
			// �޼����� �о�鿩
			msg = readStream.readUTF();
			// ��ȭâ�� ���
			jta.append("[ Client �޼��� ]: " + msg + "\n\r");
		}
	}// revMsg

	public static void main(String[] args) {
		new SimpleChatServer();
//		SimpleChatServer scs = new SimpleChatServer();
//		try {
//			scs.openServer();
//			scs.revMsg();
//		} catch (SocketException se) {
//			System.err.println("�����ڰ� ������ �� ����" + se.getMessage());
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(scs, "�������� ����!! �޼����� �о���� �� �����ϴ�.");
//			e.printStackTrace();
//		}
	}// main

}// class
