package kr.co.sist.chat.client.evt;

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

import kr.co.sist.chat.client.view.MultiChatClientView;

public class MultiChatClientEvt extends WindowAdapter implements ActionListener,Runnable{

	private MultiChatClientView mccv;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private Thread threadMsg;
	private String nick;//<��ȭ�� ���ٲٰ�
	
	public MultiChatClientEvt(MultiChatClientView mccv) {
		this.mccv=mccv;
		
	
	}//MultiChatClientEvt
	
	
	@Override
	public void run() {
		if(readStream!=null) {
			try {
				String revMsg="";
				JScrollPane jsp=mccv.getJspTalkDisplay();
				
				while(true) {//�������� �������� �޼����� �о�鿩
						revMsg=readStream.readUTF();
						//ä�ù濡 �Ѹ���.
						mccv.getJtaTalkDisplay().append(revMsg+"\n");
						//��ũ�ѹٸ� ���� �Ʒ��� �̵�
						jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum() );
				}//end while
			} catch (IOException e) {
				JOptionPane.showMessageDialog(mccv, "������ ����Ǿ����ϴ�.");
				e.printStackTrace();
			}//end catch
		}//end if
	}//run
	
	@Override
	public void windowClosing(WindowEvent e) {
		mccv.dispose();
	}//windowClosing

	@Override
	public void windowClosed(WindowEvent e) {
		try {
			if(readStream!=null) {readStream.close();}
			if(writeStream!=null) {writeStream.close();}
			if(client!=null) {client.close();}
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			System.exit(0);
			//Ȥ��,,���� �ڹٰ�ü�� ������ ��� �ν��Ͻ� ����
		}//end finally
	}//windowClosed
	
	public void connectToServer() throws UnknownHostException, IOException {
		if(client==null) {
			nick=mccv.getJtfNick().getText().trim();
			
			if(nick.equals("")) {//<nick�� ������~~
				JOptionPane.showMessageDialog(mccv, "��ȭ���� �Է��� �ּ���.");
				mccv.getJtfNick().requestFocus();
				return;
			}//end if
			
			//<������ �ּҰ� �ʿ� (���� �����ϱ� ������)
			String serverIp=mccv.getJtfServerIp().getText().trim();
			client=new Socket(serverIp, 36004);//�Է��� ip address�� ��ǻ�Ϳ� ����
			//��Ʈ��
			readStream=new DataInputStream(client.getInputStream());
			writeStream=new DataOutputStream(client.getOutputStream());
			
			//��ȭ���� ������ ������.
			writeStream.writeUTF(nick);
			writeStream.flush();//<��ȭ���� ������ ���´�
			
			mccv.getJtaTalkDisplay().setText("������ �����Ͽ����ϴ�.\n��ſ� ä�õǼ���\n");
			
			//�޼��� �б�
			threadMsg=new Thread(this);
			threadMsg.start();
			
		}else {//<�̹� ������ �ִ� ���¿��� ���ӹ�ư�� ������
			JOptionPane.showMessageDialog(mccv, 
							client.getInetAddress().getHostAddress()+"������ �̹� ������ �Դϴ�.");
		}//end else
	}//connectToServer
	
	/**
	 * ������ �޼����� ������ ��
	 * @throws IOException 
	 */
	public void sendMsg() throws IOException {
		if(writeStream!=null) {
			//<������� �������¿����� ���ܸ� �߻��ǹǷ�
			JTextField jtf=mccv.getJtfTalk();
			//JTF�� �Է��� �޼����� �о� ���δ�.
			String msg=jtf.getText().trim();
			
			if(!msg.equals("")/*!msg.isEmpty()*/) {
				//��Ʈ���� ���� ���ܴ� ��������
				writeStream.writeUTF("["+nick+/*"] ["+client.getInetAddress().getHostAddress()+"]"*/"]"+msg);
				//�������� ����
				writeStream.flush();
				//<�������� �Է��� ���ϰ� �ϱ�����
				jtf.setText("");
			}//end if
					
		}//end if
	}//sendMsg
	
	public void capture() throws IOException {
		switch (JOptionPane.showConfirmDialog(mccv, "��ȭ������ �����Ͻðڽ��ϱ�?")) {
		case JOptionPane.OK_OPTION:
			//��Ʈ���� ����Ͽ� ����
			File saveDir=new File("C:/dev/chat");
			saveDir.mkdirs();
			File saveFile=new File(saveDir.getAbsolutePath()+"/java_chat["+System.currentTimeMillis()+"].dat");
			
			BufferedWriter bw=null;
			try {
				bw=new BufferedWriter(new FileWriter(saveFile));
				bw.write(mccv.getJtaTalkDisplay().getText());//��Ʈ���� ��ȭ������ ���
				bw.flush();//��Ʈ���� ��ϵ� ������ ����
				JOptionPane.showMessageDialog(mccv, saveDir+"�� ��ȭ ������ ��� �Ǿ����ϴ�.");
			}finally {
				if(bw!=null) {bw.close();}//end if
			}//end finally
		}//end switch
		
	}//capture
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mccv.getJbtConnect()) {
			try {
				connectToServer();
			} catch (UnknownHostException uhe) {
				JOptionPane.showMessageDialog(mccv, "������ �� �� �����ϴ�.");
				uhe.printStackTrace();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mccv, "���� ����.");
				ie.printStackTrace();
			}//end catch
		}//end if
		if(ae.getSource()==mccv.getJbtClose()) {
			mccv.dispose();
		}//end if
		if(ae.getSource()==mccv.getJbtCapture()) {
			try {
				if(!mccv.getJtaTalkDisplay().getText().equals("")) {
					capture();
				}else {
					JOptionPane.showMessageDialog(mccv, "������ ��ȭ ������ �����ϴ�.");
				}//end else
			} catch (IOException e) {
				JOptionPane.showMessageDialog(mccv, "���Ϸ� �����ϴ� �� ������ �߻��Ͽ����ϴ�.");
				e.printStackTrace();
			}//end catch
		}//end if
		
		if(ae.getSource()==mccv.getJtfTalk()) {
			try {
				sendMsg();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(mccv, "������ ����Ǿ� �޼����� ������ �� �����ϴ�.");
				e.printStackTrace();
			}//end catch
		}//end if
	}//actionPerformed
	
	
}//class
