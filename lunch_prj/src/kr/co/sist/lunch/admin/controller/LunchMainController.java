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
		//도시락 목록을 초기화한다.
		setLunch();
		orderNum="";
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
	}//setLunch
	
	/**
	 * 년,월,일 정보를 가져와서 정산
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
			//선택한 일자의 조회결과를 받아서 JTable에 출력 
			List<CalcVO> list = la_dao.selectCalc(searchDate.toString());
			//JTable에 데이터를 추가하는 코드 작성해보세요.
			//데이터가 없는 날에는 "판매된 도시락이 없습니다"
			if(list.isEmpty()) {
				JOptionPane.showMessageDialog(lmv, searchDate.toString()+"에 판매된 도시락이 없습니다.");
			}else {
				Object[] rowData = null;
				CalcVO cv= null;
				for(int i=0; i<list.size(); i++) {
					cv=list.get(i);
					//DTM에 넣을 때는 1차원배열 혹은 벡터로 넣어야 함
					//DTM에 데이터를 추가하기 위한 1차원배열(Vector)을 생성하고 데이터를 추가
					rowData = new Object[4];
					rowData[0]=new Integer(i+1);
					rowData[1]=cv.getLunchName()+"("+cv.getLunchCode()+")";
					rowData[2]=cv.getTotal();
					rowData[3]=cv.getPrice();
					//DTM에 추가
					dtmCalc.addRow(rowData);
				}//end for
			}//end else
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
	}//searchCalc
	
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
//		int nowDay = cal.get(Calendar.DAY_OF_MONTH);
		
		lmv.getDcbmDay().removeAllElements();//모델을 초기화하고
		
		for(int day=1; day<lastDay+1; day++) {
				lmv.getDcbmDay().addElement(day);//마지막날을 설정한다.
			}//end for
//		lmv.getJcbDay().setSelectedItem(new Integer(nowDay));//오늘을 선택한다. 이걸 지우면 월을 바꿨을때 1일로 바뀜
		
	}//setDay
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		lmv.dispose();
	}//windowClosing
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);//JVM의 모든 인스턴스 종료
	}//windowClosed
	
	
	/**
	 * 주문 찾기
	 */
	public void searchOrder() {
		try {
			List<OrderVO> list = la_dao.selectOrderList();
			DefaultTableModel dtmOrder = lmv.getDtmOrder();
			dtmOrder.setRowCount(0);//초기화
				Vector<Object> vec = null;//여러가지 데이터형이 들어가므로 Object을 줌
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
					//DTM에 추가
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
			
			//DTM에 추가
			dtmOrder.setValueAt("Y", row, 10);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}//end catch
	}//changeOrder
	
	
	
	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getSource()==lmv.getJtb()) {
			if(lmv.getJtb().getSelectedIndex()==1) {//1번 탭에서 이벤트 발생
				//현재까지의 주문사항을 조회 (쓰레드로 돌려야 함)
				searchOrder();
			}//end if
		}//end if

		
		if(lmv.getJtOrder().columnAtPoint(me.getPoint())==10) {
			Point clickedP = new Point(me.getPoint());
			switch(JOptionPane.showConfirmDialog(lmv, "주문상태를 변경하시겠습니까?")) {
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
//			JOptionPane.showConfirmDialog(lmv, "주문을 삭제하시겠습니까?");
//		}
		
		if(me.getSource()==lmv.getJtOrder() && me.getButton()==MouseEvent.BUTTON3) {
			JTable jt = lmv.getJtOrder();
			//마우스 포인터가 클릭되면 테이블에서 클릭한 행을 가져오는 일
			
			  int r = jt.rowAtPoint(me.getPoint());
		        if (r >= 0 && r < jt.getRowCount()) {
		        	jt.setRowSelectionInterval(r, r);//시작행과 끝행 사이의 행을 선택 하는 일
		        } else {
		        	jt.clearSelection();
		        }//end else
		        //선택한 행을 넣는다.
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
				}//end catch
//				System.out.println(jt.getValueAt(jt.getSelectedRow(), 1)); //1번컬럼의 값을 가지고 온다.
			}//end if
		}//end switch
	}//mouseClicked
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==lmv.getJbtAddLunch()) { //도시락 추가 버튼
			new LunchAddView(lmv, this);
		}//end if
		if(ae.getSource()==lmv.getJcbMonth()) { //월별 마지막 일자 변경
			setDay();
		}//end if
		if(ae.getSource()==lmv.getJbtCalcOrder()) {//정산 버튼 클릭
			searchCalc();
		}//end if
		
		if(ae.getSource()==lmv.getJmOrderRemove()) {
			JOptionPane.showConfirmDialog(lmv, "정말 삭제인 부분");
		}//end if
		
		if(ae.getSource()==lmv.getJmOrderStatus()) {
			switch(JOptionPane.showConfirmDialog(lmv, "[ "+orderNum +lunchName
					+ " ]주문이 완료되었습니까?")) {
			case JOptionPane.OK_OPTION : 
				JTable jt = lmv.getJtOrder();
				jt.setValueAt("Y", selectedRow, 10);//테이블의 값만 변경
				////////////////////////////////////
				//01-17-2019: 주문 변경은 내일
				/////////////////////////////////
				
				
			}//end switch
		}//end if
		
		
		
	}//actionPerformed

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
