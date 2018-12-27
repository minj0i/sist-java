package day1227;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Thread�� ����Ͽ� ���ѷ����� �޼����� �о���̴� �ڵ带
 * ȭ������ΰ� �޼����� ������ �ڵ�� ���ÿ� �����Ų��.
 * @author owner
 */
@SuppressWarnings("serial")
public class SimpleThreadChatClient extends JFrame implements ActionListener, Runnable {

	private JTextArea jta;
	private JTextField jtf;
	private JScrollPane jsp;
	
	private Socket client; // ������ �����ϱ� ����
	private DataInputStream readStream; // ������ �����͸� �б����� ��Ʈ��
	private DataOutputStream writeStream; // ������ �����͸� ���������� ��Ʈ��

	private String serverNick; //������ ��ȭ��
	private String clientNick; //Ŭ���̾�Ʈ�� ��ȭ��
	
	public SimpleThreadChatClient() {
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
		jsp = new JScrollPane(jta);

		add("Center", jsp);
		add("South", jtf);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}// windowClosing
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					close();
					System.exit(0); //�ٷ� ���̰������ close()�� ���� ��ߵ�
				} catch (IOException ie) {
					ie.printStackTrace();
				}//end catch
			}
		});


		setBounds(100, 100, 300, 400);
		setVisible(true);
		jtf.requestFocus();// Ŀ���� jtf�� ��ġ��Ų��.
		
//		try {
//			connectToServer();
//			//Thread�� ���� Ŭ������ has a ����� ����
//			Thread t = new Thread(this);
//			//Thread ����
//			t.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
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
		clientNick = JOptionPane.showInputDialog("��ȭ�� �Է�");
		// 2.
		client = new Socket("211.63.89.144", 65535);
		
		// 4. ��Ʈ������
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
		
		//������ ��ȭ�� ����
		writeStream.writeUTF(clientNick);
		jta.setText("��ȭ�濡 "+clientNick+"���� ����\n");
		//������ ��ȭ���� ����
		serverNick=readStream.readUTF();
		
	}// connectToServer

	/**
	 * �������� �������� �޼����� ���ѷ����� �о� ���δ�.
	 */
	@Override
	public void run() /*throws IOException*/ {
		String revMsg = "";
		if(readStream!=null) {
			
		try {
		while (true) {
			revMsg = readStream.readUTF();
			// ��ȭâ�� �о���� �޼����� ���
			jta.append("["+serverNick+"]: " + revMsg + "\n\r");
			jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
		} // end while
		}catch(IOException ie) {
			JOptionPane.showMessageDialog(this, serverNick+"�Բ��� ����Ͽ����ϴ�.");
			ie.printStackTrace();
		}//end catch
		}//end if
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
		jta.append("["+clientNick+"]:"+sendMsg+"\n");
		// T.F�� ������ �����Ѵ�.
		jtf.setText("");
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}// sendMsg

	public static void main(String[] args) {
//		new SimpleThreadChatClient();
		SimpleThreadChatClient stcc = new SimpleThreadChatClient();
		try {
			stcc.connectToServer();
			//�޼����� ���ÿ� �о���ϱ� ������ Thread�� ó��
			Thread t= new Thread(stcc);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// main

}// class
