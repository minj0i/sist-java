/*
 * 은영이코드 참고
 * package day0107.hwk;


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
public class HomeWorkView extends JFrame{
   
   private JComboBox<String> jcbTab;
   private JButton jbtOk;
   private String[] tab;
   
   public HomeWorkView() {
      super("테이블 검색");
      jcbTab=new JComboBox<String>();
      jbtOk=new JButton("선택");
      
      try {
         jcbTab.setModel(new DefaultComboBoxModel<String>(selectTable()));
      } catch (SQLException e) {
         e.printStackTrace();
      }//end catch
      
      JPanel panelNorth=new JPanel();
      panelNorth.add(new JLabel("테이블 선택 "));
      panelNorth.add(jcbTab);
      panelNorth.add(jbtOk);
      
      add("North",panelNorth);
      
      HomeWorkEvt hwe=new HomeWorkEvt(this);
      addWindowListener(hwe);
      jbtOk.addActionListener(hwe);
      
      setBounds(100, 100, 450, 300);
      setVisible(true);
      setResizable(false);
   }//HomeWorkView
   
   public String[] selectTable() throws SQLException{
      List<String> list=new ArrayList<String>();
      //1.드라이버 <로딩>
      try {
         Class.forName("oracle.jdbc.OracleDriver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }//end catch
      
      Connection con =null;
      Statement stmt=null;
      ResultSet rs=null;
      
      try {
      //2.Connection 얻기
         String url="jdbc:oracle:thin:@localhost:1521:orcl";
         String id="scott";
         String pass="tiger";
         con=DriverManager.getConnection(url, id, pass);
      //3.쿼리문 <생성> 객체 얻기
         stmt=con.createStatement();
      //4.쿼리 <수행 후> 결과 얻기 
         StringBuilder selectZipcode=new StringBuilder();
         selectZipcode
         .append(" select tname  ")//null이면 whitespace주고 alias로 이름 다시 
         .append(" from tab ");
         
         rs=stmt.executeQuery(selectZipcode.toString());
         
         String tabname=null;
         while(rs.next()) {//조회된 레코드가 존재한다면
            //VO에 값을 할당하고 
            //같은 이름의 객체를 여러개 관리하기 위해 List에 추가
            tabname=new String(rs.getString("TNAME"));
            list.add(tabname);
         }//end while
         
         //list값을 배열에 할당
         tab= new String[list.size()];
          list.toArray(tab);
            
      }finally {
         //5.연결 끊기
         if(rs!=null) {rs.close(); }//end if
         if(stmt!=null) {stmt.close(); }//end if
         if(con!=null) {con.close(); }//end if
      }//end finally
      
      return tab;
   }//selectZipcode
   
   public JComboBox<String> getJcbTab() {
      return jcbTab;
   }
   public JButton getJbtOk() {
      return jbtOk;
   }

   public static void main(String[] args) {
      new HomeWorkView();
   }//main
   
}//HomeWorkView
 */