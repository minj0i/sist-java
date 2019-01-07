package day0107;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StatementLoginEvt extends WindowAdapter implements ActionListener {

	private StatementLogin sl;

	public StatementLoginEvt(StatementLogin sl) {
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
				JOptionPane.showMessageDialog(sl, "아이디는 필수 입력");
				sl.getJtfId().requestFocus();
				flag = true;
				//return flag; 라고 넣어도 되지만 중간에 return이 들어가는 건 좋지 못한 문법. 맨 마지막에 나오도록 하는게 좋음
				//예외를 강제로 발생 : throw new 예외처리 객체명(); 
				//예외를 발생시켜 로그인에서 예외가 발생하면 비밀번호로 안흘러들어가게 함
				throw new LoginException();
			} // end if
			if (pass.equals("")) {
				JOptionPane.showMessageDialog(sl, "비밀번호는 필수 입력");
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
		//DB작업
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
			.append(" select name ")
			.append(" from test_login ")
			.append(" where id='").append(blockSqlInjection(id)).append("' and")
			.append(" pass='").append(blockSqlInjection(pass)).append("'");
			
			rs=stmt.executeQuery(selectName.toString());
			if(rs.next()) {//입력된 아이디와 비밀번호에 맞는 이름이 존재 => 로그인 성공
				name = rs.getString("name");
			}//end if
			
		}finally {
		//5.연결 끊기
			if (rs!=null) {rs.close();}//end if
			if (stmt!=null) {stmt.close();}//end if
			if (con!=null) {con.close();}//end if
		}//end finally
		
		return name;
	}//login
	
	public String blockSqlInjection(String data) {
		return data.replaceAll(" ", "").replaceAll("'","").replaceAll("--","");
	}//blockSqlInjection
	
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
						JOptionPane.showMessageDialog(sl,"아이디나 비밀번호를 확인해보세요");
						sl.getJtfId().setText("");
						sl.getJpfPass().setText("");
						sl.getJtfId().requestFocus();
						return; //아래줄로 흘러가지 못하게 return
					}//end if
					
					JDialog jd = new JDialog(sl, "로그인 성공", true);
					jd.add(new JLabel(name+"님 로그인 하셨습니다."));
					jd.setBounds(sl.getX()+100, sl.getY()+300, 300, 200);
					jd.setVisible(true);
					jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					
				}catch (SQLException se) {
					JOptionPane.showMessageDialog(sl,"DB작업 중 문제가 발생하였습니다.");
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
