package day0108.hwk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class work0107View extends JFrame {
   private JLabel jlbselect ;
   private JComboBox<String> jcbTable;
   private JButton jbnSelect ;
   private DefaultTableModel dtmSelect;//+++
   public work0107View() {
      super("접속한 계정의 모든 table");
      jlbselect = new JLabel("테이블선택");
      jcbTable = new JComboBox<String>();
      jbnSelect = new JButton("선택");
      String[] columnNames = {"컬럼명","데이터형","크기","제약사항"};//++
      dtmSelect = new DefaultTableModel(columnNames,0);//++
      JTable jtSelect = new JTable(dtmSelect);//++
      JScrollPane jsp = new JScrollPane(jtSelect);//++
      jtSelect.getTableHeader().setReorderingAllowed(false);
      jtSelect.setRowHeight(24);
      
      jtSelect.getColumnModel().getColumn(0).setPreferredWidth(60);
      jtSelect.getColumnModel().getColumn(1).setPreferredWidth(30);
      jtSelect.getColumnModel().getColumn(2).setPreferredWidth(10);
      jtSelect.getColumnModel().getColumn(3).setPreferredWidth(100);
      
      setLayout(null);
      
      jlbselect.setBounds(40,20,100,50);
      add(jlbselect);
      
      jcbTable.setBounds(120, 20, 220, 50);
      add(jcbTable);
      
      jbnSelect.setBounds(350, 20, 70,50);
      add(jbnSelect);
      
      jsp.setBounds(40,80,400,300);//++
      add(jsp);//++
      
      jtSelect.setEnabled(false);//++
      
      //////이벤트//////
      work0107Evt wke = new work0107Evt(this);
      addWindowListener(wke);
      jbnSelect.addActionListener(wke);
      jcbTable.addItemListener(wke); //++
      try {
         selectTable();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      ///////////////////
      
      setBounds(100,100,500,500);
      setVisible(true);
      
   }
   public void selectTable() throws SQLException {

      //1.드라이버 로딩
      try {
         Class.forName("oracle.jdbc.OracleDriver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      Connection con = null;
      Statement stmt = null;
      ResultSet rs = null;
      try {
      //2. connection 얻기
         String url ="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
         String id = "scott";
         String pass ="tiger";
         con = DriverManager.getConnection(url, id, pass);
      //3. 쿼리문 수행 객체얻기
         stmt = con.createStatement();
      //4. 쿼리문 수행 후 결과얻기
         StringBuilder sb = new StringBuilder();
         sb.append("select tname from tab");
         
         rs = stmt.executeQuery(sb.toString());
         while(rs.next()) {
            jcbTable.addItem(rs.getString("tname"));      
         }      
      }finally {
         //5. 연결끊기         
      }
      
   }
   
   public JLabel getJlbselect() {
      return jlbselect;
   }
   public JComboBox<String> getJcbTable() {
      return jcbTable;
   }
   public JButton getJbnSelect() {
      return jbnSelect;
   }
   public DefaultTableModel getDtmSelect() {//++
      return dtmSelect;
   }
   
   public static void main(String[] args) {
      new work0107View();
   }

}
