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
		JLabel lbl = new JLabel("���̺� ����");
		CBtable = new JComboBox<String>();
		btnChoice = new JButton("����");
		JPanel pnlNorth = new JPanel();
		jta = new JTextArea();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.����̹� �ε�
			// 2.connection ���
			GetConnection gc = GetConnection.getInstance();
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id ="scott";
			String pass="tiger";
			con = gc.getConn(url, id, pass);

			// 3.������ ���� ��ü ��� : PreparedStatement ��ü�� ����Ǵ� �������� �ȴ�.
			String selectTab = "select table_name from tabs";
			pstmt = con.prepareStatement(selectTab);
			// 4.���ε� ������ �� ����
			// 5.���� ���� �� ��� ���
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CBtable.addItem(rs.getString("table_name"));
			}

		} finally {
			// 6.���� ����
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Evt �߰��ϸ� ����

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
