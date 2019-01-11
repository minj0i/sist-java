package day0111;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class web extends JFrame implements ActionListener {

	private JTable jb;

	public web() {
		String[] columnName = { "로고", "URL", "특징" };
		Object[][] rowData = new Object[3][4];
		rowData[0][0] = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/daum.png");
		rowData[1][0] = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/google.png");
		rowData[2][0] = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/naver.png");
		
		rowData[0][1] = "www.daum.net";
		rowData[1][1] = "www.naver.com";
		rowData[2][1] = "www.google.com";

		rowData[0][2] = "카카오프렌즈";
		rowData[1][2] = "웹툰";
		rowData[2][2] = "최강 검색";

		DefaultTableModel dtm = new DefaultTableModel(rowData, columnName) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};//dtm
		// 입력된 클래스가 그대로 Cell(Columns)에 표현되도록 method Override
		// getColumnClass(int column)

		JTable jt = new JTable(dtm) {
			@Override
			public Class getColumnClass(int column) {
				// row-JTable에 입력된 이차원 배열의 행에 속한다면
				// 모든 컬럼의 값을 입력된 형으로 반환한다
//				return getValueAt(0, 0).getClass();//0번째 column만 . 두번째부터 안나옴
				return getValueAt(0, column).getClass();// 입력된 어떤 행이든 간에
			}
		};
		JScrollPane jsp = new JScrollPane(jt);
		jt.getTableHeader().setReorderingAllowed(false);// 컬럼이동 막기
		jt.getTableHeader().setResizingAllowed(false);// 컬럼의 크기 변경 막기

		jt.getColumnModel().getColumn(0).setPreferredWidth(160);
		jt.getColumnModel().getColumn(1).setPreferredWidth(200);
		jt.getColumnModel().getColumn(2).setPreferredWidth(140);
		
		jt.setRowHeight(50);
		
		add("Center", jsp);

		setBounds(100, 100, 500, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}// actionPerformed

	public static void main(String[] args) {
		new web();
	}// main
}// class
