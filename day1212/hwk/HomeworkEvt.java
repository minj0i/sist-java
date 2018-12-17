package day1212.hwk;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomeworkEvt extends WindowAdapter implements ActionListener, ItemListener {
	private HomeworkDesign hd;

	public HomeworkEvt(HomeworkDesign hd) {
		this.hd = hd;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		ckList();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == hd.getBtnAdd()) {
			ckAdd();
		}
		if (e.getSource() == hd.getBtnDel()) {
			ckDel();
		}
		if (e.getSource() == hd.getBtnUpdate()) {
			ckUpdate();
		}
		if (e.getSource() == hd.getBtnExit()) {
			ckExit();
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		hd.dispose();
	}

	private void ckAdd() {
		String input = "";
		input = hd.getTfName().getText() + "/" + hd.getTfAge().getText() + "/" + hd.getTfAddr().getText();
		if (!hd.getTfName().getText().equals("") && !hd.getTfAge().getText().equals("") && !hd.getTfAddr().getText().equals("")) {
			hd.getListData().add(input);
		}
		hd.getTfName().setText("");
		hd.getTfAge().setText("");
		hd.getTfAddr().setText("");
	}

	private void ckUpdate() {
		int idx = -1;
		String input = "";
		idx = hd.getListData().getSelectedIndex();

		if (idx != -1) {
			input = hd.getTfName().getText() + "/" + hd.getTfAge().getText() + "/" + hd.getTfAddr().getText();
//			hd.getListData().add(input, idx);
//			hd.getListData().remove(idx + 1);
			hd.getListData().replaceItem(input, idx);
		}
	}

	private void ckDel() {
		int idx = -1;
		String input = "";
		idx = hd.getListData().getSelectedIndex();

		if (idx != -1) {
			input = hd.getTfName().getText() + "/" + hd.getTfAge().getText() + "/" + hd.getTfAddr().getText();
			if (hd.getListData().getItem(idx).equals(input)) {
				hd.getListData().remove(idx);
			}
		}
	}

	private void ckExit() {
		hd.dispose();
	}

	private void ckList() {
		List tempList = hd.getListData();
		String data[] = tempList.getSelectedItem().split("/");
		hd.getTfName().setText(data[0]);
		hd.getTfAge().setText(data[1]);
		hd.getTfAddr().setText(data[2]);

	}

}
