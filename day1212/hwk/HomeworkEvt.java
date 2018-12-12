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
 * Design class�� Has a ����� ������ �̺�Ʈó�� Ŭ����
 * @author owner
 */
public class HomeworkEvt extends WindowAdapter implements ActionListener, ItemListener {

	// �̺�Ʈ�� ó���ϱ����� ���Ǵ� ��� ������Ʈ�� has a ������
	// ��ü�� ����Ͽ� ó���Ѵ�.
	private HomeworkDesign hd;
	
	public HomeworkEvt(HomeworkDesign hd) {
		this.hd = hd;
	}//HomeworkEvt
	
	@Override
	public void windowClosing(WindowEvent e) {
		hd.dispose();
	}// windowClosing

	
	@Override
	//List �̺�Ʈ ó��
	public void itemStateChanged(ItemEvent ie) {
	}//itemStateChanged
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//�߰�:textField�� �ִ� ������ List�� �̵�
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
