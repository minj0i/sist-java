package admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import admin.view.PMProductAddView;

public class PMProductAddController extends WindowAdapter implements ActionListener{
	private PMProductAddView pmpav;
	private String uploadImg;
	private PMProductController pmpc;
	
	public PMProductAddController(PMProductAddView pmpav, PMProductController pmpc) {
		this.pmpav=pmpav;
		this.pmpc=pmpc;
		uploadImg = "";
	}//»ý¼ºÀÚ
	
	@Override
	public void windowClosing(WindowEvent e) {
		pmpav.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==pmpav.getJbImage()) {
			setImg();
		}//end if
		if(ae.getSource()==pmpav.getJbAdd()) {
			addLunch();
		}//end if
		
		if(ae.getSource()==pmpav.getJbEnd()) {
			pmpav.dispose();
		}//end if
	}//actionPerformed

}//class
