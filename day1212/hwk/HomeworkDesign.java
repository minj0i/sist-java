package day1212.hwk;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

import day1212.FriendsList;

@SuppressWarnings("serial")
public class HomeworkDesign extends Frame{
	private List listView;
	private Button btnAdd, btnDelete, btnModify, btnClose;
//	private Label lblName, lblAge, lblAddress;
	private TextField tfName, tfAge, tfAddress;

	public HomeworkDesign() {
		super("ģ������Ʈ");
		
		Label lblName = new Label("�̸�");
		Label lblAge = new Label("����");
		Label lblAddress = new Label("�ּ�");
		Label lblList = new Label("List");
		
		tfName = new TextField("");
		tfAge = new TextField("");
		tfAddress = new TextField("");
		
		listView = new List();
		
		btnAdd = new Button("�߰�");
		btnDelete = new Button("����");
		btnModify = new Button("����");
		btnClose = new Button("�ݱ�");
		
		
		
		setLayout(null);
		lblName.setBounds(50, 50, 50, 30);
		lblAge.setBounds(50, 100, 50, 30);
		lblAddress.setBounds(50, 150, 50, 30);
		
		tfName.setBounds(125, 55, 150, 30);
		tfAge.setBounds(125, 105, 150, 30);
		tfAddress.setBounds(125, 155, 150, 30);
		
		lblList.setBounds(300, 30, 150, 30);
		listView.setBounds(300, 60, 150, 150);
		
		btnAdd.setBounds(100, 300, 50, 30);
		btnDelete.setBounds(175, 300, 50, 30);
		btnModify.setBounds(250, 300, 50, 30);
		btnClose.setBounds(325, 300, 50, 30);
		
		add(lblName);
		add(lblAge);
		add(lblAddress);
		add(tfName);
		add(tfAge);
		add(tfAddress);
		add(lblList);
		add(listView);
		add(btnAdd);
		add(btnDelete);
		add(btnModify);
		add(btnClose);
		
		//�̺�Ʈ ���
		//������Ŭ������ �̺�Ʈó�� Ŭ������ Has a ����
		
		
		
		setBounds(200, 200, 500, 400);
		setResizable(false);
		
		setVisible(true);
		
	}//HomeworkDesign
	
	public List getListView() {
		return listView;
	}
	public Button getBtnAdd() {
		return btnAdd;
	}
	public Button getBtnDelete() {
		return btnDelete;
	}
	public Button getBtnModify() {
		return btnModify;
	}

	public Button getBtnClose() {
		return btnClose;
	}
	public TextField getTfName() {
		return tfName;
	}
	public TextField getTfAge() {
		return tfAge;
	}
	public TextField getTfAddress() {
		return tfAddress;
	}
	public static void main(String[] args) {
		new HomeworkDesign();
	}//main
	
}//class
