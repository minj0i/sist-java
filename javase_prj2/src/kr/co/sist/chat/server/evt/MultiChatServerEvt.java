package kr.co.sist.chat.server.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
//import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import kr.co.sist.chat.server.helper.MultiChatServerHelper;
import kr.co.sist.chat.server.view.MultiChatServerView;

public class MultiChatServerEvt extends WindowAdapter implements ActionListener,Runnable{

	private MultiChatServerView mcsv;
	private Thread threadServer;//�����ڿ� ���� ó���� �ϱ� ���� Thread
	private ServerSocket server;//PORT ����
	private List<MultiChatServerHelper> listClient;//��� �����ڸ� ������ List
	
	
	public MultiChatServerEvt(MultiChatServerView mcsv) {
		this.mcsv=mcsv;//<View �� Evt class�� ����� has a �����ΰ�.
		listClient = new ArrayList<MultiChatServerHelper>();
		//<list�� Ư¡ : �����ڷ���,������,�˻�����,�ߺ�����
		//<Set : �ߺ�����,��������
		//<Map : Ű�� ���� ��,Ű�� �ߺ�����(����),���� �ߺ�����.
		
		
	}//MultiChatServerEvt
	
	@Override
	public void run() {//<�θ����� start�� �ҷ��� �ϴµ�...
		//���������� ���� ������ ������ �޴´�.
		try {
			server=new ServerSocket(35000);
			//Port�� 0~65535���� ���� �� �ִ�.(<1024���ϴ� �̹� ���������� �����ִ°�찡 ����(������Ʈ))
			DefaultListModel<String> dlmTemp=mcsv.getDlmChatList();
			dlmTemp.addElement("������ 35000 PORT�� ���� ������...");
			
			Socket someClient=null;//<��ü�ʱ�ȭ ��..? null
			//������ ������ ������ ��ü
//			InetAddress ia=null;//�������� ip Address(�������� ip�ּ�ü��?)�� ��� ���� ��ü
			//<Ư�� ip�� ������ ��� ���ܰ����ϰ� ��.
			
			MultiChatServerHelper mcsh=null;
			//������ ������ �޾� ��Ʈ���� �����ϰ�, ��ȭ�� �аų� ��� �����ڿ��� �����ϴ� ��.
//			while(true) {//<�������� ��� �̺�Ʈ�� ���� �����̱� ������ ���ѷ������� �������.
			for(int cnt=0; ;cnt++) {//������ ������ ���ѷ���
				//<������ �ɼ��� �ִ� ����Ʈ�� 20�̴�~?
				someClient=server.accept();
//				ia=someClient.getInetAddress();
//				dlmTemp.addElement("["+ia+"]"+"������ ����.");
				//<��ü��ȣ���ϸ�����ϸ� ȣ��Ǵ� method=>hint,�ּ�..?t~g? toString!!!
				//<�ڽĿ��� �������̵��� �ؼ� Ŭ������ �����ϴ� �޼����� �����Ե� ����..�Ѱ� toString object�� ����.
				
				//����, ������ ȭ��, ���� ������ �Ҵ��Ͽ� �����ִ� ..Helper class ����
				mcsh=new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient, mcsv.getJspList());//<�ν��Ͻ�ȭ
				//������ ���� �̸��� ���ϰ�ü�� ������ �����ϱ����� List�� �߰�.
				listClient.add(mcsh);
//				//Helper���� ����Ʈ�� ����� �� �ֵ��� �Ҵ�.
//				mcsh.setConnectList(listClient);
				
				//�������� �޼����� �о���̱� ���� Thread ����
				mcsh.start();//<����� ���� : �ڵ��� ���뼺
				
			}//end while
			
		} catch (IOException ie) {
			ie.printStackTrace();
		}//end catch
		
	}//run
	
	@Override
	public void windowClosing(WindowEvent we) {
		mcsv.dispose();	//<Closed�� �θ���.
	}//windowClosing
	
	@Override
	public void windowClosed(WindowEvent we) {
		//<serversocket�� ���� �κ� ����
		try {
			if(server!=null){server.close();}//end if
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//windowClosed

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mcsv.getJbtOpenServer()) {
			if(threadServer==null) {
				threadServer=new Thread(this);
				threadServer.start();//start()=>run()�ҷ���.
				//<�̷��� �Ǹ� �ѹ��� �ҷ�����@!
			}else {
				JOptionPane.showMessageDialog(mcsv, "ä�� ������ �̹� ������ �Դϴ�.");
			}//end else
		}//end if
		
		if(ae.getSource()==mcsv.getJbtCloseServer()) {
			switch (JOptionPane.showConfirmDialog(mcsv,
							"ä�� ������ ���� �Ͻðڽ��ϱ�?\n�����Ͻø� ��� �������� ������ �������ϴ�.")) {
			case JOptionPane.OK_OPTION:mcsv.dispose();
			}//end switch
		}//end if
	}//actionPerformed
		
}//class
