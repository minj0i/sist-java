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
		//도시락 목록을 초기화한다.
		setLunch();
		
	}//LunchMainController
	
	/**
	 * JTable에 DB에서 조회한 도시락 정보를 보여준다.
	 */
	public void setLunch() {
		DefaultTableModel dtmLunch = lmv.getDtmLunch();
		dtmLunch.setRowCount(0); //View창에 4개 있는 걸 지워주고
		
		try {
			//DB에서 도시락 정보를 조회
			List<LunchVO> listLunch = la_dao.selectLunch();
			//JTable에 조회한 정보를 출력
			
			LunchVO lv = null;
			String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";
			
			Object[] rowData = null;
			for(int i=0; i<listLunch.size(); i++) {
				lv=listLunch.get(i);
				//DTM에 넣을 때는 1차원배열 혹은 벡터로 넣어야 함
				//DTM에 데이터를 추가하기 위한 1차원배열(Vector)을 생성하고 데이터를 추가
				rowData = new Object[5];
				rowData[0]=new Integer(i+1);
				rowData[1]=lv.getLunchCode();
				rowData[2]=new ImageIcon(imgPath+lv.getImg());
				rowData[3]=lv.getLunchName();
				rowData[4]=new Integer(lv.getPrice());
				
				//DTM에 추가
				dtmLunch.addRow(rowData);
			}//end for
			
			if(listLunch.isEmpty()) {//입력된 도시락이 없을 때
				JOptionPane.showMessageDialog(lmv, "입력된 제품이 없습니다.");
			}//end if
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lmv, "DB에서 데이터를 받아오는 중 문제 발생");
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
			if(me.getSource()==lmv.getJtLunch()) {//도시락테이블에서 더블클릭
				//도시락코드로 DB테이블을 검색하여 상세정보를 전달한다.
				JTable jt = lmv.getJtLunch();
				try {
					LunchDetailVO ldvo = 
							la_dao.selectDetailLunch((String)jt.getValueAt(jt.getSelectedRow(), 1));
					new LunchDetailView(lmv, ldvo, this);
				} catch (SQLException se) {
					JOptionPane.showMessageDialog(lmv, "DB에서 문제가 발생하였습니다.");
					se.printStackTrace();
				}
//				System.out.println(jt.getValueAt(jt.getSelectedRow(), 1)); //1번컬럼의 값을 가지고 온다.
			}//end if
			if(me.getSource()==lmv.getJtOrder()) {//주문테이블에서 더블클릭
				
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
	 * 월이 선택되면 해당년의 해당월의 마지막날을 설정
	 */
	private void setDay() {
		int selYear = ((Integer)lmv.getJcbYear().getSelectedItem()).intValue();
		int selMonth = ((Integer)lmv.getJcbMonth().getSelectedItem()).intValue();
		
		//마지막날 얻기
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, selYear);
		cal.set(Calendar.MONTH, selMonth-1);
		
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int nowDay = cal.get(Calendar.DAY_OF_MONTH);
		
		lmv.getDcbmDay().removeAllElements();//모델을 초기화하고
		
		for(int day=1; day<lastDay+1; day++) {
				lmv.getDcbmDay().addElement(day);//마지막날을 설정한다.
			}//end for
		lmv.getJcbDay().setSelectedItem(new Integer(nowDay));//오늘을 선택한다.
		
	}//setDay
	
	//mouseCliecked만 씀
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}//class
