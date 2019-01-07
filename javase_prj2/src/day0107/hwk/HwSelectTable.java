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
			super("��� ���̺� ��ȸ");
			jTableSelect = new JLabel("���̺���");
			jcombobox = new JComboBox<String>();
			jbtselect = new JButton("����");
			
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
			//1.����̹��ε�
			try {
				Class.forName("oracle.jdbc.OracleDriver"); //�ݵ�� �ܿ��
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}//end catch
		
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
			//2.Connection���
				String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //�ݵ�� �ܿ��
				String dbo_id ="scott";
				String dbo_pass="tiger";
				con=DriverManager.getConnection(url, dbo_id, dbo_pass);
		
			//3.������ ���� ��ü ���
				stmt = con.createStatement();
			//4.������ ���� �� ��� ���
				StringBuilder selectName = new StringBuilder();
				selectName
				.append(" select tname ")
				.append(" from tab ");
				
				rs=stmt.executeQuery(selectName.toString());
				
				String tabname = null;
				
				while(rs.next()) {//��ȸ�� ���ڵ尡 �����Ѵٸ�
					//VO�� ���� �Ҵ��ϰ�
					//���� �̸��� ��ü�� ������ �����ϱ� ���� List�߰�
					tabname = new String(rs.getString("TNAME"));
					list.add(tabname);
				}//end while
				
				//list���� �迭�� �Ҵ�
				tab = new String[list.size()];
				list.toArray(tab);
				
			}finally {
			//5.���� ����
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
