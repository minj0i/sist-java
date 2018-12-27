package day1227;

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

/**
 * Thread를 도입하여 메세지를 읽는 코드를 화면, 메세지를 보내는 코드와 동시에 처리한다.
 * @author owner
 */
@SuppressWarnings("serial")
public class SimpleThreadChatServer extends JFrame implements ActionListener, Runnable {

	private JTextArea jta;
	private JTextField jtf;
	private JScrollPane jsp;
	
	private ServerSocket server;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;

	private String serverNick;
	private String clientNick;
	
	public SimpleThreadChatServer() {
		super(":::::::::::::::채팅서버::::::::::::::::::");

		jta = new JTextArea();
		jta.setBorder(new TitledBorder("대화내용"));
		// 대화내용변경불가
		jta.setEditable(false);
		
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);

		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("대화입력"));

		// 스크롤붙이기
		jsp = new JScrollPane(jta);

		add("Center", jsp);
		add("South", jtf);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("종료");
				dispose();// 화면이 종료된 후 -> windowClsoed 호출
				// System.exit(0); //현재 JVM과 관련있는 모든 인스턴스가 죽음//올바르지 않음
			}// windowClosing

			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("영혼~~~~");
				try {
				
					close();// 클라이언트와 연결하고있는 스트림, 소켓, 서버소켓 종료
				
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}// windowClosed

		});


		setBounds(100, 100, 300, 400);
		setVisible(true);
		jtf.requestFocus();// 커서를 jtf에 위치시킨다.
		
//		 try {
//	         openServer();
//	         //has a : 메세지를 읽는 코드를 Thread로 처리하면 어디에있든 동작을 하게 된다.
//	         Thread t = new Thread(this);
//	         t.start(); //start에 의해 run 호출
//	      } catch (SocketException se) {
//	         System.out.println("접속자가 들어오기 전에 종료되었습니다."+se.getMessage());
//	      } catch (IOException e) {
//	         JOptionPane.showMessageDialog(this, "서버가동 실패! 메세지를 읽어들일 수 없습니다.");
//	         e.printStackTrace();
//	      }//end catch
		
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
			// 위에서 예외가 터지더라도 서버가 끊김
			if (server != null) {
				server.close();
			} // end if
		} // end finally
	}// close

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			if (writeStream != null) {// 접속자가 존재하여 스트림이 생성된 경우에만
				sendMsg();// 메세지를 보낸다.
			} else {
				JOptionPane.showMessageDialog(this, "대화상대가 없습니다.");
				jtf.setText("");
			} // end if
		} catch (IOException ie) {
			ie.printStackTrace();
		} // end catch
	}// actionPerformed

	/**
	 * 1. ServerSocket 생성하고(PORT열림) 2. 접속자소켓이 들어오면(accept) 대화를 주고받을수 있도록 3. Stream을
	 * 연결(DIS, DOS)
	 */
	public void openServer() throws IOException, SocketException {
		serverNick = JOptionPane.showInputDialog("대화명을 입력하세요");
		// 1.
		server = new ServerSocket(65535);
		jta.setText("서버가동 중... 접속자를 기다립니다.\n");
		// 3.
		client = server.accept();
		jta.append(/*clientNick*/"Client 접속\n");
		// 4. 스트림연결
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());

		//클라이언트 닉 받기
		clientNick = readStream.readUTF();
		//내 닉을 보낸다.
		writeStream.writeUTF(serverNick);
		jta.setText("대화방에 "+serverNick+"으로 입장\n");
		
	}// openServer

	/**
	 * 접속자에게 메세지를 보내는 일
	 * 
	 * @throws IOException
	 */
	public void sendMsg() throws IOException {
		// T.F의 값을 가져와서
		String msg = jtf.getText().trim();
		// 스트림에 기록하고
		writeStream.writeUTF(msg);
		// 스트림의 내용을 목적지로 분출
		writeStream.flush();
		// 내가 쓴 내용을 내 화면에 출력하고
		jta.append("["+serverNick+"]" + msg + "\n\r");
		// 입력이 편하도록 jtf를 초기화시킨다.
		jtf.setText("");
		//스크롤바
		 jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}// sendMsg

	/**
	 * 접속자가 보내오는 메세지를 계속 읽어들어야 한다.
	 */
	public void run(){
	      String msg="";
	      if(readStream != null) {
	         try {
	            while(true) {
	            //메세지를 읽어들여
	            msg=readStream.readUTF();
	            //대화창에 출력
	            jta.append("["+clientNick+"] :"+msg+"\n");
	            //메세지T.A에 추가되면 JScrollPane의 스크롤바의 값을
	            //J.S.P의 최고값으로 변경해준다.
	            jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	            }//end while
	         } catch (IOException ie) {
	            JOptionPane.showMessageDialog(this, clientNick+"님이 퇴실하였습니다.");
	            ie.printStackTrace();
	         }
	      }//end if
	   }//revMsg


	public static void main(String[] args) {
//		new SimpleThreadChatServer();
		SimpleThreadChatServer stcs = new SimpleThreadChatServer();
		try {
			stcs.openServer();
			//Thread와 stcs객체를 has a 관계로 설정
			Thread t = new Thread(stcs);
			//메세지를 읽는 코드를 Thread로 처리
			t.start();
		} catch (SocketException se) {
			System.err.println("접속자가 들어오기 전 종료" + se.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(stcs, "서버가동 실패!! 메세지를 읽어들일 수 없습니다.");
			e.printStackTrace();
		}
	}// main

}// class
