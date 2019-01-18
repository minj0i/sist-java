package kr.co.sist.lunch.user.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.user.model.LunchClientDAO;
import kr.co.sist.lunch.user.view.LunchClientView;
import kr.co.sist.lunch.user.view.LunchOrderDetailView;
import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchListVO;


public class LunchClientController extends WindowAdapter implements ActionListener, MouseListener{

	private LunchClientView lcv;
	private LunchClientDAO lc_dao;
	public static final int DBL_CLICK=2; 
	
	public LunchClientController(LunchClientView lcv) {
		this.lcv=lcv;
		lc_dao=LunchClientDAO.getInstance();
		
		setLunchList();
	}//LunchClientController
	
	/**
	 * ���ö� ����� ��ȸ�Ͽ� JTable�� �����ϴ� ��
	 * Ư������ 25�� �̻��̶�� 24�ڱ����� ����ϰ� �������� ..���� ���
	 */
	private void setLunchList() {
		//���ö� ��� ��ȸ
		try {
			List<LunchListVO> list = lc_dao.selectLunchList();
			
			DefaultTableModel dtm = lcv.getDtmLunchList();
			dtm.setRowCount(0);
			
			Object[] rowData = null;
			
			LunchListVO llvo = null;
			String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/s_";
			String spec = null;
			for(int i=0; i<list.size(); i++) {
				llvo=list.get(i);
				
				rowData = new Object[5];
				rowData[0] = new Integer(i+1);
				rowData[1] = new ImageIcon(imgPath+llvo.getImg());
				rowData[2] = llvo.getLunchCode();
				rowData[3] = llvo.getLunchName();
				spec = llvo.getLunchSpec();
				if(spec.length()>25) {
					spec=spec.substring(0,24)+"...";
				}//end if
				rowData[4] = spec;
				
				//DTM�� �߰�
				dtm.addRow(rowData);
			}//end for
			
		} catch (SQLException e) {
			msgCenter(lcv, "���ö� ����� ��ȸ�ϴ� �� ���� �߻�");
			e.printStackTrace();
		}//end catch
	}//setLunchList
	
	private void msgCenter(Component comp, String msg) {
		JOptionPane.showMessageDialog(comp, msg);
	}//msgCenter
	
	
	@Override
	public void windowClosing(WindowEvent we) {
		lcv.dispose();
	}//windowClosing
	
	@Override
	public void mouseClicked(MouseEvent me) {
		switch(me.getClickCount()){
		case DBL_CLICK: 
			JTable jt =lcv.getJtLunch();
			String lunch_Code=(String) jt.getValueAt(jt.getSelectedRow(), 2);
			//���ö��� ������ ��ȸ
			try {
				LunchDetailVO ldvo =lc_dao.selectDetailLunch(lunch_Code);
				if(ldvo == null) { //�ڵ�� ��ȸ�� ����� ���� ��
					msgCenter(lcv, "��ġ�ڵ�� ��ȸ�� ���ö��� �����ϴ�");
				}else {//�ڵ�� ��ȸ�� ����� ���� ��
				new LunchOrderDetailView(lcv, ldvo);
				}//end else
			} catch (SQLException e) {
				msgCenter(lcv, "������ ��ȸ�� ��������");
				e.printStackTrace();
			}
			
			
		}//end switch
	}//mouseClicked

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}//actionPerformed
	
	
	
	
	
	
	
	
	
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {}



}//class
