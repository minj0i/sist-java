package kr.co.sist.lunch.admin.view;

import java.awt.BorderLayout;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.controller.LunchMainController;

@SuppressWarnings("serial")
public class LunchMainView extends JFrame {
	private JTabbedPane jtb;
	private DefaultTableModel dtmLunch, dtmOrder, dtmCalc; //�޴�, �ֹ�, ����
	private JButton jbtAddLunch, jbtCalcOrder;
	private JComboBox<Integer> jcbYear;
	private JComboBox<Integer> jcbMonth;
	private JComboBox<Integer> jcbDay;
	private JTable jtLunch, jtOrder;//�޴�, �ֹ�
	
	private DefaultComboBoxModel<Integer> dcbmYear, dcbmMonth, dcbmDay;
	
	private Calendar cal;
	
	public static String adminId;
	
	private JPopupMenu jpOrderMenu;
	private JMenuItem jmOrderRemove, jmOrderStatus;
	
	public LunchMainView(String adminName){
		super("���ö� ���� [�α��� ����:"+adminName+"]");
		
		cal = Calendar.getInstance();
		
		jtb = new JTabbedPane();
		//���ö�
		String[] lunchColumns = {"��ȣ", "���ö��ڵ�", "�̹���", "���ö���", "����"};
		dtmLunch = new DefaultTableModel(lunchColumns, 4) {
			//����Ŭ�� ������ �������� ���ϵ���
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
		};
		
		jtLunch = new JTable(dtmLunch) {
			@Override //�̹����� �� �� �ֵ���
			public Class getColumnClass(int column) {//���׸� ���� �ʰ�
				return getValueAt(0, column).getClass();//row�� �ƹ��ų� ����
			}
		};
		
		//���ö��� ũ�⸦ ���� : ��ü width 800, ���ö��̹��� (W122X H110)  
		jtLunch.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtLunch.getColumnModel().getColumn(1).setPreferredWidth(120);
		jtLunch.getColumnModel().getColumn(2).setPreferredWidth(200);
		jtLunch.getColumnModel().getColumn(3).setPreferredWidth(200);
		jtLunch.getColumnModel().getColumn(4).setPreferredWidth(200);
		
		//���̺��� ����
		jtLunch.setRowHeight(110);
		
		//����
		String[] calcColumns = {"��ȣ", "���ö���(���ö��ڵ�)", "����", "����"};
		dtmCalc= new DefaultTableModel(calcColumns, 4) {
			//��� ���� ������ �� ���� ���·� ����� ��
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
		};
		//�̺�Ʈ �߻� ���ؼ� ���� ���� �ʿ䰡 ����
		JTable jtCalc = new JTable(dtmCalc);
		//���� ���̺� �÷� ���� ���� : ��ü 800,
		jtCalc.getColumnModel().getColumn(0).setPreferredWidth(100);
		jtCalc.getColumnModel().getColumn(1).setPreferredWidth(400);
		jtCalc.getColumnModel().getColumn(2).setPreferredWidth(150);
		jtCalc.getColumnModel().getColumn(3).setPreferredWidth(150);
		
		//�������̺��� ���� ����
		jtCalc.setRowHeight(25);
		
		//�ֹ�
		String[] orderColumns = {"��ȣ", "�ֹ���ȣ", "���ö��ڵ�", "���ö���", 
				"�ֹ��ڸ�", "����", "����", "�ֹ���", "����ó", "�ֹ���ip", "���ۻ���"};
		dtmOrder= new DefaultTableModel(orderColumns, 4) {
			//��� ���� ������ �� ���� ���·� ����� ��
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
		};
		jtOrder = new JTable(dtmOrder);
				
		//�ֹ� ���̺� �÷� ���� ���� : ��ü 800
		jtOrder.getColumnModel().getColumn(0).setPreferredWidth(30);
		jtOrder.getColumnModel().getColumn(1).setPreferredWidth(105);
		jtOrder.getColumnModel().getColumn(2).setPreferredWidth(70);
		jtOrder.getColumnModel().getColumn(3).setPreferredWidth(70);
		jtOrder.getColumnModel().getColumn(4).setPreferredWidth(55);
		jtOrder.getColumnModel().getColumn(5).setPreferredWidth(30);
		jtOrder.getColumnModel().getColumn(6).setPreferredWidth(50);
		jtOrder.getColumnModel().getColumn(7).setPreferredWidth(130);
		jtOrder.getColumnModel().getColumn(8).setPreferredWidth(100);
		jtOrder.getColumnModel().getColumn(9).setPreferredWidth(100);
		jtOrder.getColumnModel().getColumn(10).setPreferredWidth(60);
						
		//���̺��� ����
		jtOrder.setRowHeight(23);
		
		jbtAddLunch = new JButton("���ö��߰�");
		jbtCalcOrder = new JButton("����");
		
		dcbmYear = new DefaultComboBoxModel<Integer>();
		jcbYear = new JComboBox<Integer>(dcbmYear);
		
		dcbmMonth = new DefaultComboBoxModel<Integer>();
		jcbMonth = new JComboBox<Integer>(dcbmMonth);
		
		dcbmDay = new DefaultComboBoxModel<Integer>();
		jcbDay = new JComboBox<Integer>(dcbmDay);
		
		JScrollPane jspLunch = new JScrollPane(jtLunch);
		jspLunch.setBorder(new TitledBorder("���ö� ���"));
		JScrollPane jspOrder = new JScrollPane(jtOrder);
		jspOrder.setBorder(new TitledBorder("�ֹ� ���"));
		JScrollPane jspCalc = new JScrollPane(jtCalc);
		jspCalc.setBorder(new TitledBorder("���� ���"));
	
		
		
		//ó�� �ǿ� �� ������Ʈ ��ġ
		JPanel jplLunch = new JPanel();
		jplLunch.setLayout(new BorderLayout());
		
		JPanel jpLunchNorth = new JPanel();
		jpLunchNorth.add(jbtAddLunch);
		jplLunch.add("Center", jspLunch);
		jplLunch.add("North", jpLunchNorth);
		
		jtb.add("���ö�",jplLunch);
		
		//�ι�° �ǿ� �� ������Ʈ ��ġ
		JPanel jpOrder = new JPanel();
		jpOrder.setLayout(new BorderLayout());
		jpOrder.add(jspOrder);
		
		jtb.add("�ֹ�",jpOrder);
		
		//����° �ǿ� �� ������Ʈ ��ġ
		JPanel jpCalc = new JPanel();
		jpCalc.setLayout(new BorderLayout());
		JPanel jpCalcNorth = new JPanel();
		jpCalcNorth.setBorder(new TitledBorder("�������� ����"));
		jpCalcNorth.add(jcbYear);
		jpCalcNorth.add(new JLabel("��"));
		jpCalcNorth.add(jcbMonth);
		jpCalcNorth.add(new JLabel("��"));
		jpCalcNorth.add(jcbDay);
		jpCalcNorth.add(new JLabel("��"));
		jpCalcNorth.add(jbtCalcOrder);
		
		jpCalc.add("North", jpCalcNorth);
		jpCalc.add("Center", jspCalc);
		
		jtb.add("����",jpCalc);
		
		jpOrderMenu = new JPopupMenu();
		jmOrderRemove = new JMenuItem("�ֹ�����");
		jmOrderStatus = new JMenuItem("���ۿϷ�");
		
		jpOrderMenu.add(jmOrderStatus);
		jpOrderMenu.addSeparator();
		jpOrderMenu.add(jmOrderRemove);
		
		//���� �����ӿ� ��ġ
		add("Center", jtb);
		setYear(); //JCBYear ����
		setMonth();//JCBMonth ����
		setDay();//jcbDay ����
		
		LunchMainController lmc = new LunchMainController(this);
		addWindowListener(lmc);
		
		jtb.addMouseListener(lmc);//�ǿ��� �̺�Ʈ�� �߻����� ��
		jtLunch.addMouseListener(lmc);
		jtOrder.addMouseListener(lmc);
		
		jbtAddLunch.addActionListener(lmc);
		jbtCalcOrder.addActionListener(lmc);
		
		jcbMonth.addActionListener(lmc);
		
		jmOrderRemove.addActionListener(lmc);
		jmOrderStatus.addActionListener(lmc);
		
		setBounds(100, 100, 800, 600);
		setVisible(true);
		
	}//LunchMainView

	private void setYear() {//����⵵�� 4�� ������
		int year = cal.get(Calendar.YEAR);
		for(int temp=0; temp<4; temp++) {
			dcbmYear.addElement(year-temp);
		}//end for
		jcbYear.setSelectedItem(new Integer(year));//���� ��¥�� ���õǵ���
		
	}//setYear
	
	private void setMonth() { //1~12��
		int now_month=cal.get(Calendar.DAY_OF_MONTH)+1;
			for(int month=1; month<13; month++) {
			dcbmMonth.addElement(month);
			}//end for
			jcbMonth.setSelectedItem(new Integer(now_month));
	}//setMonth
	
	private void setDay() {//�� ���� ������ ��
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int nowDay = cal.get(Calendar.DAY_OF_MONTH);
			for(int day=1; day<lastDay+1; day++) {
			dcbmDay.addElement(day);
			}//end for
		jcbDay.setSelectedItem(new Integer(nowDay));
	}//setDay
	
	public JTabbedPane getJtb() {
		return jtb;
	}

	public DefaultTableModel getDtmLunch() {
		return dtmLunch;
	}

	public DefaultTableModel getDtmOrder() {
		return dtmOrder;
	}

	public DefaultTableModel getDtmCalc() {
		return dtmCalc;
	}

	public JButton getJbtAddLunch() {
		return jbtAddLunch;
	}

	public JButton getJbtCalcOrder() {
		return jbtCalcOrder;
	}

	public JComboBox<Integer> getJcbYear() {
		return jcbYear;
	}

	public JComboBox<Integer> getJcbMonth() {
		return jcbMonth;
	}

	public JComboBox<Integer> getJcbDay() {
		return jcbDay;
	}

	public JTable getJtLunch() {
		return jtLunch;
	}

	public JTable getJtOrder() {
		return jtOrder;
	}

	public DefaultComboBoxModel<Integer> getDcbmYear() {
		return dcbmYear;
	}

	public DefaultComboBoxModel<Integer> getDcbmMonth() {
		return dcbmMonth;
	}

	public DefaultComboBoxModel<Integer> getDcbmDay() {
		return dcbmDay;
	}

	public Calendar getCal() {
		return cal;
	}

	public static String getAdminId() {
		return adminId;
	}

	public JPopupMenu getJpOrderMenu() {
		return jpOrderMenu;
	}

	public JMenuItem getJmOrderRemove() {
		return jmOrderRemove;
	}

	public JMenuItem getJmOrderStatus() {
		return jmOrderStatus;
	}

	
	
}//class
