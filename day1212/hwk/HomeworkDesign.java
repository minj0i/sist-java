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
		super("친구리스트");
		
		Label lblName = new Label("이름");
		Label lblAge = new Label("나이");
		Label lblAddress = new Label("주소");
		Label lblList = new Label("List");
		
		tfName = new TextField("");
		tfAge = new TextField("");
		tfAddress = new TextField("");
		
		listView = new List();
		
		btnAdd = new Button("추가");
		btnDelete = new Button("삭제");
		btnModify = new Button("변경");
		btnClose = new Button("닫기");
		
		
		
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
		
		//이벤트 등록
		//디자인클래스와 이벤트처리 클래스는 Has a 관계
		
		
		
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
