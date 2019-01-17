package kr.co.sist.lunch.admin.view;

import java.awt.BorderLayout;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.controller.LunchMainController;

@SuppressWarnings("serial")
public class LunchMainView extends JFrame {
	private JTabbedPane jtb;
	private DefaultTableModel dtmLunch, dtmOrder, dtmCalc; //메뉴, 주문, 정산
	private JButton jbtAddLunch, jbtCalcOrder;
	private JComboBox<Integer> jcbYear;
	private JComboBox<Integer> jcbMonth;
	private JComboBox<Integer> jcbDay;
	private JTable jtLunch, jtOrder;//메뉴, 주문
	
	private DefaultComboBoxModel<Integer> dcbmYear, dcbmMonth, dcbmDay;
	
	private Calendar cal;
	
	public static String adminId;
	
	private JPopupMenu jpOrderMenu;
	private JMenuItem jmOrderRemove, jmOrderStatus;
	
	public LunchMainView(String adminName){
		super("도시락 관리 [로그인 계정:"+adminName+"]");
		
		cal = Calendar.getInstance();
		
		jtb = new JTabbedPane();
		//도시락
		String[] lunchColumns = {"번호", "도시락코드", "이미지", "도시락명", "가격"};
		dtmLunch = new DefaultTableModel(lunchColumns, 4) {
			//더블클릭 눌러도 편집되지 못하도록
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
		};
		
		jtLunch = new JTable(dtmLunch) {
			@Override //이미지로 들어갈 수 있도록
			public Class getColumnClass(int column) {//제네릭 쓰지 않고
				return getValueAt(0, column).getClass();//row는 아무거나 숫자
			}
		};
		
		//도시락의 크기를 설정 : 전체 width 800, 도시락이미지 (W122X H110)  
		jtLunch.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtLunch.getColumnModel().getColumn(1).setPreferredWidth(120);
		jtLunch.getColumnModel().getColumn(2).setPreferredWidth(200);
		jtLunch.getColumnModel().getColumn(3).setPreferredWidth(200);
		jtLunch.getColumnModel().getColumn(4).setPreferredWidth(200);
		
		//테이블의 높이
		jtLunch.setRowHeight(110);
		
		//정산
		String[] calcColumns = {"번호", "도시락명(도시락코드)", "수량", "가격"};
		dtmCalc= new DefaultTableModel(calcColumns, 4) {
			//모든 행을 편집할 수 없는 상태로 만들어 줌
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
		};
		//이벤트 발생 안해서 위로 빠질 필요가 없음
		JTable jtCalc = new JTable(dtmCalc);
		//정산 테이블 컬럼 넓이 설정 : 전체 800,
		jtCalc.getColumnModel().getColumn(0).setPreferredWidth(100);
		jtCalc.getColumnModel().getColumn(1).setPreferredWidth(400);
		jtCalc.getColumnModel().getColumn(2).setPreferredWidth(150);
		jtCalc.getColumnModel().getColumn(3).setPreferredWidth(150);
		
		//정산테이블의 높이 설정
		jtCalc.setRowHeight(25);
		
		//주문
		String[] orderColumns = {"번호", "주문번호", "도시락코드", "도시락명", 
				"주문자명", "수량", "가격", "주문일", "연락처", "주문자ip", "제작상태"};
		dtmOrder= new DefaultTableModel(orderColumns, 4) {
			//모든 행을 편집할 수 없는 상태로 만들어 줌
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
		};
		jtOrder = new JTable(dtmOrder);
				
		//주문 테이블 컬럼 넓이 설정 : 전체 800
		jtOrder.getColumnModel().getColumn(0).setPreferredWidth(30);
		jtOrder.getColumnModel().getColumn(1).setPreferredWidth(105);
		jtOrder.getColumnModel().getColumn(2).setPreferredWidth(70);
		jtOrder.getColumnModel().getColumn(3).setPreferredWidth(70);
		jtOrder.getColumnModel().getColumn(4).setPreferredWidth(55);
		jtOrder.getColumnModel().getColumn(5).setPreferredWidth(30);
		jtOrder.getColumnModel().getColumn(6).setPreferredWidth(50);
		jtOrder.getColumnModel().getColumn(7).setPreferredWidth(130);
		jtOrder.getColumnModel().getColumn(8).setPreferredWidth(100);
		jtOrder.getColumnModel().getColumn(9).setPreferredWidth(100);
		jtOrder.getColumnModel().getColumn(10).setPreferredWidth(60);
						
		//테이블의 높이
		jtOrder.setRowHeight(23);
		
		jbtAddLunch = new JButton("도시락추가");
		jbtCalcOrder = new JButton("정산");
		
		dcbmYear = new DefaultComboBoxModel<Integer>();
		jcbYear = new JComboBox<Integer>(dcbmYear);
		
		dcbmMonth = new DefaultComboBoxModel<Integer>();
		jcbMonth = new JComboBox<Integer>(dcbmMonth);
		
		dcbmDay = new DefaultComboBoxModel<Integer>();
		jcbDay = new JComboBox<Integer>(dcbmDay);
		
		JScrollPane jspLunch = new JScrollPane(jtLunch);
		jspLunch.setBorder(new TitledBorder("도시락 목록"));
		JScrollPane jspOrder = new JScrollPane(jtOrder);
		jspOrder.setBorder(new TitledBorder("주문 목록"));
		JScrollPane jspCalc = new JScrollPane(jtCalc);
		jspCalc.setBorder(new TitledBorder("정산 목록"));
	
		
		
		//처음 탭에 들어갈 컴포넌트 배치
		JPanel jplLunch = new JPanel();
		jplLunch.setLayout(new BorderLayout());
		
		JPanel jpLunchNorth = new JPanel();
		jpLunchNorth.add(jbtAddLunch);
		jplLunch.add("Center", jspLunch);
		jplLunch.add("North", jpLunchNorth);
		
		jtb.add("도시락",jplLunch);
		
		//두번째 탭에 들어갈 컴포넌트 배치
		JPanel jpOrder = new JPanel();
		jpOrder.setLayout(new BorderLayout());
		jpOrder.add(jspOrder);
		
		jtb.add("주문",jpOrder);
		
		//세번째 탭에 들어갈 컴포넌트 배치
		JPanel jpCalc = new JPanel();
		jpCalc.setLayout(new BorderLayout());
		JPanel jpCalcNorth = new JPanel();
		jpCalcNorth.setBorder(new TitledBorder("정산일자 선택"));
		jpCalcNorth.add(jcbYear);
		jpCalcNorth.add(new JLabel("년"));
		jpCalcNorth.add(jcbMonth);
		jpCalcNorth.add(new JLabel("월"));
		jpCalcNorth.add(jcbDay);
		jpCalcNorth.add(new JLabel("일"));
		jpCalcNorth.add(jbtCalcOrder);
		
		jpCalc.add("North", jpCalcNorth);
		jpCalc.add("Center", jspCalc);
		
		jtb.add("정산",jpCalc);
		
		jpOrderMenu = new JPopupMenu();
		jmOrderRemove = new JMenuItem("주문삭제");
		jmOrderStatus = new JMenuItem("제작완료");
		
		jpOrderMenu.add(jmOrderStatus);
		jpOrderMenu.addSeparator();
		jpOrderMenu.add(jmOrderRemove);
		
		//탭을 프레임에 배치
		add("Center", jtb);
		setYear(); //JCBYear 설정
		setMonth();//JCBMonth 설정
		setDay();//jcbDay 설정
		
		LunchMainController lmc = new LunchMainController(this);
		addWindowListener(lmc);
		
		jtb.addMouseListener(lmc);//탭에서 이벤트가 발생했을 때
		jtLunch.addMouseListener(lmc);
		jtOrder.addMouseListener(lmc);
		
		jbtAddLunch.addActionListener(lmc);
		jbtCalcOrder.addActionListener(lmc);
		
		jcbMonth.addActionListener(lmc);
		
		jmOrderRemove.addActionListener(lmc);
		jmOrderStatus.addActionListener(lmc);
		
		setBounds(100, 100, 800, 600);
		setVisible(true);
		
	}//LunchMainView

	private void setYear() {//현재년도의 4년 전까지
		int year = cal.get(Calendar.YEAR);
		for(int temp=0; temp<4; temp++) {
			dcbmYear.addElement(year-temp);
		}//end for
		jcbYear.setSelectedItem(new Integer(year));//지금 날짜가 선택되도록
		
	}//setYear
	
	private void setMonth() { //1~12월
		int now_month=cal.get(Calendar.DAY_OF_MONTH)+1;
			for(int month=1; month<13; month++) {
			dcbmMonth.addElement(month);
			}//end for
			jcbMonth.setSelectedItem(new Integer(now_month));
	}//setMonth
	
	private void setDay() {//그 월의 마지막 날
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int nowDay = cal.get(Calendar.DAY_OF_MONTH);
			for(int day=1; day<lastDay+1; day++) {
			dcbmDay.addElement(day);
			}//end for
		jcbDay.setSelectedItem(new Integer(nowDay));
	}//setDay
	
	public JTabbedPane getJtb() {
		return jtb;
	}

	public DefaultTableModel getDtmLunch() {
		return dtmLunch;
	}

	public DefaultTableModel getDtmOrder() {
		return dtmOrder;
	}

	public DefaultTableModel getDtmCalc() {
		return dtmCalc;
	}

	public JButton getJbtAddLunch() {
		return jbtAddLunch;
	}

	public JButton getJbtCalcOrder() {
		return jbtCalcOrder;
	}

	public JComboBox<Integer> getJcbYear() {
		return jcbYear;
	}

	public JComboBox<Integer> getJcbMonth() {
		return jcbMonth;
	}

	public JComboBox<Integer> getJcbDay() {
		return jcbDay;
	}

	public JTable getJtLunch() {
		return jtLunch;
	}

	public JTable getJtOrder() {
		return jtOrder;
	}

	public DefaultComboBoxModel<Integer> getDcbmYear() {
		return dcbmYear;
	}

	public DefaultComboBoxModel<Integer> getDcbmMonth() {
		return dcbmMonth;
	}

	public DefaultComboBoxModel<Integer> getDcbmDay() {
		return dcbmDay;
	}

	public Calendar getCal() {
		return cal;
	}

	public static String getAdminId() {
		return adminId;
	}

	public JPopupMenu getJpOrderMenu() {
		return jpOrderMenu;
	}

	public JMenuItem getJmOrderRemove() {
		return jmOrderRemove;
	}

	public JMenuItem getJmOrderStatus() {
		return jmOrderStatus;
	}

	
	
}//class
