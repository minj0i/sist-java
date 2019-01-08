package day0108.hwk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class work0107Evt extends WindowAdapter implements ActionListener, ItemListener {
   private work0107View wk;
   private String comboSelect;
   private String[][] rowData;

   public work0107Evt() {
   }

   public work0107Evt(work0107View wk) {
      this.wk = wk;
   }

   private void searchColumn() throws SQLException{
      clearAll();
      // 1.드라이버 로딩
      try {
         Class.forName("oracle.jdbc.OracleDriver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      ResultSetMetaData rsmd = null;
      try {
         // 2. connection 얻기
         String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
         String id = "scott";
         String pass = "tiger";
         con = DriverManager.getConnection(url, id, pass);
         // 3. 쿼리문 수행 객체얻기
         String str = null;
         //4. 바인드변수 값 넣기
         System.out.println(comboSelect);
         str = "select * from " + comboSelect;
         pstmt = con.prepareStatement(str);
         rs = pstmt.executeQuery();
         rsmd = rs.getMetaData();
         rowData = new String[20][5];
         int i=0;
         while (rs.next()) {
            i++;
            rowData[i][0] = rsmd.getColumnLabel(i);
            rowData[i][1] = rsmd.getColumnTypeName(i);
            rowData[i][2] = String.valueOf(rsmd.getPrecision(i));
            wk.getDtmSelect().addRow(rowData[i]);
         }

      } finally {
         // 5. 연결끊기
    	  if(rs!=null) {rs.close();};
    	  if(pstmt!=null) {pstmt.close();};
    	  if(con!=null) {con.close();};
    	  
      }
   }

   @Override
   public void windowClosing(WindowEvent e) {
      wk.dispose();
   }

   @Override
   public void windowClosed(WindowEvent e) {
      System.exit(0);
   }

   @Override
   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == wk.getJbnSelect()) {
         wk.getDtmSelect().addRow(rowData);
      }
      try {
         searchColumn();
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

   @Override
   public void itemStateChanged(ItemEvent we) {
      comboSelect = wk.getJcbTable().getSelectedItem().toString();
      System.out.println(comboSelect);
   }
   public void clearAll() {
     wk.getDtmSelect().setNumRows(0);
  }

}
