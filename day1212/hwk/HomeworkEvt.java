package day1212.hwk;

import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import day1212.FriendsList;

/**
 * Design class와 Has a 관계로 설정된 이벤트처리 클래스
 * @author owner
 */
public class HomeworkEvt extends WindowAdapter implements ActionListener, ItemListener {

	// 이벤트를 처리하기위해 사용되는 모든 컴포넌트는 has a 관계의
	// 객체를 사용하여 처리한다.
	private HomeworkDesign hd;
	
	public HomeworkEvt(HomeworkDesign hd) {
		this.hd = hd;
	}//HomeworkEvt
	
	@Override
	public void windowClosing(WindowEvent e) {
		hd.dispose();
	}// windowClosing

	
	@Override
	//List 이벤트 처리
	public void itemStateChanged(ItemEvent ie) {
	}//itemStateChanged
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//추가:textField에 있던 정보를 List로 이동
		if(ae.getSource()==hd.getBtnAdd()) {
			add();
		}//end if
	}//actionPerformed

	private void add() {
		String name=hd.getTfName().getText();
		String age=hd.getTfAge().getText();
		String address=hd.getTfAddress().getText();
		
		String viewData = name+"/"+age+"/"+address;
	
		
		hd.getListView().add(viewData);
	}
}//class
