/*package kr.co.sist.chat.server.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import kr.co.sist.chat.server.helper.MultiChatServerHelper;
import kr.co.sist.chat.server.view.MultiChatServerView;

public class MultiChatServerEvt2 extends WindowAdapter implements ActionListener,Runnable{

   private MultiChatServerView mcsv;
   private Thread threadServer;//접속자에 대한 처리를 하기 위한 Thread
   private ServerSocket server;//PORT 열기
   private List<MultiChatServerHelper> listClient;//모든 접속자를 관리할 List
   
   
   public MultiChatServerEvt(MultiChatServerView mcsv) {
      this.mcsv=mcsv;//<View 와 Evt class의 관계는 has a 관계인것.
      listClient = new ArrayList<MultiChatServerHelper>();
      //<list의 특징 : 가변자료형,순차적,검색가능,중복가능
      //<Set : 중복ㄴㄴ,순차ㄴㄴ
      //<Map : 키와 값의 쌍,키는 중복ㄴㄴ(유일),값은 중복가능.
      
      
   }//MultiChatServerEvt
   
   @Override
   public void run() {//<부르려면 start를 불러야 하는데...
      //서버소켓을 열고 접속자 소켓을 받는다.
      try {
         server=new ServerSocket(35000);
         //Port는 0~65535개가 열릴 수 있다.(<1024이하는 이미 고정적으로 열려있는경우가 많음(웰론포트))
         DefaultListModel<String> dlmTemp=mcsv.getDlmChatList();
         dlmTemp.addElement("서버가 35000 PORT를 열고 가동중...");
         
         Socket someClient=null;//<객체초기화 값..? null
         //접속자 소켓을 저장할 객체
//         InetAddress ia=null;//접속자의 ip Address(내구간의 ip주소체계?)를 얻기 위한 객체
         //<특정 ip로 들어오는 사람 차단가능하게 됨.
         
         MultiChatServerHelper mcsh=null;
         //접속자 소켓을 받아 스트림을 연결하고, 대화를 읽거나 모든 접속자에게 전송하는 일.
//         while(true) {//<보여지는 뷰와 이벤트는 따로 움직이기 때문에 무한루프여도 상관없다.
         for(int cnt=0; ;cnt++) {//조건이 없으니 무한루프
            //<제한을 걸수도 있다 리스트가 20이니~?
            someClient=server.accept();
//            ia=someClient.getInetAddress();
//            dlmTemp.addElement("["+ia+"]"+"접속자 접속.");
            //<객체를호출하면출력하면 호출되는 method=>hint,주소..?t~g? toString!!!
            //<자식에서 오버라이딩을 해서 클레스가 제공하는 메세지가 나오게도 가능..한게 toString object에 존재.
            
            //소켓, 서버의 화면, 접속 순서를 할당하여 도와주는 ..Helper class 생성
            mcsh=new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient, mcsv.getJspList());//<인스턴스화
            //생성된 같은 이름의 소켓객체를 여러개 관리하기위해 List에 추가.
            listClient.add(mcsh);
//            //Helper에서 리스트를 사용할 수 있도록 할당.
//            mcsh.setConnectList(listClient);
            
            //접속자의 메세지를 읽어들이기 위한 Thread 시작
            mcsh.start();//<상속의 장점 : 코드의 재사용성
            
         }//end while
         
      } catch (IOException ie) {
         ie.printStackTrace();
      }//end catch
      
   }//run
   
   @Override
   public void windowClosing(WindowEvent we) {
      mcsv.dispose();   //<Closed를 부른다.
   }//windowClosing
   
   @Override
   public void windowClosed(WindowEvent we) {
      //<serversocket을 끊는 부분 정의
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
            threadServer.start();//start()=>run()불려짐.
            //<이렇게 되면 한번만 불려질것@!
         }else {
            JOptionPane.showMessageDialog(mcsv, "채팅 서버가 이미 가동중 입니다.");
         }//end else
      }//end if
      
      if(ae.getSource()==mcsv.getJbtCloseServer()) {
         switch (JOptionPane.showConfirmDialog(mcsv,
                     "채팅 서버를 종료 하시겠습니까?\n종료하시면 모든 접속자의 연결이 끊어집니다.")) {
         case JOptionPane.OK_OPTION:mcsv.dispose();
         }//end switch
      }//end if
   }//actionPerformed
      
}//class*/