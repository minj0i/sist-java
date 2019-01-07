package day0107.hwk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HwSelectTableEvt extends WindowAdapter implements ActionListener {
	private HwSelectTable hst;
	
	public HwSelectTableEvt(HwSelectTable hst) {
		this.hst = hst;
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		hst.dispose();
	}// windowClosing
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		hst.getJcombobox().getSelectedItem();
	}

}
