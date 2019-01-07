package day0107.hwk;


import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



	@SuppressWarnings("serial")
	public class HwSelectTable extends JFrame{
		
		private JLabel jTableSelect;
		private JComboBox<String> jcombobox;
		private JButton jbtselect;
		private String[] tab;
		
		public HwSelectTable() {
			super("모든 테이블 조회");
			jTableSelect = new JLabel("테이블선택");
			jcombobox = new JComboBox<String>();
			jbtselect = new JButton("선택");
			
			try {
				jcombobox.setModel(new DefaultComboBoxModel<String>(selectTable()));
			}catch(SQLException e) {
				e.printStackTrace();
			}//end catch
			
			setLayout(new GridLayout(3, 1));
			JPanel panel = new JPanel();
			panel.add(jTableSelect);
			panel.add(jcombobox);
			panel.add(jbtselect);
			add(panel);
			
			HwSelectTableEvt hst = new HwSelectTableEvt(this);
			addWindowListener(hst);
			jbtselect.addActionListener(hst);
			
			setBounds(100,100,500,150);
			setVisible(true);
			setResizable(false);
			
		}//HwSelectTable
		
		public String[] selectTable() throws SQLException{
			List<String> list = new ArrayList<String>();
			//1.드라이버로딩
			try {
				Class.forName("oracle.jdbc.OracleDriver"); //반드시 외우기
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}//end catch
		
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
			//2.Connection얻기
				String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //반드시 외우기
				String dbo_id ="scott";
				String dbo_pass="tiger";
				con=DriverManager.getConnection(url, dbo_id, dbo_pass);
		
			//3.쿼리문 생성 객체 얻기
				stmt = con.createStatement();
			//4.쿼리문 수행 후 결과 얻기
				StringBuilder selectName = new StringBuilder();
				selectName
				.append(" select tname ")
				.append(" from tab ");
				
				rs=stmt.executeQuery(selectName.toString());
				
				String tabname = null;
				
				while(rs.next()) {//조회된 레코드가 존재한다면
					//VO에 값을 할당하고
					//같은 이름의 객체를 여러개 관리하기 위해 List추가
					tabname = new String(rs.getString("TNAME"));
					list.add(tabname);
				}//end while
				
				//list값을 배열에 할당
				tab = new String[list.size()];
				list.toArray(tab);
				
			}finally {
			//5.연결 끊기
				if (rs!=null) {rs.close();}//end if
				if (stmt!=null) {stmt.close();}//end if
				if (con!=null) {con.close();}//end if
			}//end finally
			
			return tab;
		}
		
		

		public JComboBox<String> getJcombobox() {
			return jcombobox;
		}

		public JButton getJbtselect() {
			return jbtselect;
		}


		public static void main(String[] args) {
			new HwSelectTable();
		}//main

}
