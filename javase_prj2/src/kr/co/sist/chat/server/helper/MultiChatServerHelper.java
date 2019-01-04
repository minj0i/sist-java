package kr.co.sist.chat.server.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * 서버에서 생성하며 접속자소켓에 스트림을 얻어와서 관리하는 클래스<br>
 * 접속자가 존재하면 접속자 소켓에서 얻어낸 스트림에서 메세지를 무한루프로 읽어들이고 모든접속자에게 메세지 출력
 * @author owner
 */
public class MultiChatServerHelper extends Thread{
	//<소켓만 받아선 안돼..
	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private DefaultListModel<String> dlm;
	private int cnt;
	private List<MultiChatServerHelper> connectList;//리스트에 저장하는 하나가 클라이언트 하나하나 인것.
	
	private JFrame jf;
	private JScrollPane jsp;
	private String nick;
	
	/**
	 * 접속자 소켓을 받아서 스트림을 얻어 메세지를 읽거나 보낼 수 있는 상태로 만든다.
	 * @param socket 접속자 소켓
	 * @param dlm 접속자 관리창을 사용하기 위한 Model객체
	 * @param cnt 접속 순서
	 */
	public MultiChatServerHelper(Socket socket, DefaultListModel<String> dlm, int cnt,JFrame jf,List<MultiChatServerHelper> list, JScrollPane jsp) {
		someClient=socket;//<someClient에는 왜 this를 안붙였을까요?아래꺼엔 붙이고??
						  //<매개변수와 이름이 달라서?!아하...식별하기 위함.
		this.dlm=dlm;
		this.cnt=cnt;
		this.jf=jf;
		connectList=list;//<내가 들어왔음을 접속자에게 알리는?
		this.jsp=jsp;
		
		//스트림 얻기//<보내고 읽을 수 있는 상태가 된것
		try {
			readStream=new DataInputStream(someClient.getInputStream());
			writeStream=new DataOutputStream(someClient.getOutputStream());
			//<일이 겹쳐서? throws 아니고 try catch로 
			
			//접속자가 보내오는 nick을 받는다.
			nick=readStream.readUTF();
			//서버창에 접속메세지를 출력
			dlm.addElement("["+someClient.getInetAddress()+"/"+nick+"] 님이 접속하셨습니다.");//<접속 시간까지도 가능해짐.
			
			//서버에 접속한 모든 접속자에게 메세지를 출력(<누가들어왔어~!)
			broadcast("["+cnt+"] 번째 접속자가 ["+nick+"]으로 채팅방에 접속하였습니다.");
			jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
			
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(jf, "접속자 연결 중 문제 발생...");
			ie.printStackTrace();
		}//end catch
		
	}//MultiChatServerHelper
	
//	public void setConnectList(List<MultiChatServerHelper> list) {
//		connectList=list;
//	}//serConnectList
	
	@Override
	public void run() {
		if(readStream!=null) {
			try {//<얘가 나가게 try를 while밖으로.
				
				String revMsg="";
				while(true) {
					//서버에서 보내오는 모든 메세지를 읽어서, 모든 접속자에게 뿌린다.
					revMsg=readStream.readUTF();
					broadcast(revMsg);
				}//end while
			} catch (IOException ie) {
				//접속자가 퇴실하면 해당 접속자를 리스트에서 삭제 한다. 후엔 서버창에 남겨주도 삭제된애 빼고 모든접속자에게 보내준다.
				connectList.remove(this);//<cnt가 안되는 이유는 list에 여러명이 들어오는데, 앞에사람이 나가면 인덱스가 변경됨으로 안됨.(나를 지우라고 하면 됨)
				
				//메세지를 읽어들이지 못하는 상태라면 접속자가 연결을 종료한 상태.라 관리자 창에 뿌려준다.
				dlm.addElement(cnt+"번째/"+nick+" 접속자 퇴실");
				broadcast("["+nick+"]님이 퇴실하였습니다.");
				
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				
				ie.printStackTrace();
			}//end catch
		}//end if
	}//run
	
	/**
	 * 모든 접속자에게 메세지를 뿌려주는 일.
	 * synchronized : MultiThread에서 동시 호출을 막는다.(동기화처리)-stringbuffer?,arraylist의반대?,vector,hashtable(느려짐)
	 * @param msg
	 */
	public synchronized void broadcast(String msg) {
		MultiChatServerHelper mcsh=null;
		try {
			for(int i=0; i<connectList.size(); i++) {//<모든접속자가 나올것.
				mcsh = connectList.get(i);//list에서 Helper객체를 얻고
				mcsh.writeStream.writeUTF(msg);//출력 스트림에 출력
				mcsh.writeStream.flush();//목적지로 분출
			}//end for
		} catch (IOException ie) {//<보낼수없는상태에요 라는건 연결이 끊긴것
			JOptionPane.showMessageDialog(jf, "["+cnt+"] 번째 접속자에게 메세지를 보낼 수 없습니다.");
			ie.printStackTrace();
		}//end catch
		
	}//broadcast
	
}//class
