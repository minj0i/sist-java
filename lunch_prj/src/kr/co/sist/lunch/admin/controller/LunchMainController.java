package kr.co.sist.lunch.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchAddView;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchVO;


public class LunchMainController extends WindowAdapter implements ActionListener, MouseListener{

	private LunchMainView lmv;
	private LunchAdminDAO la_dao;
	
	public static final int DBL_CLICK = 2;
	
	public LunchMainController(LunchMainView lmv) {
		this.lmv = lmv;
		la_dao=LunchAdminDAO.getInstance();
		//���ö� ����� �ʱ�ȭ�Ѵ�.
		setLunch();
		
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
	}
	
	public void searchOrder() {
		DefaultTableModel dtmOrder = lmv.getDtmOrder();
		
//		List<OrderVO> orderLunch = la_dao.
		
	}
	
	public void searchCalc() {
		DefaultTableModel dtmCalc = lmv.getDtmCalc();
	}
	
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		lmv.dispose();
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
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
				}
//				System.out.println(jt.getValueAt(jt.getSelectedRow(), 1)); //1���÷��� ���� ������ �´�.
			}//end if
			if(me.getSource()==lmv.getJtOrder()) {//�ֹ����̺��� ����Ŭ��
				
			}//end if
		}//end switch
	}//mouseClicked
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==lmv.getJbtAddLunch()) {
			new LunchAddView(lmv, this);
		}//end if
		if(ae.getSource()==lmv.getJcbMonth()) {
			setDay();
		}//end if
	}//actionPerformed

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
		int nowDay = cal.get(Calendar.DAY_OF_MONTH);
		
		lmv.getDcbmDay().removeAllElements();//���� �ʱ�ȭ�ϰ�
		
		for(int day=1; day<lastDay+1; day++) {
				lmv.getDcbmDay().addElement(day);//���������� �����Ѵ�.
			}//end for
		lmv.getJcbDay().setSelectedItem(new Integer(nowDay));//������ �����Ѵ�.
		
	}//setDay
	
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
