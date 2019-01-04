package evt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * �������� �����ϸ� ������ ���Ͽ� ��Ʈ���� ���ͼ� �����ϴ� Ŭ����.<br>
 * �����ڰ� �����ϸ� ������ ��Ĺ�� �� ��Ʈ������ �޼����� ���ѷ����� �о���̰� ��� �����ڿ��� �޼����� ���
 * 
 * @author owner
 */
public class MultiChatServerHelper extends Thread {
	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private DefaultListModel<String> dlm;
	private int cnt;
	private List<MultiChatServerHelper> connectList;
	private JFrame jf;
	private JScrollPane jsp;
	private String nick;
	private String allPeople;

	/**
	 * �����ڼ����� �޾Ƽ� ��Ʈ���� ��� �޼����� �аų� ���� �� �ִ� ���·� �����.
	 * 
	 * @param socket �����ڼ���
	 * @param dlm    ������ ����â�� ����ϱ� ���� Model��ü
	 * @param cnt    ������ ����
	 */
	public MultiChatServerHelper(Socket socket, DefaultListModel<String> dlm, int cnt, JFrame jf,
			List<MultiChatServerHelper> list, JScrollPane jsp) {
		someClient = socket;
		this.dlm = dlm;
		this.cnt = cnt;
		this.jf = jf;
		connectList = list;
		this.jsp = jsp;

		// ��Ʈ�����
		try {
			readStream = new DataInputStream(someClient.getInputStream());
			writeStream = new DataOutputStream(someClient.getOutputStream());
			// ������ ������ Ŭ���̾�Ʈ�� �г��� �����ͼ� �����ǿ� �Բ� ������ ��������
			nick = readStream.readUTF();
			dlm.addElement("[ " + someClient.getInetAddress() + " / " + nick + " ] ���� �����Ͽ����ϴ�.");
			// ������ ������ �����ڿ��� �޼����� ���
			broadcast("[ " + cnt + " ] ��° ������ [" + nick + "]���� ä�ù濡 ���� �Ͽ����ϴ�.");
			//chatJoinNick();//���ӽ� ������ ���� 
			
			jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(jf, "������ ���� �� ���� �߻�....");
			ie.printStackTrace();
		}
	}

	@Override
	public void run() {
		if (readStream != null) {
			try {
				String revMsg = "";
				while (true) {// �������� �������� ��� �޼����� �о ��� �����ڿ��� �Ѹ���.
					revMsg = readStream.readUTF();
					broadcast(revMsg);
				}
			} catch (IOException ie) {
				// �����ڰ� ����ϸ� �ش� �����ڸ� ����Ʈ���� �����Ѵ�.
				connectList.remove(this);
				// �޼����� �о������ ���ϴ� ���¶�� �����ڰ� ������ ������ ����
				dlm.addElement(cnt + "��°/" + nick + "������ ���");
				chatJoinNick();//��ǽ� ������ ���� 
				
				broadcast("[ " + nick + " ] ���� �����ڰ� ����Ͽ����ϴ�.");
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());

				ie.printStackTrace();
			}
		}

	}

	/**
	 * ��� �����ڿ��� �޼����� �ѷ��ִ� ��. synchronized : MultiThread���� ����ȣ�� ���� (����ȭ ó��)
	 * 
	 * @param msg
	 */
	public synchronized void broadcast(String msg) {
		MultiChatServerHelper mcsh = null;
		try {
			for (int i = 0; i < connectList.size(); i++) {
				mcsh = connectList.get(i);// list���� Helper ��ü�� ���
				mcsh.writeStream.writeUTF(msg);// ��� ��Ʈ���� ���
				mcsh.writeStream.flush();// �������� ����
			}
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(jf, "[" + cnt + "] ��° �����ڿ��� �޼����� ���� �� �����ϴ�.");
			ie.printStackTrace();
		}
	}

	/**
	 * ������ ��Ȳ�� �������� ���, �������� ������ �־����� ��� �����ڿ��� ������ ��Ȳ�� �ѷ��ִ� ��
	 */
	public synchronized void chatJoinNick() {
		MultiChatServerHelper mcsh = null;
		allPeople = "  a^2d&3#";

		for (int i = 0; i < connectList.size(); i++) {
			mcsh = connectList.get(i);// list���� Helper ��ü�� ���
			allPeople = allPeople + mcsh.nick + ",";
		}

		broadcast(allPeople);
	}

}
