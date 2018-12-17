package day1217;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * MVC Pattern�� ����� class
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJTable extends JFrame implements ActionListener {

	private JButton btnAdd;
	private DefaultTableModel dtm;
	private JTable jt;
	private UseJTable ujt; //�ν��Ͻ����� �����
	
	public UseJTable() {
		super("JTable����");
		ujt = this; //this���ٰ� �Ҵ�
		//1.�����͸� �����ϴ� ModelŬ������ ����
		String[] columnNames= {"��ȣ", "�̸�", "�ּ�","�̸���"};
		String[][] rowData = {
				{"1","������","��õ�� �ҷ���","chan@test.com"},
				{"2","���ü�","����� ���ε�","tack@sist.com"},
				{"3","������","��⵵ �Ⱦ��","hyun@gmail.com"},
		};
		//���� �����ϴ� ��ü : Button���� ���� �ö󰡾��� -> private���� ����
		dtm = new DefaultTableModel(rowData, columnNames) {
			//anonymous innerŬ����
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		//2. �����͸� �����ִ� ViewŬ����(��ü) ����
		jt = new JTable(dtm);
		//�÷��� ũ�� �ٲٱ� : View�� jtable�� ������ �ٲ�
		//�÷��� �ϳ��� ���̸� �����ϸ� �Ʒ� �÷��� ������ ũ�⸦ ����޴´�.
		//�÷�ũ�⺯�� 1.: �÷��� ��´�.
		TableColumn tc = jt.getColumnModel().getColumn(0); //���� ù��°�� 0��°�÷�
		//�÷�ũ�⺯�� 2.: �÷��� ũ�⺯��
		tc.setPreferredWidth(80);
		//���ٷ� ���� - ��ü â�� ũ�⸦ ���� ������ ����
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(200);
		jt.getColumnModel().getColumn(3).setPreferredWidth(170);
		
		//���̺� ���� ���� ����
		jt.setRowHeight(25);
		
		btnAdd = new JButton("������ �߰�");
		//Column�� �̸��� ScrollBar�� ����� �� �ֵ��� JScrollPane�� ��ġ
		JScrollPane jsp = new JScrollPane(jt);
		JPanel jp = new JPanel();
		jp.add(btnAdd); 
		
		//3. ��ġ
		add("Center", jsp);
		add("South", jp);
		
		//�̺�Ʈ���
		btnAdd.addActionListener(this);
//		jt.addMouseListener(new TableEvt());//�� �ص� ��
		//�̳�Ŭ���� ����! �ݵ�� �˾Ƶα�
		UseJTable.TableEvt te = this.new TableEvt();
		jt.addMouseListener(te);
		
		setBounds(100,100,500,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJtable

	@Override
	public void actionPerformed(ActionEvent ae) {
		String inputData = JOptionPane.showInputDialog("�����͸� �Է�\n ��)��ȣ,�̸�,�ּ�,�̸���");
		
		String[] tempData = inputData.split(",");//toknizer�ᵵ ����
		//��ȿ������
		if(tempData.length!=4) {
			JOptionPane.showMessageDialog(this, "�Էµ������� ���´� \n ��)��ȣ, �̸�, �ּ�, �̸���", "�Է� ����", JOptionPane.ERROR_MESSAGE);
			return; //void�϶� return�� ȣ���� ������ ���ư����� ��� ��
		}//end if
		
		//�Էµ� �����͸� ȭ�鿡 �����ֱ� ���� DefaultTableModel�� �߰�
		dtm.addRow(tempData);//String�� Object�� �ڽ��̹Ƿ� String���� ����
	}//actionPerformed

	//////////////////////////inner class ����///////////////////////////
	public class TableEvt extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent me) {
//			System.out.println("�༱��: "+jt.getSelectedRow()+"������: "+jt.getSelectedColumn());
//			System.out.println(jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn()));
//			String selectedValue = jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn());
			//Object(�θ�)�� String(�ڽ�)���� ���� ����
			
//			String selectedValue = (String)jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn());
			//�����ڽ����� ���� ��� : �� �� �ȵɶ��� �̰� ����
//			String selectedValue0 = (String)jt.getValueAt(jt.getSelectedRow(), 0);
//			String selectedValue1 = (String)jt.getValueAt(jt.getSelectedRow(), 1);
			
			//for�� ���
			StringBuilder viewData = new StringBuilder();
			int selectedRow = jt.getSelectedRow();
			int columncount = jt.getColumnCount();
			
			int flag = JOptionPane.showConfirmDialog(ujt, "���� ������ ��ȸ, �ƴϿ��� ������ ������ ����");
			switch(flag) {
			case JOptionPane.OK_OPTION:
				for(int i=0; i<columncount; i++) {
					viewData.append(jt.getValueAt(selectedRow, i)).append("\n");
				}//end for
				
			JOptionPane.showMessageDialog(ujt, viewData);
			
				break;
			case JOptionPane.NO_OPTION:
				switch(JOptionPane.showConfirmDialog(ujt, "���� �����Ͻðڽ��ϱ�?")) {
				case JOptionPane.OK_OPTION:
					dtm.removeRow(selectedRow);
				}//end switch
			}//end switch
			
		}//mouseClicked
	}//class
	//////////////////////////inner class ��///////////////////////////
	
	//main method�� ���� �ؿ� �ְ� ��.
	//Java SE������ ���� �ȳְԵ�
	public static void main(String[] args) {
		new UseJTable(); //�ν��Ͻ� �������� : ��ü�� �����ϱ� ���ؼ�
	}//main
	
}//class
