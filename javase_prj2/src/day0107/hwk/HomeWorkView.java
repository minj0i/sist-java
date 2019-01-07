/*
 * �������ڵ� ����
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
      super("���̺� �˻�");
      jcbTab=new JComboBox<String>();
      jbtOk=new JButton("����");
      
      try {
         jcbTab.setModel(new DefaultComboBoxModel<String>(selectTable()));
      } catch (SQLException e) {
         e.printStackTrace();
      }//end catch
      
      JPanel panelNorth=new JPanel();
      panelNorth.add(new JLabel("���̺� ���� "));
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
      //1.����̹� <�ε�>
      try {
         Class.forName("oracle.jdbc.OracleDriver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }//end catch
      
      Connection con =null;
      Statement stmt=null;
      ResultSet rs=null;
      
      try {
      //2.Connection ���
         String url="jdbc:oracle:thin:@localhost:1521:orcl";
         String id="scott";
         String pass="tiger";
         con=DriverManager.getConnection(url, id, pass);
      //3.������ <����> ��ü ���
         stmt=con.createStatement();
      //4.���� <���� ��> ��� ��� 
         StringBuilder selectZipcode=new StringBuilder();
         selectZipcode
         .append(" select tname  ")//null�̸� whitespace�ְ� alias�� �̸� �ٽ� 
         .append(" from tab ");
         
         rs=stmt.executeQuery(selectZipcode.toString());
         
         String tabname=null;
         while(rs.next()) {//��ȸ�� ���ڵ尡 �����Ѵٸ�
            //VO�� ���� �Ҵ��ϰ� 
            //���� �̸��� ��ü�� ������ �����ϱ� ���� List�� �߰�
            tabname=new String(rs.getString("TNAME"));
            list.add(tabname);
         }//end while
         
         //list���� �迭�� �Ҵ�
         tab= new String[list.size()];
          list.toArray(tab);
            
      }finally {
         //5.���� ����
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