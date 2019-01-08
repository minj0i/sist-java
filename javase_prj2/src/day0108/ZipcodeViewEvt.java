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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ZipcodeViewEvt extends WindowAdapter implements ActionListener {

	private ZipcodeView zv;
	
	
	public ZipcodeViewEvt(ZipcodeView zv) {
		this.zv = zv;
	}

	@Override
	public void windowClosing(WindowEvent we) {

	}//windowClosing
	
	//blockInjectionmethod 삭제 -> 안씀
	//PreparedStatement를 쓰는 것만으로도
	//Injection ' union select tname, '0,'0','0','0' from tab -- 를 넣어도 막힘
	
	/**
	 * PreparedStatement를 사용하여 SQLInjection을 방어
	 * @param dong
	 * @return
	 * @throws SQLException
	 */
	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException{
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		//1.드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//2.Connection얻기
			//jdbc가 oracle에 연결할건데 thin드라이버를 쓰고있고 @localhost 
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id ="scott";
			String pass = "tiger";
			
			con=DriverManager.getConnection(url, id, pass);
		//3.쿼리문 생성 객체 얻기
			StringBuilder selectZipcode = new StringBuilder();
			//bunji는 null로 나올 수 있으니 nvl로 제거함
			selectZipcode
			.append(" select zipcode,sido,gugun,dong,nvl(bunji,' ') bunji ")
			.append(" from zipcode ")
			.append(" where dong like ?||'%'");
			
			//preparedStatement는 홀따옴표를 못씀. ?%있으면 구분을 못함 -> ''로 묶고 ||로 이어줌
			//PreparedStatement의 버그 : bind변수를 인식 못할 때가 있음. (에러 날수도 있고 안날수도있고)
			
			System.out.println(selectZipcode);//호출관계를 확인하기 위해 넣어봄
			
			pstmt=con.prepareStatement(selectZipcode.toString());
		//4.바인드 변수에 값 넣기
			pstmt.setString(1, dong);
			
		//5.쿼리문 수행 후 결과 얻기
			
			rs=pstmt.executeQuery(/*selectZipcode.toString() 들어있으면 에러*/);

			ZipcodeVO zv = null;
			
			while(rs.next()){//조회된 레코드가 존재한다면
				//VO에 값을 할당하고 
				zv= new ZipcodeVO(rs.getString("zipcode"),rs.getString("sido"),rs.getString("gugun"),
						rs.getString("dong"),rs.getString("bunji"));
				//같은 이름의 객체를 여러개 관리하기 위해 List에 추가
				list.add(zv);
				
			}//end while
				
		}finally {
		//5.연결 끊기
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return list;
	}//selectZipcode
	
	public void searchZipcode(String dong) {
		try {
			//DB에서 조회한 결과를 받아
			List<ZipcodeVO> listZip = selectZipcode(dong);
			//DefaultTableModel에 추가 => JTable에 반영
			DefaultTableModel dtm = zv.getDtmZipcode();
			//D.T.M초기화
			dtm.setRowCount(0);
			//D.T.M에 행(Row: 우편번호, 주소) 추가
			
			String[] rowData = null;
			for(ZipcodeVO zv:listZip) {
				rowData=new String[2];
				rowData[0]=zv.getZipcode();
				rowData[1]=zv.getSido()+" "+zv.getGugun()+" "+zv.getDong()+" "+zv.getBunji();
				dtm.addRow(rowData);
			}//end for
			
			if(listZip.isEmpty()) {
				rowData = new String[2];
				rowData[0]="";
				rowData[1]="해당 동은 존재하지 않습니다.";
				
				dtm.addRow(rowData);
			}//end if
			
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(zv, "DB에서 문제가 발생하였습니다.");
			se.printStackTrace();
		}//end catch 
		
	}//searchZipcode
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String dong = zv.getJtfDong().getText().trim();
		if(!dong.equals("")) {
			searchZipcode(dong);
		}//end if
	}//actionPerformed

	
}//class
