package day1212.hwk;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;

public class HomeworkDesign extends Frame{

	private TextField tfName;
	private TextField tfAge;
	private TextField tfAddr;
	
	private Button btnAdd;
	private Button btnDel;
	private Button btnUpdate;
	private Button btnExit;
	
	private List listData;
	
	public TextField getTfName() {
		return tfName;
	}

	public TextField getTfAge() {
		return tfAge;
	}

	public TextField getTfAddr() {
		return tfAddr;
	}

	public Button getBtnAdd() {
		return btnAdd;
	}

	public Button getBtnDel() {
		return btnDel;
	}

	public Button getBtnUpdate() {
		return btnUpdate;
	}

	public Button getBtnExit() {
		return btnExit;
	}

	public List getListData() {
		return listData;
	}

	public HomeworkDesign() {
		super("�л� ���� ���");
		Label lblName = new Label("�̸�");
		Label lblAge = new Label("����");
		Label lblAddr = new Label("�ּ�");
		
		tfName = new TextField(10);
		tfAge = new TextField(10);
		tfAddr = new TextField(10);
		
		btnAdd = new Button("�߰�");
		btnDel = new Button("����");
		btnUpdate = new Button("����");
		btnExit = new Button("�ݱ�");
		
		listData = new List();
		
		setLayout(new BorderLayout());
		
		Panel panelCenter = new Panel(new GridLayout(1, 2));
		Panel panelCenterLeft = new Panel(new GridLayout(3, 1));
		Panel panelCenterLeft1 = new Panel();
		Panel panelCenterLeft2 = new Panel();
		Panel panelCenterLeft3 = new Panel();
		Panel panelSouth = new Panel();
		
		add("Center", panelCenter);
		panelCenter.add(panelCenterLeft);
		panelCenter.add(listData);
		panelCenterLeft.add(panelCenterLeft1);
		panelCenterLeft.add(panelCenterLeft2);
		panelCenterLeft.add(panelCenterLeft3);
		panelCenterLeft1.add(lblName);
		panelCenterLeft1.add(tfName);
		panelCenterLeft2.add(lblAge);
		panelCenterLeft2.add(tfAge);
		panelCenterLeft3.add(lblAddr);
		panelCenterLeft3.add(tfAddr);
		
		add("South", panelSouth);
		panelSouth.add(btnAdd);
		panelSouth.add(btnDel);
		panelSouth.add(btnUpdate);
		panelSouth.add(btnExit);

		// �̺�Ʈ ��� has a ����
		HomeworkEvt hde = new HomeworkEvt(this);
		// ������Ʈ�� �̺�Ʈ�� ���
		btnAdd.addActionListener(hde);
		btnDel.addActionListener(hde);
		btnUpdate.addActionListener(hde);
		btnExit.addActionListener(hde);
		listData.addItemListener(hde);

		addWindowListener(hde);

		setBounds(200, 200, 300, 250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new HomeworkDesign();
	}
}
