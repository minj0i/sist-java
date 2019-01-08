package day0108.hwk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import day0107.ZipcodeVO;

public class TableSelectViewEvt extends WindowAdapter implements ActionListener{
	private TableSelectView tv;
	private String selectTName;
	private TableSelectDAO tsdao;
	
	public TableSelectViewEvt(TableSelectView tv) {
		this.tv = tv;
		List<String> tableNames = new ArrayList<String>();
		tsdao = new TableSelectDAO();
		
		try {
			tableNames = tsdao.getTableName();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<tableNames.size(); i++) {
			tv.getJcbTableSelect().addItem(tableNames.get(i));
		}
		
		selectTName = tv.getJcbTableSelect().getItemAt(0);
		
	}

	//���ý� ���̺� �̸� �����ϴ� ��
	public String selectTableName() {
		String selectTName = "";
		selectTName = tv.getJcbTableSelect().getSelectedItem().toString();

		return selectTName;
	}
	
	//������ ���̺� �̸� �����ϴ� ��
	public void applyTableContents() {
		try {
			//DB���� ��ȸ�� ����� �޾� 
			List<String[]> listTableColums = tsdao.getTableColums(selectTName);
			//defaultTableModel�� �߰� => Jtable �ݿ�
			DefaultTableModel dtm = tv.getDtmTableContents();
			//D.T.M �ʱ�ȭ
			dtm.setRowCount(0);
			
			String[] rowData = null;
			//��ȸ�� ����� ������
			for(int i=0; i<listTableColums.size(); i++) {
				rowData = new String[4];
				rowData[0] = listTableColums.get(i)[0];
				rowData[1] = listTableColums.get(i)[1];
				rowData[2] = listTableColums.get(i)[2];
				rowData[3] = listTableColums.get(i)[3];
				
				//D.T.M�� ��(Row : �����ȣ, �ּ�) �߰�
				dtm.addRow(rowData);
			}
			
			if(listTableColums.isEmpty()) {
				rowData=new String[4];
				rowData[0]="�ش� ���̺�";
				rowData[1]="����";
				rowData[2]="��������";
				rowData[3]="�ʽ��ϴ�.";
				
				dtm.addRow(rowData);
			}
			
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(tv, "DB���� ������ �߻�");
			se.printStackTrace();
		}	
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == tv.getJcbTableSelect()) {
			selectTName = selectTableName();
		}
		if(ae.getSource() == tv.getJbtSelect()) {
			// DAO�� �Ű������� ���̺�� �־��� �� 
			applyTableContents();
		}	
	}
	
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		tv.dispose();
	}
}

