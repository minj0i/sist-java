package kr.co.sist.memo.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.MemoHelp;

public class MemoHelpEvt extends WindowAdapter implements ActionListener, ItemListener {

	private MemoHelp mh;
	
	public MemoHelpEvt(MemoHelp mh) {
		this.mh=mh;
	}//MemohelpEvt
	

	@Override
	public void windowClosing(WindowEvent we) {
		mh.dispose();
	}//windowClosing
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
	}//itemStateChanged

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mh.getBtnConfirm()) {
			mh.dispose();
		}//end if
	}//actionPerformed

	
}//class
