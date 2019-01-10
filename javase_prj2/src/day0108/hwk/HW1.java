package day0108.hwk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import kr.co.sist.connection.GetConnection;

@SuppressWarnings("serial")
public class HW1 extends JFrame {

	private JComboBox<String> CBtable;
	private JButton btnChoice;
	private JTextArea jta;

	public HW1() throws SQLException {
		JLabel lbl = new JLabel("테이블 선택");
		CBtable = new JComboBox<String>();
		btnChoice = new JButton("선택");
		JPanel pnlNorth = new JPanel();
		jta = new JTextArea();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.드라이버 로딩
			// 2.connection 얻기
			GetConnection gc = GetConnection.getInstance();
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id ="scott";
			String pass="tiger";
			con = gc.getConn(url, id, pass);

			// 3.쿼리문 생성 객체 얻기 : PreparedStatement 객체는 실행되는 쿼리문을 안다.
			String selectTab = "select table_name from tabs";
			pstmt = con.prepareStatement(selectTab);
			// 4.바인드 변수에 값 설정
			// 5.쿼리 수행 후 결과 얻기
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CBtable.addItem(rs.getString("table_name"));
			}

		} finally {
			// 6.연결 끊기
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		pnlNorth.add(lbl);
		pnlNorth.add(CBtable);
		pnlNorth.add(btnChoice);
		add("North", pnlNorth);
		add(jta);
		HW1Evt hw1Evt = new HW1Evt(this);
		CBtable.addActionListener(hw1Evt);
		btnChoice.addActionListener(hw1Evt);

		setVisible(true);
		setBounds(100, 100, 500, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Evt 추가하면 삭제

	}// constructor

	public JTextArea getJta() {
		return jta;
	}

	public JComboBox<String> getCBtable() {
		return CBtable;
	}

	public JButton getBtnChoice() {
		return btnChoice;
	}

	public static void main(String[] args) {
		try {
			new HW1();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
