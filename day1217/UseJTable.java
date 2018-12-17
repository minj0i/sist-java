package day1217;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * MVC Pattern이 적용된 class
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJTable extends JFrame implements ActionListener {

	private JButton btnAdd;
	private DefaultTableModel dtm;
	private JTable jt;
	private UseJTable ujt; //인스턴스변수 만들고
	
	public UseJTable() {
		super("JTable연습");
		ujt = this; //this에다가 할당
		//1.데이터를 관리하는 Model클래스의 생성
		String[] columnNames= {"번호", "이름", "주소","이메일"};
		String[][] rowData = {
				{"1","이재찬","인천시 소래동","chan@test.com"},
				{"2","정택성","서울시 구로동","tack@sist.com"},
				{"3","이재현","경기도 안양시","hyun@gmail.com"},
		};
		//값을 관리하는 객체 : Button보다 위로 올라가야함 -> private으로 선언
		dtm = new DefaultTableModel(rowData, columnNames) {
			//anonymous inner클래스
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		//2. 데이터를 보여주는 View클래스(객체) 생성
		jt = new JTable(dtm);
		//컬럼의 크기 바꾸기 : View인 jtable을 가지고 바꿈
		//컬럼은 하나만 넓이를 변경하면 아래 컬럼도 동일한 크기를 적용받는다.
		//컬럼크기변경 1.: 컬럼을 얻는다.
		TableColumn tc = jt.getColumnModel().getColumn(0); //제일 첫번째가 0번째컬럼
		//컬럼크기변경 2.: 컬럼의 크기변경
		tc.setPreferredWidth(80);
		//한줄로 쓰기 - 전체 창의 크기를 넘지 말도록 유의
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(200);
		jt.getColumnModel().getColumn(3).setPreferredWidth(170);
		
		//테이블 행의 높이 변경
		jt.setRowHeight(25);
		
		btnAdd = new JButton("데이터 추가");
		//Column의 이름과 ScrollBar를 사용할 수 있도록 JScrollPane에 배치
		JScrollPane jsp = new JScrollPane(jt);
		JPanel jp = new JPanel();
		jp.add(btnAdd); 
		
		//3. 배치
		add("Center", jsp);
		add("South", jp);
		
		//이벤트등록
		btnAdd.addActionListener(this);
//		jt.addMouseListener(new TableEvt());//로 해도 됨
		//이너클래스 문법! 반드시 알아두기
		UseJTable.TableEvt te = this.new TableEvt();
		jt.addMouseListener(te);
		
		setBounds(100,100,500,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJtable

	@Override
	public void actionPerformed(ActionEvent ae) {
		String inputData = JOptionPane.showInputDialog("데이터를 입력\n 예)번호,이름,주소,이메일");
		
		String[] tempData = inputData.split(",");//toknizer써도 무방
		//유효성검증
		if(tempData.length!=4) {
			JOptionPane.showMessageDialog(this, "입력데이터의 형태는 \n 예)번호, 이름, 주소, 이메일", "입력 오류", JOptionPane.ERROR_MESSAGE);
			return; //void일때 return은 호출한 곳으로 돌아가버려 라는 뜻
		}//end if
		
		//입력된 데이터를 화면에 보여주기 위해 DefaultTableModel에 추가
		dtm.addRow(tempData);//String이 Object의 자식이므로 String으로 들어가짐
	}//actionPerformed

	//////////////////////////inner class 시작///////////////////////////
	public class TableEvt extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent me) {
//			System.out.println("행선택: "+jt.getSelectedRow()+"열선택: "+jt.getSelectedColumn());
//			System.out.println(jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn()));
//			String selectedValue = jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn());
			//Object(부모)이 String(자식)으로 들어가지 못함
			
//			String selectedValue = (String)jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn());
			//개발자스럽지 못한 방법 : 몇 개 안될때는 이게 나음
//			String selectedValue0 = (String)jt.getValueAt(jt.getSelectedRow(), 0);
//			String selectedValue1 = (String)jt.getValueAt(jt.getSelectedRow(), 1);
			
			//for문 사용
			StringBuilder viewData = new StringBuilder();
			int selectedRow = jt.getSelectedRow();
			int columncount = jt.getColumnCount();
			
			int flag = JOptionPane.showConfirmDialog(ujt, "예를 누르면 조회, 아니오를 누르면 삭제를 수행");
			switch(flag) {
			case JOptionPane.OK_OPTION:
				for(int i=0; i<columncount; i++) {
					viewData.append(jt.getValueAt(selectedRow, i)).append("\n");
				}//end for
				
			JOptionPane.showMessageDialog(ujt, viewData);
			
				break;
			case JOptionPane.NO_OPTION:
				switch(JOptionPane.showConfirmDialog(ujt, "정말 삭제하시겠습니까?")) {
				case JOptionPane.OK_OPTION:
					dtm.removeRow(selectedRow);
				}//end switch
			}//end switch
			
		}//mouseClicked
	}//class
	//////////////////////////inner class 끝///////////////////////////
	
	//main method는 제일 밑에 넣게 됨.
	//Java SE끝나면 거의 안넣게됨
	public static void main(String[] args) {
		new UseJTable(); //인스턴스 생성목적 : 객체를 생성하기 위해서
	}//main
	
}//class
