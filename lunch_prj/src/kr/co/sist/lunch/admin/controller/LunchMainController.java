package kr.co.sist.lunch.admin.controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
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
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchVO;
import kr.co.sist.lunch.admin.vo.OrderVO;


public class LunchMainController extends WindowAdapter implements ActionListener, MouseListener{

	private LunchMainView lmv;
	private LunchAdminDAO la_dao;
	private String orderNum;
	private int selectedRow;
	
	public static final int DBL_CLICK = 2;
	
	private String lunchName;
	
	public LunchMainController(LunchMainView lmv) {
		this.lmv = lmv;
		la_dao=LunchAdminDAO.getInstance();
		//���ö� ����� �ʱ�ȭ�Ѵ�.
		setLunch();
		orderNum="";
	}//LunchMainController
	
	/**
	 * JTable�� DB���� ��ȸ�� ���ö� ������ �����ش�.
	 */
	public void setLunch() {
		DefaultTableModel dtmLunch = lmv.getDtmLunch();
		dtmLunch.setRowCount(0); //Viewâ�� 4�� �ִ� �� �����ְ�
		
		try {
			//DB���� ���ö� ������ ��ȸ
			List<LunchVO> listLunch = la_dao.selectLunch();
			//JTable�� ��ȸ�� ������ ���
			
			LunchVO lv = null;
			String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";
			
			Object[] rowData = null;
			for(int i=0; i<listLunch.size(); i++) {
				lv=listLunch.get(i);
				//DTM�� ���� ���� 1�����迭 Ȥ�� ���ͷ� �־�� ��
				//DTM�� �����͸� �߰��ϱ� ���� 1�����迭(Vector)�� �����ϰ� �����͸� �߰�
				rowData = new Object[5];
				rowData[0]=new Integer(i+1);
				rowData[1]=lv.getLunchCode();
				rowData[2]=new ImageIcon(imgPath+lv.getImg());
				rowData[3]=lv.getLunchName();
				rowData[4]=new Integer(lv.getPrice());
				
				//DTM�� �߰�
				dtmLunch.addRow(rowData);
			}//end for
			
			if(listLunch.isEmpty()) {//�Էµ� ���ö��� ���� ��
				JOptionPane.showMessageDialog(lmv, "�Էµ� ��ǰ�� �����ϴ�.");
			}//end if
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lmv, "DB���� �����͸� �޾ƿ��� �� ���� �߻�");
			e.printStackTrace();
		}//end catch
	}//setLunch
	
	/**
	 * ��,��,�� ������ �����ͼ� ����
	 */
	public void searchCalc() {
		DefaultTableModel dtmCalc = lmv.getDtmCalc();
		dtmCalc.setRowCount(0);
		
		int selYear = ((Integer)lmv.getJcbYear().getSelectedItem()).intValue();
		int selMonth = ((Integer)lmv.getJcbMonth().getSelectedItem()).intValue();
		int selDay = ((Integer)lmv.getJcbDay().getSelectedItem()).intValue();
		StringBuilder searchDate = new StringBuilder();
		
		searchDate.append(selYear).append("-").append(selMonth).append("-")
		.append(selDay);
		
		try {
			//������ ������ ��ȸ����� �޾Ƽ� JTable�� ��� 
			List<CalcVO> list = la_dao.selectCalc(searchDate.toString());
			//JTable�� �����͸� �߰��ϴ� �ڵ� �ۼ��غ�����.
			//�����Ͱ� ���� ������ "�Ǹŵ� ���ö��� �����ϴ�"
			if(list.isEmpty()) {
				JOptionPane.showMessageDialog(lmv, searchDate.toString()+"�� �Ǹŵ� ���ö��� �����ϴ�.");
			}else {
				Object[] rowData = null;
				CalcVO cv= null;
				for(int i=0; i<list.size(); i++) {
					cv=list.get(i);
					//DTM�� ���� ���� 1�����迭 Ȥ�� ���ͷ� �־�� ��
					//DTM�� �����͸� �߰��ϱ� ���� 1�����迭(Vector)�� �����ϰ� �����͸� �߰�
					rowData = new Object[4];
					rowData[0]=new Integer(i+1);
					rowData[1]=cv.getLunchName()+"("+cv.getLunchCode()+")";
					rowData[2]=cv.getTotal();
					rowData[3]=cv.getPrice();
					//DTM�� �߰�
					dtmCalc.addRow(rowData);
				}//end for
			}//end else
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
	}//searchCalc
	
	/**
	 * ���� ���õǸ� �ش���� �ش���� ���������� ����
	 */
	private void setDay() {
		int selYear = ((Integer)lmv.getJcbYear().getSelectedItem()).intValue();
		int selMonth = ((Integer)lmv.getJcbMonth().getSelectedItem()).intValue();
		
		//�������� ���
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, selYear);
		cal.set(Calendar.MONTH, selMonth-1);
		
		int lastDay = cal.getActualMaximum(Calendar.DATE);
//		int nowDay = cal.get(Calendar.DAY_OF_MONTH);
		
		lmv.getDcbmDay().removeAllElements();//���� �ʱ�ȭ�ϰ�
		
		for(int day=1; day<lastDay+1; day++) {
				lmv.getDcbmDay().addElement(day);//���������� �����Ѵ�.
			}//end for
//		lmv.getJcbDay().setSelectedItem(new Integer(nowDay));//������ �����Ѵ�. �̰� ����� ���� �ٲ����� 1�Ϸ� �ٲ�
		
	}//setDay
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		lmv.dispose();
	}//windowClosing
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);//JVM�� ��� �ν��Ͻ� ����
	}//windowClosed
	
	
	/**
	 * �ֹ� ã��
	 */
	public void searchOrder() {
		try {
			List<OrderVO> list = la_dao.selectOrderList();
			DefaultTableModel dtmOrder = lmv.getDtmOrder();
			dtmOrder.setRowCount(0);//�ʱ�ȭ
				Vector<Object> vec = null;//�������� ���������� ���Ƿ� Object�� ��
				OrderVO ovo= null;
				for(int i=0; i<list.size(); i++) {
					ovo=list.get(i);
					vec = new Vector<Object>();
					vec.add(new Integer(i+1));
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
					//DTM�� �߰�
					dtmOrder.addRow(vec);
				}//end for
		} catch (SQLException e1) {
			e1.printStackTrace();
		}//end catch
	}//searchOrder
	
	private void changeOrder(Integer row) {
		try {
			List<OrderVO> list = la_dao.selectOrderList();
			DefaultTableModel dtmOrder = lmv.getDtmOrder();
			
			list.get(row).setStatus("Y");
			System.out.println(list.get(row).getStatus());
			
			//DTM�� �߰�
			dtmOrder.setValueAt("Y", row, 10);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}//end catch
	}//changeOrder
	
	
	
	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getSource()==lmv.getJtb()) {
			if(lmv.getJtb().getSelectedIndex()==1) {//1�� �ǿ��� �̺�Ʈ �߻�
				//��������� �ֹ������� ��ȸ (������� ������ ��)
				searchOrder();
			}//end if
		}//end if

		
		if(lmv.getJtOrder().columnAtPoint(me.getPoint())==10) {
			Point clickedP = new Point(me.getPoint());
			switch(JOptionPane.showConfirmDialog(lmv, "�ֹ����¸� �����Ͻðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION :
				System.out.println(lmv.getJtOrder().rowAtPoint(clickedP));
				changeOrder(Integer.parseInt(String.valueOf(lmv.getJtOrder().rowAtPoint(clickedP))));
				break;
//			case JOptionPane.NO_OPTION :
//				changeOrder(Integer.parseInt(String.valueOf(lmv.getJtOrder().rowAtPoint(clickedP))));
//				break;
			}//end switch
		}//end if
		
//		if(lmv.getJtOrder().columnAtPoint(me.getPoint())==7) {
//			JOptionPane.showConfirmDialog(lmv, "�ֹ��� �����Ͻðڽ��ϱ�?");
//		}
		
		if(me.getSource()==lmv.getJtOrder() && me.getButton()==MouseEvent.BUTTON3) {
			JTable jt = lmv.getJtOrder();
			//���콺 �����Ͱ� Ŭ���Ǹ� ���̺��� Ŭ���� ���� �������� ��
			
			  int r = jt.rowAtPoint(me.getPoint());
		        if (r >= 0 && r < jt.getRowCount()) {
		        	jt.setRowSelectionInterval(r, r);//������� ���� ������ ���� ���� �ϴ� ��
		        } else {
		        	jt.clearSelection();
		        }//end else
		        //������ ���� �ִ´�.
		        selectedRow =r;
		        
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setLocation(me.getXOnScreen(), me.getYOnScreen());
			jp.setVisible(true);
			orderNum=(String)jt.getValueAt(jt.getSelectedRow(), 1);
			lunchName=(String)jt.getValueAt(jt.getSelectedRow(), 3)+" "+
						(String)jt.getValueAt(jt.getSelectedRow(), 4);
			
		}else {
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false);
		}//end if
		
		switch(me.getClickCount()) {
			case DBL_CLICK:
			if(me.getSource()==lmv.getJtLunch()) {//���ö����̺��� ����Ŭ��
				//���ö��ڵ�� DB���̺��� �˻��Ͽ� �������� �����Ѵ�.
				JTable jt = lmv.getJtLunch();
				try {
					LunchDetailVO ldvo = 
							la_dao.selectDetailLunch((String)jt.getValueAt(jt.getSelectedRow(), 1));
					new LunchDetailView(lmv, ldvo, this);
				} catch (SQLException se) {
					JOptionPane.showMessageDialog(lmv, "DB���� ������ �߻��Ͽ����ϴ�.");
					se.printStackTrace();
				}//end catch
//				System.out.println(jt.getValueAt(jt.getSelectedRow(), 1)); //1���÷��� ���� ������ �´�.
			}//end if
		}//end switch
	}//mouseClicked
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==lmv.getJbtAddLunch()) { //���ö� �߰� ��ư
			new LunchAddView(lmv, this);
		}//end if
		if(ae.getSource()==lmv.getJcbMonth()) { //���� ������ ���� ����
			setDay();
		}//end if
		if(ae.getSource()==lmv.getJbtCalcOrder()) {//���� ��ư Ŭ��
			searchCalc();
		}//end if
		
		if(ae.getSource()==lmv.getJmOrderRemove()) {
			JOptionPane.showConfirmDialog(lmv, "���� ������ �κ�");
		}//end if
		
		if(ae.getSource()==lmv.getJmOrderStatus()) {
			switch(JOptionPane.showConfirmDialog(lmv, "[ "+orderNum +lunchName
					+ " ]�ֹ��� �Ϸ�Ǿ����ϱ�?")) {
			case JOptionPane.OK_OPTION : 
				JTable jt = lmv.getJtOrder();
				jt.setValueAt("Y", selectedRow, 10);//���̺��� ���� ����
				////////////////////////////////////
				//01-17-2019: �ֹ� ������ ����
				/////////////////////////////////
				
				
			}//end switch
		}//end if
		
		
		
	}//actionPerformed

	//mouseCliecked�� ��
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}//class
