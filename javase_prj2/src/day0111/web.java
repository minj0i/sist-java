package day0111;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class web extends JFrame implements ActionListener {

	private JTable jb;

	public web() {
		String[] columnName = { "�ΰ�", "URL", "Ư¡" };
		Object[][] rowData = new Object[3][4];
		rowData[0][0] = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/daum.png");
		rowData[1][0] = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/google.png");
		rowData[2][0] = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/naver.png");
		
		rowData[0][1] = "www.daum.net";
		rowData[1][1] = "www.naver.com";
		rowData[2][1] = "www.google.com";

		rowData[0][2] = "īī��������";
		rowData[1][2] = "����";
		rowData[2][2] = "�ְ� �˻�";

		DefaultTableModel dtm = new DefaultTableModel(rowData, columnName) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};//dtm
		// �Էµ� Ŭ������ �״�� Cell(Columns)�� ǥ���ǵ��� method Override
		// getColumnClass(int column)

		JTable jt = new JTable(dtm) {
			@Override
			public Class getColumnClass(int column) {
				// row-JTable�� �Էµ� ������ �迭�� �࿡ ���Ѵٸ�
				// ��� �÷��� ���� �Էµ� ������ ��ȯ�Ѵ�
//				return getValueAt(0, 0).getClass();//0��° column�� . �ι�°���� �ȳ���
				return getValueAt(0, column).getClass();// �Էµ� � ���̵� ����
			}
		};
		JScrollPane jsp = new JScrollPane(jt);
		jt.getTableHeader().setReorderingAllowed(false);// �÷��̵� ����
		jt.getTableHeader().setResizingAllowed(false);// �÷��� ũ�� ���� ����

		jt.getColumnModel().getColumn(0).setPreferredWidth(160);
		jt.getColumnModel().getColumn(1).setPreferredWidth(200);
		jt.getColumnModel().getColumn(2).setPreferredWidth(140);
		
		jt.setRowHeight(50);
		
		add("Center", jsp);

		setBounds(100, 100, 500, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}// actionPerformed

	public static void main(String[] args) {
		new web();
	}// main
}// class
