package day0110;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import kr.co.sist.connection.GetConnection;

/**
 * Transaction처리
 * 
 * @author owner
 */
public class TestTransaction {
	// Commit과 Rollback을 DB작업 외부에서 처리할 수 있도록 class field에 정의
	private Connection con = null;

	public boolean insert(TransactionVO tv) throws SQLException {
		// transaction에 사용할 쿼리 갯수만큼 쿼리실행 객체 선언. 하나만 있으면 끊어지게 되므로.
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;

		boolean flag = false;

		try {
			// 1.
			// 2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			con = GetConnection.getInstance().getConn(url, id, pass);
			// auto commit 해제
			con.setAutoCommit(false);

			// 3.
			String sql = "insert into test_transaction1(Subject, writer)values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tv.getSubject());
			pstmt.setString(2, tv.getWriter());
			// 4.
			int cnt = pstmt.executeUpdate();
			// 3.
			String sql1 = "insert into test_transaction2(Subject, writer)values(?,?)";
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, tv.getSubject());
			pstmt1.setString(2, tv.getWriter());
			// 4.
			int cnt1 = pstmt1.executeUpdate();
			
			//트랜잭션에 해당하는 모든 쿼리의 목표 수행 수를 비교하여
			//commit과 rollback여부를 설정한다.
			if (cnt == 1 && cnt1 == 1) {
				flag = true;
			} // end if

			/*
			 * 기존의 코딩형태로 transaction처리하면 안됨 -> commit과 rollback을 밖에서 해야됨 int cnt1 =
			 * pstmt.executeUpdate(); if(cnt==1 && cnt1 ==1) { con.commit();
			 * System.out.println("커밋!!!"); }else { con.rollback();
			 * System.out.println("롤백!!!"); }//end else
			 */
		} finally {
			// 6.
//			boolean으로 바꾸어 flag를 하면 끊을 필요 없음. 끊으면 auto commit 되므로
//			if(pstmt!=null) {pstmt.close();}//end if
//			if(con!=null) {con.close();}//end if
		} // end catch
		return flag;
	}// insert

	public void add() {
		String inputData = JOptionPane.showInputDialog("제목과 작성자를 입력해주세요.\n 제목-작성자");

		String[] data = inputData.split("-");

		if (data.length != 2) {
			JOptionPane.showMessageDialog(null, "입력형식을 확인해주세요.");
			return;
		} // end if
		TransactionVO tv = new TransactionVO(data[0], data[1]);

		try {
			// DB업무를 사용하는 곳에서 수행 결과를 받아 = 여기서 boolean flag = insert(tv)로 받아
			boolean flag = insert(tv);
			if (flag) {
				// if/else로 커밋하거나
				con.commit();
				System.out.println("커밋");
			} else { // update나 delete가 transaction일 때 필요 //insert는 무조건 예 를 탐
				// rollback한다.
				con.rollback();
				System.out.println("update/ delete 롤백");
			} // end else
		} catch (SQLException e) {
			try {// insert는 위에 else를 안타기 때문에 얘를 해줘야함.
				con.rollback();
				System.out.println("insert 롤백");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				con.close(); // con끊으면 pstmt도 끊김
				// pstmt도 끊고 싶으면 이건 private으로 올린다음 끊어줌
			} catch (SQLException e) {
				e.printStackTrace();
			} // end catch
		} // end finally

	}// add

	public static void main(String[] args) {
		TestTransaction tt = new TestTransaction();
		tt.add();
	}// main

}// class
