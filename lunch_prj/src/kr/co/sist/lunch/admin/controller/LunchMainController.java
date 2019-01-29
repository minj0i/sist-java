package kr.co.sist.lunch.admin.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchAddView;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.CalcVO;
import kr.co.sist.lunch.admin.vo.FlagVO;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchVO;
import kr.co.sist.lunch.admin.vo.OrderVO;

public class LunchMainController extends WindowAdapter implements ActionListener, MouseListener, Runnable {

	private LunchMainView lmv;
	private LunchAdminDAO la_dao;

	private String orderNum;
	private int selectedRow;
	private Thread threadOrdering;

	public static final int DBL_CLICK = 2;

	private String lunchName;

	private Map<String, FlagVO> map;

	public LunchMainController(LunchMainView lmv) {
		this.lmv = lmv;
		la_dao = LunchAdminDAO.getInstance();
		// ���ö� ����� �ʱ�ȭ�Ѵ�.
		setLunch();
		orderNum = "";
		map = new HashMap<String, FlagVO>();
	}// LunchMainController

	/**
	 * JTable�� DB���� ��ȸ�� ���ö� ������ �����ش�.
	 */
	public void setLunch() {
		DefaultTableModel dtmLunch = lmv.getDtmLunch();
		dtmLunch.setRowCount(0); // Viewâ�� 4�� �ִ� �� �����ְ�

		try {
			// DB���� ���ö� ������ ��ȸ
			List<LunchVO> listLunch = la_dao.selectLunch();
			// JTable�� ��ȸ�� ������ ���

			LunchVO lv = null;
			String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";

			Object[] rowData = null;
			for (int i = 0; i < listLunch.size(); i++) {
				lv = listLunch.get(i);
				// DTM�� ���� ���� 1�����迭 Ȥ�� ���ͷ� �־�� ��
				// DTM�� �����͸� �߰��ϱ� ���� 1�����迭(Vector)�� �����ϰ� �����͸� �߰�
				rowData = new Object[5];
				rowData[0] = new Integer(i + 1);
				rowData[1] = lv.getLunchCode();
				rowData[2] = new ImageIcon(imgPath + lv.getImg());
				rowData[3] = lv.getLunchName();
				rowData[4] = new Integer(lv.getPrice());

				// DTM�� �߰�
				dtmLunch.addRow(rowData);
			} // end for

			if (listLunch.isEmpty()) {// �Էµ� ���ö��� ���� ��
				JOptionPane.showMessageDialog(lmv, "�Էµ� ��ǰ�� �����ϴ�.");
			} // end if

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lmv, "DB���� �����͸� �޾ƿ��� �� ���� �߻�");
			e.printStackTrace();
		} // end catch
	}// setLunch

	/**
	 * ��,��,�� ������ �����ͼ� ����
	 */
	public void searchCalc() {
		DefaultTableModel dtmCalc = lmv.getDtmCalc();
		dtmCalc.setRowCount(0);

		int selYear = ((Integer) lmv.getJcbYear().getSelectedItem()).intValue();
		int selMonth = ((Integer) lmv.getJcbMonth().getSelectedItem()).intValue();
		int selDay = ((Integer) lmv.getJcbDay().getSelectedItem()).intValue();
		StringBuilder searchDate = new StringBuilder();

		searchDate.append(selYear).append("-").append(selMonth).append("-").append(selDay);

		try {
			// ������ ������ ��ȸ����� �޾Ƽ� JTable�� ���
			List<CalcVO> list = la_dao.selectCalc(searchDate.toString());
			// JTable�� �����͸� �߰��ϴ� �ڵ� �ۼ��غ�����.
			// �����Ͱ� ���� ������ "�Ǹŵ� ���ö��� �����ϴ�"
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(lmv, searchDate.toString() + "�� �Ǹŵ� ���ö��� �����ϴ�.");
			} else {
				Object[] rowData = null;
				CalcVO cv = null;
				for (int i = 0; i < list.size(); i++) {
					cv = list.get(i);
					// DTM�� ���� ���� 1�����迭 Ȥ�� ���ͷ� �־�� ��
					// DTM�� �����͸� �߰��ϱ� ���� 1�����迭(Vector)�� �����ϰ� �����͸� �߰�
					rowData = new Object[4];
					rowData[0] = new Integer(i + 1);
					rowData[1] = cv.getLunchName() + "(" + cv.getLunchCode() + ")";
					rowData[2] = cv.getTotal();
					rowData[3] = cv.getPrice();
					// DTM�� �߰�
					dtmCalc.addRow(rowData);
				} // end for
			} // end else

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

	}// searchCalc

	/**
	 * ���� ���õǸ� �ش���� �ش���� ���������� ����
	 */
	private void setDay() {
		int selYear = ((Integer) lmv.getJcbYear().getSelectedItem()).intValue();
		int selMonth = ((Integer) lmv.getJcbMonth().getSelectedItem()).intValue();

		// �������� ���
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, selYear);
		cal.set(Calendar.MONTH, selMonth - 1);

		int lastDay = cal.getActualMaximum(Calendar.DATE);
//		int nowDay = cal.get(Calendar.DAY_OF_MONTH);

		lmv.getDcbmDay().removeAllElements();// ���� �ʱ�ȭ�ϰ�

		for (int day = 1; day < lastDay + 1; day++) {
			lmv.getDcbmDay().addElement(day);// ���������� �����Ѵ�.
		} // end for
//		lmv.getJcbDay().setSelectedItem(new Integer(nowDay));//������ �����Ѵ�. �̰� ����� ���� �ٲ����� 1�Ϸ� �ٲ�

	}// setDay

	@Override
	public void windowClosing(WindowEvent e) {
		lmv.dispose();
	}// windowClosing

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);// JVM�� ��� �ν��Ͻ� ����
	}// windowClosed

	/**
	 * �ֹ� ã��
	 */
	public void searchOrder() {
		try {
			List<OrderVO> list = la_dao.selectOrderList();
			DefaultTableModel dtmOrder = lmv.getDtmOrder();
			dtmOrder.setRowCount(0);// �ʱ�ȭ
			Vector<Object> vec = null;// �������� ���������� ���Ƿ� Object�� ��
			OrderVO ovo = null;
			for (int i = 0; i < list.size(); i++) {
				ovo = list.get(i);
				vec = new Vector<Object>();
				vec.add(new Integer(i + 1));
				vec.add(ovo.getOrderNum());
				vec.add(ovo.getLunchCode());
				vec.add(ovo.getLunchName());
				vec.add(ovo.getOrderName());
				vec.add(ovo.getQuan());
				vec.add(ovo.getPrice());
				vec.add(ovo.getOrderDate());
				vec.add(ovo.getPhone());
				vec.add(ovo.getIpAddress());
				vec.add(ovo.getStatus());
				if (ovo.getRequest() != null) {
					orderNum = ovo.getOrderNum();
					map.put(orderNum, new FlagVO(ovo.getRequest(),
							map.get(orderNum) == null ? false : map.get(orderNum).isReadFlag()));
				} // end if

				// DTM�� �߰�
				dtmOrder.addRow(vec);

			} // end for
		} catch (SQLException e1) {
			e1.printStackTrace();
		} // end catch
	}// searchOrder

//	private void changeOrder(Integer row) {
//		try {
//			List<OrderVO> list = la_dao.selectOrderList();
//			DefaultTableModel dtmOrder = lmv.getDtmOrder();
//			
//			list.get(row).setStatus("Y");
//			System.out.println(list.get(row).getStatus());
//			
//			//DTM�� �߰�
//			dtmOrder.setValueAt("Y", row, 10);
//			
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}//end catch
//	}//changeOrder

	@Override
	public void mouseClicked(MouseEvent me) {
		if (me.getSource() == lmv.getJtb()) {
			if (lmv.getJtb().getSelectedIndex() == 1) {// �ι�° ��(�ֹ�)���� �̺�Ʈ �߻�
				// �ֹ���Ȳ�� ��� ��ȸ�Ͽ� �ǽð����� �ǽð����� DB�� ��ȸ�Ͽ� ����
				if (threadOrdering == null) { // �̰ɾ��������� ����ؼ� ��ü�� �������
					threadOrdering = new Thread(this);
					threadOrdering.start();
				} // end if
					// ��������� �ֹ������� ��ȸ (������� ������ ��)
//				searchOrder();
			} // end if
		} // end if

//		if(lmv.getJtOrder().columnAtPoint(me.getPoint())==10) {
//			Point clickedP = new Point(me.getPoint());
//			switch(JOptionPane.showConfirmDialog(lmv, "�ֹ����¸� �����Ͻðڽ��ϱ�?")) {
//			case JOptionPane.OK_OPTION :
//				System.out.println(lmv.getJtOrder().rowAtPoint(clickedP));
//				changeOrder(Integer.parseInt(String.valueOf(lmv.getJtOrder().rowAtPoint(clickedP))));
//				break;
//			case JOptionPane.NO_OPTION :
//				changeOrder(Integer.parseInt(String.valueOf(lmv.getJtOrder().rowAtPoint(clickedP))));
//				break;
//			}//end switch
//		}//end if

		if (me.getSource() == lmv.getJtOrder() && me.getButton() == MouseEvent.BUTTON3) {
			JTable jt = lmv.getJtOrder();
			// ���콺 �����Ͱ� Ŭ���Ǹ� ���̺����� Ŭ���� ���� �������� ��

			int r = jt.rowAtPoint(me.getPoint());
			if (r >= 0 && r < jt.getRowCount()) {
				jt.setRowSelectionInterval(r, r);// ������� ���� ������ ���� ���� �ϴ� ��
			} else {
				jt.clearSelection();
			} // end else
				// ������ ���� �ִ´�.
			selectedRow = r;
			/////////////////////// ��û�����߰�////////////////////////////////////////////
			boolean flag = map.containsKey(jt.getValueAt(r, 1)) && !map.get(jt.getValueAt(r, 1)).isReadFlag();
			if (!flag) {

				JPopupMenu jp = lmv.getJpOrderMenu();
				jp.setLocation(me.getXOnScreen(), me.getYOnScreen());
				jp.setVisible(true);
				orderNum = (String) jt.getValueAt(jt.getSelectedRow(), 1);
				lunchName = (String) jt.getValueAt(jt.getSelectedRow(), 3) + " "
						+ (String) jt.getValueAt(jt.getSelectedRow(), 4);
			} else {
				msgCenter(lmv, "��û������ �ִ� �ֹ� �Դϴ�.");
			} // end else
		} else {
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false);
		} // end if

		switch (me.getClickCount()) {
		case DBL_CLICK:
			if (me.getSource() == lmv.getJtOrder()) {
				JTable jt = lmv.getJtOrder();
				String flag = (String) jt.getValueAt(jt.getSelectedRow(), 1);
				if (map.containsKey(flag)) {
					FlagVO val = map.get(flag);
					msgCenter(lmv, val.getRequest());
					val.setReadFlag(true);
				} // end if
			} // end if

//			case DBL_CLICK:
//				if (me.getSource() == lmv.getJtOrder()) {// �ֹ����̺����� ����Ŭ��
//					System.out.println("�ֹ� ����Ŭ��");
//					try {
//						List<OrderVO> list = la_dao.selectOrderList();
//						String re_quest = null;// �������� ���������� ���Ƿ� Object�� ��
//						OrderVO ovo = null;
//						JTable jt = lmv.getJtOrder();
//						int r = jt.rowAtPoint(me.getPoint());
//						if (r >= 0 && r < jt.getRowCount()) {
//							jt.setRowSelectionInterval(r, r);// ������� ���� ������ ���� ���� �ϴ� ��
//						} else {
//							jt.clearSelection();
//						} // end else
//						ovo = list.get(r);
//						re_quest = ovo.getRequest().toString();
//						if (re_quest != "") {// ��û���� Ȯ��
//							JOptionPane.showMessageDialog(lmv, re_quest);
//						} // end if
//					} catch (SQLException e1) {
//						e1.printStackTrace();
//					} catch (NullPointerException npe) {
//					} // end catch
//				} // end if
//			}// end switch

			if (me.getSource() == lmv.getJtLunch()) {// ���ö����̺����� ����Ŭ��
				// ���ö��ڵ�� DB���̺��� �˻��Ͽ� �������� �����Ѵ�.
				JTable jt = lmv.getJtLunch();
				try {
					LunchDetailVO ldvo = la_dao.selectDetailLunch((String) jt.getValueAt(jt.getSelectedRow(), 1));
					new LunchDetailView(lmv, ldvo, this);
				} catch (SQLException se) {
					JOptionPane.showMessageDialog(lmv, "DB���� ������ �߻��Ͽ����ϴ�.");
					se.printStackTrace();
				} // end catch
//				System.out.println(jt.getValueAt(jt.getSelectedRow(), 1)); //1���÷��� ���� ������ �´�.
			} // end if
		}// end switch

	}// mouseClicked

	private void msgCenter(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(lmv, message);
	}

//	private String requestPopup() {
//		String requestPopup = "";
//		try {
//			List<OrderVO> list = la_dao.selectOrderList();
//			String re_quest = null;// �������� ���������� ���Ƿ� Object�� ��
//			OrderVO ovo = null;
//			for (int i = 0; i < list.size(); i++) {
//				ovo = list.get(i);
//				re_quest = ovo.getRequest().toString();
//				if (re_quest != null) {
//					JOptionPane.showMessageDialog(lmv, re_quest);
//					requestPopup = re_quest;
//				} // ��û���� Ȯ��
//			} // end for
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		} catch (NullPointerException npe) {
//		} // end catch
//		return requestPopup;
//	}// re_quest

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lmv.getJbtAddLunch()) { // ���ö� �߰� ��ư
			new LunchAddView(lmv, this);
		} // end if
		if (ae.getSource() == lmv.getJcbMonth()) { // ���� ������ ���� ����
			setDay();
		} // end if
		if (ae.getSource() == lmv.getJbtCalcOrder()) {// ���� ��ư Ŭ��
			searchCalc();
		} // end if

		if (ae.getSource() == lmv.getJmOrderRemove()) {
			JTable jt = lmv.getJtOrder();
			if (((String) jt.getValueAt(selectedRow, 10)).equals("N")) {
				switch (JOptionPane.showConfirmDialog(lmv, orderNum + " " + lunchName + "�ֹ� ������ ���� �Ͻðڽ��ϱ�?")) {
				case JOptionPane.OK_OPTION:
					try {
						if (la_dao.deleteOrder(orderNum)) {// DBTable���� �ش� ���ڵ� ����
							msgCenter(lmv, orderNum + " �ֹ� ���� ����");
							// �ֹ� ���̺� ����
							searchOrder();
						} else {
							msgCenter(lmv, orderNum + " ���� �Ұ�");
						} // end else
					} catch (SQLException e) {
						msgCenter(lmv, "DB���� ���� �߻�");
						e.printStackTrace();
					} // end catch
				}// end switch

			} else {
				msgCenter(lmv, "�̹� �ֹ��� �����. ���� �Ұ�");
			} // end else

			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false);

		} // end if

		if (ae.getSource() == lmv.getJmOrderStatus()) {
			// ���ۻ��°� 'N'�� ���¿����� ����
			JTable jt = lmv.getJtOrder();
			if (((String) jt.getValueAt(selectedRow, 10)).equals("N")) {
//				if (requestPopup() != "") {
				switch (JOptionPane.showConfirmDialog(lmv, "[ " + orderNum + lunchName + " ]�ֹ��� �Ϸ�Ǿ����ϱ�?")) {
				case JOptionPane.OK_OPTION:
					try {
						// DB�ش� ���ڵ� ����
						if (la_dao.updateStatus(orderNum)) {// ���� ��ȯ ����
							jt.setValueAt("Y", selectedRow, 10);// ���̺��� ���� ����
							JOptionPane.showMessageDialog(lmv, "���ö� ���� �Ϸ�!");
						} else {// ���� ��ȯ ����
							JOptionPane.showMessageDialog(lmv, "���ö� ���ۻ��� ��ȯ�� �����߽��ϴ�.");
						} // end else
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(lmv, "DB���� ������ �߻��Ͽ����ϴ�.");
						e.printStackTrace();
					} // end catch
				}// end switch
//				} else {
//					JOptionPane.showMessageDialog(lmv, requestPopup());
//				}
			} else {
				JOptionPane.showMessageDialog(lmv, "������ �Ϸ�� ���ö��Դϴ�.");
			} // end else

			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false);
			
		} // end if

	}// actionPerformed

	@Override
	public void run() {
		// 30�ʸ��� �ѹ��� ��ȸ ����
		try {
			while (true) {// ���ѷ����� ������ CPU���� ��Ƹ���. ��ǻ�Ͱ� ������
				searchOrder();
				Thread.sleep(1000 * 30);
			} // end while
		} catch (InterruptedException e) {
			msgCenter(lmv, "�ֹ� ��ȸ �� ������ �߻��߽��ϴ�.");
			e.printStackTrace();
		} // end catch
	}// run

	//////////////////////////////////////////////////////////////////
	// mouseCliecked�� ��
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}// class