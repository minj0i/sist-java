package day0108;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PreparedStatementLoginEvt extends WindowAdapter implements ActionListener {

	private PreparedStatementLogin sl;

	public PreparedStatementLoginEvt(PreparedStatementLogin sl) {
		this.sl = sl;
	}

	@Override
	public void windowClosing(WindowEvent we) {
		sl.dispose();
	}// windowClosing

	public boolean chkNull(String id, String pass) {
		boolean flag = false;
	
		try {
			if (id.equals("")) {
				JOptionPane.showMessageDialog(sl, "���̵�� �ʼ� �Է�");
				sl.getJtfId().requestFocus();
				flag = true;
				//return flag; ��� �־ ������ �߰��� return�� ���� �� ���� ���� ����. �� �������� �������� �ϴ°� ����
				//���ܸ� ������ �߻� : throw new ����ó�� ��ü��(); 
				//���ܸ� �߻����� �α��ο��� ���ܰ� �߻��ϸ� ��й�ȣ�� ���귯���� ��
				throw new LoginException();
			} // end if
			if (pass.equals("")) {
				JOptionPane.showMessageDialog(sl, "��й�ȣ�� �ʼ� �Է�");
				sl.getJpfPass().requestFocus();
				flag = true;
			} // end if
		}catch(LoginException le) {
			le.printStackTrace();
		}
		return !flag;
	}// chkNull

	public String login(String id, String pass) throws SQLException {
		String name ="";
		//DB�۾�
		//1.����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //�ݵ�� �ܿ��
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//2.Connection���
			String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //�ݵ�� �ܿ��
			String dbo_id ="scott";
			String dbo_pass="tiger";
			con=DriverManager.getConnection(url, dbo_id, dbo_pass);
	
		//3.������ ���� ��ü ���
			StringBuilder selectName = new StringBuilder();
			selectName
			.append(" select name ")
			.append(" from test_login ")
			.append(" where id= ? and pass= ?");
			
			pstmt = con.prepareStatement(selectName.toString());
		//4.���ε� ������ �� �ֱ�
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
		
//			System.out.println(selectName);//���ε� ������ �� ������ �����
		//Prepared�� ���� Injection : ' or 1=1 --
			
		//5.������ ���� �� ��� ���
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//�Էµ� ���̵�� ��й�ȣ�� �´� �̸��� ���� => �α��� ����
				name = rs.getString("name");
			}//end if
			
		}finally {
		//6.���� ����
			if (rs!=null) {rs.close();}//end if
			if (pstmt!=null) {pstmt.close();}//end if
			if (con!=null) {con.close();}//end if
		}//end finally
		
		return name;
	}//login
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==sl.getJtfId() || ae.getSource()==sl.getJpfPass()
				||ae.getSource()==sl.getJbtLogin()) {
			String id = sl.getJtfId().getText().trim();
			String pass = new String(sl.getJpfPass().getPassword()).trim();
			if(chkNull(id, pass)) {
				
				try {
					String name = login(id,pass);
					
					if(name.isEmpty()) {
						JOptionPane.showMessageDialog(sl,"���̵� ��й�ȣ�� Ȯ���غ�����");
						sl.getJtfId().setText("");
						sl.getJpfPass().setText("");
						sl.getJtfId().requestFocus();
						return; //�Ʒ��ٷ� �귯���� ���ϰ� return
					}//end if
					
					JDialog jd = new JDialog(sl, "�α��� ����", true);
					jd.add(new JLabel(name+"�� �α��� �ϼ̽��ϴ�."));
					jd.setBounds(sl.getX()+100, sl.getY()+300, 300, 200);
					jd.setVisible(true);
					jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					
				}catch (SQLException se) {
					JOptionPane.showMessageDialog(sl,"DB�۾� �� ������ �߻��Ͽ����ϴ�.");
					se.printStackTrace();
				}//end catch
			}//end if
		}//end if
		if(ae.getSource()==sl.getJbtCancel()) {
			sl.getJtfId().setText("");
			sl.getJpfPass().setText("");
			sl.getJtfId().requestFocus();
		}//end if
		
	}// actionPerformed

}// class
